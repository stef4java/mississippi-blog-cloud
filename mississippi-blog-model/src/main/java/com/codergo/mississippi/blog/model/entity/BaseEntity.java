package com.codergo.mississippi.blog.model.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public  class BaseEntity implements Serializable {


    @JsonIgnore
    @ApiModelProperty(value = "逻辑删除标识，未删除为 0，已删除为删除时间")
    @TableLogic
    private Long deleted;

    @JsonIgnore
    @ApiModelProperty(value = "创建者")
    private Integer createBy;

    @JsonIgnore
    @ApiModelProperty(value = "修改者")
    private Integer updateBy;

    @JsonIgnore
    @ApiModelProperty(value = "创建时间")
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @JsonIgnore
    @ApiModelProperty(value = "修改时间")
    private Date updateTime;
}