select * from MEMBER
select * from MEMBER where id = 'gosugosu@gosu'
update member set name='1',address='1',password='1',tel='1' where id='ksg@ksg'

select * from category
update member set password=#{password},name=#{name},address=#{address},tel=#{tel} where id=#{id}

update master set specifications=#{specifications},career=#{career} where id=#{id}

update master set specifications = '1' , career='1' where id='asdf@asd'
select * from master where id = 'asdf@asd'

회원member, 게시판board, 카테고리board_category, 
보드넘버,제목(보드테이블),카테고리(카테고	리테이블)

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
values(review_seq.nextval,5,'이 바보야','33@33','ksg@1'); 

select * from member where id = '33@33'

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
values(message_seq.nextval,'바보야!','sg@sg','as@as',sysdate)

create sequence message_seq

select ms.id, m.name
from message ms, member m, master ma
where m.id=ms.id and ma.id='as@as' and ms.receive_id = ma.id
group by ms.id, m.name

select ms.id, m.name, ms.message_content, ms.receive_date
from message ms, member m
where m.id = ms.receive_id and m.id = 'as@as'

select m.name, ms.*
from member m, message ms
where ms.id = 'as@as' and ms.receive_id = m.id and ms.receive_id = 'lsj@naver.com'

select * from message where id = 'as@as'

receive_id = 받는사람
id = 보내는 사람
member id

select ms.id, ms.receive_id, ms.message_content
from member m, message ms
where m.id = ms.id and ms.id = 'as@as'

select ms.message_no,ms.message_content, ms.receive_id, ms.receive_date,m.name
from message ms, member m 
where ms.id=#{sendMvo.id}
and ms.receive_id=#{reMvo.id}
and ms.receive_id=m.id

union all
         
select ms.message_no,ms.message_content, ms.receive_id, ms.receive_date,m.name
from message ms, member m 
where ms.id=#{reMvo.id}
and ms.receive_id=#{sendMvo.id}
and ms.receive_id=m.id
         
order by receive_date asc

select * from message where id = 'as@as'

delete from message where receive_id = 'as@as'

select i.*,m.id from images i, member m where i.id = m.id

update images set image_name = '김승배님.jpg' where id = '534534@423423'

select * from images

select * from master where id = 'ksg@1'

select * from category

select * from master_detail where id = 'ksg@1'

select * from skills

select * from category

select * from skills

select * from times

select * from days
select * from master_detail

select * from master_detail where id = 'ksg@1' skils_id=16(중국어) times_id=1(이른오전 9시이전) days_id=1 월요일

select distinct m.* from skills s,times t,days d,master_detail m where m.id = 'ksg@1'

select * from master_detail m,skills s where m.id = '2022@2' and m.skills_id>0 and m.skills_id = s.skills_id
select * from master_detail m,times t where m.id = '2022@2' and m.times_id>0 and m.times_id = t.times_id
select * from master_detail m,days d where m.id = '2022@2' and m.days_id>0 and m.days_id = d.days_id

select r.board_no, r.board_title,r.hits, m.name
from(
	select b.board_no, b.board_title,b. hits, b.id
	from  board b, board_category bc
	where b.category_no=1
	and b.category_no=bc.category_no
) r, member m
where  r.id=m.id

select distinct s.skills,d.days,t.times,m.id
from(
	select *
	from master_detail m,skills s
	where m.id = '2022@2'
	and m.skills_id>0
	and m.skills_id = s.skills_id
)s, (select *
	from master_detail m,times t 
	where m.id = '2022@2'
	and m.times_id>0 
	and m.times_id = t.times_id
)t, (select * 
	from master_detail m,days d 
	where m.id = '2022@2' 
	and m.days_id>0 
	and m.days_id = d.days_id
)d, master_detail m
where m.id = '2022@2'

select * from category

union all
select t.times from master_detail m,times t where m.id = '2022@2' and m.times_id>0 and m.times_id = t.times_id
union all
select d.days
from master_detail m,days d where m.id =  '2022@2' and m.days_id>0 and m.days_id = d.days_id

select c.lesson_sort from master m,category c where id = '2022@2' and m.category_no = c.category_no
union all
select s.skills from master_detail m,skills s where m.id =  '2022@2'and m.skills_id>0 and m.skills_id = s.skills_id


