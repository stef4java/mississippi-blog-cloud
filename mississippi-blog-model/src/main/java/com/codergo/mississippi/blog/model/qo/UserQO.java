package com.codergo.mississippi.blog.model.qo;

    import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
* 用户表 查询对象
*
* @author stef
* @date 2022-02-10
*/
@Data
@ApiModel(value="User查询对象", description="用户表查询对象")
public class UserQO {
    @ApiModelProperty(value = "按照[昵称]和[真实名字]模糊搜索")
    private String keyword;


    @ApiModelProperty(value = "性别(未知:-1,男:1,女:0. 默认：-1)")
    private Integer gender;
}
