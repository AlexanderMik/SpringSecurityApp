-- Create table for users

CREATE TABLE users(
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY UNIQUE,
  username VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL
);

-- Create table for roles

CREATE TABLE roles(
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(10) NOT NULL
);

-- Create table for mapping users and roles

CREATE TABLE users_roles(
  user_id INT NOT NULL,
  role_id INT NOT NULL,

  FOREIGN KEY (user_id) REFERENCES users(id),
  FOREIGN KEY (role_id) REFERENCES roles(id),

  UNIQUE (user_id, role_id)
);

-- Insert data

INSERT INTO users VALUES (1, 'admin', 'password');

INSERT INTO roles VALUES (1, 'ROLE_USER');
INSERT INTO roles VALUES (2, 'ROLE_ADMIN');

INSERT INTO users_roles VALUES (1, 2);