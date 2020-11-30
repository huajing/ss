package c.c.k.service;


import c.c.k.domain.Stock;

import java.util.Optional;

/**
 * @Title chen.ce.kuan.service
 * @Copyright: Copyright 2018
 * @Description: java <br/>
 * @Created on 2018/7/16 chenck
 */
public interface StockService {
    public void save(Stock stock);
    public Optional<Stock> getStock(Long stockId);
    public Optional<Stock> getStock(String code);
}
