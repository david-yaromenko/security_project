create table user_and_role(
user_id int not null,
role_id int not null,

foreign key (user_id) references users(id),

foreign key (role_id) references roles(id)
);

insert into user_and_role(user_id, role_id) values (1, 1);
insert into user_and_role(user_id, role_id) values (2, 1);
insert into user_and_role(user_id, role_id) values (3, 2);