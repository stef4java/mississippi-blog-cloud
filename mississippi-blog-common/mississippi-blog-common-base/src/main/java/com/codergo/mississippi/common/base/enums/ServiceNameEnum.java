package com.codergo.mississippi.common.base.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

/**
 * @author stef
 * @version 1.0
 * @date 2022/4/24 20:56
 */
@Getter
@AllArgsConstructor
public enum ServiceNameEnum {

    UPMS("UPMS", "通用用户权限管理系统"),
    OA("OA", "办公自动化系统"),
    CRM("CRM", "客户关系管理系统");

    @Getter
    private String name;

    ServiceNameEnum(String name, String description) {
        this.name = name;
    }

    public static ServiceNameEnum toType(String name) {
        return Stream.of(ServiceNameEnum.values())
                .filter(c -> c.name.equals(name))
                .findAny()
                .orElse(null);
    }

}