package c.c.k.repository;

import c.c.k.domain.Stock;
import c.c.k.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Title chen.ce.kuan.repository
 * @Copyright: Copyright 2018
 * @Description: java <br/>
 * @Created on 2018/7/16 chenck
 */
public interface StockRepository extends JpaRepository<Stock, Long> {
}
