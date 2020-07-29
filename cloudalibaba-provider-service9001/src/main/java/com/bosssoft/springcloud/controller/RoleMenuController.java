package com.bosssoft.springcloud.controller;

import com.bosssoft.springcloud.entity.dto.RoleMenuDTO;
import com.bosssoft.springcloud.entity.po.RoleMenuPO;
import com.bosssoft.springcloud.service.RoleMenuService;
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
public class RoleMenuController {
    @Resource
    private RoleMenuService roleMenuService;

    @GetMapping("/roleMenu/getAll")
    public List<RoleMenuDTO> getAll(){
        List<RoleMenuPO> roleMenuPOs = roleMenuService.getAll();
        List<RoleMenuDTO> collect = roleMenuPOs.stream()
                .map(roleMenuPO ->
                        new RoleMenuDTO(roleMenuPO.getId(),
                                roleMenuPO.getRoleId(), roleMenuPO.getMenuId())
                )
                .collect(Collectors.toList());
        return collect;
    }

    @GetMapping("/roleMenu/get/{id}")
    public RoleMenuDTO get(@PathVariable Integer id){
        RoleMenuPO roleMenuPO = roleMenuService.getByPrimaryKey(id);
        return new RoleMenuDTO(roleMenuPO.getId(),roleMenuPO.getRoleId(),roleMenuPO.getMenuId());
    }

    @PostMapping("/roleMenu/add")
    public int add(RoleMenuPO roleMenuPO){
        return roleMenuService.insert(roleMenuPO);
    }

    @PutMapping("/roleMenu/update")
    public void update(RoleMenuPO roleMenuPO){
        roleMenuService.update(roleMenuPO);
    }

    @DeleteMapping("/roleMenu/delete/{id}")
    public boolean delete(@PathVariable Integer id){
        return roleMenuService.delete(id);
    }
}
