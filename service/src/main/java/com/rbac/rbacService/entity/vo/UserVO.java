package com.rbac.rbacService.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;


/**
 * @author 张高奎
 * @version 1.0
 * @description 用户数据VO
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserVO {
    //做简单的验证，不能为空，限制长度
    @ApiModelProperty(value = "用户名")
    @NotNull(message = "用户名不能为空!")
    @Length(min = 1,max = 24,message = "用户名长度在1到24之间")
    private String userName;

    @ApiModelProperty(value = "用户密码")
    @NotNull(message = "密码不能为空!")
    @Length(min = 6,max = 24,message = "密码长度在6-24之间")
    private String password;

    //是否是管理员
    @NotNull(message = "用户的身份需明确!")
    private Boolean admin;
}
