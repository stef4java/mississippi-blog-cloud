package com.codergo.mississippi.blog.admin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.codergo.mississippi.blog.model.dto.UserDTO;
import com.codergo.mississippi.blog.model.entity.User;
import com.codergo.mississippi.blog.model.qo.UserQO;
import com.codergo.mississippi.blog.service.IUserService;
import com.codergo.mississippi.common.base.dto.R;
import com.codergo.mississippi.common.base.dto.validator.Create;
import com.codergo.mississippi.common.base.dto.validator.Update;
import com.codergo.mississippi.common.base.exception.BusinessException;
import com.codergo.mississippi.common.base.exception.GeneralErrorCodeEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.groups.Default;
import java.util.List;

/**
 * 用户表 前端控制器
 *
 * @author stef
 * @date 2022-02-10
 */
@Api(value = "用户表 控制器",tags = "用户表 控制器")
@RestController
@RequestMapping("/user")
@Validated
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final IUserService userService;


    @ApiOperation(value = "分页查询用户表")
    @GetMapping("/page")
    public R<Page<User>> pageUser(Page page, @Valid UserQO qo){
        return R.ok(userService.paging(page, qo));
    }


    @ApiOperation(value = "获取一组用户详情")
    @GetMapping(value = "users/{ids}")
    R<List<User>> userByIds(@PathVariable List<Long> ids) {
        Assert.notEmpty(ids, ()-> { throw new BusinessException(GeneralErrorCodeEnum.INVALID_PARAMETERS); });
        return R.ok(userService.listByIds(ids));
    }


    @ApiOperation(value = "根据id获取用户信息")
    @GetMapping("/{id}")
    public R<User> getById(@PathVariable Long id){
        User user = userService.getById(id);
//        Optional.ofNullable(user).orElseThrow(()-> new BusinessException(GeneralErrorCodeEnum.NOT_FOUND_CODE));
        Assert.notNull(user, ()-> { throw new BusinessException(GeneralErrorCodeEnum.NOT_FOUND_CODE); });
        return R.ok(user);
    }

    @ApiOperation(value = "RequestParam参数校验")
    @GetMapping("/demo")
    public R<User> demo(@Min(value = 16, message = "年龄不得小于16")
                        @Max(value = 150, message = "年龄不得大于150")
                        Integer age){
        log.info("年龄: {}", age);
        return R.ok();
    }

    @ApiOperation(value = "RequestParam参数校验1")
    @PostMapping("/demo1")
    public R<User> demo1(@NotBlank(message = "name不能为空") String name){
        log.info("name: {}", name);
        return R.ok();
    }


    @ApiOperation(value = "添加用户表")
    @PostMapping("")
    public R addUser(@Validated({Create.class, Default.class}) @RequestBody UserDTO dto){
        userService.doSave(dto);
        return R.ok();
    }


    @ApiOperation(value = "删除用户表")
    @DeleteMapping("/{id}")
    public R deleteUser( @PathVariable Long id){
        userService.removeById(id);
        return R.ok();
    }


    @ApiOperation(value = "更新用户表")
    @PutMapping("")
    public R updateUser(@Validated({Update.class}) @RequestBody UserDTO dto){
        userService.doUpdate(dto);
        return R.ok();
    }

}
