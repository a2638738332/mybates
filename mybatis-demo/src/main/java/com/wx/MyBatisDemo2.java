package com.wx;

import com.wx.mapper.UserMapper;
import com.wx.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * mybatis代理开发
 */
public class MyBatisDemo2 {
    public static void main(String[] args) throws IOException {
         //1.加载核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2.获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.执行sql语句
        //List<User> users = sqlSession.selectList("test.t t");
        //获取接口的代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectAll();
        User user = mapper.selectForId(3);

        System.out.println(users);
        System.out.println(user);
        sqlSession.close();


    }

}
