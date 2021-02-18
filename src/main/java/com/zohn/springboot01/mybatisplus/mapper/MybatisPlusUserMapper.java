/*
package com.zohn.springboot01.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zohn.springboot01.mybatisplus.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

*/
/**
 * Mybatis-plus自动帮助我们生成的方法相当全面，一般来说，开发业务代码的时候，最耗时最枯燥的莫过于单表的CURD的操作，
 * Mybatis-plus确实能大大简化我们开发
 *//*


*/
/*@Repository
public interface MybatisPlusUserMapper extends BaseMapper<User> {
    /**
     * 根据username查询
     * @param username
     * @return
     *//*

    default User selectByUsername(@Param("username") String username) {
        LambdaQueryWrapper<User> wrapper = new QueryWrapper<User>().lambda();
        return selectOne(wrapper.eq(User::getUsername, username));
    }
}
*/
