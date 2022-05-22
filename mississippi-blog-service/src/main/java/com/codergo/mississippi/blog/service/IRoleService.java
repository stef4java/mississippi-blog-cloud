package com.codergo.mississippi.blog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.codergo.mississippi.blog.model.dto.RoleDTO;
import com.codergo.mississippi.blog.model.entity.Role;
import com.codergo.mississippi.blog.model.qo.RoleQO;


/**
 * 系统角色表 服务类
 *
 * @author stef
 * @date 2022-02-10
 */
public interface IRoleService extends IService<Role> {

  Page<Role> paging(Page page, RoleQO qo);

  boolean doSave(RoleDTO dto);

  boolean doUpdate(RoleDTO dto);
}
