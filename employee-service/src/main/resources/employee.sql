CREATE TABLE IF NOT EXISTS employee (
      id SERIAL PRIMARY KEY,
      name VARCHAR(255) NOT NULL UNIQUE,
      department VARCHAR(255) NOT NULL
    );

INSERT INTO employee (name, department)
VALUES
    ('Sara Martin', 'Ressources Humaines'),
    ('Youssef Haddad', 'Finance'),
    ('Nina Dupont', 'Marketing'),
    ('Liam Smith', 'Informatique'),
    ('Olivia Brown', 'Ventes'),
    ('Noah Wilson', 'Finance'),
    ('Emma Johnson', 'Ressources Humaines'),
    ('Ava Garcia', 'Marketing'),
    ('Isabella Martinez', 'Informatique'),
    ('Sophia Rodriguez', 'Ventes'),
    ('Mia Hernandez', 'Finance'),
    ('Charlotte Lopez', 'Ressources Humaines'),
    ('Amelia Gonzalez', 'Marketing'),
    ('Harper Perez', 'Informatique'),
    ('Ahmed Ben Ali', 'Informatique'),
    ('Sara Martin', 'Ressources Humaines');