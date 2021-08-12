INSERT INTO role(ROLE_ID, ROLE_NAME) VALUES (1, 'ADMIN');
INSERT INTO role(ROLE_ID, ROLE_NAME) VALUES (2, 'BUYER');
INSERT INTO role(ROLE_ID, ROLE_NAME) VALUES (3, 'SELLER');

INSERT into User (id, FIRST_NAME,LAST_NAME, email, username, password)  VALUES (11,'Dean','Raey', 'd@gmail.com', 'dean','1234');
INSERT into User (id, FIRST_NAME,LAST_NAME, email, username, password)  VALUES (12,'Semayat','Fikre', 's@gmail.com', 'semayat','1234');

insert into USER_ROLES(USER_ID, ROLE_ID) values (11, 1);
insert into USER_ROLES(USER_ID, ROLE_ID) values (12, 2);