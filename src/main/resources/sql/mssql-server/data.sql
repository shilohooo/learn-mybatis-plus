use MyBatisPlusExample;

SET IDENTITY_INSERT System.UserInfo ON
insert into System.UserInfo(Id, username, sex, age, email)
values (1, 'shiloh', N'男', 26, 'shiloh595@gmail.com'),
       (2, 'tom', N'男', 24, 'tom@163.com'),
       (3, 'jack', N'男', 23, 'jack@firefox.com'),
       (4, 'bruce', N'男', 22, 'bruce@sina.com'),
       (5, 'rose', N'女', 21, 'rose@qq.com');

SET IDENTITY_INSERT System.UserInfo OFF;

SET IDENTITY_INSERT System.AddressInfo ON;
insert into System.AddressInfo(Id, city, address, UserId)
values (1, N'北京', N'天安门广场', 1),
       (2, N'上海', N'东方明珠塔', 2),
       (3, N'广州', N'小蛮腰', 3),
       (4, N'深圳', N'世界之窗', 4),
       (5, N'杭州', N'西湖', 5);
SET IDENTITY_INSERT System.AddressInfo OFF;
