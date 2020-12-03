package c.c.k.service.impl;

import c.c.k.domain.Stock;
import c.c.k.domain.User;
import c.c.k.repository.StockRepository;
import c.c.k.repository.UserRepository;
import c.c.k.service.StockService;
import c.c.k.service.UserService;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Optional;

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
        Optional<Stock> stock1 = this.getStock(stock.getCode());
        if(!stock1.isPresent()) {
            stockRepository.save(stock);
        }
    }

    @Override
    public Optional<Stock> getStock(Long stockId) {
        return stockRepository.findById(stockId);
    }

    @Override
    public Optional<Stock> getStock(String code) {
        Stock stock = new Stock();
        stock.setCode(code);
        Example<Stock> example = Example.of(stock);
        return stockRepository.findOne(example);
    }
}
