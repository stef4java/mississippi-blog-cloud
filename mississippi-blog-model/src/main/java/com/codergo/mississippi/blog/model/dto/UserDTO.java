package com.codergo.mississippi.blog.model.dto;


import com.codergo.mississippi.common.base.dto.validator.Create;
import com.codergo.mississippi.common.base.dto.validator.Update;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;


/**
 * 用户表 传输实体
 *
 * @author stef
 * @date 2022-02-10
 */
@Data
@ApiModel(value="User传输实体", description="用户表传输实体")
public class UserDTO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @Null(message = "id需要为空", groups = Create.class)
    @NotNull(message = "id不能为空", groups = Update.class)
    private Long id;

    @ApiModelProperty(value = "登录账号")
    @NotBlank(message = "账户不能为空")
    @Length(min = 4, max = 10, message = "账户需要在4-10字符之间")
    private String username;

    @ApiModelProperty(value = "真实名字")
    @Length(min = 2, max = 10, message = "真实名字需要在4-10字符之间")
    private String realName;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "头像")
    private String avatar;

    @ApiModelProperty(value = "性别(未知:-1,男:1,女:0. 默认：-1)")
    private Integer gender;

    @ApiModelProperty(value = "电子邮件")
    @Email(message = "email不合法")
    private String email;

    @ApiModelProperty(value = "手机号")
    @Pattern(regexp = "^1(3\\d|4[5-9]|5[0-35-9]|6[567]|7[0-8]|8\\d|9[0-35-9])\\d{8}$", message = "手机号格式有误")
    private String mobile;

    @ApiModelProperty(value = "部门ID")
    @NotNull(message = "部门id不能为空", groups = Create.class)
    private Integer deptId;
}
