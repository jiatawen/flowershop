package com.flowershop.controller.flower;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.flowershop.entity.flower.TPublicNotice;
import com.flowershop.service.flower.TPublicNoticeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 公告(TPublicNotice)表控制层
 *
 * @author makejava
 * @since 2024-05-20 19:31:46
 */
@RestController
@RequestMapping("tPublicNotice")
public class TPublicNoticeController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private TPublicNoticeService tPublicNoticeService;

    /**
     * 分页查询所有数据
     *
     * @param page          分页对象
     * @param tPublicNotice 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<TPublicNotice> page, TPublicNotice tPublicNotice) {
        return success(this.tPublicNoticeService.page(page, new QueryWrapper<>(tPublicNotice)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.tPublicNoticeService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param tPublicNotice 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody TPublicNotice tPublicNotice) {
        return success(this.tPublicNoticeService.save(tPublicNotice));
    }

    /**
     * 修改数据
     *
     * @param tPublicNotice 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody TPublicNotice tPublicNotice) {
        return success(this.tPublicNoticeService.updateById(tPublicNotice));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.tPublicNoticeService.removeByIds(idList));
    }
}

