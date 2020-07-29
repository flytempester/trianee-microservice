package com.bosssoft.springcloud.service.impl;

import com.bosssoft.springcloud.dao.mapper.UserRoleMapper;
import com.bosssoft.springcloud.entity.po.UserRolePO;
import com.bosssoft.springcloud.service.AbstractService;
import com.bosssoft.springcloud.service.BaseService;
import com.bosssoft.springcloud.service.UserRoleService;
import org.springframework.stereotype.Service;

/**
 * @author 张东海
 * @date 2020/7/29
 * @description
 */
@Service
public class UserRoleServiceImpl extends AbstractService<UserRolePO, UserRoleMapper>
        implements UserRoleService {

}
