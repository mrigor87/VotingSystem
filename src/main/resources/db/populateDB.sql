DELETE  FROM restaurants;
DELETE  FROM dishes;
DELETE FROM user_roles;
DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO restaurants(name)
VALUES
  ('Restaurant1'), /*100000*/
  ('Restaurant2'), /*100001*/
  ('Restaurant3'); /*100002*/
INSERT INTO dishes (name,price,restaurantid)
VALUES
  ('dish1',10.2,100000), /*100003*/
  ('dish2',10.2,100000), /*100004*/
  ('dish3',10.2,100000), /*100005*/
  ('dish4',10.2,100001), /*100006*/
  ('dish5',10.2,100001), /*100007*/
  ('dish6',10.2,100002); /*100008*/

INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', 'password');

INSERT INTO users (name, email, password)
VALUES ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER',  100009),
  ('ROLE_ADMIN', 100010);


