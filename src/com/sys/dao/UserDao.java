package com.sys.dao;

import com.sys.Page;
import com.sys.entity.Area;
import com.sys.entity.User;
import com.sys.utils.JdbcTemplateUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;


public class UserDao {

    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcTemplateUtil.getDataSource());
    //下拉查询
    public List<Area> ss(){
        String sql = "select * from areagl where typeid=1 ";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Area.class));
    }
    //关联
    public List<Area> aa(Integer id){
        String sql = "select * from areagl where d_id=? ";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Area.class),id);
    }

    //查询全部
    public List<User> listAll() {
        String sql = "select * from user";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
    }
    //模糊查询及分页一起实现
    public List<User> listAll(String account, Page page) {
        String sql = "select * from user where name like ? limit ?,?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), "%" + account + "%", (page.getPage() - 1) * page.getPageSize(), page.getPageSize());
    }
    //查询总记录数
    public Integer count(String account) {
        String sql = "select count(1) from user where name like ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, "%" + account + "%");
    }
    //删除语句
    public void delById(Integer id) {
        String sql = "delete from user where id=?";
        jdbcTemplate.update(sql, id);
    }
    //添加语句
    public void addUser(User user) {
        String sql = "insert into user(name,pwd,sex) values(?,?,?)";
        jdbcTemplate.update(sql, user.getName(),user.getPwd(),user.getSex());
    }
    //条件查询
    public User getById(Integer id) {
        String sql = "select * from user where id=?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id);
    }
    //修改语句
    public void uptUser(User user){
        String sql = "update user set name=?,pwd=?,sex=? where id=?";
        jdbcTemplate.update(sql,user.getName(),user.getPwd(),user.getSex(),user.getId());
    }
}
