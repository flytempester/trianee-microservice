package com.bosssoft.RBAC.service.impl;

import com.bosssoft.RBAC.DAO.mapper.UserInfoMapper;
import com.bosssoft.RBAC.DTO.UserDTO;
import com.bosssoft.RBAC.PO.UserInfo;
import com.bosssoft.RBAC.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 张东海
 * @date 2020/7/27
 * @description
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public UserDTO[] getAllUsers() {
        List<UserInfo> userInfos = userInfoMapper.selectAll();
        List<UserDTO> userDTOs = new ArrayList<>();
        for (UserInfo userInfo : userInfos) {
            UserDTO userDTO = new UserDTO(userInfo.getId(), userInfo.getPassword());
            userDTOs.add(userDTO);
        }
        return (UserDTO[]) userDTOs.toArray();
    }
}
