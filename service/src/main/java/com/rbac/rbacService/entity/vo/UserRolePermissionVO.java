package com.rbac.rbacService.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @author 张高奎
 * @version 1.0
 * @description  总表数据
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserRolePermissionVO {
    //做简单的验证，不能为空，限制长度Permission

    @ApiModelProperty(value = "用户名称")
    @NotNull(message = "用户名称不能为空!")
    @Length(min = 1,max = 24,message = "权限长度在1到24之间")
    private String User;

    @ApiModelProperty(value = "权限名称")
    @NotNull(message = "权限名称不能为空!")
    @Length(min = 6,max = 24,message = "权限名称在1-24之间")
    private String permission;

    @ApiModelProperty(value = "角色名称")
    @NotNull(message = "角色名称不能为空!")
    @Length(min = 6,max = 24,message = "角色名称在1-24之间")
    private String role;



}
