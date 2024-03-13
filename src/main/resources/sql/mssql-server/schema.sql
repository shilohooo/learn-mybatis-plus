use MyBatisPlusExample;

create schema System;

drop table if exists System.UserInfo;

create table System.UserInfo
(
    Id       bigint primary key identity,
    Username nvarchar(50),
    Sex      nchar(1),
    Age      int,
    Email    nvarchar(255),
    Deleted  bit default 0
);

create table System.AddressInfo
(
    Id      bigint primary key identity,
    City    nvarchar(255),
    Address nvarchar(255),
    UserId  bigint,
    Deleted bit default 0
);
