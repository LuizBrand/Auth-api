INSERT INTO roles (name) VALUES ('ADMIN'), ('USER');

INSERT INTO users (username, password) VALUES
    ('admin', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iKTVEFDa'),
    ('user', '$2a$10$DowJonesIndex123456789uJ8iAt6Z5EHsM8lE9lBOsl7iKTVEFDa');

INSERT INTO user_roles (user_id, role_id) VALUES
    ((SELECT id FROM users WHERE username = 'admin'), (SELECT id FROM roles WHERE name = 'ADMIN')),
    ((SELECT id FROM users WHERE username = 'user'), (SELECT id FROM roles WHERE name = 'USER'));