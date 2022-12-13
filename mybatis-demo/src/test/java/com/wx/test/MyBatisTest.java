package com.wx.test;

import com.wx.mapper.BrandMapper;
import com.wx.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MyBatisTest {
    @Test
   public void testSelectAll() throws IOException {
       //1.加载核心配置文件，获取 SqlSessionFactory
       String resource = "mybatis-config.xml";
       InputStream inputStream = Resources.getResourceAsStream(resource);
       SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
       SqlSession sqlSession = sqlSessionFactory.openSession();
       BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
       List<Brand> brands = mapper.selectAll();
       System.out.println(brands);
       sqlSession.close();

   }
   @Test
    public void selectOFId() throws IOException {
        //1.加载核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
       BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
       Brand brand = mapper.selectById(1);
       System.out.println(brand);
        sqlSession.close();

    }
    @Test
    public void selectByCondition() throws IOException {
        //1.加载核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //List<Brand> brands = mapper.selectByCondition(new Brand(0,"%三只%","%三只%"));
        //List<Brand> brands = mapper.selectByCondition(0, "%三只%", "%三只%");
        Map map=new HashMap();
        map.put("status",0);
        map.put("companyName","%三只%");
        map.put("brandName","%三只%");
        List<Brand> brands = mapper.selectByCondition(map);
        System.out.println(brands);
        sqlSession.close();
    }
}
