package com.flowershop.controller.user;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.flowershop.entity.user.TUser;
import com.flowershop.entity.user.UserMonthlyActivity;
import com.flowershop.service.user.TUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 用户表;(TUser)表控制层
 *
 * @author makejava
 * @since 2024-05-20 19:54:58
 */
@RestController
@RequestMapping("tUser")
public class TUserController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private TUserService tUserService;

    /**
     * 分页查询所有数据
     *
     * @param page  分页对象
     * @param tUser 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<TUser> page, TUser tUser) {
        return success(this.tUserService.page(page, new QueryWrapper<>(tUser)));
    }

    /**
     * 通过邮箱查找数据
     *
     * @param email 邮箱地址
     * @return 单条数据
     */
    @GetMapping("/email/{email}")
    public R selectByEmail(@PathVariable String email) {
        return success(this.tUserService.getOne(new QueryWrapper<TUser>().eq("u_mail", email)));
    }


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.tUserService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param tUser 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody TUser tUser) {
        return success(this.tUserService.save(tUser));
    }

    /**
     * 修改数据
     *
     * @param tUser 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody TUser tUser) {
        return success(this.tUserService.updateById(tUser));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.tUserService.removeByIds(idList));
    }

    /**
     * 重置密码
     */
    @PostMapping("resetPassword")
    public Integer resetPassword(@RequestParam("email") String email, @RequestParam("code") String code, @RequestParam("password") String password) {
        return tUserService.resetPassword(email, code, password);
    }

    /**
     * 通过uid查询用户订单情况
     */
    @GetMapping("/order/{uid}")
    public UserMonthlyActivity selectByUid(@PathVariable String uid) {
        return null;
    }
}

