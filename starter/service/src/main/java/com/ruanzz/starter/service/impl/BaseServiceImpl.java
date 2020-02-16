package com.ruanzz.starter.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruanzz.starter.mapper.BaseMapper;

/**
 * @author Zhenzhuo.Ruan
 */
public class BaseServiceImpl<M extends BaseMapper<E>, E> extends
    ServiceImpl<M, E> {

}
