package com.ruanzz.service.impl;

import com.ruanzz.entity.User;
import com.ruanzz.mapper.UserMapper;
import com.ruanzz.service.UserService;
import com.ruanzz.starter.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author Zhenzhuo.Ruan
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper, User> implements UserService {

}
