-- Step 1 Clean DB Data

USE `full-stack-ecommerce`;

SET FOREIGN_KEY_CHECKS = 0;

TRUNCATE customer;
TRUNCATE orders;
TRUNCATE order_item;
TRUNCATE address;

SET FOREIGN_KEY_CHECKS = 0;

-- Make Email Address Unique (Add DB constraint)

alter table customer add unique(email);