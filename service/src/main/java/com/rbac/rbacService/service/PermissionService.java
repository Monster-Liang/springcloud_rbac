package com.rbac.rbacService.service;
import com.bosssoft.rbac.entity.dto.PemissionDTO;


public interface PermissionService {
    /**
     * 根据权限id获取权限信息
     * @param id 权限id
     * @return 返回权限DTO
     */
    public PermissionDTO getPermissionById(long id);

    /**
     * 添加权限
     * @param permissionDTO  权限DTO
     * @return
     */
    public boolean addPermission(PermissionDTO permissionDTO);

    /**
     * 修改权限
     * @param orderDTO  权限DTO
     * @return
     */
    public boolean updataPermission(PermissionDTO permissionDTO);

    /**
     * 去除某个权限
     * @param id 权限Id
     * @return
     */
    public boolean removeById(Long id);
}
