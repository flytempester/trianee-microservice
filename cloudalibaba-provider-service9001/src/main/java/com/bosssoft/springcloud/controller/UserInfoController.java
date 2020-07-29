package com.bosssoft.springcloud.controller;

import com.bosssoft.springcloud.entity.dto.UserInfoDTO;
import com.bosssoft.springcloud.entity.po.UserInfoPO;
import com.bosssoft.springcloud.service.UserInfoService;
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
public class UserInfoController {
    @Resource
    private UserInfoService userInfoService;

    @GetMapping("/userInfo/getAll")
    public List<UserInfoDTO> getAll(){
        List<UserInfoPO> userInfoPOs = userInfoService.getAll();
        return userInfoPOs.stream()
                .map(userInfoPO ->
                   new UserInfoDTO(userInfoPO.getId(), userInfoPO.getName())
                )
                .collect(Collectors.toList());
    }

    @GetMapping("/userInfo/get/{id}")
    public UserInfoDTO get(@PathVariable Integer id){
        UserInfoPO userInfoPO = userInfoService.getByPrimaryKey(id);
        return new UserInfoDTO(userInfoPO.getId(),userInfoPO.getName());
    }

    @PostMapping("/userInfo/add")
    public int add(UserInfoPO userInfoPO){
       return userInfoService.insert(userInfoPO);
    }

    @PutMapping("/userInfo/update")
    public void update(UserInfoPO userInfoPO){
        userInfoService.update(userInfoPO);
    }

    @DeleteMapping("/userInfo/delete/{id}")
    public boolean delete(@PathVariable Integer id){
        return userInfoService.delete(id);
    }
}
