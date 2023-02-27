insert into course (id,name,created_date, last_updated_date) values(10001,'JPA IN 50 STEPS', now(),now());
insert into course (id,name,created_date, last_updated_date) values(10002,'DEVOPS IN 50 STEPS',now(),now());
insert into course (id,name,created_date, last_updated_date) values(10003,'JAVA IN 50 STEPS',now(),now());
insert into course (id,name,created_date, last_updated_date) values(10004,'SPING IN 50 STEPS',now(),now());




insert into passport(id,number) values(40001,'E093470');
insert into passport(id,number) values(40002,'I239843');
insert into passport(id,number) values(40003,'J983850');

insert into student(id,name,passport_id) values(20001,'Ranga',40003);
insert into student(id,name,passport_id) values(20002,'Adam',40001);
insert into student(id,name,passport_id) values(20003,'James',40002);

insert into review(id,rating,description,course_id) values(50001,'1','Great course',10001);
insert into review(id,rating,description,course_id) values(50002,'3','Good course',10002);
insert into review(id,rating,description,course_id) values(50003,'5','wonderful course',10001);