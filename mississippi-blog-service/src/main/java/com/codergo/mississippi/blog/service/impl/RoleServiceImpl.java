package com.codergo.mississippi.blog.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.codergo.mississippi.blog.mapper.RoleMapper;
import com.codergo.mississippi.blog.model.dto.RoleDTO;
import com.codergo.mississippi.blog.model.entity.Role;
import com.codergo.mississippi.blog.model.qo.RoleQO;
import com.codergo.mississippi.blog.service.IRoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 系统角色表 服务实现类
 *
 * @author stef
 * @date 2022-02-10
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Override
    public Page<Role> paging(Page page, RoleQO qo){
        Role role = new Role();
        BeanUtils.copyProperties(qo, role);
        return this.page(page, Wrappers.query(role));
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean doSave(RoleDTO dto){
        Role role = new Role();
        BeanUtils.copyProperties(dto, role);
        return this.save(role);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean doUpdate(RoleDTO dto){
        Role role = new Role();
        BeanUtils.copyProperties(dto, role);
        return this.updateById(role);
    }

}
