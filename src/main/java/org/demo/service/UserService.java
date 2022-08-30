package org.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;
import org.demo.entity.User;

public interface UserService extends IService<User> {

    User selectByAge(@Param("age") String age);
}
