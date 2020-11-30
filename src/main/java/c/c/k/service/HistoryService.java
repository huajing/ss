package c.c.k.service;


import c.c.k.domain.User;

/**
 * @Title chen.ce.kuan.service
 * @Copyright: Copyright 2018
 * @Description: java <br/>
 * @Created on 2018/7/16 chenck
 */
public interface HistoryService {
    public void save(User user);
    public void getUser(int userId);
}
