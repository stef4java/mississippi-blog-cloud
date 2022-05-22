package com.codergo.mississippi.blog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.codergo.mississippi.blog.model.dto.DeptDTO;
import com.codergo.mississippi.blog.model.entity.Dept;
import com.codergo.mississippi.blog.model.qo.DeptQO;


/**
 * 部门表 服务类
 *
 * @author stef
 * @date 2022-02-10
 */
public interface IDeptService extends IService<Dept> {

    Page<Dept> paging(Page page, DeptQO qo);

    boolean doSave(DeptDTO dto);

    boolean doUpdate(DeptDTO dto);
}
