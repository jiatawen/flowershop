package com.flowershop.controller.user;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.flowershop.entity.user.TUserLoginBehavior;
import com.flowershop.service.user.TUserLoginBehaviorService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 用户登录行为记录表;(TUserLoginBehavior)表控制层
 *
 * @author makejava
 * @since 2024-05-20 19:54:59
 */
@RestController
@RequestMapping("tUserLoginBehavior")
public class TUserLoginBehaviorController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private TUserLoginBehaviorService tUserLoginBehaviorService;

    /**
     * 分页查询所有数据
     *
     * @param page               分页对象
     * @param tUserLoginBehavior 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<TUserLoginBehavior> page, TUserLoginBehavior tUserLoginBehavior) {
        return success(this.tUserLoginBehaviorService.page(page, new QueryWrapper<>(tUserLoginBehavior)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.tUserLoginBehaviorService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param tUserLoginBehavior 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody TUserLoginBehavior tUserLoginBehavior) {
        return success(this.tUserLoginBehaviorService.save(tUserLoginBehavior));
    }

    /**
     * 修改数据
     *
     * @param tUserLoginBehavior 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody TUserLoginBehavior tUserLoginBehavior) {
        return success(this.tUserLoginBehaviorService.updateById(tUserLoginBehavior));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.tUserLoginBehaviorService.removeByIds(idList));
    }

    /**
     * 统计各月份登录计数
     *
     * @param uid 用户id
     * @return VUserLogin
     */
    @GetMapping("count")
    public R count(@RequestParam("uid") Integer uid) {
        return success(this.tUserLoginBehaviorService.getPerMonth(uid));
    }
}

