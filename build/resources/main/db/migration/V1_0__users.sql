create table users (
    id serial not null primary key,
    username varchar(32) not null unique,
    password varchar(128) not null
);

insert into users(username, password) values ('Denis', '$2a$10$TrQdWa7moOsIDUyyBC/Vh.Q2niTb/Al4LEYNe4XcHW.wHsYfHUOlq');
insert into users(username, password) values ('David', '$2a$10$jwf3JPS8o.77pauexLT2K.BDgoC.ciO8A330i6IcnDIdgMXfxMqua');
insert into users(username, password) values ('Jeka', '$2a$10$k/BiLRW5L/4pMy6nwawTTu8AjIPSGtTdRu81EF3xXoR0ttBOiimzi');
