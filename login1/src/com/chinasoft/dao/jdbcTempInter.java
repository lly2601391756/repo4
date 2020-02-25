package com.chinasoft.dao;

public interface jdbcTempInter {
     boolean getlogin(String name,String password);
     boolean RegisterUsername(String name);
     void Register(String name,String password);
}
