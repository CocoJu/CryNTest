ALTER TABLE `users` ADD UNIQUE(`user_name`);

INSERT INTO users
  (user_name,passwd,role)
VALUES
  ("user1", "pwd", 1),
  ("user2", "pwd", 2),
  ("user3", "pwd", 2);

INSERT INTO houses
  (adress, count_floors)
VALUES
  ("маяковского 5", 5),
  ("Комарова 7", 12)
