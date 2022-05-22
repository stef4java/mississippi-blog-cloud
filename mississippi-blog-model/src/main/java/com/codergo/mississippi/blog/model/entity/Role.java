package com.codergo.mississippi.blog.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


/**
 * 系统角色表
 *
 * @author stef
 * @date 2022-02-10
 */
@Data
@TableName("sys_role")
@ApiModel(value="Role", description="系统角色表")
public class Role extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private String code;

    @ApiModelProperty(value = "备注")
    private String remark;


}
