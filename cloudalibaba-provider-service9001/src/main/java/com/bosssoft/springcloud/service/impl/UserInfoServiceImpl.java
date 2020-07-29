package com.bosssoft.springcloud.service.impl;

import com.bosssoft.springcloud.dao.mapper.UserInfoMapper;
import com.bosssoft.springcloud.entity.po.UserInfoPO;
import com.bosssoft.springcloud.service.AbstractService;
import com.bosssoft.springcloud.service.UserInfoService;
import org.springframework.stereotype.Service;

/**
 * @author 张东海
 * @date 2020/7/29
 * @description
 */
@Service
public class UserInfoServiceImpl extends AbstractService<UserInfoPO, UserInfoMapper>
        implements UserInfoService {

}
