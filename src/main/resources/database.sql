CREATE TABLE users (
                       id INT NOT NULL PRIMARY KEY,
                       username VARCHAR(255) NOT NULL,
                       password VARCHAR(255) NOT NULL
);


CREATE TABLE roles (
                       id INT NOT NULL PRIMARY KEY,
                       name VARCHAR(100) NOT NULL
);


CREATE TABLE user_roles (
                            user_id INT NOT NULL ,
                            role_id INT NOT NULL ,

                            FOREIGN KEY (user_id) REFERENCES users(id),
                            FOREIGN KEY (role_id) REFERENCES roles(id),

                            UNIQUE (user_id, role_id)
);


INSERT into roles VALUES (1, 'ROLE_USER');
INSERT into roles VALUES (2, 'ROLE_ADMIN');

INSERT into users VALUES (1, 'Artem', '$2y$10$uUVAxEV1KyYNOMJVBGatW.5R7vVR6esfDP2x2cNRhwPSk39wpJ6IS');
INSERT into user_roles VALUES (1, 2);