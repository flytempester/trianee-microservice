package com.bosssoft.springcloud.controller;

import com.bosssoft.springcloud.entity.dto.MenuInfoDTO;
import com.bosssoft.springcloud.entity.po.MenuInfoPO;
import com.bosssoft.springcloud.service.MenuInfoService;
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
public class MenuInfoController {
    @Resource
    private MenuInfoService menuInfoService;

    @GetMapping("/menuInfo/getAll")
    public List<MenuInfoDTO> getAll(){
        List<MenuInfoPO> menuInfoPOs = menuInfoService.getAll();
        return menuInfoPOs.stream()
                .map(menuInfoPO ->
                        new MenuInfoDTO(menuInfoPO.getId(), menuInfoPO.getName())
                )
                .collect(Collectors.toList());
    }

    @GetMapping("/menuInfo/get/{id}")
    public MenuInfoDTO get(@PathVariable Integer id){
        MenuInfoPO menuInfoPO = menuInfoService.getByPrimaryKey(id);
        return new MenuInfoDTO(menuInfoPO.getId(),menuInfoPO.getName());
    }

    @PostMapping("/menuInfo/add")
    public int add(MenuInfoPO menuInfoPO){
        return menuInfoService.insert(menuInfoPO);
    }

    @PutMapping("/menuInfo/update")
    public void update(MenuInfoPO menuInfoPO){
        menuInfoService.update(menuInfoPO);
    }

    @DeleteMapping("/menuInfo/delete/{id}")
    public boolean delete(@PathVariable Integer id){
        return menuInfoService.delete(id);
    }
}
