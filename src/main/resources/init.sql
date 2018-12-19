CREATE TABLE item (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  category varchar(255) DEFAULT NULL,
  description varchar(255) DEFAULT NULL,
  name varchar(255) DEFAULT NULL,
  path_to_file varchar(255) DEFAULT NULL,
  price int(11) DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE user (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  is_blocked bit(1) NOT NULL,
  password varchar(255) DEFAULT NULL,
  username varchar(255) DEFAULT NULL,
  role varchar(20) CHARACTER SET utf8 NOT NULL DEFAULT 'ROLE_USER',
  PRIMARY KEY (id)
);

CREATE TABLE bought_item(
  id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  user_id BIGINT NOT NULL,
  item_id BIGINT NOT NULL,
  status NVARCHAR(100),
  card_number INT NOT NULL,
  address NVARCHAR(100),
  FOREIGN KEY (user_id) REFERENCES user(id),
  FOREIGN KEY (item_id) REFERENCES item(id)
);

INSERT INTO user(is_blocked, password, username, role) VALUES (false, '$2a$10$rNv55rQku/k5w/I4/Ml0SuCS5kFH6RAJgVjB2mv.3SmgkRpqOXM8O','admin','ROLE_ADMIN');
INSERT INTO item(category, description, name, path_to_file, price) VALUES ('phone','iphone X','Cell phone','/img/iphone.jpg',999);
