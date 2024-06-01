package com.flowershop.controller.order;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;

import com.alipay.easysdk.factory.Factory;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.flowershop.config.AliPayConfig;
import com.flowershop.entity.order.AliPay;
import com.flowershop.entity.order.TCart;
import com.flowershop.entity.order.TOrder;
import com.flowershop.service.impl.order.TCartServiceImpl;
import com.flowershop.service.order.TOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@RequestMapping("/api/alipay")
@RestController
public class AliPayUtil {

    @Resource
    private AliPayConfig aliPayConfig;

    @Resource
    private TOrderService tOrderService;

    @Resource
    private TCartServiceImpl tCartService;

    private static final String GATEWAY_URL ="https://openapi-sandbox.dl.alipaydev.com/gateway.do";
    private static final String FORMAT ="JSON";
    private static final String CHARSET ="utf-8";
    private static final String SIGN_TYPE ="RSA2";



    // &subject=xxx&traceNo=xxx&totalAmount=xxx
    public void pay(AliPay aliPay, HttpServletResponse httpResponse) throws Exception {
        AlipayClient alipayClient = new DefaultAlipayClient(GATEWAY_URL, aliPayConfig.getAppId(),
                aliPayConfig.getAppPrivateKey(), FORMAT, CHARSET, aliPayConfig.getAlipayPublicKey(), SIGN_TYPE);
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
        request.setNotifyUrl(aliPayConfig.getNotifyUrl());
        request.setBizContent("{\"out_trade_no\":\"" + aliPay.getTraceNo() + "\","
                + "\"total_amount\":\"" + aliPay.getTotalAmount() + "\","
                + "\"subject\":\"" + aliPay.getSubject() + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        String form = "";
        try {
            // 调用SDK生成表单
            form = alipayClient.pageExecute(request).getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        httpResponse.setContentType("text/html;charset=" + CHARSET);
        // 直接将完整的表单html输出到页面
        httpResponse.getWriter().write(form);
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();
    }
    @PostMapping("/notify")  // 注意这里必须是POST接口
    public String payNotify(HttpServletRequest request) throws Exception {
        if (request.getParameter("trade_status").equals("TRADE_SUCCESS")) {
            System.out.println("=========支付宝异步回调========");

            Map<String, String> params = new HashMap<>();
            Map<String, String[]> requestParams = request.getParameterMap();
            for (String name : requestParams.keySet()) {
                params.put(name, request.getParameter(name));
                // System.out.println(name + " = " + request.getParameter(name));
            }

            String tradeNo = params.get("out_trade_no");
            String gmtPayment = params.get("gmt_payment");
            String alipayTradeNo = params.get("trade_no");
            // 支付宝验签
            if (Factory.Payment.Common().verifyNotify(params)) {
                // 验签通过
                //System.out.println("交易名称: " + params.get("subject"));
                //System.out.println("交易状态: " + params.get("trade_status"));
                //System.out.println("支付宝交易凭证号: " + params.get("trade_no"));
                //System.out.println("商户订单号: " + params.get("out_trade_no"));
                //System.out.println("交易金额: " + params.get("total_amount"));
                //System.out.println("买家在支付宝唯一id: " + params.get("buyer_id"));
                //System.out.println("买家付款时间: " + params.get("gmt_payment"));
                //System.out.println("买家付款金额: " + params.get("buyer_pay_amount"));
                // 更新订单为已支付
                TOrder order = tOrderService.getById(tradeNo);
                order.setOStatus("1");
                tOrderService.updateById(order);
                //删除购物车
                //构造查询条件
                QueryWrapper<TCart> queryWrapper = new QueryWrapper<>();
                queryWrapper.eq("u_id", order.getUId());
                //删除购物车
                tCartService.remove(queryWrapper);
            }
        }
        return "success";
    }
}
