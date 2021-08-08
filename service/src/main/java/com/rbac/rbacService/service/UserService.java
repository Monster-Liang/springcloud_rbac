package com.rbac.rbacService.service;
import com.bosssoft.rbac.entity.dto.UserDTO;
/**
 * @author 梁家宝
 * @description 用户业务层接口
 */
public interface UserService {
    /**
     * 储存用户信息
     * @param userDTO 用户密码
     * @return
     */
    public boolean saveUser(UserDTO userDTO);

    /**
     * 修改密码
     * @param id 用户Id
     * @return
     */
    public boolean updatePassword(long id, String password);

    /**
     * 获得用户信息
     * @param id 用户id
     * @return UserDTO用户传输对象
     */
    public UserDTO getUserById(long id);
}
