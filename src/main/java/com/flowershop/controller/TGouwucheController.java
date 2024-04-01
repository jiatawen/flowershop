package com.flowershop.controller;

import com.flowershop.entity.TGouwuche;
import com.flowershop.service.TGouwucheService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * (TGouwuche)表控制层
 *
 * @author makejava
 * @since 2024-04-01 23:48:23
 */
@RestController
@RequestMapping("tGouwuche")
public class TGouwucheController {
    /**
     * 服务对象
     */
    @Autowired
    private TGouwucheService tGouwucheService;

    /**
     * 分页查询
     *
     * @param tGouwuche   筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<TGouwuche>> queryByPage(TGouwuche tGouwuche, PageRequest pageRequest) {
        return ResponseEntity.ok(this.tGouwucheService.queryByPage(tGouwuche, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<TGouwuche> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.tGouwucheService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param tGouwuche 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<TGouwuche> add(TGouwuche tGouwuche) {
        return ResponseEntity.ok(this.tGouwucheService.insert(tGouwuche));
    }

    /**
     * 编辑数据
     *
     * @param tGouwuche 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<TGouwuche> edit(TGouwuche tGouwuche) {
        return ResponseEntity.ok(this.tGouwucheService.update(tGouwuche));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.tGouwucheService.deleteById(id));
    }

}

