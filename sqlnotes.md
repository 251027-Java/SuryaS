sql

atomic data - single data that can be standalone

deserialize - split

candidate key - possible unique identifier 

primary key - unique identifier, cannot be null

composite key - two+ columns that act together as unique identifiers

1NF - first normal form - every table has a primary key and is atomic
2NF - second normal form - every other column value depends on whole primary key
3NF - no transitive dependencies with non keys A-->B-->C (primary key)

DDL - Data Definition Language
DCL - Data Control Language 
DML - Data Manipulation Language: SELECT, UPDATE, INSERT, DELETE 
DQL - Data Query Language --> SELECT __ FROM ___ WHERE ... GROUP BY  __ HAVING __ ORDER BY ASC/DESC

ON UPDATE CASCADE - change primary key, all foreign key references to that primary key are updated.
ON DELETE CASCADE

referential integrity - checks for relationships

If you have a foreign key in one table and that specific value is not in the parent table with the primary key
, sql doesn't check for it when inserting, since there is no cascade on insert feature. if you join on that key then
yes there will be an error.

ALTER
