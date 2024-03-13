use mybatis_plus_example;

# 清空用户信息表
delete
from tb_user
where id <> 0;

# 插入用户信息测试数据
insert into tb_user(id, username, sex, age, email)
values (1, 'shiloh', '男', 26, 'shiloh595@163.com'),
       (2, 'tom', '男', 26, 'tom@foxmail.com'),
       (3, 'bruce', '男', 26, 'bruce@sina.com'),
       (4, 'rose', '女', 26, 'rose@qq.com'),
       (5, 'jack', '男', 26, 'jack@gmail.com');

# 清空地址表
delete
from tb_address
where id <> 0;

# 插入地址测试数据
insert into tb_address(id, city, address, user_id)
values (1, '北京', '天安门广场', 1),
       (2, '上海', '东方明珠塔', 2),
       (3, '广州', '小蛮腰', 3),
       (4, '深圳', '世界之窗', 4),
       (5, '惠州', '红花湖', 5);