package com.rbac.rbacService.service;

import java.security.Permission;
import com.bosssoft.rbac.entity.dto.PermissionDTO;
import com.bosssoft.rbac.entity.po.PermissionPO;
import com.bosssoft.rbac.mapper.dao.PermissionMapper;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;

/**
 * @author 梁家宝
 */
public class PermissionImpl implements PermissionService {
    @Resource
    private PermissionMapper permissionMapper;

    /**
     * 根据权限id获取权限信息
     * @param id 权限id
     * @return 返回权限DTO
     */
    @Override
    public PermissionDTO getPermissionById(long id){
        if(id > 0){
            PermissionPO permissionPO = permissionMapper.selectById(id);
            if(permissionPO != null){
                PermissionDTO permissionDTO =new PermissionDTO();
                BeanUtils.copyProperties(permissionPO, permissionDTO);
                return orderDTO;
            }

        }
        return null;
    }

    /**
     * 添加权限
     * @param permissionDTO  权限DTO
     * @return
     */
    @Override
    public boolean addPermission(PermissionDTO permissionDTO){
        PermissionPO permissionPO =new PermissionPO();
        BeanUtils.copyProperties(permissionDTO,permissionPO);
        int insert = permissionMapper.insert(permissionPO);
        if (insert > 0){
            return true;
        }
        return false;
    }

    /**
     * 修改权限
     * @param orderDTO  权限DTO
     * @return
     */
    @Override
    public boolean updataPermission(PermissionDTO permissionDTO){
        PermissionPO permissionPO =new PermissionPO();
        BeanUtils.copyProperties(permissionDTO,permissionPO);
        int update = permissionMapper.updateById(permissionPO);
        if(update >0 ){
            return true;
        }
        return false;
    }

    /**
     * 去除某个权限
     * @param id 权限Id
     * @return
     */
    @Override
    public boolean removeById(Long id){
        int delete = permissionMapper.deleteById(id);
        if(delete > 0){
            return true;
        }
        return false;

    }
}
