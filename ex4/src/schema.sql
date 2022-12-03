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
	foreign key (spitter) references spitter(id)
);