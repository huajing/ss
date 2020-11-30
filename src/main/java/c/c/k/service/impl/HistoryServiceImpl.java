package c.c.k.service.impl;

import c.c.k.domain.User;
import c.c.k.repository.UserRepository;
import c.c.k.service.HistoryService;
import c.c.k.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Title chen.ce.kuan.service.impl
 * @Copyright: Copyright 2018
 * @Description: java <br/>
 * @Created on 2018/7/16 chenck
 */
@Service
public class HistoryServiceImpl implements HistoryService {
    @Resource
    private UserRepository userRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(User user) {
        //user.setId(35);
        userRepository.save(user);

        //测试异常是否回滚
        //throw new RuntimeException("abc");
    }

    @Override
    public void getUser(int userId) {
        //userRepository.findById(userId).get().
    }
}
