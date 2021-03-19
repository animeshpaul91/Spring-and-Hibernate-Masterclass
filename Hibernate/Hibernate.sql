use spring;

-- CREATE DATABASE  IF NOT EXISTS `hb_student_tracker`;
-- USE `hb_student_tracker`;
--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

select * from student;

CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `company` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

select * from employee;

alter table student
add column `date_of_birth` datetime null after last_name;

delete from student where id=1;

select * from instructor;
select * from instructor_detail;

select * from instructor;
select * from instructor_detail;
select * from course;

select * from review;

select * from student;
select * from course;
select * from course_student;

select courses0_.student_id as student_1_1_0_, courses0_.course_id as course_i2_1_0_, course1_.id as id1_0_1_, course1_.instructor_id as instruct3_0_1_, course1_.title as title2_0_1_, instructor2_.id as id1_2_2_, instructor2_.email as email2_2_2_, instructor2_.first_name as first_na3_2_2_, instructor2_.instructor_detail_id as instruct5_2_2_, instructor2_.last_name as last_nam4_2_2_, instructor3_.id as id1_3_3_, instructor3_.hobby as hobby2_3_3_, instructor3_.youtube_channel as youtube_3_3_3_ from course_student courses0_ inner join course course1_ on courses0_.course_id=course1_.id left outer join instructor instructor2_ on course1_.instructor_id=instructor2_.id left outer join instructor_detail instructor3_ on instructor2_.instructor_detail_id=instructor3_.id 
where courses0_.student_id=1;

select * from customer;

select * from users;
select * from authorities;