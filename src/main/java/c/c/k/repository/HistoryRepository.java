package c.c.k.repository;

import c.c.k.domain.History;
import c.c.k.domain.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Title chen.ce.kuan.repository
 * @Copyright: Copyright 2018
 * @Description: java <br/>
 * @Created on 2018/7/16 chenck
 */
public interface HistoryRepository extends JpaRepository<History, Long> {
}
