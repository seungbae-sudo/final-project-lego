update member set password=#{password},name=#{name},address=#{address}, tel=#{tel}
			where id=#{id}

update member set password='aa',name='손석구',address='내 요동치는 마음속', tel='01012345678'
			where id='java@naver.com'		

select*from board;

select bc.category_no, m.id, b.board_title, b.hits
from  board b, MEMBER m,board_category bc
where bc.category_no=1
and bc.category_no=b.category_no and m.id=b=id

select r.category_no, r.board_title, r.hits,m.id
from (
	select bc.category_no, b.board_title, b.hits,b.id
	from  board b, board_category bc
	where bc.category_no=1) r ,member m
where m.id=r.id

select category_no, id, board_title, hits from board where category_no=1

select r.board_no, r.board_title,r.hits, m.name
from(
	select b.board_no, b.board_title,b. hits, b.id
	from  board b, board_category bc
	where b.category_no=1
	and b.category_no=bc.category_no
) r, member m
where  r.id=m.id

select b.board_no, b.board_title,b.hits, m.name
from board b, member m
where b.category_no=1
and b.id=m.id


select b.board_no, b.board_title,b. hits
	from  board b, board_category bc
	where b.category_no=1
	and b.category_no=bc.category_no


--내가 쓴 글 리스트
select b.board_no, b.board_title, bc.category_name
from  board b, board_category bc
where b.category_no=bc.category_no
and b.id='lsj@naver.com'
order by b.board_no


select*from member where id='java@naver.com'

select*from master_detail
select*from booking;
--master_detail에 skill, times, days, 고수 id가 입력되어있다.  id빼고 number
select*from master
CREATE SEQUENCE booking_seq;

--임의로 예약정보 넣어두기
insert into booking(booking_no,condition,booking_day,booking_content,booking_times,skills_id,times_id,days_id,master_id,member_id)
values(booking_seq.nextval,'예약날짜가능한지',to_date('9-6-2022','dd-mm-yyyy'),'예약 가능할까요?','12시',1,2,3,'asdf@asd','lsj@naver.com') 

insert into booking(booking_no,condition,booking_day,booking_content,booking_times,skills_id,times_id,days_id,master_id,member_id)
values(booking_seq.nextval,'예약날짜가능한지22',to_date('9-6-2022','dd-mm-yyyy'),'예약 가능할까요?','12시',1,2,3,'lego@lego.com','lsj@naver.com'); 

insert into booking(booking_no,condition,booking_day,booking_content,booking_times,skills_id,times_id,days_id,master_id,member_id)
values(booking_seq.nextval,'예약날짜가능한지333',to_date('9-6-2022','dd-mm-yyyy'),'예약 가능할까요?','12시',1,2,3,'12@12','lsj@naver.com');

insert into booking(booking_no,condition,booking_day,booking_content,booking_times,skills_id,times_id,days_id,master_id,member_id)
values(booking_seq.nextval,'예약날짜가능한지444',to_date('9-6-2022','dd-mm-yyyy'),'예약 가능할까요?','12시',1,2,3,'as@as','lsj@naver.com'); 


-- 내가 예약한 상담 리스트 불러오기 
--master_id로 고수 이름을 찾아야함 master 랑 member
-- 해당 고수의 카테고리도 찾아야함 
select m.name as 고수이름, go.category_no , go.id as 고수 아이디 ,b.booking_day
from master g, member m, booking b
where go.id=m.id
and b.master_id=go.id
and go.id='66@66'




select r.id as 고수아이디,r.lesson_sort as 레슨종류 ,m.name as 고수이름,b.booking_day
from (
		select ms.id,c.lesson_sort
		from master ms, category c
		where ms.category_no=c.category_no) r, member m, booking b
where m.id=r.id

--booking에 member_id가 지금 로그인한 사람의 id와 같아야함
--where b.member_id='lsj@naver.com'

-- 내 예약 


-- 자 이제 시작이야~~ (내꿈을~~) 내 꿈을 위한 여행~ 피카츄~~
select  r.skills_id,r.name,b.booking_day
from(
	select md.skills_id, m.name, m.id
	from master_detail md,master ms, member m
	where ms.id=md.id
	and ms.id=m.id) r, booking b
where r.id=b.master_id
and b.member_id='lsj@naver.com'



select name,skills,booking_day
from master ms,

-- categroy,booking, master 고수 이름 분야 상담날짜 
select r.name, r.lesson_sort, b.booking_day
from(
		select ms.id, m.name, c.lesson_sort
		from master ms, category c,member m
		where ms.category_no=c.category_no
		and m.id=ms.id) r, booking b
where r.id=b.master_id
and b.member_id='lsj@naver.com'



select*from master
select*from category
select*from cart


---


select skills
from skills
where skills_id=1



--고수 마이 페이지 예약 목록
select g.name as 고객이름, b.booking_day
from (
	select name, id
	from member
) g, booking b
where b.member_id=g.id
and b.master_id='33@33'


select ms.id, ms.category_no,c.lesson_sort,m.name
from master ms, category c, member m
where ms.category_no=c.category_no
and m.id=ms.id


select*
from master 

select*
from skills 

select*from category


---- 찜목록 cart cart_no id master_id
--master아이디로 고수 이름 
-- 이름 평점 스펙 
select*from cart


select*from review
select*from member
select*from master
cart

-- 해당 고수의 평균 평점
select 
(
select avg(score) from review where master_id='as@as'
) r, cart


select m.name, ms.specifications , round(avg(r.score) as score_arg)
select round(avg(r.score))
from review r, cart c, member m, master ms
where c.id='lsj@naver.com'
and r.master_id=ms.id
group by m.name, ms.specifications

select round(avg(r.score)),m.name
from (select name, id from member) m,review r, cart c,master ms
where c.id='lsj@naver.com'
and r.id=c.id
and m.id=r.master_id
and r.master_id=ms.id
group by m.name,ms.specifications

select specifications,career
from master

select*from review
select*from member
select*from master
select *from cart 
      22 aa@aa         12@12

select round(avg(r.score)), to_char(dbms_lob.substr(ms.specifications, 4000)),m.name
from (select name, id from member) m,review r, cart c,master ms
where c.id='aa@aa '
and r.id=c.id
and m.id=r.master_id
and r.master_id=ms.id
group by to_char(dbms_lob.substr(ms.specifications, 4000)),m.name

-- cart에 있는 아이디가 지금 로그인한사람 아이디 
-- cart에 있는 master_id를 통해 member name을 가져와야한다 
-- cart 에 있는 master_id를 통해 master specifications를 가져와야한다 
-- cart에 있는 master_id를 통해 review에 있는 score를 평균을 내서 가져와야한다 
select round(avg(r.score)), to_char(dbms_lob.substr(ms.specifications, 4000)),m.name
from (select name, id from member) m,review r, cart c,master ms
where c.id='aa@aa '
and c.master_id=m.id
and c.master_id=ms.id
and c.master_id=r.master_id
group by to_char(dbms_lob.substr(ms.specifications, 4000)),m.name

select round(avg(r.score)), to_char(dbms_lob.substr(ms.specifications, 4000)), m.name
from cart c,member m,master ms,review r
where c.id='aa@aa' 
and c.master_id=m.id
and c.master_id=ms.id
group by to_char(dbms_lob.substr(ms.specifications, 4000)),m.name


select*from review

select to_char(dbms_lob.substr(ms.specifications, 4000)), m.name
from cart c,member m,master ms,review r
where c.id='aa@aa' 
and c.master_id=m.id
and c.master_id=ms.id
and r.master_id
group by to_char(dbms_lob.substr(ms.specifications, 4000)),m.name