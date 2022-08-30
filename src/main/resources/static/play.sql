create database if not exists play;

use play;

create table if not exists `user`(
    `id` bigint auto_increment comment '主键id',
    `name` varchar(10) comment '姓名',
    `age` int(2) comment '年龄',
    `birthday` datetime comment '生日',
    `account` varchar(20) comment '账号',
    `password` varchar(20) comment '密码',
    `is_deleted` char(1) default '0' comment '是否删除',
    `create_time` datetime comment '创建时间',
    `update_time` datetime comment '更新时间',
    primary key(`id`)
)ENGINE=InnoDB default charset=utf8mb4;