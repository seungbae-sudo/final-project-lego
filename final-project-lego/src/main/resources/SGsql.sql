-- 일반 회원 update
update member set password=1,name=1,address=#{address},tel=#{tel} where id=#{id}

-- 고수 update
update master set specifications=#{specifications},career=#{career} where id=#{id}

-- 고수 정보 list
select id,career,category_no,specifications from master where id =#{value}

-- 고수 category list select
select distinct s.skills,d.days,t.times,m.id
from(
select *
from master_detail m,skills s
where m.id = #{value}
and m.skills_id>0
and m.skills_id = s.skills_id
)s, (select *
from master_detail m,times t 
where m.id = #{value}
and m.times_id>0 
and m.times_id = t.times_id
)t, (select * 
from master_detail m,days d 
where m.id = #{value}
and m.days_id>0 
and m.days_id = d.days_id
)d, master_detail m
where m.id = #{value}

-- 고수 my board select
select b.board_no,b.board_title,c.category_name, c.category_no
from board b, board_category c
where b.id = #{value}
and c.category_no = b.category_no

-- 고수 booking list select 
select m.*, b.*
from member m, booking b
where m.id = b.member_id
and b.master_id = #{value}

-- 고수 booking detail select
select b.booking_no,b.booking_day,b.booking_content,b.master_id,b.member_id,m.name 
from booking b,member m 
where booking_no=#{value}
and m.id=b.member_id	

-- 고수 review select
select r.id, r.score, r.review_content, m.name
from review r, member m
where r.id = m.id
and r.master_id = #{value}

-- 고수 pagenation,review select
select rnum,score,review_content,id,name
from 
(
select row_number() over(order by review_no desc) as rnum, r.score, r.review_content, r.id, m.name
from review r, member m
where r.id = m.id
and r.master_id = #{id} 
)
where rnum between #{pagination.startRowNumber} and #{pagination.endRowNumber}

-- 고수 review pagenation total list
select count(*)
from 
(
select r.id, r.score, r.review_content, m.name
from review r, member m
where r.id = m.id
and r.master_id = #{value}
)

-- 고수가 받은 message select
select ms.id, ms.receive_id as id,m.name,i.image_name
from message ms, member m , images i
where ms.receive_id = #{value}
and ms.id=m.id
and ms.id=i.id(+)
group by ms.id,ms.receive_id,m.name,i.image_name

-- message detail select
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

-- 고수 message 전송
insert into message(message_no, message_content, id,receive_id,receive_date) values(message_no_seq.nextval, #{messageContent},#{sendMvo.id},#{reMvo.id},sysdate)

-- 고수 image 
select * from images where id=#{value}

-- 고수 category select
select c.lesson_sort from master m,category c where id = #{value} and m.category_no = c.category_no

-- 고수 skill select
select s.skills from master_detail m,skills s where m.id = #{value} and m.skills_id>0 and m.skills_id = s.skills_id

-- 고수 review 평균값
select nvl(round(avg(r.score),1),0) as score from review r where master_id= '123@123.com'

-- 고수 pagenation + my board 
select rnum,board_no,board_title,category_name,category_no
from 
(
select row_number() over(order by b.board_no desc) as rnum, b.board_no, b.board_title, c.category_name, c.category_no
from board b, board_category c
where b.id = #{id}
and c.category_no = b.category_no
) where rnum between #{pagination.startRowNumber} and #{pagination.endRowNumber}

-- 고수 pagenation + my board list count
select count(*)
from
(
select b.board_no, b.board_title, c.category_name, c.category_no
from board b, board_category c
where b.id = #{value}
and c.category_no = b.category_no
)

-- 고수 pagenation + booking list select 
select rnum,name,booking_no,booking_day,booking_content,member_id
from 
(
select row_number() over(order by b.booking_no desc) as rnum, m.name, b.booking_no, b.booking_day,b.booking_content, b.member_id
from member m, booking b
where m.id = b.member_id
and b.master_id = #{id}
)where rnum between #{pagination.startRowNumber} and #{pagination.endRowNumber}

-- 고수 pagenation + booking list count
select count(*)
from
(
select m.name, b.booking_no, b.booking_day,b.booking_content, b.member_id
from member m, booking b
where m.id = b.member_id
and b.master_id = #{value}
)

-----------------------------------------------------------------------------------------------------------------------------------------
--연습--

-- 고수 pagenation,review select
select rnum,score,review_content,id,name
from 
(
select row_number() over(order by review_no desc) as rnum, r.score, r.review_content, r.id, m.name
from review r, member m
where r.id = m.id
and r.master_id = 'ksg@kosta.com' 
)
where rnum between #{pagination.startRowNumber} and #{pagination.endRowNumber}

-- 고수 pagenation total list
select count(*)
from 
(
select r.id, r.score, r.review_content, m.name
from review r, member m
where r.id = m.id
and r.master_id = 'ksg@kosta.com'
)

-- 고수 my board select
select b.board_no,b.board_title,c.category_name, c.category_no
from board b, board_category c
where b.id = #{value}
and c.category_no = b.category_no

-- 고수 pagenation
select rnum,board_no,board_title,category_name,category_no
from 
(
select row_number() over(order by b.board_no desc) as rnum, b.board_no, b.board_title, c.category_name, c.category_no
from board b, board_category c
where b.id = #{id}
and c.category_no = b.category_no
) where rnum between #{pagination.startRowNumber} and #{pagination.endRowNumber}

-- 고수 카운트
select count(*)
from
(
select row_number() over(order by b.board_no desc) as rnum, b.board_no, b.board_title, c.category_name, c.category_no
from board b, board_category c
where b.id = #{value}
and c.category_no = b.category_no
)

-- 고수 booking list select 
select rnum,name,booking_no,booking_day,booking_content,member_id
from 
(
select row_number() over(order by b.booking_no desc) as rnum, m.name, b.booking_no, b.booking_day,b.booking_content, b.member_id
from member m, booking b
where m.id = b.member_id
and b.master_id = #{id}
)where rnum between #{pagination.startRowNumber} and #{pagination.endRowNumber}






select count(*)
from 
(
select r.id, r.score, r.review_content, m.name
from review r, member m
where r.id = m.id
and r.master_id = 'ksg@kosta.com'
)
