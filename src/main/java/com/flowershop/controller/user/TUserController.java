package com.flowershop.controller.user;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.flowershop.entity.user.TUser;
import com.flowershop.service.user.EmailService;
import com.flowershop.service.user.TUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 用户表;(TUser)表控制层
 *
 * @author makejava
 * @since 2024-04-20 01:43:38
 */
@RestController
@RequestMapping("tUser")
public class TUserController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private TUserService tUserService;

    @Resource
    private EmailService emailService;

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
     * 通过邮箱查找数据
     *
     * @param email 邮箱
     * @return 单条数据
     */
    @GetMapping("email")
    public R selectByEmail(@RequestParam("email") String email) {
        return success(this.tUserService.getOne(new QueryWrapper<TUser>().lambda().eq(TUser::getUMail, email)));
    }

    /**
     * 重置密码
     *
     * @param code     邮箱验证码
     * @param password 新密码
     * @param email    邮箱
     * @return 修改结果
     */
    @PostMapping("resetPassword")
    public Integer ResetPassword(@RequestParam("code") String code, @RequestParam("password") String password, @RequestParam("email") String email) {
        return tUserService.ResetPassword(email, code, password);
    }

    /**
     * 修改用户权限
     * @param status 修改状态
     * @param id 主键
     * @return 修改结果
     */

    @PostMapping("setStatus")
    public Integer setStatus(@RequestParam("status") String status, @RequestParam("id") String id) {
        return tUserService.setStatus(status, id);
    }
}

