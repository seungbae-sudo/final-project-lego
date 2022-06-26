select * from MEMBER
select * from MEMBER where id = 'gosugosu@gosu'
update member set name='1',address='1',password='1',tel='1' where id='ksg@ksg'


update member set password=#{password},name=#{name},address=#{address},tel=#{tel} where id=#{id}

update master set specifications=#{specifications},career=#{career} where id=#{id}

update master set specifications = '1' , career='1' where id='asdf@asd'
select * from master where id = 'asdf@asd'

회원member, 게시판board, 카테고리board_category, 
보드넘버,제목(보드테이블),카테고리(카테고리테이블)

select board_title from board where id = 'lsj@naver.com'
select * from board_category
select * from category_no
select category_no from board

select board_no,board_title,category_no from board where id = 'lsj@naver.com'

select 

보드아이디 로그인한사람 아이디 같아야됨 <조건

select b.board_no,b.board_title,c.category_name from board b, category c where 

select b.board_no,b.board_title,c.category_name
from board b 
inner join board_category c on b.id = 'lsj@naver.com'

select b.board_no,b.board_title,c.category_name
from board b, board_category c
where b.id = 'lsj@naver.com'
and c.category_no = b.category_no

