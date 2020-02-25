package com.chinasoft.dao;

import com.chinasoft.utils.DBUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Map;
import java.util.Set;

public class jdbcTempImpl implements jdbcTempInter {

    @Override
    public boolean getlogin(String name, String password) {
        JdbcTemplate template = new JdbcTemplate(DBUtils.getDataSource());
        boolean flag = false;
        //System.out.println("name="+name+" password="+password);
         if(name.equals("") || name.equals(null)){
             //System.out.println("用户名为空");
             return false;
         }
         if(password.equals("") || password.equals(null)){
             //System.out.println("密码为空");
             return false;
         }
        String sql = "select name,password from user where name = ?";
        Map<String, Object> map = null;
        try {
            map = template.queryForMap(sql, name);
        } catch (DataAccessException e) {
            //System.out.println("用户不存在");
            return false;
        }
        Set<Map.Entry<String, Object>> entries = map.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            String pass = (String) entry.getValue();
            if(password.equals(pass)){
                flag = true;
            }
        }
        return flag;

    }

    @Override
    public boolean RegisterUsername(String name) {
        boolean flag = false;
        JdbcTemplate template = new JdbcTemplate(DBUtils.getDataSource());
        String sql = "select id from user where name=?";
        Map<String, Object> map = null;
        try {
            map = template.queryForMap(sql, name);
        } catch (DataAccessException e) {
            //System.out.println("用户不存在");
            flag = true;
        }
        return flag;
    }

    @Override
    public void Register(String name, String password) {
        JdbcTemplate template = new JdbcTemplate(DBUtils.getDataSource());
        String sql="insert into user(name,password) values(?,?)";
        template.update(sql,name,password);
    }
}
