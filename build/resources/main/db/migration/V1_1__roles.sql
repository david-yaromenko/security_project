create table roles(
    id serial not null primary key,
    name varchar(32) not null
);

insert into roles(name) values ('ADMIN');
insert into roles(name) values ('USER');