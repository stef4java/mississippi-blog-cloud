package com.codergo.mississippi.blog.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 系统角色表 传输实体
 *
 * @author stef
 * @date 2022-02-10
 */
@Data
@ApiModel(value="Role传输实体", description="系统角色表传输实体")
public class RoleDTO {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private String code;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "逻辑删除标识，未删除为 0，已删除为删除时间")
    private Long deleted;

    @ApiModelProperty(value = "创建人")
    private Integer createBy;

    @ApiModelProperty(value = "修改人")
    private Integer updateBy;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime updateTime;



}
