use enjoy_trip;
SELECT * FROM user;
insert into user values(null,'ssafy', '1234', 'hi', 'ssafy@ssafy.com', now(), 'A');
insert into user values(null,'user1', '1234', 'u1', 'u1@naver.com', now(), 'U'),(null,'user2', '1234', 'u2', 'u2@gmail.com', now(), 'U'),
(null,'user3', '1234', 'u3', 'u3@daum.net', now(), 'U'),(null,'user4', '1234', 'u4', 'u4@kakao.com', now(), 'U'),(null,'user5', '1234', 'u5', 'u5@ssafy.com', now(), 'U');
alter table user auto_increment = 1;
delete from user;