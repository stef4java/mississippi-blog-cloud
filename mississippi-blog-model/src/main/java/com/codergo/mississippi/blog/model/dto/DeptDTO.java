package com.codergo.mississippi.blog.model.dto;


import com.codergo.mississippi.common.base.dto.validator.Create;
import com.codergo.mississippi.common.base.dto.validator.Update;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

/**
 * 部门表 传输实体
 *
 * @author stef
 * @date 2022-02-10
 */
@Data
@ApiModel(value="Dept传输实体", description="部门表传输实体")
public class DeptDTO {

    private static final long serialVersionUID = 1L;


//    @ApiGroupProperty({Update.class})
    @Null(message = "id需要为空", groups = Create.class)
    @NotNull(message = "id不能为空", groups = Update.class)
    private Integer id;

//    @ApiModelProperty(value = "部门名称", required = true)
    @NotNull
    @Size(min = 3, max = 20, message = "部门名称需要3-20个字符之间")
    private String name;
}
