select * from MEMBER
select * from MEMBER where id = 'gosugosu@gosu'
update member set name='1',address='1',password='1',tel='1' where id='ksg@ksg'

select * from category
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

select * from booking
distinct(중복 제거)

select m.name, b.booking_day
from booking b, master ms, member m
where ms.id = '33@33' and m.id = b.member_id


부킹id = 로그인한 고수 아이디

고객 이름 상담 날짜 

멤버 아이디에 따른 멤버 이름 상담(부킹) 시간

select name, id
from member
where id = 'lsj@naver.com'


select m.*, b.*
	from member m, booking b
	where m.id = b.member_id
	and b.master_id = 'as@as'

	select * from skills
	
	select * from booking
	
	
	
select b.booking_content
from member m, booking b
where m.id = b.member_id
and b.master_id = 'as@as'

insert into review(review_no,score,review_content,id,master_id)
values(review_seq.nextval,5,'이 바보야','33@33','as@as'); 

create sequence review_seq
select * from review

   		select b.*,bc.*
		from board b, board_category bc
		where b.id = 'as@as'
		and b.category_no = bc.category_no

select * from message

select ms.message_content
from message ms, member m, master ma
where m.id=ms.id and ma.id='as@as' and ms.receive_id = ma.id

insert into message(message_no,message_content,receive_id,id,receive_date)
values(message_seq.nextval,'천재!','as@as','sg@sg',sysdate)

create sequence message_seq

select ms.*, m.name
from message ms, member m, master ma
where m.id=ms.id and ma.id='as@as' and ms.receive_id = ma.id

select * from member