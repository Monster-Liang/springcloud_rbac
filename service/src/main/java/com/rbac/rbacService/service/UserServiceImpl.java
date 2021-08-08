package com.rbac.rbacService.service;
import com.bosssoft.rbac.entity.dto.UserDTO;

import javax.annotation.Resource;

import com.bosssoft.rbac.entity.po.UserPO;
import com.bosssoft.rbac.exception.ExceptionType;
import com.bosssoft.rbac.exception.MyException;
import com.bosssoft.rbac.mapper.dao.UserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.util.DigestUtils;
/**
 * @author 张高奎
 * @version 1.0
 * @description 用户业务
 */
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;


    /**
     * 储存用户信息
     * @param userDTO 用户密码,加盐值加密存到数据库中
     * @return
     */
    @Override
    public boolean saveUser(UserDTO userDTO){
        try {
            UserPO userPO =new UserPO();
            userPO.setUserName(userDTO.getUserName());
            //使用md5加密,加上盐值
            String md5 = DigestUtils.md5DigestAsHex(userDTO.getPassword().getBytes());
            String temp = md5.substring(8,24);
            userPO.setPassword(DigestUtils.md5DigestAsHex((temp+md5).getBytes()));
            int insert = userMapper.insert(userPO);
            if (insert > 0){
                return true;
            } else {
                return false;
            }
        }catch (Exception e) {
            throw new MyException(ExceptionType.SYSTEM_ERROR);
        }

    }

    /**
     * 修改密码
     * @param id 用户Id
     * @return 修改成功为true，失败为false
     */
    @Override
    public boolean updatePassword(long id, String password){
        if(id > 0){
            UserPO userPO = userMapper.selectById(id);
            userPO.setPassword(password);
            return true;
        }
        return false;
    }

    /**
     * 获得用户信息
     * @param id 用户id
     * @return UserDTO用户传输对象
     */
    @Override
    public UserDTO getUserById(long id){
        if (id > 0) {
            UserPO userPO = userMapper.selectById(id);
            if(userPO != null){
                UserDTO useDTO = new UserDTO();
                BeanUtils.copyProperties(userPO, useDTO);
                return useDTO;
            }
        }
        return null;
    }
}
