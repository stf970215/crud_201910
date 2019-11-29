package com.sys.service;

import com.sys.Page;
import com.sys.dao.UserDao;
import com.sys.entity.Area;
import com.sys.entity.User;

import java.util.List;


public class UserService {

    private UserDao userDao = new UserDao();

    public List<User> listAll() {
        return userDao.listAll();
    }
    public List<User> listAll(String account, Page page){
        return userDao.listAll(account,page);
    }
    public Integer count(String account){
        return userDao.count(account);
    }
    public void delById(Integer id) {
        userDao.delById(id);
    }
    public void uptUser(User user){
        userDao.uptUser(user);
    }
    public void addUser(User user) {
        userDao.addUser(user);
    }
    public User getById(Integer id) {
        return userDao.getById(id);
    }

    public List<Area> ss(){
        return userDao.ss();
    }
    public List<Area> aa(Integer id){
        return userDao.aa(id);
    }
}
