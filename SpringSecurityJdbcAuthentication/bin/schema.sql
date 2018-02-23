DROP TABLE IF EXISTS USERS;
DROP TABLE IF EXISTS USER_ROLES;
DROP TABLE IF EXISTS AUTHORITIES;
CREATE  TABLE users (
  username VARCHAR(60) NOT NULL ,
  password VARCHAR(60) NOT NULL ,
  enabled TINYINT NOT NULL DEFAULT 1 ,
  PRIMARY KEY (username));
 
  CREATE TABLE user_roles (
  user_role_id int(11) NOT NULL AUTO_INCREMENT,
  username varchar(60) NOT NULL,
  role varchar(60) NOT NULL,
  PRIMARY KEY (user_role_id),
  UNIQUE KEY uni_username_role (role,username),
FOREIGN KEY (username) REFERENCES users (username));

  CREATE TABLE AUTHORITIES (
  user_role_id int(11) NOT NULL AUTO_INCREMENT,
  username varchar(60) NOT NULL,
  authority varchar(60) NOT NULL,
  PRIMARY KEY (user_role_id),
  UNIQUE KEY uni_username_role1 (authority,username),
FOREIGN KEY (username) REFERENCES users (username));