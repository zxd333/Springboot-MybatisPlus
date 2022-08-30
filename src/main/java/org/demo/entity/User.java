package org.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    // 设置 id 为自增
    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;

    private String age;

    private Date birthday;

    private String account;

    private String password;

    // 逻辑删除
    @TableLogic
    private String isDeleted;

    private Date createTime;

    private Date updateTime;

}
