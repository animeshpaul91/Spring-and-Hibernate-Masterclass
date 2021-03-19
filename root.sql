CREATE USER 'hbstudent'@'localhost' IDENTIFIED BY 'hbstudent';

GRANT ALL PRIVILEGES ON *.* to 'hbstudent'@'localhost';

ALTER USER 'hbstudent'@'localhost' IDENTIFIED WITH mysql_native_password BY 'hbstudent';

show databases;

CREATE USER 'springstudent'@'localhost' IDENTIFIED BY 'springstudent';

GRANT ALL PRIVILEGES ON spring_security_demo_plaintext.* TO 'springstudent'@'localhost';

DROP USER if exists 'springstudent'@'localhost';
CREATE USER 'springstudent'@'localhost' IDENTIFIED BY 'Babubabu123**';
GRANT ALL PRIVILEGES ON * . * TO 'springstudent'@'localhost';
# ALTER USER 'springstudent'@'localhost' IDENTIFIED WITH mysql_native_password BY 'springstudent';


SHOW VARIABLES LIKE 'validate_password%';

SET GLOBAL validate_password.length = 0;
SET GLOBAL validate_password.number_count = 0;

ALTER USER 'animesh'@'localhost' IDENTIFIED WITH mysql_native_password BY 'Babubabu123**';

select user from mysql.user;