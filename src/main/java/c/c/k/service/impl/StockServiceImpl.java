package c.c.k.service.impl;

import c.c.k.domain.Stock;
import c.c.k.domain.User;
import c.c.k.repository.StockRepository;
import c.c.k.repository.UserRepository;
import c.c.k.service.StockService;
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
public class StockServiceImpl implements StockService {
    @Resource
    private StockRepository stockRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(Stock stock) {
        //user.setId(35);
        stockRepository.save(stock);

        //测试异常是否回滚
        //throw new RuntimeException("abc");
    }

    @Override
    public void getStock(int stockId) {
        //userRepository.findById(userId).get().
    }
}
