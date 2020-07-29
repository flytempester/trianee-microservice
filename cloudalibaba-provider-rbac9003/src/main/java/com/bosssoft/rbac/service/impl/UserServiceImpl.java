package com.bosssoft.rbac.service.impl;

import com.bosssoft.rbac.dao.mapper.UserInfoMapper;
import com.bosssoft.rbac.entity.dto.UserDTO;
import com.bosssoft.rbac.entity.po.UserInfoPO;
import com.bosssoft.rbac.service.UserService;
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
        List<UserInfoPO> userInfoPOS = userInfoMapper.selectAll();
        List<UserDTO> userDTOs = new ArrayList<>();
        for (UserInfoPO userInfoPO : userInfoPOS) {
            UserDTO userDTO = new UserDTO(userInfoPO.getId(), userInfoPO.getPassword());
            userDTOs.add(userDTO);
        }
        return (UserDTO[]) userDTOs.toArray();
    }
}
