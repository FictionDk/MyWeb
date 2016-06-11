use mydb3;

drop table if exists comments;
create table if not exists comments(
	id int auto_increment primary key,
	title varchar(40) not null,
	text varchar(60) not null,
	ip varchar(20) not null
);
