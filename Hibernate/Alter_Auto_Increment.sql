-- Will set auto increment index start to 3000
alter table spring.student auto_increment=3000; 

-- Delete the data in table and reset auto increment index to 1
truncate spring.student;