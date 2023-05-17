use enjoy_trip;
SELECT * FROM board;
insert into board values(null,0,now(),'첫번째 글', '첫번째 내용', 1); -- board_type 0 : 공지사항 1 : 게시글?
insert into board values
(null,1,now(),'sub test21 con test1con test1con test1con tes', 'con test1con test1con test1con test1con test1con test1con test1con test1con test1con test1con test1con test1con test1con test1con test1con test1con test1con test1con test1con test1con test1', 5),
(null,1,now(),'sub test22 con test1con test1con test1con tes', 'con test2con test2con test2con test2con test2con test2con test2con test2con test1con test1con test1con test1con test1con test1con test1', 5),
(null,1,now(),'sub test23', 'con test3con test3con test3con test3con test3con test3con test3con test3con test3con test3con test3con test3con test3con test3', 5),
(null,1,now(),'sub test24', 'con test4con test4con test4con test4con test4con test4con test4con test3con test3con test3con test3con test3con test3con test3', 5),
(null,1,now(),'sub test25', 'con test5con test5con test5con test5con test5con test5con test5con test3con test3con test3con test3con test3con test3con test3', 5);