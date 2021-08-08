package com.rbac.rbacService.service;

import com.bosssoft.rbac.entity.dto.RoleDTO;
import com.bosssoft.rbac.entity.po.RolesPO;
import com.bosssoft.rbac.mapper.dao.RoleMapper;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;
/**
 * @author 张高奎
 * @version 1.0
 * @description  角色业务
 */
public class RoleServiceImpl implements RoleService {
    @Resource
    private ROleMapper roleMapper;
    /**
     * 根据id查询权限信息
     * @param id 需要查询的权限信息id
     * @return 将得到的商品信息封装成商品数据传输对象并返回
     */
    @Override
    public RoleDTO queryRoleById(Long id){
        if(id > 0){
            RolePO rolePO = roleMapper.selectById(id);
            if(rolePO != null){
                RoleDTO roleDTO =new roleDTO();
                BeanUtils.copyProperties(rolePO, roleDTO);
                return roleDTO;
            }

        }
        return null;
    }

    /**
     * 角色信息的添加
     * @param roleDTO 前端传入的角色
     * @return
     */
    @Override
    public boolean addRole(RoleDTO RoleDTO){
        RolePO rolePO =new RolePO();
        BeanUtils.copyProperties(roleDTO,rolePO);
        int insert = roleMapper.insert(rolePO);
        if (insert > 0){
            return true;
        }
        return false;
    }

    /**
     * 角色信息的修改
     * @param goodDTO 前端传入的商品角色修改
     * @return
     */
    @Override
    public boolean updateRole(RoleDTO roleDTO){
        RolePO rolePO = new RolePO();
        BeanUtils.copyProperties(roleDTO, rolePO);
        int update = roleMapper.updateById(rolePO);
        if(update >0 ){
            return true;
        }
        return false;
    }

    /**
     * 根据商品id删除角色信息
     * @param id 需要删除的角色的id
     * @return
     */
    @Override
    public boolean removeRole(Long id){
        int delete = roleMapper.deleteById(id);
        if(delete > 0){
            return true;
        }
        return false;
    }
}
