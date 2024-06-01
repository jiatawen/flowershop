package com.flowershop.controller.order;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.flowershop.entity.flower.TFlower;
import com.flowershop.entity.order.TCart;
import com.flowershop.entity.order.TCartVO;
import com.flowershop.entity.user.TUser;
import com.flowershop.service.flower.TFlowerService;
import com.flowershop.service.order.TCartService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.math.BigDecimal;
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
    private TFlowerService tFlowerService;

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

