package com.bosssoft.springcloud.service.impl;

import com.bosssoft.springcloud.dao.mapper.MenuInfoMapper;
import com.bosssoft.springcloud.entity.po.MenuInfoPO;
import com.bosssoft.springcloud.service.AbstractService;
import com.bosssoft.springcloud.service.BaseService;
import com.bosssoft.springcloud.service.MenuInfoService;
import org.springframework.stereotype.Service;

/**
 * @author 张东海
 * @date 2020/7/29
 * @description
 */
@Service
public class MenuInfoServiceImpl extends AbstractService<MenuInfoPO, MenuInfoMapper>
        implements MenuInfoService {

}
