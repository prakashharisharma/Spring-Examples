insert into users(USERNAME, PASSWORD, ENABLED) values('user','123456',1);
insert into users(USERNAME, PASSWORD, ENABLED) values('apiuser','123456',1);
insert into users(USERNAME, PASSWORD, ENABLED) values('admin','123456',1);

insert into user_roles(USERNAME,ROLE)  values('user','ROLE_USER');
insert into user_roles(USERNAME,ROLE)  values('admin','ROLE_USER');
insert into user_roles(USERNAME,ROLE)  values('admin','ROLE_ADMIN');
insert into user_roles(USERNAME,ROLE)  values('admin','ROLE_API');
insert into user_roles(USERNAME,ROLE)  values('apiuser','ROLE_USER');
insert into user_roles(USERNAME,ROLE)  values('apiuser','ROLE_API');