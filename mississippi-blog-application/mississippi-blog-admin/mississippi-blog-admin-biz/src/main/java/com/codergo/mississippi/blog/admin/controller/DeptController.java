package com.codergo.mississippi.blog.admin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.codergo.mississippi.blog.model.dto.DeptDTO;
import com.codergo.mississippi.blog.model.entity.Dept;
import com.codergo.mississippi.blog.model.qo.DeptQO;
import com.codergo.mississippi.blog.service.IDeptService;
import com.codergo.mississippi.common.base.dto.R;
import com.codergo.mississippi.common.base.dto.validator.Create;
import com.codergo.mississippi.common.base.dto.validator.Update;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.groups.Default;

/**
 * 部门表 前端控制器
 *
 * @author stef
 * @date 2022-02-10
 */
@Api(value = "部门表 控制器",tags = "部门表 控制器")
@RestController
@RequestMapping("/dept")
@Validated
@RequiredArgsConstructor
public class DeptController {

    private final IDeptService deptService;


    @ApiOperation(value = "分页查询部门表")
    @GetMapping("/page")
    public R<Page<Dept>> pageDept(Page page, @Valid DeptQO qo){
        return R.ok(deptService.paging(page, qo));
    }

    @ApiOperation(value = "查询部门",notes = "根据id查询部门")
    @ApiImplicitParam(paramType = "path",name="id",value = "部门id",required = true)
    @GetMapping("/{id}")
    public R<Dept> getById(@PathVariable Integer id) {
        Dept dept = deptService.getById(id);
        Assert.notNull(dept, "部门不存在");
        return R.ok(dept);
    }


    @ApiOperation(value = "添加部门表")
    @PostMapping("")
    public R addDept(@RequestBody @Validated({Create.class, Default.class}) DeptDTO dto){
        deptService.doSave(dto);
        return R.ok();
    }


    @ApiOperation(value = "删除部门表")
    @DeleteMapping("/{id}")
    public R deleteDept(@PathVariable Integer id){
        deptService.removeById(id);
        return R.ok();
    }


    @ApiOperation(value = "更新部门表")
    @PutMapping("")
    public R updateDept( @RequestBody @Validated({Update.class})  DeptDTO dto){
        deptService.doUpdate(dto);
        return R.ok();
    }

}
