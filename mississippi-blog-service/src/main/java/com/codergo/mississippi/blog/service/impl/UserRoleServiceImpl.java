package com.codergo.mississippi.blog.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.codergo.mississippi.blog.mapper.UserRoleMapper;
import com.codergo.mississippi.blog.model.dto.UserRoleDTO;
import com.codergo.mississippi.blog.model.entity.UserRole;
import com.codergo.mississippi.blog.model.qo.UserRoleQO;
import com.codergo.mississippi.blog.service.IUserRoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户角色表 服务实现类
 *
 * @author stef
 * @date 2022-02-10
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

    @Override
    public Page<UserRole> paging(Page page, UserRoleQO qo){
        UserRole userRole = new UserRole();
        BeanUtils.copyProperties(qo, userRole);
        return this.page(page, Wrappers.query(userRole));
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean doSave(UserRoleDTO dto){
        UserRole userRole = new UserRole();
        BeanUtils.copyProperties(dto, userRole);
        return this.save(userRole);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean doUpdate(UserRoleDTO dto){
        UserRole userRole = new UserRole();
        BeanUtils.copyProperties(dto, userRole);
        return this.updateById(userRole);
    }

}
