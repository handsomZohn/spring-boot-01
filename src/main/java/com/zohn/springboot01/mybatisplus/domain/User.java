package com.zohn.springboot01.mybatisplus.domain;

/*import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;*/
import lombok.Data;

import java.util.Date;

@Data
//@TableName("user")
public class User {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 是否删除
     */
    // @TableLogic
    private Integer deleted;
}
