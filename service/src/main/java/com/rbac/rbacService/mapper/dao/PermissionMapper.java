package com.rbac.rbacService.mapper.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rbac.rbacService.entity.po.PessmissionPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author 梁家宝
 * @description  权限的mapper
 */

@Mapper
@Repository
public interface PermissionMapper extends BaseMapper<PessmissionPO> {
}
