use mydb3;

drop table if exists contacter;
create table if not exists contacter(
	id int auto_increment primary key,
	name varchar(20) not null,
	email varchar(20) not null,
	comments varchar(80) not null
);
