-- -- -- initial user permissions
-- -- -- hardcoded and read-only, cannot be altered by anyone except devs
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
    ('READ_ANY_PERMISSION',     'Utilizatorul poate accesa toate permisiunile de utilizator'),
    ('ELEVATED',                'Utilizatorul are drepturi administrative si poate accesa sectiunile de administrare');

-- -- initial user roles
-- -- hardcoded and read-only, cannot be altered by anyone except devs
-- -- newly created user roles are mutable
INSERT INTO user_roles (name, description) VALUES
    ('USER', 'Utilizatorul poate posta, edita si sterge comentarii si plasa comenzi'), 
    ('MODERATOR', 'Utilizatorul are, pe langa privilegiile de utilizator obisnuit, acces complet asupra tuturor comentariilor si poate vizualiza conturi, permisiuni si roluri de utilizatori'), 
    ('ADMIN', 'Utilizatorul are toate privilegiile posibile - are acces complet asupra comentariilor, produselor, conturilor, rolurilor si permisiunilor de utilizatori');

-- -- initial user role permissions
-- -- hardcoded and read-only, cannot be altered by anyone except devs
-- -- newly created user roles are mutable and can have any associated permission

-- -- initial USER permissions
-- -- hardcoded and read-only, cannot be altered by anyone except devs
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

-- -- initial MODERATOR permissions
-- -- hardcoded and read-only, cannot be altered by anyone except devs
-- -- MODERATOR has elevated privileges
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
INSERT INTO roles_permissions(role_id, permission_id) VALUES 
    ((SELECT id FROM user_roles WHERE name = 'MODERATOR' LIMIT 1), 
        (SELECT id FROM user_permissions WHERE name = 'ELEVATED' LIMIT 1));

-- -- initial ADMIN permissions
-- -- hardcoded and read-only, cannot be altered by anyone except devs
-- -- ADMIN has elevated privileges
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
INSERT INTO roles_permissions(role_id, permission_id) VALUES 
    ((SELECT id FROM user_roles WHERE name = 'ADMIN' LIMIT 1), 
        (SELECT id FROM user_permissions WHERE name = 'ELEVATED' LIMIT 1));

-- -- initial user data
INSERT INTO users(first_name, last_name, username, email, `password`, locked, activated, role) VALUES
    ('Vlad-Gabriel', 'Zahiu', 'ekorad', 'vladzahiu28@gmail.com', 
    '$2y$10$21IAdXQqqO8vtxn0s9gjDu8NCFqQtuxT.rYq3uTEZp/YRm/E/.Sq6', false, true,
        (SELECT id FROM user_roles WHERE name = 'ADMIN'));
INSERT INTO users(first_name, last_name, username, email, `password`, locked, activated, role) VALUES
    ('Gogu', 'Leustean', 'goguleustean', 'gogu.leustean@gmail.com', 
    '$2y$10$LKJJTBYRqIzcfDlYDRIB9uGknnr5eu99y6rTZSEfcVu8ggRfV02rC', false, false,
        (SELECT id FROM user_roles WHERE name = 'USER'));

INSERT INTO review(review , grade )
    VALUES ('caltlator f bun', 4);


-- initial products data
INSERT INTO products(product_name , description, new_price,old_price,cpu,gpu,ram,mother_board)
    VALUES ('Asus', 'Conceput pentru a se potrivi nevoilor profesionistului modern pentru productivitate oricand si oriunde, acest laptop este unul dintre cele mai subtiri si mai usoare disponibile la aceasta gama de pret.',41990,1600,'Intel 80486','Matrox M94199','8GB','EmCORE-a10R2');
INSERT INTO products(product_name, description, new_price,old_price,cpu,gpu,ram,mother_board) 
    VALUES ('Asus Rog', 'Conceput pentru a se potrivi nevoilor profesionistului modern pentru productivitate oricand si oriunde, acest laptop este unul dintre cele mai subtiri si mai usoare disponibile la aceasta gama de pret.',2999,3200,'Intel Pentium','NVidia GeForce GT710','8GB','EmCORE-a10R2');
INSERT INTO products(product_name, description, new_price,old_price,cpu,gpu,ram,mother_board) 
    VALUES ('Huawei', 'Conceput pentru a se potrivi nevoilor profesionistului modern pentru productivitate oricand si oriunde, acest laptop este unul dintre cele mai subtiri si mai usoare disponibile la aceasta gama de pret.',2800,3000,'AMD ATHLON','GIGABYTE GeForce GT 710 ','8GB','EmCORE-a10R2');
INSERT INTO products(product_name, description, new_price,old_price,cpu,gpu,ram,mother_board) 
    VALUES ('Huawei', 'Conceput pentru a se potrivi nevoilor profesionistului modern pentru productivitate oricand si oriunde, acest laptop este unul dintre cele mai subtiri si mai usoare disponibile la aceasta gama de pret.',3099,3200,'Intel Pentium Pro','GeForce GTX 1600 146','8GB','EmCORE-a10R2');
    INSERT INTO products(product_name, description, new_price,old_price,cpu,gpu,ram,mother_board) 
    VALUES ('Huawei MateBook', 'Conceput pentru a se potrivi nevoilor profesionistului modern pentru productivitate oricand si oriunde, acest laptop este unul dintre cele mai subtiri si mai usoare disponibile la aceasta gama de pret.',3099,3500,'Intel P7','GeForce GTX 1600 146','16GB','EmCORE-i90U2');
    INSERT INTO products(product_name, description, new_price,old_price,cpu,gpu,ram,mother_board) 
    VALUES ('Huawei MateBook', 'Conceput pentru a se potrivi nevoilor profesionistului modern pentru productivitate oricand si oriunde, acest laptop este unul dintre cele mai subtiri si mai usoare disponibile la aceasta gama de pret.',4019,4299,'Intel Core Solo','AMD 217','16GB','EmCORE-i90U2');
    INSERT INTO products(product_name, description, new_price,old_price,cpu,gpu,ram,mother_board) 
    VALUES ('Asus tuf', 'Conceput pentru a se potrivi nevoilor profesionistului modern pentru productivitate oricand si oriunde, acest laptop este unul dintre cele mai subtiri si mai usoare disponibile la aceasta gama de pret.',5199,5300,'Intel Core Duo','GEFORCE RTX™ SERIA 30','16GB','EmCORE-i90U2');
    INSERT INTO products(product_name, description, new_price,old_price,cpu,gpu,ram,mother_board) 
    VALUES ('Asus tuf', 'Conceput pentru a se potrivi nevoilor profesionistului modern pentru productivitate oricand si oriunde, acest laptop este unul dintre cele mai subtiri si mai usoare disponibile la aceasta gama de pret.',6199,6500,'Intel Core 2 Solo','GEFORCE RTX 3090','32GB','EmCORE-i90U2');
    INSERT INTO products(product_name, description, new_price,old_price,cpu,gpu,ram,mother_board) 
    VALUES ('Acer ASPIRE', 'Conceput pentru a se potrivi nevoilor profesionistului modern pentru productivitate oricand si oriunde, acest laptop este unul dintre cele mai subtiri si mai usoare disponibile la aceasta gama de pret.',2300,2500,'Intel Core 2 Duo','AMD 217','32GB','EmCORE-i90U2');
    INSERT INTO products(product_name, description, new_price,old_price,cpu,gpu,ram,mother_board) 
    VALUES ('Acer', 'Conceput pentru a se potrivi nevoilor profesionistului modern pentru productivitate oricand si oriunde, acest laptop este unul dintre cele mai subtiri si mai usoare disponibile la aceasta gama de pret.',2600,3000,'Intel Core i3','NGeForce GT 26000 20','64GB','EmCORE-a5364');
    INSERT INTO products(product_name, description, new_price,old_price,cpu,gpu,ram,mother_board) 
    VALUES ('Apple MacBook', 'Conceput pentru a se potrivi nevoilor profesionistului modern pentru productivitate oricand si oriunde, acest laptop este unul dintre cele mai subtiri si mai usoare disponibile la aceasta gama de pret.',2900,3200,'Intel Core i5','GeForce GT 700 42','64GB','EmCORE-a5364');
    INSERT INTO products(product_name, description, new_price,old_price,cpu,gpu,ram,mother_board) 
    VALUES ('Apple MacBook', 'Conceput pentru a se potrivi nevoilor profesionistului modern pentru productivitate oricand si oriunde, acest laptop este unul dintre cele mai subtiri si mai usoare disponibile la aceasta gama de pret.',3199,3500,'Intel Core i7','GeForce GTX 60000 27','64GB','EmCORE-a5364');
    INSERT INTO products(product_name, description, new_price,old_price,cpu,gpu,ram,mother_board) 
    VALUES ('Hp', 'Conceput pentru a se potrivi nevoilor profesionistului modern pentru productivitate oricand si oriunde, acest laptop este unul dintre cele mai subtiri si mai usoare disponibile la aceasta gama de pret.',5999,6500,'Intel Atom','GeForce GT 200 4','128GB','EmCORE-a5364');
    INSERT INTO products(product_name, description, new_price,old_price,cpu,gpu,ram,mother_board) 
    VALUES ('Hp', 'Conceput pentru a se potrivi nevoilor profesionistului modern pentru productivitate oricand si oriunde, acest laptop este unul dintre cele mai subtiri si mai usoare disponibile la aceasta gama de pret.',4199,4500,'Intel Core i5 ','GeForce GTX 1600 146','128GB','EmCORE-i2708');
    INSERT INTO products(product_name, description, new_price,old_price,cpu,gpu,ram,mother_board) 
    VALUES ('Hp 10-sda', 'Conceput pentru a se potrivi nevoilor profesionistului modern pentru productivitate oricand si oriunde, acest laptop este unul dintre cele mai subtiri si mai usoare disponibile la aceasta gama de pret.',3199,3500,'Intel Core i7','GeForce RTX','256GB','EmCORE-i2708');
    INSERT INTO products(product_name, description, new_price,old_price,cpu,gpu,ram,mother_board) 
    VALUES ('Hp 10-pc', 'Conceput pentru a se potrivi nevoilor profesionistului modern pentru productivitate oricand si oriunde, acest laptop este unul dintre cele mai subtiri si mai usoare disponibile la aceasta gama de pret.',1800,2000,'Intel Core i7','Sapphire Radeon RX 570 PULSE','256GB','EmCORE-i2708');
    INSERT INTO products(product_name, description, new_price,old_price,cpu,gpu,ram,mother_board) 
    VALUES ('Lenovo', 'Conceput pentru a se potrivi nevoilor profesionistului modern pentru productivitate oricand si oriunde, acest laptop este unul dintre cele mai subtiri si mai usoare disponibile la aceasta gama de pret.',3200,3500,'Intel Core i9','GIGABYTE GeForce GT 710','512GB','EmCORE-a55E1');
    INSERT INTO products(product_name, description, new_price,old_price,cpu,gpu,ram,mother_board) 
    VALUES ('Gaming Lenovo', 'Conceput pentru a se potrivi nevoilor profesionistului modern pentru productivitate oricand si oriunde, acest laptop este unul dintre cele mai subtiri si mai usoare disponibile la aceasta gama de pret.',4599,5000,'Intel Core i9','NVidia GeForce GT710','512GB','EmCORE-a55E1');
    INSERT INTO products(product_name, description, new_price,old_price,cpu,gpu,ram,mother_board) 
    VALUES ('Gaming Lenovo', 'Conceput pentru a se potrivi nevoilor profesionistului modern pentru productivitate oricand si oriunde, acest laptop este unul dintre cele mai subtiri si mai usoare disponibile la aceasta gama de pret.',4100,4500,'AMD ATHLON','Palit GeForce GT 1030','1TB','EmCORE-i2305');
    INSERT INTO products(product_name, description, new_price,old_price,cpu,gpu,ram,mother_board) 
    VALUES ('Gaming Lenovo', 'Conceput pentru a se potrivi nevoilor profesionistului modern pentru productivitate oricand si oriunde, acest laptop este unul dintre cele mai subtiri si mai usoare disponibile la aceasta gama de pret.',4199,4300,'Intel Core i3','Matrox M9120','1TB','EmCORE-a10R2');
