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
 * @description
 * @data
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RoleVO {
    //做简单的验证，不能为空，限制长度
    @ApiModelProperty(value = "角色名称")
    @NotNull(message = "角色名称不能为空!")
    @Length(min = 1,max = 24,message = "角色名称长度在1到24之间")
    private String roleName;

    @ApiModelProperty(value = "角色描述")
    @NotNull(message = "角色描述不能为空!")
    @Length(min = 6,max = 24,message = "角色描述在6-80之间")
    private String roleInfo;

}
