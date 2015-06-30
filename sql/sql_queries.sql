SELECT
	user_name, passwd, role
FROM
	`users`
WHERE
	users.user_name = "user1" and passwd = "pwd";
