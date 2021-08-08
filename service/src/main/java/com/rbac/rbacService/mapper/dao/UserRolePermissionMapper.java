package com.rbac.rbacService.mapper.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rbac.rbacService.entity.po.UserRolePermissionPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author 梁家宝
 * @description  总表的mapper
 */

@Mapper
@Repository
public interface UserRolePermissionMapper extends BaseMapper<UserRolePermissionPO> {
}
