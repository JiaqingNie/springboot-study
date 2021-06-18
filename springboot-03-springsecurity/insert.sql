USE springbootSpringSecurity;
INSERT INTO user (id, username, password) values (1, 'Nickit', '$2a$12$Q0UJS3IhH/kEbxbNfiHhIOSP8n3HUbbnTm8/Bym7tuWzHG307pebC');
INSERT INTO user (id, username, password) values (2, 'Lucy', '$2a$12$Q0UJS3IhH/kEbxbNfiHhIOSP8n3HUbbnTm8/Bym7tuWzHG307pebC');
INSERT INTO user (id, username, password) values (3, 'Thea', '$2a$12$Q0UJS3IhH/kEbxbNfiHhIOSP8n3HUbbnTm8/Bym7tuWzHG307pebC');

INSERT INTO role (id, role_name) VALUES (1, 'SUPER_ADMIN');
INSERT INTO role (id, role_name) VALUES (2, 'ADMIN');
INSERT INTO role (id, role_name) VALUES (3, 'USER');

INSERT INTO operation (id, op_name) VALUES (1, 'ADMIN_READ');
INSERT INTO operation (id, op_name) VALUES (2, 'ADMIN_CREATE');
INSERT INTO operation (id, op_name) VALUES (3, 'ADMIN_UPDATE');
INSERT INTO operation (id, op_name) VALUES (4, 'ADMIN_DELETE');
INSERT INTO operation (id, op_name) VALUES (5, 'USER_READ');
INSERT INTO operation (id, op_name) VALUES (6, 'USER_CREATE');
INSERT INTO operation (id, op_name) VALUES (7, 'USER_UPDATE');
INSERT INTO operation (id, op_name) VALUES (8, 'USER_DELETE');


INSERT INTO user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO user_role (user_id, role_id) VALUES (1, 2);
INSERT INTO user_role (user_id, role_id) VALUES (1, 3);
INSERT INTO user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO user_role (user_id, role_id) VALUES (2, 3);
INSERT INTO user_role (user_id, role_id) VALUES (3, 3);

INSERT INTO role_operation (role_id, operation_id) VALUES (1, 1);
INSERT INTO role_operation (role_id, operation_id) VALUES (1, 2);
INSERT INTO role_operation (role_id, operation_id) VALUES (1, 3);
INSERT INTO role_operation (role_id, operation_id) VALUES (1, 4);
INSERT INTO role_operation (role_id, operation_id) VALUES (1, 5);
INSERT INTO role_operation (role_id, operation_id) VALUES (1, 6);
INSERT INTO role_operation (role_id, operation_id) VALUES (1, 7);
INSERT INTO role_operation (role_id, operation_id) VALUES (1, 8);
INSERT INTO role_operation (role_id, operation_id) VALUES (2, 5);
INSERT INTO role_operation (role_id, operation_id) VALUES (2, 6);
INSERT INTO role_operation (role_id, operation_id) VALUES (2, 7);
INSERT INTO role_operation (role_id, operation_id) VALUES (2, 8);