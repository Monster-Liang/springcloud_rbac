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
 * @description 权限PO
 */
@NoArgsConstructor
@AllArgsConstructor
@TableName("permissions")
@Data
public class PessmissionPO {

    @ApiModelProperty(value = "权限ID")
    @TableId(value = "pid")
    private Long pId;

    @ApiModelProperty(value = "权限名称")
    @TableField(value = "permission_name")
    private String permissionName;

    @ApiModelProperty(value = "权限描述")
    @TableField(value = "permission_info")
    private String permissionInfo;

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
