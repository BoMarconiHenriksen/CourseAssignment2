drop table if exists address;
create table address like addressTest;
insert into address select * from addressTest;
                
drop table if exists cityinfo;
create table cityinfo like cityinfoTest;
insert into cityinfo select * from cityinfoTest;
                
drop table if exists company;
create table company like companyTest;
insert into company select * from companyTest;
                
drop table if exists hobby;
create table hobby like hobbyTest;
insert into hobby select * from hobbyTest;
                
drop table if exists infoentity;
create table infoentity like infoentityTest;
insert into infoentity select * from infoentityTest;
                
drop table if exists person;
create table person like personTest;
insert into person select * from personTest;
                
drop table if exists phone;
create table phone like phoneTest;
insert into phone select * from phoneTest;