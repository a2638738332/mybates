package com.wx.mapper;

import com.wx.pojo.User;

import java.util.List;

public interface UserMapper {


    List<User> selectAll();
    User selectForId(int id);
}
