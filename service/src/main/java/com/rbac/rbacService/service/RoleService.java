package com.rbac.rbacService.service;
import com.bosssoft.rbac.entity.dto.GoodDTO;



public interface RoleService {
    /**
     * 根据id查询权限信息
     * @param id 需要查询的权限信息id
     * @return 将得到的商品信息封装成商品数据传输对象并返回
     */
    RoleDTO queryRoleById(Long id);

    /**
     * 角色信息的添加
     * @param roleDTO 前端传入的角色
     * @return
     */
    boolean addRoles(RoleDTO roleDTO);

    /**
     * 角色信息的修改
     * @param goodDTO 前端传入的商品角色修改
     * @return
     */
    boolean updateROles(RoleDTO roleDTO);

    /**
     * 根据商品id删除角色信息
     * @param id 需要删除的角色的id
     * @return
     */
    boolean removeRoles(Long id);

}
