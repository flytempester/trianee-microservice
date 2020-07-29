package com.bosssoft.springcloud.service;

import tk.mybatis.mapper.entity.Example;

import java.util.List;

public interface BaseService<B> {

     B getByPrimaryKey(Object key);

     B get(B bean);

     List<B> gets(B bean);

     List<B> getAll();

     Class<B> getBeanClass();

     B createBeanObject();

     int insert(B bean);

     void update(B bean);

     boolean delete(Object primaryKey);

     List<B> getsByExample(Example example);

     B getByExample(Example example);
}
