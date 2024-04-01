package com.flowershop.controller;

import com.flowershop.entity.TGonggao;
import com.flowershop.service.TGonggaoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * (TGonggao)表控制层
 *
 * @author makejava
 * @since 2024-04-01 23:48:22
 */
@RestController
@RequestMapping("tGonggao")
public class TGonggaoController {
    /**
     * 服务对象
     */
    @Autowired
    private TGonggaoService tGonggaoService;

    /**
     * 分页查询
     *
     * @param tGonggao    筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<TGonggao>> queryByPage(TGonggao tGonggao, PageRequest pageRequest) {
        return ResponseEntity.ok(this.tGonggaoService.queryByPage(tGonggao, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<TGonggao> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.tGonggaoService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param tGonggao 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<TGonggao> add(TGonggao tGonggao) {
        return ResponseEntity.ok(this.tGonggaoService.insert(tGonggao));
    }

    /**
     * 编辑数据
     *
     * @param tGonggao 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<TGonggao> edit(TGonggao tGonggao) {
        return ResponseEntity.ok(this.tGonggaoService.update(tGonggao));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.tGonggaoService.deleteById(id));
    }

}

