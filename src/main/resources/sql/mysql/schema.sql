use mybatis_plus_example;

# 重新创建用户信息表
drop table if exists tb_user;

create table tb_user
(
    id       bigint(20) primary key auto_increment comment '自增主键',
    username varchar(50) comment '用户名',
    sex      char(2) comment '性别：男 / 女 / 未知',
    age      int(11) comment '年龄',
    email    varchar(255) comment '电子邮箱',
    deleted  bit(1) default b'0' comment '逻辑删除标识'
) comment '用户信息表';

# 重新创建地址表
drop table if exists tb_address;

create table tb_address
(
    id      bigint(20) primary key auto_increment comment '自增主键',
    city    varchar(50) comment '城市',
    address varchar(255) comment '地址',
    user_id bigint(20) comment '用户 ID',
    deleted  bit(1) default b'0' comment '逻辑删除标识'
) comment '地址表';
