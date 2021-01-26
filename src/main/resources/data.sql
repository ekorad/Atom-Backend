-- initial user permissions
-- hardcoded and read-only, cannot be altered by anyone except devs
INSERT INTO user_permissions (name, description) VALUES
    ('CREATE_SELF_COMMENTS',    'Utilizatorul poate scrie comentarii'), 
    ('MODIFY_SELF_COMMENTS',    'Utilizatorul isi poate edita propriile comentarii'), 
    ('DELETE_SELF_COMMENTS',    'Utilizatorul isi poate sterge propriile comentarii'),
    ('PLACE_ORDER',             'Utilizatorul poate plasa comenzi'), 
    ('MODIFY_ANY_ORDER',        'Utilizatorul poate modifica orice comanda a oricarui utilizator'), 
    ('DELETE_ANY_ORDER',        'Utilizatorul poate sterge orice comanda a oricarui utilizator'), 
    ('READ_ANY_ORDER',          'Utilizatorul poate accesa orice comanda a oricarui utilizator'), 
    ('MODIFY_ANY_COMMENT',      'Utilizatorul poate modifica orice comentariu al oricarui utilizator'), 
    ('DELETE_ANY_COMMENT',      'Utilizatorul poate sterge orice comentariu al oricarui utilizator'),
    ('ADD_NEW_PRODUCT',         'Utilizatorul poate adauga noi produse in baza de date'), 
    ('MODIFY_ANY_PRODUCT',      'Utilizatorul poate modifica orice produs din baza de date'), 
    ('DELETE_ANY_PRODUCT',      'Utilizatorul poate sterge orice produs din baza de date'),
    ('CREATE_NEW_USER',         'Utilizatorul poate crea noi conturi de utilizatori'), 
    ('MODIFY_ANY_USER',         'Utilizatorul poate modifica contul oricarui utilizator'), 
    ('DELETE_ANY_USER',         'Utilizatorul poate sterge contul oricarui utilizator'), 
    ('READ_ANY_USER',           'Utilizatorul poate accesa datele contului oricarui utilizator'),
    ('READ_ANY_ROLE',           'Utilizatorul poate accesa toate rolurile de utilizator'), 
    ('MODIFY_ANY_ROLE',         'Utilizatorul poate modifica toate rolurile de utilizator'),
    ('DELETE_ANY_ROLE',         'Utilizatorul poate sterge orice rol de utilizator'),
    ('CREATE_NEW_ROLE',         'Utilizatorul poate crea noi roluri de utilizatori'),
    ('READ_ANY_PERMISSION',     'Utilizatorul poate accesa toate permisiunile de utilizator');

-- initial user roles
-- hardcoded and read-only, cannot be altered by anyone except devs
-- newly created user roles are mutable
INSERT INTO user_roles (name, description) VALUES
    ('USER', 'Utilizatorul poate posta, edita si sterge comentarii si plasa comenzi'), 
    ('MODERATOR', 'Utilizatorul are, pe langa privilegiile de utilizator obisnuit, acces complet asupra tuturor comentariilor si poate vizualiza conturi, permisiuni si roluri de utilizatori'), 
    ('ADMIN', 'Utilizatorul are toate privilegiile posibile - are acces complet asupra comentariilor, produselor, conturilor, rolurilor si permisiunilor de utilizatori');

-- initial user role permissions
-- hardcoded and read-only, cannot be altered by anyone except devs
-- newly created user roles are mutable and can have any associated permission

-- initial USER permissions
-- hardcoded and read-only, cannot be altered by anyone except devs
INSERT INTO roles_permissions(role_id, permission_id) VALUES 
    ((SELECT id FROM user_roles WHERE name = 'USER' LIMIT 1), 
        (SELECT id FROM user_permissions WHERE name = 'CREATE_SELF_COMMENTS' LIMIT 1));
INSERT INTO roles_permissions(role_id, permission_id) VALUES 
    ((SELECT id FROM user_roles WHERE name = 'USER' LIMIT 1), 
        (SELECT id FROM user_permissions WHERE name = 'MODIFY_SELF_COMMENTS' LIMIT 1));
INSERT INTO roles_permissions(role_id, permission_id) VALUES 
    ((SELECT id FROM user_roles WHERE name = 'USER' LIMIT 1), 
        (SELECT id FROM user_permissions WHERE name = 'DELETE_SELF_COMMENTS' LIMIT 1));
INSERT INTO roles_permissions(role_id, permission_id) VALUES 
    ((SELECT id FROM user_roles WHERE name = 'USER' LIMIT 1), 
        (SELECT id FROM user_permissions WHERE name = 'PLACE_ORDER' LIMIT 1));

-- initial MODERATOR permissions
-- hardcoded and read-only, cannot be altered by anyone except devs
INSERT INTO roles_permissions(role_id, permission_id) VALUES 
    ((SELECT id FROM user_roles WHERE name = 'MODERATOR' LIMIT 1), 
        (SELECT id FROM user_permissions WHERE name = 'CREATE_SELF_COMMENTS' LIMIT 1));
INSERT INTO roles_permissions(role_id, permission_id) VALUES 
    ((SELECT id FROM user_roles WHERE name = 'MODERATOR' LIMIT 1), 
        (SELECT id FROM user_permissions WHERE name = 'MODIFY_SELF_COMMENTS' LIMIT 1));
INSERT INTO roles_permissions(role_id, permission_id) VALUES 
    ((SELECT id FROM user_roles WHERE name = 'MODERATOR' LIMIT 1), 
        (SELECT id FROM user_permissions WHERE name = 'DELETE_SELF_COMMENTS' LIMIT 1));
INSERT INTO roles_permissions(role_id, permission_id) VALUES 
    ((SELECT id FROM user_roles WHERE name = 'MODERATOR' LIMIT 1), 
        (SELECT id FROM user_permissions WHERE name = 'PLACE_ORDER' LIMIT 1));
INSERT INTO roles_permissions(role_id, permission_id) VALUES 
    ((SELECT id FROM user_roles WHERE name = 'MODERATOR' LIMIT 1), 
        (SELECT id FROM user_permissions WHERE name = 'MODIFY_ANY_COMMENT' LIMIT 1));
INSERT INTO roles_permissions(role_id, permission_id) VALUES 
    ((SELECT id FROM user_roles WHERE name = 'MODERATOR' LIMIT 1), 
        (SELECT id FROM user_permissions WHERE name = 'DELETE_ANY_COMMENT' LIMIT 1));
INSERT INTO roles_permissions(role_id, permission_id) VALUES 
    ((SELECT id FROM user_roles WHERE name = 'MODERATOR' LIMIT 1), 
        (SELECT id FROM user_permissions WHERE name = 'READ_ANY_ORDER' LIMIT 1));
INSERT INTO roles_permissions(role_id, permission_id) VALUES 
    ((SELECT id FROM user_roles WHERE name = 'MODERATOR' LIMIT 1), 
        (SELECT id FROM user_permissions WHERE name = 'READ_ANY_PERMISSION' LIMIT 1));
INSERT INTO roles_permissions(role_id, permission_id) VALUES 
    ((SELECT id FROM user_roles WHERE name = 'MODERATOR' LIMIT 1), 
        (SELECT id FROM user_permissions WHERE name = 'READ_ANY_ROLE' LIMIT 1));
INSERT INTO roles_permissions(role_id, permission_id) VALUES 
    ((SELECT id FROM user_roles WHERE name = 'MODERATOR' LIMIT 1), 
        (SELECT id FROM user_permissions WHERE name = 'READ_ANY_USER' LIMIT 1));

-- initial ADMIN permissions
-- hardcoded and read-only, cannot be altered by anyone except devs
INSERT INTO roles_permissions(role_id, permission_id) VALUES 
    ((SELECT id FROM user_roles WHERE name = 'ADMIN' LIMIT 1), 
        (SELECT id FROM user_permissions WHERE name = 'CREATE_SELF_COMMENTS' LIMIT 1));
INSERT INTO roles_permissions(role_id, permission_id) VALUES 
    ((SELECT id FROM user_roles WHERE name = 'ADMIN' LIMIT 1), 
        (SELECT id FROM user_permissions WHERE name = 'MODIFY_SELF_COMMENTS' LIMIT 1));
INSERT INTO roles_permissions(role_id, permission_id) VALUES 
    ((SELECT id FROM user_roles WHERE name = 'ADMIN' LIMIT 1), 
        (SELECT id FROM user_permissions WHERE name = 'DELETE_SELF_COMMENTS' LIMIT 1));
INSERT INTO roles_permissions(role_id, permission_id) VALUES 
    ((SELECT id FROM user_roles WHERE name = 'ADMIN' LIMIT 1), 
        (SELECT id FROM user_permissions WHERE name = 'PLACE_ORDER' LIMIT 1));
INSERT INTO roles_permissions(role_id, permission_id) VALUES 
    ((SELECT id FROM user_roles WHERE name = 'ADMIN' LIMIT 1), 
        (SELECT id FROM user_permissions WHERE name = 'MODIFY_ANY_COMMENT' LIMIT 1));
INSERT INTO roles_permissions(role_id, permission_id) VALUES 
    ((SELECT id FROM user_roles WHERE name = 'ADMIN' LIMIT 1), 
        (SELECT id FROM user_permissions WHERE name = 'DELETE_ANY_COMMENT' LIMIT 1));
INSERT INTO roles_permissions(role_id, permission_id) VALUES 
    ((SELECT id FROM user_roles WHERE name = 'ADMIN' LIMIT 1), 
        (SELECT id FROM user_permissions WHERE name = 'READ_ANY_ORDER' LIMIT 1));
INSERT INTO roles_permissions(role_id, permission_id) VALUES 
    ((SELECT id FROM user_roles WHERE name = 'ADMIN' LIMIT 1), 
        (SELECT id FROM user_permissions WHERE name = 'MODIFY_ANY_ORDER' LIMIT 1));
INSERT INTO roles_permissions(role_id, permission_id) VALUES 
    ((SELECT id FROM user_roles WHERE name = 'ADMIN' LIMIT 1), 
        (SELECT id FROM user_permissions WHERE name = 'DELETE_ANY_ORDER' LIMIT 1));
INSERT INTO roles_permissions(role_id, permission_id) VALUES 
    ((SELECT id FROM user_roles WHERE name = 'ADMIN' LIMIT 1), 
        (SELECT id FROM user_permissions WHERE name = 'ADD_NEW_PRODUCT' LIMIT 1));
INSERT INTO roles_permissions(role_id, permission_id) VALUES 
    ((SELECT id FROM user_roles WHERE name = 'ADMIN' LIMIT 1), 
        (SELECT id FROM user_permissions WHERE name = 'MODIFY_ANY_PRODUCT' LIMIT 1));
INSERT INTO roles_permissions(role_id, permission_id) VALUES 
    ((SELECT id FROM user_roles WHERE name = 'ADMIN' LIMIT 1), 
        (SELECT id FROM user_permissions WHERE name = 'DELETE_ANY_PRODUCT' LIMIT 1));
INSERT INTO roles_permissions(role_id, permission_id) VALUES 
    ((SELECT id FROM user_roles WHERE name = 'ADMIN' LIMIT 1), 
        (SELECT id FROM user_permissions WHERE name = 'CREATE_NEW_USER' LIMIT 1));
INSERT INTO roles_permissions(role_id, permission_id) VALUES 
    ((SELECT id FROM user_roles WHERE name = 'ADMIN' LIMIT 1), 
        (SELECT id FROM user_permissions WHERE name = 'DELETE_ANY_USER' LIMIT 1));
INSERT INTO roles_permissions(role_id, permission_id) VALUES 
    ((SELECT id FROM user_roles WHERE name = 'ADMIN' LIMIT 1), 
        (SELECT id FROM user_permissions WHERE name = 'MODIFY_ANY_USER' LIMIT 1));
INSERT INTO roles_permissions(role_id, permission_id) VALUES 
    ((SELECT id FROM user_roles WHERE name = 'ADMIN' LIMIT 1), 
        (SELECT id FROM user_permissions WHERE name = 'READ_ANY_USER' LIMIT 1));
INSERT INTO roles_permissions(role_id, permission_id) VALUES 
    ((SELECT id FROM user_roles WHERE name = 'ADMIN' LIMIT 1), 
        (SELECT id FROM user_permissions WHERE name = 'READ_ANY_ROLE' LIMIT 1));
INSERT INTO roles_permissions(role_id, permission_id) VALUES 
    ((SELECT id FROM user_roles WHERE name = 'ADMIN' LIMIT 1), 
        (SELECT id FROM user_permissions WHERE name = 'READ_ANY_PERMISSION' LIMIT 1));
INSERT INTO roles_permissions(role_id, permission_id) VALUES 
    ((SELECT id FROM user_roles WHERE name = 'ADMIN' LIMIT 1), 
        (SELECT id FROM user_permissions WHERE name = 'CREATE_NEW_ROLE' LIMIT 1));
INSERT INTO roles_permissions(role_id, permission_id) VALUES 
    ((SELECT id FROM user_roles WHERE name = 'ADMIN' LIMIT 1), 
        (SELECT id FROM user_permissions WHERE name = 'MODIFY_ANY_ROLE' LIMIT 1));
INSERT INTO roles_permissions(role_id, permission_id) VALUES 
    ((SELECT id FROM user_roles WHERE name = 'ADMIN' LIMIT 1), 
        (SELECT id FROM user_permissions WHERE name = 'DELETE_ANY_ROLE' LIMIT 1));