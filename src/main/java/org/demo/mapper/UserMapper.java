package org.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.demo.entity.User;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    User selectByAge(@Param("age") String age);
}
