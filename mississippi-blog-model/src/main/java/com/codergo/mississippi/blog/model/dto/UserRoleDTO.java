package com.codergo.mississippi.blog.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户角色表 传输实体
 *
 * @author stef
 * @date 2022-02-10
 */
@Data
@ApiModel(value="UserRole传输实体", description="用户角色表传输实体")
public class UserRoleDTO {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @ApiModelProperty(value = "用户ID")
    private Integer userId;

    @ApiModelProperty(value = "用户ID")
    private Integer roleId;



}
