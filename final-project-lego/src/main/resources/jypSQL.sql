update member set password=#{password},name=#{name},address=#{address}, tel=#{tel}
			where id=#{id}

update member set password='aa',name='손석구',address='내 요동치는 마음속', tel='01012345678'
			where id='java@naver.com'		
			
select*from member where id='java@naver.com'

select*from master_detail
select*from booking;
--master_detail에 skill, times, days, 고수 id가 입력되어있다.  id빼고 number

CREATE SEQUENCE booking_seq;
insert into booking(booking_no,condition,booking_day,booking_content,booking_times,skills_id,times_id,days_id,id)
values(booking_seq.nextval,'예약날짜가능한지',to_date('9-6-2022','dd-mm-yyyy'),'예약 가능할까요?','12시',1,2,3,'kosta@naver.com') 
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