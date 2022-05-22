package com.codergo.mississippi.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.codergo.mississippi.blog.mapper.UserMapper;
import com.codergo.mississippi.blog.model.dto.UserDTO;
import com.codergo.mississippi.blog.model.entity.Dept;
import com.codergo.mississippi.blog.model.entity.User;
import com.codergo.mississippi.blog.model.qo.UserQO;
import com.codergo.mississippi.blog.service.IDeptService;
import com.codergo.mississippi.blog.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.Objects;

/**
 * 用户表 服务实现类
 *
 * @author stef
 * @date 2022-02-10
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private IDeptService deptService;

    @Override
    public Page<User> paging(Page page, UserQO qo){
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(!Objects.isNull(qo.getGender()), User::getGender, qo.getGender());
        if (StringUtils.hasLength(qo.getKeyword())) {
            wrapper.and(qw->qw.like(User::getRealName, qo.getKeyword()).or().like(User::getNickname, qo.getKeyword()));
        }
        return this.page(page, wrapper);
    }



    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean doSave(UserDTO dto){
        Dept dept = deptService.getById(dto.getDeptId());
        Assert.notNull(dept, "部门不存在");
//        Assert.notNull(dept, ()-> { throw new BusinessException(GeneralErrorCodeEnum.NOT_FOUND_CODE.getCode(),"部门不存在"); });
//        Optional.ofNullable(dept).orElseThrow(()-> new BusinessException(GeneralErrorCodeEnum.NOT_FOUND_CODE.getCode(),"部门不存在"));
        User user = new User();
        BeanUtils.copyProperties(dto, user);
        return this.save(user);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean doUpdate(UserDTO dto){
        User user = new User();
        BeanUtils.copyProperties(dto, user);
        return this.updateById(user);
    }

}
