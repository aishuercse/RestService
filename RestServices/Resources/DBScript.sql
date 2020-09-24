create table message(id integer, message varchar(50), author_name varchar(20), posted_date timestamp, primary key(id));
insert into message values(1, "first message posted by author1", "author1", now());
insert into message values(2, "second message posted by author1", "author1", now());
insert into message values(3, "first message posted by author2", "author2", now());
insert into message values(4, "second message posted by author2", "author2", now());