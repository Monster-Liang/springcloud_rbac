package com.rbac.rbacService.mapper.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rbac.rbacService.entity.po.RolePO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author 梁家宝
 * @version 1.0
 * @description  角色的mapper
 */

@Mapper
@Repository
public interface RoleMapper extends BaseMapper<RolePO> {
}
