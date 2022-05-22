package com.codergo.mississippi.blog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.codergo.mississippi.blog.model.dto.UserDTO;
import com.codergo.mississippi.blog.model.entity.User;
import com.codergo.mississippi.blog.model.qo.UserQO;


/**
 * 用户表 服务类
 *
 * @author stef
 * @date 2022-02-10
 */
public interface IUserService extends IService<User> {

  Page<User> paging(Page page, UserQO qo);

  boolean doSave(UserDTO dto);

  boolean doUpdate(UserDTO dto);
}
