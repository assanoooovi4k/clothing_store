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
  card_number NVARCHAR(16) NOT NULL,
  address NVARCHAR(100) NOT NULL,
  FOREIGN KEY (user_id) REFERENCES user(id),
  FOREIGN KEY (item_id) REFERENCES item(id)
);



INSERT INTO clothing_store.bought_item (id, user_id, item_id, status, card_number, address) VALUES (1, 26, 11, 'delivered', '2322333344445555', 'Minsk,str. Nevazno, 33/11');
INSERT INTO clothing_store.bought_item (id, user_id, item_id, status, card_number, address) VALUES (2, 26, 17, 'rejected', '123', 'ne znau');
INSERT INTO clothing_store.hibernate_sequence (next_val) VALUES (27);
INSERT INTO clothing_store.hibernate_sequence (next_val) VALUES (27);
INSERT INTO clothing_store.hibernate_sequence (next_val) VALUES (27);
INSERT INTO clothing_store.item (id, category, description, name, path_to_file, price) VALUES (11, 'Jackets', 'Warm, autumn jacket for men. Size: M', 'YOUTH MOUNTAIN GTX JACKET', '/img/TNFJacket.png', 230);
INSERT INTO clothing_store.item (id, category, description, name, path_to_file, price) VALUES (17, 'Jeans', 'Beautiful, rare EVISU jeans for men. Size M.', 'EVISU JEANS', '/img/EVISUPants.png', 150);
INSERT INTO clothing_store.item (id, category, description, name, path_to_file, price) VALUES (23, 'Boots', 'Warm, perfect boots for winter. Size: 44', 'THE NORTH FACE BOOTS', '/img/TNFBoots.png', 210);
INSERT INTO clothing_store.user (id, is_blocked, password, username, role) VALUES (1, false, '$2a$10$rNv55rQku/k5w/I4/Ml0SuCS5kFH6RAJgVjB2mv.3SmgkRpqOXM8O', 'admin', 'ROLE_ADMIN');
INSERT INTO clothing_store.user (id, is_blocked, password, username, role) VALUES (26, false, '$2a$10$XPupoqZ.4qQRazOjxG82mev8i798P1f4P2rLr1GuC60cGXEbHmnku', 'kirill', 'ROLE_USER');