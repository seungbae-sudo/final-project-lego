select * from days;
select * from times;

CONSTRAINT fk_mem_id FOREIGN KEY(id) REFERENCES mem(id),
	CONSTRAINT pk_sharess PRIMARY KEY(id,skill_id)
drop table board_comment
CREATE TABLE board
(
	board_no              NUMBER  primary key ,
	board_title           VARCHAR2(100)  not NULL ,
	board_content          CLOB not NULL ,
	category_no          number not null,
	hits                  NUMBER not NULL ,
	board_date                  DATE not NULL ,
	likes                 NUMBER not NULL ,
	id                    VARCHAR2(100) not NULL,
	CONSTRAINT fk_board_id FOREIGN KEY(id) REFERENCES member(id),
	CONSTRAINT fk_board_category_no FOREIGN KEY(category_no) REFERENCES board_category(category_no)
);

create table board_category(
	category_no number primary key,
	category_name varchar2(100) not null
)

CREATE TABLE board_comment
(
	comment_no            NUMBER  primary key ,
	comment_content       CLOB not NULL ,
	board_no              NUMBER not NULL ,
	id                    VARCHAR2(100) not NULL,
	CONSTRAINT fk_board_comment_id FOREIGN KEY(id) REFERENCES member(id)
);


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



CREATE TABLE cart
(
	cart_no               NUMBER  primary key,
	id                    VARCHAR2(100) not null ,
	CONSTRAINT fk_cart_id FOREIGN KEY(id) REFERENCES member(id)
);



CREATE TABLE category
(
	category_no           NUMBER  primary key ,
	lesson_sort           VARCHAR2(100) not NULL	
);



CREATE TABLE days
(
	days_id               NUMBER  primary key ,
	days                  VARCHAR2(100) not NULL 
);

CREATE TABLE images
(
	image_no              NUMBER  primary key ,
	image_name            VARCHAR2(100) not NULL ,
	id                    VARCHAR2(100) not NULL ,
	CONSTRAINT fk_images_id FOREIGN KEY(id) REFERENCES member(id)
);



CREATE TABLE master
(
	id                    VARCHAR2(100),
	specifications        VARCHAR2(100) not NULL ,
	career                VARCHAR2(100) not NULL ,
	category_no           NUMBER not NULL ,
	CONSTRAINT pk_master_share PRIMARY KEY(id),
	CONSTRAINT fk_master_id FOREIGN KEY(id) REFERENCES member(id),
	CONSTRAINT fk_master_categroy_no FOREIGN KEY(category_no) REFERENCES category(category_no)
	
);



drop table master_detail
CREATE TABLE master_detail
(
	skills_id             NUMBER ,
	times_id              NUMBER ,
	days_id               NUMBER ,
	id                    VARCHAR2(100),
	CONSTRAINT pk_master_detail_share PRIMARY KEY(id,skills_id,times_id,days_id),	
	CONSTRAINT fk_master_detail_id FOREIGN KEY(id) REFERENCES master(id),
	CONSTRAINT fk_master_detail_skills_id FOREIGN KEY(skills_id) REFERENCES skills(skills_id),
	CONSTRAINT fk_master_detail_times_id FOREIGN KEY(times_id) REFERENCES times(times_id),
	CONSTRAINT fk_master_detail_days_id FOREIGN KEY(days_id) REFERENCES days(days_id)
);


CREATE TABLE member
(
	id                    VARCHAR2(100) primary key ,
	name                  VARCHAR2(100) not NULL ,
	address               VARCHAR2(100) not NULL ,
	password              VARCHAR2(100) not NULL ,
	tel                   VARCHAR2(100) not NULL ,
	member_type                  NUMBER not NULL 
);


CREATE TABLE message
(
	message_no            number primary key  ,
	message_content       clob not NULL ,
	receive_id            VARCHAR2(100) not null ,
	id                    VARCHAR2(100) not NULL ,
	receive_date          DATE not NULL ,
	CONSTRAINT fk_message_id FOREIGN KEY(id) REFERENCES member(id),
	CONSTRAINT fk_message_receive_id FOREIGN KEY(receive_id) REFERENCES member(id)
);



CREATE TABLE qna
(
	qna_no                NUMBER  primary key ,
	ask                   VARCHAR2(100) not NULL ,
	id                    VARCHAR2(100) not NULL,
	CONSTRAINT fk_qna_id FOREIGN KEY(id) REFERENCES member(id)
);



CREATE TABLE qna_comment
(
	qna_comment_no        NUMBER  primary key ,
	qna_comment_content   CLOB not NULL ,
	qna_no                NUMBER not NULL ,
	id                    VARCHAR2(100) not NULL,
	CONSTRAINT fk_qna_comment_id FOREIGN KEY(id) REFERENCES member(id)
);



CREATE TABLE review
(
	review_no             NUMBER  primary key,
	score                 NUMBER not NULL ,
	reivew_content        CLOB not NULL ,
	id                    VARCHAR2(100) not null,
	CONSTRAINT fk_review_id FOREIGN KEY(id) REFERENCES member(id)
);


CREATE TABLE skills
(
	skills_id             NUMBER  primary key ,
	skills                VARCHAR2(100) not NULL 
);


CREATE TABLE survey
(
	survey_no             NUMBER  primary key,
	gender                VARCHAR2(100) not NULL ,
	location              VARCHAR2(100) not NULL ,
	id                    VARCHAR2(100) not NULL,
	CONSTRAINT fk_survey_id FOREIGN KEY(id) REFERENCES member(id)
	
);




CREATE TABLE survey_detail
(
	survey_no             NUMBER  ,
	times_id              NUMBER  ,
	days_id               NUMBER  ,
	CONSTRAINT pk_survey_detail_share PRIMARY KEY(survey_no,times_id,days_id),
	CONSTRAINT fk_survey_detail_times_id FOREIGN KEY(times_id) REFERENCES times(times_id),
	CONSTRAINT fk_survey_detail_days_id FOREIGN KEY(days_id) REFERENCES days(days_id)
);



CREATE TABLE times
(
	times_id              NUMBER primary key ,
	times                 VARCHAR2(100) not NULL 
);


