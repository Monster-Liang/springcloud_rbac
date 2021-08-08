package com.rbac.rbacService.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bosssoft.rbac..entity.dto.UserDTO;
import com.bosssoft.rbac.entity.po.UserPO;
import com.bosssoft.rbac.entity.vo.UserVO;
import com.bosssoft.rbac.exception.MyException;
import com.bosssoft.rbac.mapper.dao.UserMapper;
import com.bosssoft.rbac.sevice.UserSevice;
import com.bosssoft.rbac.utils.TokenUtil;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.util.DigestUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
/**
 * @author  梁家宝
 * @description  有关用户操作
 */
@Slf4j
@RestController
@RequestMapping("/rbac/user")
@CrossOrigin
public class UserController {
    @Resource
    private UserSevice userService;
    @Resource
    private UserMapper userMapper;
    private String userToken;

    /**
     * 用户注册
     * @param userVO 前端传入的用户注册信息
     * @return
     */
    @PostMapping("/register")
    @ApiOperation(value = "register",notes = "用户注册",tags = "UserRegister",httpMethod = "POST")
    public boolean Register(@RequestBody @Valid UserVO userVO, BindingResult bindingResult) {
        try {
            if (userVO != null) {
                if (bindingResult.hasErrors()) {
                    throw new MyException(10004, "输入的用户名或者密码格式不正确");
                }
                UserDTO userDTO = new UserDTO();
                BeanUtils.copyProperties(userVO, userDTO);
                boolean flag = userService.saveUser(userDTO);
                if (flag) {
                    log.info("注册成功");
                    return true;
                }
            }
            log.info("注册失败");
            return false;
        } catch (Exception e) {
            log.info("注册失败");
            return false;
        }

    }

    /**
     * 用户的登录
     * @param name 用户名
     * @param password 密码
     * @return
     */
    @GetMapping("/login")
    @ApiOperation(value = "login",notes = "用户登录",tags = "UserLogin",httpMethod = "GET")

    public boolean login(@RequestParam("userName") String name,@RequestParam("password") String password){
        try {
            if(name != null && password !=null){
                QueryWrapper<UserPO> queryWrapper = new QueryWrapper<>();
                queryWrapper.eq("user_name", name);
                String md5 = DigestUtils.md5DigestAsHex(password.getBytes());
                String temp = md5.substring(8,24);
                queryWrapper.eq("user_password", DigestUtils.md5DigestAsHex((temp+md5).getBytes()));
                UserPO userPO = userMapper.selectOne(queryWrapper);
                UserDTO userDTO =new UserDTO();
                BeanUtils.copyProperties(userPO, userDTO);
                if (userDTO != null){
                    UserVO userVO = new UserVO();
                    BeanUtils.copyProperties(userDTO, userVO);
                    userToken = TokenUtil.createToken(userVO);
                    log.info("登录成功");
                    return true;
                }
            }
            log.info("注册失败");
            return false;
        }catch (Exception e) {
            log.info("注册失败");
            return false;
        }

    }

}
