

DELETE FROM event_resources;
DELETE FROM event;
DELETE FROM user;
DELETE FROM user_role;

INSERT INTO user_role (id, name) VALUES ('1', 'ADMIN');
INSERT INTO user_role (id, name) VALUES ('2', 'USER');

INSERT INTO user (id,deleteDate,email,name,password,phone,registerDate,surname,updateDate,username,user_role_id) VALUES ('1', NULL, 'seruvent@seruvent.org.tr', 'seruventName', '$2a$10$LXL4vxEnUzG7HoFPKJiWSOgk7zZCE8Yrwq9pFbMGWK.WkrIZuZdrO', '5556527348', '2019-12-05 11:23:56.877000', 'citybugsSurname', '2019-12-05 11:23:56.877000', 'seruvent', '1');
INSERT INTO user (id,deleteDate,email,name,password,phone,registerDate,surname,updateDate,username,user_role_id) VALUES ('2', NULL, 'guppy@seruvent.org.tr', 'guppyName', '$2a$10$nDl8DIDEZLJDY0.9QhKuLelPHzUZWLFYMPjz9rGTQc3G4qk8vn.tK', '5556527349', '2019-12-27 07:42:14.730000', 'citybugsSurname', '2019-12-27 07:42:14.730000', 'guppy', '2');
INSERT INTO user (id,deleteDate,email,name,password,phone,registerDate,surname,updateDate,username,user_role_id) VALUES ('3', NULL, 'test@seruvent.org.tr', 'testName', '$2a$10$ZnY7fAooWvUyYivIwEMO8utDruUSyzD525NofOTWVqx8nzrMbH1pK', '5556527350', '2019-12-27 08:21:44.040000', 'citybugsSurname', '2019-12-27 08:21:44.040000', 'test', '2');