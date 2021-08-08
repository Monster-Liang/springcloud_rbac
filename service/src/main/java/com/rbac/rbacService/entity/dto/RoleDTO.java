package com.rbac.rbacService.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author  梁家宝
 * @description 角色DTO
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RoleDTO {
    @ApiModelProperty(value = "角色ID")
    private Long rId;

    @ApiModelProperty(value = "角色名称")
    private String roleName;

    @ApiModelProperty(value = "角色描述")
    private String roleInfo;
}
