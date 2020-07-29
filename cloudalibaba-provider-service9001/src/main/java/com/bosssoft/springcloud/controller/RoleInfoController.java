package com.bosssoft.springcloud.controller;

import com.bosssoft.springcloud.entity.dto.RoleInfoDTO;
import com.bosssoft.springcloud.entity.po.RoleInfoPO;
import com.bosssoft.springcloud.service.RoleInfoService;
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
public class RoleInfoController {
    @Resource
    private RoleInfoService roleInfoService;

    @GetMapping("/roleInfo/getAll")
    public List<RoleInfoDTO> getAll(){
        List<RoleInfoPO> roleInfoPOs = roleInfoService.getAll();
        return roleInfoPOs.stream()
                .map(roleInfoPO ->
                        new RoleInfoDTO(roleInfoPO.getId(), roleInfoPO.getName())
                )
                .collect(Collectors.toList());
    }

    @GetMapping("/roleInfo/get/{id}")
    public RoleInfoDTO get(@PathVariable Integer id){
        RoleInfoPO roleInfoPO = roleInfoService.getByPrimaryKey(id);
        return new RoleInfoDTO(roleInfoPO.getId(),roleInfoPO.getName());
    }

    @PostMapping("/roleInfo/add")
    public int add(RoleInfoPO roleInfoPO){
        return roleInfoService.insert(roleInfoPO);
    }

    @PutMapping("/roleInfo/update")
    public void update(RoleInfoPO roleInfoPO){
        roleInfoService.update(roleInfoPO);
    }

    @DeleteMapping("/roleInfo/delete/{id}")
    public boolean delete(@PathVariable Integer id){
        return roleInfoService.delete(id);
    }
}
