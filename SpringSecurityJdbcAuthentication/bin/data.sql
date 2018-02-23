insert into users(USERNAME, PASSWORD) values('user','123456');
insert into users(USERNAME, PASSWORD) values('apiuser','123456');
insert into users(USERNAME, PASSWORD) values('admin','123456');

insert into user_roles values(1,'user','ROLE_USER');
insert into user_roles values(2,'admin','ROLE_USER');
insert into user_roles values(3,'admin','ROLE_ADMIN');
insert into user_roles values(4,'admin','ROLE_API');
insert into user_roles values(5,'apiuser','ROLE_USER');
insert into user_roles values(6,'apiuser','ROLE_API');

insert into AUTHORITIES values(1,'user','ROLE_USER');
insert into AUTHORITIES values(2,'admin','ROLE_USER');
insert into AUTHORITIES values(3,'admin','ROLE_ADMIN');
insert into AUTHORITIES values(4,'admin','ROLE_API');
insert into AUTHORITIES values(5,'apiuser','ROLE_USER');
insert into AUTHORITIES values(6,'apiuser','ROLE_API');