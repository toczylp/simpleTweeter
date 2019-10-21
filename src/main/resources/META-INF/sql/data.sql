insert into User (email, firstName, lastName, password) VALUES ('a@a.pl', 'Janek', 'Wisnia', '123');
insert into User (email, firstName, lastName, password) VALUES ('b@b.pl', 'Lolek', 'Lolek', '123');
insert into User (email, firstName, lastName, password) VALUES ('c@c.pl', 'Piotr', 'Piotr', '123');
insert into User (email, firstName, lastName, password) VALUES ('d@d.pl', 'Aga', 'Aga', '123');

insert into Tweet (created, text, user_id) VALUES ('2019-10-15T20:46:31.569946', 'Tweet 1', 1 );
insert into Tweet (created, text, user_id) VALUES ('2019-10-15T20:47:31.569946', 'Tweet 3', 1 );
insert into Tweet (created, text, user_id) VALUES ('2019-10-15T20:48:31.569946', 'Tweet 4', 1 );
insert into Tweet (created, text, user_id) VALUES ('2019-10-15T20:49:31.569946', 'Tweet 2', 2 );
insert into Tweet (created, text, user_id) VALUES ('2019-10-15T20:45:31.569946', 'Tweet 5', 3 );
insert into Tweet (created, text, user_id) VALUES ('2019-10-15T20:44:31.569946', 'Tweet 6', 4 );
insert into Tweet (created, text, user_id) VALUES ('2019-10-15T20:55:31.569946', 'Tweet 7', 4 );
insert into Tweet (created, text, user_id) VALUES ('2019-10-15T20:51:31.569946', 'Tweet 8', 2 );
insert into Tweet (created, text, user_id) VALUES ('2019-10-15T20:15:31.569946', 'Tweet 9', 1 );
insert into Tweet (created, text, user_id) VALUES ('2019-10-15T20:45:31.569946', 'Tweet 10', 2 );
insert into Tweet (created, text, user_id) VALUES ('2019-10-15T20:43:31.569946', 'Tweet 11', 3 );
insert into Tweet (created, text, user_id) VALUES ('2019-10-15T20:42:31.569946', 'Tweet 12', 3 );

INSERT INTO tweetDB.Message (id, created, message, readFlag, recipient_id, sender_id) VALUES (1, '2019-10-20 19:24:28.197000', 'jh', false, 1, 2);
INSERT INTO tweetDB.Message (id, created, message, readFlag, recipient_id, sender_id) VALUES (2, '2019-10-20 19:28:34.544000', 'cbnc', false, 1, 2);
INSERT INTO tweetDB.Message (id, created, message, readFlag, recipient_id, sender_id) VALUES (3, '2019-10-20 19:28:41.853000', 'c ', false, 2, 1);
INSERT INTO tweetDB.Message (id, created, message, readFlag, recipient_id, sender_id) VALUES (4, '2019-10-20 19:29:59.306000', 'bncvc', false, 2, 1);