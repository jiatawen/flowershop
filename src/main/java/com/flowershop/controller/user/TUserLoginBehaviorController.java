package com.flowershop.controller.user;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.flowershop.entity.user.TUser;
import com.flowershop.entity.user.TUserLoginBehavior;
import com.flowershop.service.user.TUserLoginBehaviorService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

/**
 * 用户登录行为记录表;(TUserLoginBehavior)表控制层
 *
 * @author makejava
 * @since 2024-04-20 01:43:39
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
     * 登录
     *
     * @param email password session 账户 密码 登录信息
     */
    @PostMapping("login")
    public void login(@RequestParam("email") String email, @RequestParam("password") String password, HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(30*60);

        TUser user = tUserLoginBehaviorService.login(email, password);
        if (user != null){
            System.out.println(user);
            session.setAttribute("user", user);
//            页面重定向至首页
            response.sendRedirect("/user/index.html");
        }
    }

    @PostMapping("sendEmail")
    public void sendEmail() throws Exception {
        System.out.println("sendEmail被调用");
        tUserLoginBehaviorService.sendEmail("");
    }
}

