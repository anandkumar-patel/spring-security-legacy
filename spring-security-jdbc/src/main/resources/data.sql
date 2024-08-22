-- Insert the admin user with a BCrypt-encoded password
INSERT INTO users (username, password, enabled) VALUES ('admin', 'admin', TRUE);

-- Insert the regular user with a BCrypt-encoded password
INSERT INTO users (username, password, enabled) VALUES ('user', 'user', TRUE);


-- Admin has both ADMIN and USER roles
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_USER');

-- Regular user has only the USER role
INSERT INTO authorities (username, authority) VALUES ('user', 'ROLE_USER');
