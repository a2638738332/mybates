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
        //map.put("status",0);
        map.put("companyName","%三只%");
        map.put("brandName","%三只%");
        List<Brand> brands = mapper.selectByCondition(map);
        System.out.println(brands);
        sqlSession.close();
    }
    @Test
    public void selectByConditionSingle() throws IOException {
        //1.加载核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //List<Brand> brands = mapper.selectByCondition(new Brand(0,"%三只%","%三只%"));
        //List<Brand> brands = mapper.selectByCondition(0, "%三只%", "%三只%");
        Map map=new HashMap();
        map.put("status",1);
        List<Brand> brands = mapper.selectByConditionSingle(map);
        System.out.println(brands);
        sqlSession.close();
    }
    @Test
    public void addTest() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = new Brand("王鑫", "有限公司", 0, "牛逼克拉斯", 1);
        mapper.add(brand);
        System.out.println(brand.getId());
        sqlSession.close();
    }
    @Test
    public void updateTest() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = new Brand("", "", 0, "牛逼xxx克拉斯", 1);
        brand.setId(7);
        int update = mapper.update(brand);
        System.out.println(update);
        sqlSession.close();
    }
    @Test
    public void delectTest() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.delectById(7);
        sqlSession.close();
    }
    @Test
    public void delectsTest() throws IOException {
        int[] ids={6,8,9,10};
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.delectByIds(ids);
        sqlSession.close();
    }

}
