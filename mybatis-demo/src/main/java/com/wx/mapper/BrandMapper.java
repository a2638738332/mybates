package com.wx.mapper;

import com.wx.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
    public List<Brand> selectAll();
    public Brand selectById(int id);

    public List<Brand> selectByCondition(Brand brand);
    public List<Brand> selectByCondition(@Param("status") Integer status,@Param("companyName") String company_name,@Param("brandName") String brand_name);
    public List<Brand> selectByCondition(Map map);

    public List<Brand> selectByConditionSingle(Map map);
}
