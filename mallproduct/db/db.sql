-- 创建数据库实例
create database demo_test1 default charset utf-8;

-- 产品表
create table products(pid int not null primary key auto_increment,pname varchar (200),type varchar (50),price double ,createtime timestamp )