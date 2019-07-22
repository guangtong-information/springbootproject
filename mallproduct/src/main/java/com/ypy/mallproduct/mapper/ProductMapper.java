package com.ypy.mallproduct.mapper;

import com.ypy.mallproduct.bean.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductMapper {

    @Insert("insert into products(pname,type,price) values(#{pname},#{type},#{price})")
    public Integer add(Product product);

    @Delete("delete from products where pid=#{arg1}")
    public Integer deleteById(Integer id);

    @Update("update products set pname=#{pname},type=#{type},price=#{price} where pid=#{pid}")
    public Integer update(Product product);

    @Select("select * from products where pid=#{arg1}")
    public Product getById(Integer id);

    @Select("select * from products order by pid desc")
    public List<Product> queryByLists();

}
