package com.wx.mapper;

import com.wx.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
    /*查询全部*/
    public List<Brand> selectAll();
    /*根据id查询*/
    public Brand selectById(int id);
    /*多条件查询*/
    public List<Brand> selectByCondition(Brand brand);
    public List<Brand> selectByCondition(@Param("status") Integer status,@Param("companyName") String company_name,@Param("brandName") String brand_name);
    public List<Brand> selectByCondition(Map map);
    /*单调条件查询*/
    public List<Brand> selectByConditionSingle(Map map);
    /*添加数据*/
    public void add(Brand brand);
    /*修改数据*/
    public int update(Brand brand);
    /*s删除*/
    public void delectById(int id);
    /*批量删除*/
    public void delectByIds(@Param("ids") int[] ids);
}
