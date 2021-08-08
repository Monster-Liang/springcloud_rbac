package com.rbac.rbacService.controller;

import com.bosssoft.rbac.entity.dto.RoleDTO;
import com.bosssoft.rbac.entity.vo.RoleVO;
import com.bosssoft.rbac.exception.MyException;
import com.bosssoft.rbac.sevice.RoleSevice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
/**
 * @author  梁家宝
 * @description 角色控制层
 */
@Slf4j
@RestController
@RequestMapping("/rbac/role")
@CrossOrigin
public class RoleController {
    @Resource
    private RoleService roleService;

    /**
     * 添加角色
     * @param roleVO 角色信息
     * @return
     */
    @PostMapping
    public boolean addRole(@RequestBody @Valid RoleVO roleVO, BindingResult bindingResult){
        if (roleVO != null){
            if (bindingResult.hasErrors()){
                throw new MyException(10005, "角色的有关格式不正确");
            }
            RoleDTO roleDTO = new RoleDTO();
            BeanUtils.copyProperties(roleVO, roleDTO);
            boolean flag = roleService.addRoles(roleDTO);
            if (flag) {
                log.info("添加成功");
                return true;
            }
        }
        log.info("添加失败");
        return false;
    }
    /**
     * 角色的删除
     * @param id 需要删除的角色的id
     * @return 返回角色删除的结果
     */
    @DeleteMapping("/{rid}")
    public boolean deleteRole(@PathVariable("rid") Long id){
        if (id != null){
            Boolean flag = roleService.removeroles(id);
            if (flag){
                log.info("删除成功");
                return true;
            }
        }
        log.info("删除失败");
        return false;

    }
    /**
     * 角色信息的修改
     * @param roleVO 角色信息
     * @return
     */
    @PutMapping
    public  boolean updateRole(@RequestBody @Valid RoleVO roleVO, BindingResult bindingResult){
        if (roleVO != null){
            if (bindingResult.hasErrors()){
                throw new MyException(10005, "角色的有关格式不正确");
            }
            RoleDTO roleDTO = new RoleDTO();
            BeanUtils.copyProperties(roleVO, roleDTO);
            Boolean flag = roleService.updateRoles(roleDTO);
            if (flag) {
                log.info("修改成功");
                return true;
            }
        }
        log.info("修改失败");
        return false;
    }



    /**
     * 角色信息的查询
     * @param id 需要查询的角色id
     * @return
     */
    @GetMapping("/{rid}")
    public boolean getRoleById(@PathVariable("rid") Long id){
        if (id != null) {
            RoleDTO roleDTO = roleService.queryRoleById(id);
            if (roleDTO != null) {
                RoleVO roleVO = new roleVO();
                BeanUtils.copyProperties(roleDTO, roleVO);
                log.info("查询成功");
                return true;
            }
        }
        log.info("查询失败");
        return false;

    }

}
