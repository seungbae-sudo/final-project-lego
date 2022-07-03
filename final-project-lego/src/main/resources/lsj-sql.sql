CREATE SEQUENCE board_seq;
DROP SEQUENCE board_seq;

INSERT INTO board_category(category_no,category_name) values(1,'꿀팁');
INSERT INTO board_category(category_no,category_name) values(2,'추천');
INSERT INTO board_category(category_no,category_name) values(3,'나눔');

insert into board(board_no,board_title,board_content,category_no,hits,board_date,likes) values(board_seq.nextval,'안녕','안녕하세요',1,3,sysdate,1,'sefe2@gaeg');

select*from board

insert into 

select category_name, category_no from board_category where category_no=1

select*from board where category_no=2
select*from board where category_no=1


select b .board_no,b.board_title,b.hits, 
			m.name,
			bc.category_no
from board b, member m,board_category bc
where bc.category_no=1
and b.category_no=bc.category_no(+)
and b.id=m.id(+);
 
select*from board where board_no=3;

--findAllCommunityList [내림차순 정렬]
select b.board_no, b.board_title,b.hits, m.name
from board b, member m 
where b.category_no=1
and b.id=m.id order by board_no desc

--
select b.board_title,b.board_content,b.board_date,b.hits, m.name, m.id 
from board b, member m
where b.id=m.id
and b.board_no=3

-- detail
select b.board_title,b.board_content,b.board_date,b.hits, b.likes, m.name, m.id 
from board b, member m
where b.id=m.id
and m.id='lsj@naver.com'
and b.board_no=7

--detail2 (category no 까지 가져옴)
select b.board_no, b.board_title,b.board_content,b.board_date,b.hits, m.name, m.id,bc.category_no,bc.category_name
from board b, member m, board_category bc
where b.id=m.id
and bc.category_no=b.category_no
and b.board_no=66

select b.board_no, b.board_title,b.board_content,b.board_date,b.hits, m.name, m.id,bc.category_no,bc.category_name
from board b 
inner join member m 
on b.id=m.id
inner join board_category bc
on bc.category_no=b.category_no
where b.board_no=66;

select b.board_no, b.board_title ,b.hits , m.name, bc.category_no
			from board b, member m ,board_category bc
			where b.category_no= 1
			and b.id=m.id and b.category_no = bc.category_no order by board_no desc

		

--update
UPDATE board SET board_title='33번 수정test',board_content='재미따', category_no='2' WHERE board_no = 33;

--delete
DELETE FROM BOARD WHERE board_no = 33;


select b.* , m.*, bc.*
		from board b, member m , board_category bc
		where b.id=m.id
		and bc.category_no = b.category_no
		and b.board_no=33
		
select m.* ,b.*
from board b , member m
where b.id = m.id

select b.*,m.*,bc.*
		from board b, member m, board_category bc
		where b.id=m.id
		and bc.category_no = b.category_no
		and b.board_no=66
		

--comment
select*from board_comment;
CREATE SEQUENCE  board_comment_seq;
DROP SEQUENCE board_comment_seq;

--comment insert
insert into board_comment(comment_no,comment_content,board_no,comment_date,id) values(board_comment_seq.nextval,'nct가 머야~','81', sysdate,'lsj@naver.com')
insert into board_comment(comment_no,comment_content,board_no,id) values(board_comment_seq.nextval,#{commentContent},#{bvo.boardNo},#{sysdate},#{mvo.id})

--findBVO
select b.board_no,cm.comment_content, cm.comment_no,cm.comment_date , m.name
from  board b, member m, board_comment cm
where b.board_no=cm.board_no
and m.id=cm.id
and b.board_no='81';

--wrtieCommentList
select cm.board_no, m.name, cm.comment_no, cm.comment_content, cm.comment_date
from board b, member m, board_comment cm
where b.board_no=cm.board_no
and m.id=cm.id

--commentDelete
DELETE FROM board_comment WHERE comment_no =46
select *from board_comment WHERE comment_no =46

WHERE bc.
select
--hits
UPDATE board SET hits = hits+1 WHERE board_no = 81

--likesUp
UPDATE board SET likes = likes+1 WHERE board_no = 1

select*from board
--likesDown
UPDATE board SET likes = likes -1 WHERE board_no = 1 

-- comment 고수찾기
select authority
from authorities
where username = 'lsj@kosta.com'

-- findCommentList 2
select cm.comment_content, cm.comment_no,cm.comment_date , m.name, m.id, a.authority, a.username
from  board b, member m, board_comment cm, authorities a
where b.board_no=cm.board_no
and a.username = m.id 
and m.id=cm.id
and b. board_no=16


-- findCommentList 3 (master id 추가 , commentFindMasterById)
select cm.comment_content, cm.comment_no,cm.comment_date , m.name, m.id, a.authority, a.username, ma.id
from  board b, member m, board_comment cm, authorities a, master ma
where b.board_no=cm.board_no
and a.username = m.id 
and m.id=cm.id
and cm.id=ma.id
and a.username='lsj@kosta.com'

select * from master where id= 'lsj@kosta.com'
   		
 

--search	test
	SELECT * FROM BOARD WHERE board_title LIKE '%' || '꿀팁' || '%' 
	SELECT board_no, board_title,  FROM BOARD WHERE board_title LIKE '%' || #{KEYWORD} || '%' 
	
		select b.* , m.*,c.*
		from board b, member m, board_category c
		WHERE board_title LIKE '%' || '꿀팁'|| '%'
		and c.category_no = b.category_no
		and b.id=m.id order by board_no desc

	
		select b.* , m.*,c.*
		from board b, member m, board_category c
		WHERE name LIKE '%' || '소정' || '%'
		and c.category_no = b.category_no
		and b.id=m.id order by board_no desc

