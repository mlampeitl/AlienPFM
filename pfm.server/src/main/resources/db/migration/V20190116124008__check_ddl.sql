/*
 * Creating and droping a temporary table to ensure ddl is working
 */
 CREATE TABLE sys_check_ddl
 (
    id NUMERIC
 );

 INSERT INTO sys_check_ddl VALUES (1);

 DROP TABLE sys_check_ddl;
