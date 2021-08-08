package com.rbac.rbacService.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author  梁家宝
 * @description  总表DTO
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserRolePermissionDTO {
    @ApiModelProperty(value = "用户ID")
    private Long uId;

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "角色名称")
    private String roleName;

    @ApiModelProperty(value = "权限名称")
    private String permissionName;

}
