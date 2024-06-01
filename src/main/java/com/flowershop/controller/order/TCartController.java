package com.flowershop.controller.order;


import cn.hutool.http.HttpResponse;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.flowershop.entity.flower.TFlower;
import com.flowershop.entity.order.*;
import com.flowershop.entity.user.TUser;
import com.flowershop.entity.user.TUserContact;
import com.flowershop.service.flower.TFlowerService;
import com.flowershop.service.impl.order.TOrderDetailsServiceImpl;
import com.flowershop.service.impl.user.TUserContactServiceImpl;
import com.flowershop.service.order.TCartService;
import com.flowershop.service.order.TOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 购物车;(TCart)表控制层
 *
 * @author makejava
 * @since 2024-05-20 19:31:41
 */
@RestController
@RequestMapping("tCart")
public class TCartController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private TCartService tCartService;

    @Resource
    private TOrderService tOrderService;

    @Resource
    private TFlowerService tFlowerService;

    @Resource
    private TOrderDetailsServiceImpl tOrderDetailsService;

    @Resource
    private AliPayUtil aliPayUtil;

    @Resource
    private TUserContactServiceImpl tUserContactService;

    @GetMapping("/getAll")
    public R getAll(HttpSession session) {
        //获取用户ID
        TUser user = (TUser) session.getAttribute("user");
        Integer uId = user.getUId();
        //构造查询条件
        QueryWrapper<TCart> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("u_id", uId);
        List<TCart> carts = this.tCartService.list(queryWrapper);
        //处理返回结果
        List<TCartVO> cartVO = carts.stream().map(cart -> {
                    TCartVO cartDTO = new TCartVO();
                    //设置ID
                    cartDTO.setId(cart.getId());
                    TFlower flower = tFlowerService.getById(cart.getFId());
                    //设置鲜花名称
                    cartDTO.setName(flower.getFName());
                    //设置鲜花数量
                    cartDTO.setNumber(cart.getCCount());
                    //设置鲜花单价
                    cartDTO.setPrice(flower.getFPrice().toString());
                    //计算小记价格
                    cartDTO.setTotalPrice(flower.getFPrice().multiply(new BigDecimal(cart.getCCount())).toString());
                    return cartDTO;
                })
                .collect(Collectors.toList());
        return success(cartVO);

    }

    /**
     * 获取购物车总价
     *
     * @param session 用户会话
     * @return 购物车总价
     */
    @GetMapping("/getPrice")
    public R getPrice(HttpSession session) {
        //获取用户ID
        TUser user = (TUser) session.getAttribute("user");
        Integer uId = user.getUId();
        //构造查询条件
        QueryWrapper<TCart> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("u_id", uId);
        List<TCart> carts = this.tCartService.list(queryWrapper);
        BigDecimal sum = new BigDecimal("0");
        //处理返回结果
        for (TCart cart : carts) {
            TFlower flower = tFlowerService.getById(cart.getFId());
            //计算当前总价
            sum = sum.add(flower.getFPrice().multiply(new BigDecimal(cart.getCCount())));

        }
        return success(sum.toString());
    }

    @Transactional
    @GetMapping("/pay")
    public void pay(HttpServletResponse response, HttpSession session) throws Exception {
        //获取用户ID
        TUser user = (TUser) session.getAttribute("user");
        Integer uId = user.getUId();
        //获取用户联系方式
        QueryWrapper<TUserContact> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.eq("u_id", uId);
        TUserContact userContact = tUserContactService.getOne(queryWrapper1);
        //新建订单
        TOrder order = new TOrder();
        order.setUId(uId);
        order.setOName(user.getUName());
        order.setOCreateTime(new Date());
        order.setOStatus("0");
        order.setOAddress(userContact.getUcAddress());
        order.setOTel(userContact.getUcTel());
        order.setOSumPrice(new BigDecimal("0"));
        //保存订单获取订单号
        tOrderService.save(order);
        //构造查询条件
        QueryWrapper<TCart> queryWrapper2 = new QueryWrapper<>();
        queryWrapper2.eq("u_id", uId);
        List<TCart> carts = this.tCartService.list(queryWrapper2);
        BigDecimal sum = new BigDecimal("0");
        //处理返回结果
        for (TCart cart : carts) {
            TFlower flower = tFlowerService.getById(cart.getFId());
            //新增订单详情
            TOrderDetails orderDetails = new TOrderDetails();
            orderDetails.setOId(order.getOId().intValue());
            orderDetails.setFId(flower.getFId());
            orderDetails.setOdCount(cart.getCCount());
            //保存订单详情
            tOrderDetailsService.save(orderDetails);
            //计算当前总价
            sum = sum.add(flower.getFPrice().multiply(new BigDecimal(cart.getCCount())));
        }
        order.setOSumPrice(sum);//设置总价
        tOrderService.updateById(order);//更新订单
        aliPayUtil.pay(
                new AliPay(String.valueOf(order.getOId()), sum.toString(), "鲜花订单", ""), response);
    }

    /**
     * 分页查询所有数据
     *
     * @param page  分页对象
     * @param tCart 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<TCart> page, TCart tCart) {
        return success(this.tCartService.page(page, new QueryWrapper<>(tCart)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.tCartService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param tCart 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody TCart tCart) {
        return success(this.tCartService.save(tCart));
    }

    /**
     * 修改数据
     *
     * @param tCart 实体对象
     * @return 修改结果
     */
    @PutMapping("/update/{id}")
    public R update(@PathVariable Integer id, TCart tCart) {
        //获取原始对象
        TCart oldCart = this.tCartService.getById(id);
        //更新数据
        oldCart.setCCount(tCart.getCCount());
        return success(this.tCartService.updateById(oldCart));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.tCartService.removeByIds(idList));
    }
}

