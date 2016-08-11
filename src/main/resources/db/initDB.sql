DROP TABLE IF EXISTS dishes;
DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS restaurants;
DROP SEQUENCE IF EXISTS global_seq;


CREATE SEQUENCE global_seq START 100000;

CREATE TABLE restaurants(
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name       VARCHAR NOT NULL
);
CREATE TABLE dishes(
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name       VARCHAR NOT NULL,
  price      FLOAT,
  restaurantId INTEGER,
  FOREIGN KEY (restaurantId) REFERENCES restaurants (id) ON DELETE CASCADE
)


CREATE TABLE users
(
  id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name       VARCHAR NOT NULL,
  email      VARCHAR NOT NULL,
  password   VARCHAR NOT NULL,
  registered TIMESTAMP DEFAULT now(),
  enabled    BOOL DEFAULT TRUE,
  voteRestaurantId INTEGER
  ,
  FOREIGN KEY (voteRestaurantId) REFERENCES restaurants (id)
);
CREATE UNIQUE INDEX users_unique_email_idx ON users (email);

CREATE TABLE user_roles
(
  user_id INTEGER NOT NULL,
  role    VARCHAR,
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

/*CREATE TABLE meals (
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  user_id     INTEGER NOT NULL,
  date_time    TIMESTAMP NOT NULL,
  description TEXT NOT NULL,
  calories    INT NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);*/
/*
CREATE UNIQUE INDEX meals_unique_user_datetime_idx ON meals(user_id, date_time)*/
