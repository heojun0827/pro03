select * from mysql.user;

show databases;

use yeosu;

set AUTOCOMMIT=true;	-- 자동커밋 설정
show variables like 'autocommit';	-- 자동커밋 설정 확인

-- 테스트용 샘플 테이블 작성
create table sample1(item1 varchar(50) primary key, item2 int default 0, item3 datetime default current_timestamp);

insert into sample1 values ('heojun', 90, default);
insert into sample1 values ('leeyouseop', 60, default);
insert into sample1 values ('kimwoojoo', 80, default);

select * from sample1;

-- 자동 커밋이 설정되어 있으므로 커밋하지 않아도 됨
-- commit;

-- ALTER TABLE sequence_table auto_increment=1; (MYSQL AUTO_INCREMENT 초기화)
-- auto_increment (시퀀스역할)

select * from qna;
drop table tbl_exp;

create table tbl_user(id varchar(20) primary key, pw varchar(300) not null, name varchar(20), phone varchar(13), addr varchar(300), email varchar(50), regdate datetime default current_timestamp);
create table tbl_notice(idx int auto_increment primary key, title varchar(100) not null, content varchar(1000), author varchar(20), file1 varchar(200), regdate datetime default current_timestamp, readcnt int default 0);
create table tbl_place(pname varchar(20) primary key, cate varchar(6), addr varchar(300), phone varchar(13), comm varchar(1000), pic varchar(200));
create table cate(cate varchar(6), gname varchar(50), cname varchar(50));
create table qna(qno varchar(8) primary key, title varchar(100), content varchar(1000), author varchar(20), resdate datetime default current_timestamp, lev int, parno varchar(8), visited int default 0);
