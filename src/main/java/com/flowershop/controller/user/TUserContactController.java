package com.flowershop.controller.user;

import com.flowershop.entity.user.TUserContact;
import com.flowershop.service.user.TUserContactService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 收货联系方式表;(TUserContact)表控制层
 *
 * @author makejava
 * @since 2024-04-26 13:01:52
 */
@RestController
@RequestMapping("tUserContact")
public class TUserContactController {
    /**
     * 服务对象
     */
    @Autowired
    private TUserContactService tUserContactService;

    /**
     * 分页查询
     *
     * @param tUserContact 筛选条件
     * @param pageRequest  分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<TUserContact>> queryByPage(TUserContact tUserContact, PageRequest pageRequest) {
        System.out.println("cjw");
        return ResponseEntity.ok(this.tUserContactService.queryByPage(tUserContact, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<TUserContact> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.tUserContactService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param tUserContact 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<TUserContact> add(TUserContact tUserContact) {
        return ResponseEntity.ok(this.tUserContactService.insert(tUserContact));
    }

    /**
     * 编辑数据
     *
     * @param tUserContact 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<TUserContact> edit(TUserContact tUserContact) {
        return ResponseEntity.ok(this.tUserContactService.update(tUserContact));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.tUserContactService.deleteById(id));
    }


}

