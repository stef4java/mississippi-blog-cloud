package com.codergo.mississippi.blog.admin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.codergo.mississippi.blog.model.dto.RoleDTO;
import com.codergo.mississippi.blog.model.entity.Role;
import com.codergo.mississippi.blog.model.qo.RoleQO;
import com.codergo.mississippi.blog.service.IRoleService;
import com.codergo.mississippi.common.base.dto.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 系统角色表 前端控制器
 *
 * @author stef
 * @date 2022-02-10
 */
@Api(value = "系统角色表 控制器",tags = "系统角色表 控制器")
@RestController
@RequestMapping("/role")
@Validated
@RequiredArgsConstructor
public class RoleController {

    private final IRoleService roleService;


    @ApiOperation(value = "分页查询系统角色表")
    @GetMapping("/page")
    public R<Page<Role>> pageRole(Page page, @Valid RoleQO qo){
        return R.ok(roleService.paging(page, qo));
    }


    @ApiOperation(value = "添加系统角色表")
    @PostMapping("")
    public R addRole(@Valid @RequestBody RoleDTO dto){
        roleService.doSave(dto);
        return R.ok();
    }


    @ApiOperation(value = "删除系统角色表")
    @DeleteMapping("/{id}")
    public R deleteRole( @PathVariable Integer id){
        roleService.removeById(id);
        return R.ok();
    }


    @ApiOperation(value = "更新系统角色表")
    @PutMapping("")
    public R updateRole(@Valid @RequestBody RoleDTO dto){
        roleService.doUpdate(dto);
        return R.ok();
    }

}
