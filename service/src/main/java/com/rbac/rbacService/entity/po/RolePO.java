package com.rbac.rbacService.entity.po;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 张高奎
 * @version 1.0
 * @description  角色PO
 */

@NoArgsConstructor
@AllArgsConstructor
@TableName("roles")
@Data
public class RolePO {

    @ApiModelProperty(value = "角色ID")
    @TableId(value = "rid")
    private Long rId;

    @ApiModelProperty(value = "角色名称")
    @TableField(value = "role_name")
    private String roleName;

    @ApiModelProperty(value = "角色描述")
    @TableField(value = "role_info")
    private String roleInfo;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @ApiModelProperty(value = "版本号")
    @TableField(value = "f_version",fill = FieldFill.INSERT)
    private Integer version;

    @ApiModelProperty(value = "逻辑删除标志 1已删除 0未删除")
    @TableField(value = "logic_delete",select = false)
    @TableLogic
    private Integer deleted;
}
