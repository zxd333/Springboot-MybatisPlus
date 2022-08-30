package org.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.demo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.demo.mapper.UserMapper;

import java.util.Date;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        Page<User> page = new Page<User>();

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("age", "18");
        Page<User> userPage = userMapper.selectPage(page, queryWrapper);
        System.out.println(userPage.getTotal() + "," + userPage.getPages() + "," + userPage.getSize() + "," + userPage.getRecords());
    }

    @Test
    void query(){
        List<User> users = userMapper.selectList(new QueryWrapper<>());
        System.out.println(users);
    }

    @Test
    void insert(){
        User u = new User();
        u.setName("test");
        u.setAge("15");
        u.setAccount("root");
        u.setPassword("root");
        u.setBirthday(new Date());

        userMapper.insert(u);
    }

    @Test
    void delete(){
        userMapper.deleteById(2);
    }
}
