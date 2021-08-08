package com.rbac.rbacService.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author  梁家宝
 * @description  用户DTO
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {
    @ApiModelProperty(value = "用户ID")
    private Long uId;

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "用户密码")
    private String password;
}
