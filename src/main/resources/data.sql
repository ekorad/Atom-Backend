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
    ('READ_ANY_PERMISSION',     'Utilizatorul poate accesa toate permisiunile de utilizator');