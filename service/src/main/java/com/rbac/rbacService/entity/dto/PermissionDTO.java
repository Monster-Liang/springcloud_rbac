package com.rbac.rbacService.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 梁家宝
 * @description 权限DTO
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PermissionDTO {

    @ApiModelProperty(value = "权限ID")
    private Long pId;

    @ApiModelProperty(value = "权限名称")
    private String permissionName;

    @ApiModelProperty(value = "权限描述")
    private String permissionInfo;
}
