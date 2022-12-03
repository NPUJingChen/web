create table Spitter (
	id identity,
	username varchar(20) unique not null,
	password varchar(20) not null,
	first_name varchar(30) not null,
	last_name varchar(30) not null,
	email varchar(30) not null
);


create table spittle (
	id integer identity primary key,
	spitter integer not null,
	message varchar(2000) not null,
	postedTime datetime not null,
	ischecked varchar(5),
	checker_id integer ,
	check_time datetime,
	foreign key (spitter) references spitter(id)
);

create table Manager (
    id identity ,
    userName varchar (20) unique not null ,
    password varchar (20) not null ,
    fullName varchar (20) not null ,
    email varchar (30) not null ,
    phoneNo varchar (20) not null ,
    isDelete int not null

);
insert into Manager(userName,password,fullName,email,phoneNo,isDelete) values ('admin','admin','admin','123456@qq.com','178946',1);
