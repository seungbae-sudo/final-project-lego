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
values(booking_seq.nextval,'예약날짜가능한지444',to_date('9-6-2022','dd-mm-yyyy'),'예약 가능할까요?','12시',1,2,3,'33@33','lsj@naver.com'); 


-- 내가 예약한 상담 리스트 불러오기 
select*from booking ;


CREATE TABLE booking
(
	booking_no            NUMBER ,
	condition             VARCHAR2(100) not NULL ,
	booking_day           date not NULL ,
	booking_content       CLOB not NULL ,
	booking_times         VARCHAR2(100) not NULL ,
	skills_id             NUMBER  ,
	times_id              NUMBER ,
	days_id               NUMBER ,
	id                    VARCHAR2(100),
	CONSTRAINT fk_booking_id FOREIGN KEY(id) REFERENCES member(id),
	CONSTRAINT pk_booking_share PRIMARY KEY(id,skills_id,times_id,days_id,booking_no),
	CONSTRAINT fk_booking_skills_id FOREIGN KEY(skills_id) REFERENCES skills(skills_id),
	CONSTRAINT fk_booking_times_id FOREIGN KEY(times_id) REFERENCES times(times_id),
	CONSTRAINT fk_booking_days_id FOREIGN KEY(days_id) REFERENCES days(days_id)
);