package com.codergo.mississippi.blog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.codergo.mississippi.blog.model.dto.UserRoleDTO;
import com.codergo.mississippi.blog.model.entity.UserRole;
import com.codergo.mississippi.blog.model.qo.UserRoleQO;


/**
 * 用户角色表 服务类
 *
 * @author stef
 * @date 2022-02-10
 */
public interface IUserRoleService extends IService<UserRole> {

  Page<UserRole> paging(Page page, UserRoleQO qo);

  boolean doSave(UserRoleDTO dto);

  boolean doUpdate(UserRoleDTO dto);
}
