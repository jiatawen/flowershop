package com.flowershop.controller;

import com.flowershop.entity.TDingdan;
import com.flowershop.service.TDingdanService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * (TDingdan)表控制层
 *
 * @author makejava
 * @since 2024-04-01 23:48:19
 */
@RestController
@RequestMapping("tDingdan")
public class TDingdanController {
    /**
     * 服务对象
     */
    @Autowired
    private TDingdanService tDingdanService;

    /**
     * 分页查询
     *
     * @param tDingdan    筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<TDingdan>> queryByPage(TDingdan tDingdan, PageRequest pageRequest) {
        return ResponseEntity.ok(this.tDingdanService.queryByPage(tDingdan, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<TDingdan> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.tDingdanService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param tDingdan 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<TDingdan> add(TDingdan tDingdan) {
        return ResponseEntity.ok(this.tDingdanService.insert(tDingdan));
    }

    /**
     * 编辑数据
     *
     * @param tDingdan 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<TDingdan> edit(TDingdan tDingdan) {
        return ResponseEntity.ok(this.tDingdanService.update(tDingdan));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.tDingdanService.deleteById(id));
    }

}

