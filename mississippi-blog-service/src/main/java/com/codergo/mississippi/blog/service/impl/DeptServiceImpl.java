package com.codergo.mississippi.blog.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.codergo.mississippi.blog.mapper.DeptMapper;
import com.codergo.mississippi.blog.model.dto.DeptDTO;
import com.codergo.mississippi.blog.model.entity.Dept;
import com.codergo.mississippi.blog.model.qo.DeptQO;
import com.codergo.mississippi.blog.service.IDeptService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 部门表 服务实现类
 *
 * @author stef
 * @date 2022-02-10
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements IDeptService {

    @Override
    public Page<Dept> paging(Page page, DeptQO qo){
        Dept dept = new Dept();
        BeanUtils.copyProperties(qo, dept);
        return this.page(page, Wrappers.query(dept));
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean doSave(DeptDTO dto){
        Dept dept = new Dept();
        BeanUtils.copyProperties(dto, dept);
        return this.save(dept);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean doUpdate(DeptDTO dto){
        Dept dept = new Dept();
        BeanUtils.copyProperties(dto, dept);
        return this.updateById(dept);
    }

}
