package com.codergo.mississippi.blog.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


/**
 * 用户表
 *
 * @author stef
 * @date 2022-02-10
 */
@Data
@TableName("sys_user")
@ApiModel(value="User", description="用户表")
public class User extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    //解决雪花Long类型在js处理错误
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    @ApiModelProperty(value = "登录账号")
    private String username;

    @ApiModelProperty(value = "真实名字")
    private String realName;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    //密码不参与序列化
    @JsonIgnore
    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "头像")
    private String avatar;

    @ApiModelProperty(value = "性别(未知:-1,男:1,女:0. 默认：-1)")
    private Integer gender;

    @ApiModelProperty(value = "电子邮件")
    private String email;

    @ApiModelProperty(value = "手机号")
    private String mobile;

    @ApiModelProperty(value = "状态(1-正常,0-冻结)")
    private Integer status = 1;

    @ApiModelProperty(value = "微信登录openId")
    private String wxOpenid;

    @ApiModelProperty(value = "小程序openId")
    private String miniOpenid;

    @ApiModelProperty(value = "QQ openId")
    private String qqOpenid;

    @ApiModelProperty(value = "部门ID")
    private Integer deptId;

    @ApiModelProperty(value = "年龄")
    @TableField(exist = false)
    private Integer age;

}
