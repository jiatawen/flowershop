package com.flowershop.controller;

import com.flowershop.entity.TFenlei;
import com.flowershop.service.TFenleiService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * (TFenlei)表控制层
 *
 * @author makejava
 * @since 2024-04-01 23:48:21
 */
@RestController
@RequestMapping("tFenlei")
public class TFenleiController {
    /**
     * 服务对象
     */
    @Autowired
    private TFenleiService tFenleiService;

    /**
     * 分页查询
     *
     * @param tFenlei     筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<TFenlei>> queryByPage(TFenlei tFenlei, PageRequest pageRequest) {
        return ResponseEntity.ok(this.tFenleiService.queryByPage(tFenlei, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<TFenlei> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.tFenleiService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param tFenlei 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<TFenlei> add(TFenlei tFenlei) {
        return ResponseEntity.ok(this.tFenleiService.insert(tFenlei));
    }

    /**
     * 编辑数据
     *
     * @param tFenlei 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<TFenlei> edit(TFenlei tFenlei) {
        return ResponseEntity.ok(this.tFenleiService.update(tFenlei));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.tFenleiService.deleteById(id));
    }

}

