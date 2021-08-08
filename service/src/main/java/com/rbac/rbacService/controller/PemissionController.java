package com.rbac.rbacService.controller;

import com.bosssoft.rbac.entity.dto.PermissionDTO;
import com.bosssoft.rbac.entity.vo.PermissionVO;
import com.bosssoft.rbac.exception.MyException;
import com.bosssoft.rbac.sevice.PermissionSevice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
/**
 * @author  梁家宝
 * @description 权限控制层
 */
@Slf4j
@RestController
@RequestMapping("/rbac/permisssion")
@CrossOrigin
public class PemissionController {
    @Resource
    private PermissionSevrvice permissionService;
    /**
     * 添加权限
     * @param permissionVO 权限信息
     * @return
     */
    @PostMapping("/rbac/insertPermisssion")
    public boolean addPermission(@RequestBody @Valid PermissionVO permissionVO,  BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new MyException(10005, "权限的有关格式不正确");
        }
        PermissionDTO permissionDTO = new Permission();
        BeanUtils.copyProperties(permissionVO, permissionDTO);
        boolean flag = permissionService.addPermission(permissionDTO);
        if (flag) {
            log.info("添加成功");
            return true;
        }
        log.info("添加失败");
        return false;
    }
    /**
     * 权限的删除
     * @param id 需要删除的权限的id
     * @return
     */
    @DeleteMapping("/{pid}")
    public boolean deletePermission(@PathVariable("pid") Long id){
        if (id != null){
            Boolean flag = permissionService.removeById(id);
            if (flag){
                log.info("删除成功");
                return true;
            }
        }
        log.info("删除失败");
        return false;

    }
    /**
     * 权限信息的修改
     * @param permissionVO 订单信息
     * @return
     */
    @PutMapping
    public  boolean updatePermission(@RequestBody @Valid PermissionVO permissionVO, BindingResult bindingResult){
        if (permissionVO != null){
            if (bindingResult.hasErrors()){
                throw new MyException(10005, "商品的有关格式不正确");
            }
            PermissionDTO permissionDTO = new PermissionDTO();
            BeanUtils.copyProperties(permissionVO, permissionDTO);
            Boolean flag = orderService.updataPermission(permissionDTO);
            if (flag) {
                log.info("修改成功");
                return true;
            }
        }
        log.info("修改失败");
        return false;
    }
    /**
     * 权限信息的查询
     * @param id 需要查询的权限id
     * @return
     */
    @GetMapping("/{pid}")
    public boolean getPermissionById(@PathVariable("pid") Long id){
        if (id != null) {
            PermissionDTO permissionDTO = permissionService.getPermissionById(id);
            if (permissionDTO != null) {
                PermissionVO permissionVO = new PermissionVO();
                BeanUtils.copyProperties(permissionDTO, permissionVO);
                log.info("查询成功");
                return true;
            }
        }
        log.info("查询失败");
        return false;

    }
}
