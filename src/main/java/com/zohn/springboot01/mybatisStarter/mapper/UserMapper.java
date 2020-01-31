package com.zohn.springboot01.mybatisStarter.mapper;

import com.zohn.springboot01.mybatisStarter.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Description: 访问数据库的接口
 * @Author: zohn
 * @CreateDate: 2019/3/17 11:09
 * @Version: 1.0
 */
public interface UserMapper {

    /**
     * 新增
     * @param user 要存的实体
     * @return -1失败 0 1 成功
     * //推荐使用#{}取值，不要用${},因为存在注入的风险
     */
    @Insert("INSERT INTO user(name, phone, create_time, age) VALUES(#{name}, #{phone}, #{createTime}, #{age})")
    // keyProperty java对象的属性；keyColumn表示数据库的字段
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")

    int insert(User user);


    /**
     * 查询所有
     * @return
     */
    @Select("select * from user")
    @Results({
         @Result(column = "create_time", property = "createTime")
    })
    List<User> getAll();


    /**
     * 通过id查找用户  因为id为主键
     * @param id 用户id
     * @return
     */
    @Select("select * from user where id = #{id}")
    @Results({
            @Result(property = "createTime", column = "create_time")
    })
    User findById(String id);


    /**
     * 更新对象
     * @param user
     */
    @Update("update user set name = #{name} where id = #{id}")
    void update(User user);

    /**
     * 删除对象
     * @param id
     */
    @Delete("delete from user where id = #{id}")
    void delete(String id);
}
