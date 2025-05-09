insert into bablog_db.user (id, email, password) values (1, 'kernel01@gmail.com', '1234');
insert into bablog_db.user (id, email, password) values (2, 'kernel02@gmail.com', '1234');
insert into bablog_db.user (id, email, password) values (3, 'kernel03@gmail.com', '1234');
insert into bablog_db.user (id, email, password) values (4, 'kernel04@gmail.com', '1234');
insert into bablog_db.user (id, email, password) values (5, 'kernel05@gmail.com', '1234');
insert into bablog_db.user (id, email, password) values (6, 'kernel06@gmail.com', '1234');
insert into bablog_db.user (id, email, password) values (7, 'kernel07@gmail.com', '1234');
insert into bablog_db.user (id, email, password) values (8, 'kernel08@gmail.com', '1234');
insert into bablog_db.user (id, email, password) values (9, 'kernel09@gmail.com', '1234');
insert into bablog_db.user (id, email, password) values (10, 'kernel10@gmail.com', '1234');
insert into bablog_db.user (id, email, password) values (11, 'kernel11@gmail.com', '1234');
insert into bablog_db.user (id, email, password) values (12, 'kernel12@gmail.com', '1234');
insert into bablog_db.user (id, email, password) values (13, 'kernel13@gmail.com', '1234');
insert into bablog_db.user (id, email, password) values (14, 'kernel14@gmail.com', '1234');

INSERT INTO bablog_db.user (id, email, password) VALUES
                                                     (15, 'kernel15@gmail.com', '1234'),
                                                     (16, 'kernel16@gmail.com', '1234'),
                                                     (17, 'kernel17@gmail.com', '1234'),
                                                     (18, 'kernel18@gmail.com', '1234'),
                                                     (19, 'kernel19@gmail.com', '1234'),
                                                     (20, 'kernel20@gmail.com', '1234'),
                                                     (21, 'kernel21@gmail.com', '1234'),
                                                     (22, 'kernel22@gmail.com', '1234'),
                                                     (23, 'kernel23@gmail.com', '1234'),
                                                     (24, 'kernel24@gmail.com', '1234'),
                                                     (25, 'kernel25@gmail.com', '1234'),
                                                     (26, 'kernel26@gmail.com', '1234'),
                                                     (27, 'kernel27@gmail.com', '1234'),
                                                     (28, 'kernel28@gmail.com', '1234'),
                                                     (29, 'kernel29@gmail.com', '1234'),
                                                     (30, 'kernel30@gmail.com', '1234');

insert into post (created_at, id, address, img_url, title) values (CURRENT_TIMESTAMP, 1, '서울특별시 강남구 역삼로3길 17-4 1층', 'http://127.0.01:8080/static/001.png', '칸나칼국수');
insert into post (created_at, id, address, img_url, title) values (CURRENT_TIMESTAMP, 2, '서울 강남구 역삼로3길 20-4', 'http://127.0.01:8080/static/002.jpeg', '농민백암순대');
insert into post (created_at, id, address, img_url, title) values (CURRENT_TIMESTAMP, 3, '서울 강남구 테헤란로4길 46 쌍용플래티넘밸류 B-147,148,149호', 'http://127.0.01:8080/static/003.jpeg', '을밀대');
insert into post (created_at, id, address, img_url, title) values (CURRENT_TIMESTAMP, 4, '서울 강남구 강남대로84길 6 1층 1992덮밥&짜글이', 'http://127.0.01:8080/static/004.png', '1992 덮밥');
insert into post (created_at, id, address, img_url, title) values (CURRENT_TIMESTAMP, 5, '서울 강남구 테헤란로4길 46 쌍용플래티넘밸류 B1 120호', 'http://127.0.01:8080/static/005.jpeg', '왓쇼이켄');
insert into post (created_at, id, address, img_url, title) values (CURRENT_TIMESTAMP, 6, '서울 강남구 강남대로94길 27 지상1층', 'http://127.0.01:8080/static/006.jpeg', '멘노아지');
insert into post (created_at, id, address, img_url, title) values (CURRENT_TIMESTAMP, 7, '서울 강남구 테헤란로4길 46 쌍용플래티넘밸류 상가 1층 102호, 103호', 'http://127.0.01:8080/static/007.jpeg', '오토김밥');
insert into post (created_at, id, address, img_url, title) values (CURRENT_TIMESTAMP, 8, '서울 서초구 강남대로 421', 'http://127.0.01:8080/static/008.png', '쉐이크쉑 강남대로점');
insert into post (created_at, id, address, img_url, title) values (CURRENT_TIMESTAMP, 9, '주소9', 'http://127.0.01:8080/static/009.jpeg', '지미존스');
insert into post (created_at, id, address, img_url, title) values (CURRENT_TIMESTAMP, 10, '주소10', 'http://127.0.01:8080/static/010.jpeg', '안녕숯불');
insert into post (created_at, id, address, img_url, title) values (CURRENT_TIMESTAMP, 11, '주소11', 'http://127.0.01:8080/static/011.jpeg', '고쿠텐');
insert into post (created_at, id, address, img_url, title) values (CURRENT_TIMESTAMP, 12, '주소12', 'http://127.0.01:8080/static/012.jpeg', '강남불백');

INSERT INTO review (review_like, created_at, id, modified_at, post_id, user_id, comment) VALUES
                                                                                             (1, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 1, 1, 'comment01'),
                                                                                             (1, CURRENT_TIMESTAMP, 2, CURRENT_TIMESTAMP, 1, 2, 'comment02'),
                                                                                             (1, CURRENT_TIMESTAMP, 3, CURRENT_TIMESTAMP, 1, 3, 'comment03'),
                                                                                             (1, CURRENT_TIMESTAMP, 4, CURRENT_TIMESTAMP, 1, 4, 'comment04'),
                                                                                             (1, CURRENT_TIMESTAMP, 5, CURRENT_TIMESTAMP, 1, 5, 'comment05'),
                                                                                             (1, CURRENT_TIMESTAMP, 6, CURRENT_TIMESTAMP, 1, 6, 'comment06'),
                                                                                             (1, CURRENT_TIMESTAMP, 7, CURRENT_TIMESTAMP, 1, 7, 'comment07'),
                                                                                             (1, CURRENT_TIMESTAMP, 8, CURRENT_TIMESTAMP, 1, 8, 'comment08'),
                                                                                             (1, CURRENT_TIMESTAMP, 9, CURRENT_TIMESTAMP, 1, 9, 'comment09'),
                                                                                             (1, CURRENT_TIMESTAMP, 10, CURRENT_TIMESTAMP, 1, 10, 'comment10'),
                                                                                             (0, CURRENT_TIMESTAMP, 11, CURRENT_TIMESTAMP, 1, 11, 'comment11'),
                                                                                             (0, CURRENT_TIMESTAMP, 12, CURRENT_TIMESTAMP, 1, 12, 'comment12'),
                                                                                             (0, CURRENT_TIMESTAMP, 13, CURRENT_TIMESTAMP, 1, 13, 'comment13'),
                                                                                             (0, CURRENT_TIMESTAMP, 14, CURRENT_TIMESTAMP, 1, 14, 'comment14'),
                                                                                             (0, CURRENT_TIMESTAMP, 15, CURRENT_TIMESTAMP, 1, 15, 'comment15'),
                                                                                             (0, CURRENT_TIMESTAMP, 16, CURRENT_TIMESTAMP, 1, 16, 'comment16'),
                                                                                             (0, CURRENT_TIMESTAMP, 17, CURRENT_TIMESTAMP, 1, 17, 'comment17'),
                                                                                             (0, CURRENT_TIMESTAMP, 18, CURRENT_TIMESTAMP, 1, 18, 'comment18'),
                                                                                             (0, CURRENT_TIMESTAMP, 19, CURRENT_TIMESTAMP, 1, 19, 'comment19'),
                                                                                             (0, CURRENT_TIMESTAMP, 20, CURRENT_TIMESTAMP, 1, 20, 'comment20'),
                                                                                             (0, CURRENT_TIMESTAMP, 21, CURRENT_TIMESTAMP, 1, 21, 'comment21'),
                                                                                             (0, CURRENT_TIMESTAMP, 22, CURRENT_TIMESTAMP, 1, 22, 'comment22'),
                                                                                             (0, CURRENT_TIMESTAMP, 23, CURRENT_TIMESTAMP, 1, 23, 'comment23'),
                                                                                             (0, CURRENT_TIMESTAMP, 24, CURRENT_TIMESTAMP, 1, 24, 'comment24'),
                                                                                             (0, CURRENT_TIMESTAMP, 25, CURRENT_TIMESTAMP, 1, 25, 'comment25'),
                                                                                             (0, CURRENT_TIMESTAMP, 26, CURRENT_TIMESTAMP, 1, 26, 'comment26'),
                                                                                             (0, CURRENT_TIMESTAMP, 27, CURRENT_TIMESTAMP, 1, 27, 'comment27'),
                                                                                             (0, CURRENT_TIMESTAMP, 28, CURRENT_TIMESTAMP, 1, 28, 'comment28'),
                                                                                             (0, CURRENT_TIMESTAMP, 29, CURRENT_TIMESTAMP, 1, 29, 'comment29'),
                                                                                             (0, CURRENT_TIMESTAMP, 30, CURRENT_TIMESTAMP, 1, 30, 'comment30');

