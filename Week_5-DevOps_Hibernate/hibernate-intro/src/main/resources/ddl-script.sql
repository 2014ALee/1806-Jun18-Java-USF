--DROP TABLE EMPLOYEES;
CREATE TABLE EMPLOYEES (
    id          NUMBER(11) PRIMARY KEY,
    name        VARCHAR2(25) NOT NULL,
    role        VARCHAR2(25) NOT NULL,
    insert_time DATE DEFAULT NULL
);

CREATE SEQUENCE  EMPLOYEE_SEQ
MINVALUE 1 
MAXVALUE 999999999 
INCREMENT BY 1;

/*
CREATE OR REPLACE TRIGGER EMPLOYEE_TRIGGER
BEFORE INSERT ON EMPLOYEES
FOR EACH ROW

BEGIN
  SELECT EMPLOYEE_SEQ.NEXTVAL 
  INTO :new.ID
  FROM DUAL;
END;
*/

--DROP TABLE STUDENTS;
--TRUNCATE TABLE STUDENTS;

CREATE TABLE STUDENTS (
  id            NUMBER(11) NOT NULL PRIMARY KEY,
  first_name    VARCHAR2(45) DEFAULT NULL,
  last_name     VARCHAR2(45) DEFAULT NULL,
  email         VARCHAR2(45) DEFAULT NULL
);

--DROP SEQUENCE STUDENT_SEQ;
CREATE SEQUENCE STUDENT_SEQ
MINVALUE 1 
MAXVALUE 999999999 
INCREMENT BY 1
START WITH 1;

/*
CREATE OR REPLACE TRIGGER STUDENT_TRIGGER
BEFORE INSERT ON STUDENTS
FOR EACH ROW

BEGIN
  SELECT STUDENT_SEQ.NEXTVAL 
  INTO :new.ID
  FROM DUAL;
END;
*/

--DROP TABLE instructor_details;
CREATE TABLE instructor_details (
    id      NUMBER(11) PRIMARY KEY,
    focus   VARCHAR2(45) DEFAULT NULL,
    hobby   VARCHAR2(45) DEFAULT NULL
);

--DROP TABLE instructors;
CREATE TABLE instructors (
    id                      NUMBER(11) PRIMARY KEY,
    first_name              VARCHAR2(45) DEFAULT NULL,
    last_name               VARCHAR2(45) DEFAULT NULL,
    email                   VARCHAR2(45) DEFAULT NULL,
    instructor_detail_id    NUMBER(11) DEFAULT NULL,
    
    CONSTRAINT fk_instructor_detail_id 
    FOREIGN KEY (instructor_detail_id)
    REFERENCES instructor_details (id)
);

--DROP SEQUENCE INSTRUCTOR_DETAIL_SEQ;
CREATE SEQUENCE INSTRUCTOR_DETAIL_SEQ
MINVALUE 1 
MAXVALUE 999999999 
INCREMENT BY 1
START WITH 1;

--DROP SEQUENCE INSTRUCTOR_SEQ;
CREATE SEQUENCE INSTRUCTOR_SEQ
MINVALUE 1 
MAXVALUE 999999999 
INCREMENT BY 1
START WITH 1;

--DROP TABLE COURSES;
CREATE TABLE COURSES (
    id              NUMBER(11) PRIMARY KEY,
    title           VARCHAR2(128) UNIQUE,
    instructor_id   NUMBER(11),
    
    CONSTRAINT fk_instructor_id
    FOREIGN KEY (instructor_id)
    REFERENCES INSTRUCTORS (id)
);

--DROP SEQUENCE COURSE_SEQ;
CREATE SEQUENCE COURSE_SEQ
MINVALUE 1 
MAXVALUE 999999999 
INCREMENT BY 1
START WITH 1;

--DROP TABLE COURSE_STUDENT;
CREATE TABLE COURSE_STUDENT (
    course_id   NUMBER(11),
    student_id  NUMBER(11),
    
    CONSTRAINT ck_course_student 
    PRIMARY KEY (course_id, student_id),
    
    CONSTRAINT fk_cs_course
    FOREIGN KEY (course_id)
    REFERENCES COURSES (id),
    
    CONSTRAINT fk_cs_student
    FOREIGN KEY (student_id)
    REFERENCES STUDENTS (id)
);

--DROP TABLE BOOK_INFO;
CREATE TABLE BOOK_INFO (
    isbn        VARCHAR2(13) NOT NULL,
    book_name   VARCHAR2(30),
    author_name VARCHAR2(30),
    
    CONSTRAINT ck_book_info
    PRIMARY KEY (book_name, author_name)
);