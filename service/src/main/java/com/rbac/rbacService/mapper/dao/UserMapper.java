package com.rbac.rbacService.mapper.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rbac.rbacService.entity.po.UserPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


/**
 * @author 梁家宝
 * @description  用户的mapper
 */

@Mapper
@Repository
public interface UserMapper extends BaseMapper<UserPO> {
}
