package com.bosssoft.springcloud.controller;

import com.bosssoft.springcloud.entity.dto.UserRoleDTO;
import com.bosssoft.springcloud.entity.po.UserRolePO;
import com.bosssoft.springcloud.service.UserRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 张东海
 * @date 2020/7/29
 * @description
 */
@RestController
@Slf4j
public class UserRoleController {
    @Resource
    private UserRoleService userRoleService;

    @GetMapping("/userRole/getAll")
    public List<UserRoleDTO> getAll(){
        List<UserRolePO> userRolePOs = userRoleService.getAll();
        return userRolePOs.stream()
                .map(userRolePO ->
                        new UserRoleDTO(userRolePO.getId(),
                                userRolePO.getUserId(),userRolePO.getRoleId())
                )
                .collect(Collectors.toList());
    }

    @GetMapping("/userRole/get/{id}")
    public UserRoleDTO get(@PathVariable Integer id){
        UserRolePO userRolePO = userRoleService.getByPrimaryKey(id);
        return new UserRoleDTO(userRolePO.getId(),userRolePO.getUserId(),userRolePO.getRoleId());
    }

    @PostMapping("/userRole/add")
    public int add(UserRolePO userRolePO){
        return userRoleService.insert(userRolePO);
    }

    @PutMapping("/userRole/update")
    public void update(UserRolePO userRolePO){
        userRoleService.update(userRolePO);
    }

    @DeleteMapping("/userRole/delete/{id}")
    public boolean delete(@PathVariable Integer id){
        return userRoleService.delete(id);
    }
}
