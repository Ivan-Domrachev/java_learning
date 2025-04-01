-- Удаление таблиц если они существуют
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS product;

-- Товары
CREATE TABLE product (
                         id SERIAL PRIMARY KEY,
                         description VARCHAR(255) NOT NULL,
                         price DECIMAL(10, 2) NOT NULL,
                         quantity INTEGER NOT NULL
);

-- Покупатели
CREATE TABLE customer (
                          id SERIAL PRIMARY KEY,
                          first_name VARCHAR(100) NOT NULL,
                          last_name VARCHAR(100) NOT NULL
);

-- Заказы
CREATE TABLE orders (
                        id SERIAL PRIMARY KEY,
                        product_id INTEGER NOT NULL REFERENCES product(id),
                        customer_id INTEGER NOT NULL REFERENCES customer(id),
                        order_date DATE NOT NULL,
                        quantity INTEGER NOT NULL
);

-- Наполнение товаров
INSERT INTO product (description, price, quantity) VALUES
                                                       ('Ноутбук Lenovo IdeaPad', 59999.00, 15),
                                                       ('Смартфон Samsung Galaxy S23', 99999.00, 20),
                                                       ('Наушники Sony WH-1000XM4', 34999.00, 30),
                                                       ('Клавиатура Logitech MX Keys', 12999.00, 25),
                                                       ('Мышь Razer DeathAdder', 5999.00, 40),
                                                       ('Монитор Dell 27" 4K', 49999.00, 10),
                                                       ('Флешка SanDisk 128GB', 2999.00, 50),
                                                       ('Внешний жесткий диск Seagate 1TB', 7999.00, 18),
                                                       ('Колонка JBL Flip 5', 11999.00, 22),
                                                       ('Роутер TP-Link Archer AX50', 14999.00, 12);

-- Наполнение покупателей
INSERT INTO customer (first_name, last_name) VALUES
                                                 ('Иван', 'Иванов'),
                                                 ('Петр', 'Петров'),
                                                 ('Алексей', 'Сидоров'),
                                                 ('Мария', 'Кузнецова'),
                                                 ('Анна', 'Смирнова'),
                                                 ('Дмитрий', 'Васильев'),
                                                 ('Елена', 'Попова'),
                                                 ('Сергей', 'Новиков'),
                                                 ('Ольга', 'Морозова'),
                                                 ('Александр', 'Лебедев');

-- Наполнение заказов
INSERT INTO orders (product_id, customer_id, order_date, quantity) VALUES
                                                                       (1, 1, '2024-01-15', 1),
                                                                       (2, 2, '2024-01-16', 2),
                                                                       (3, 3, '2024-01-17', 1),
                                                                       (4, 4, '2024-01-18', 1),
                                                                       (5, 5, '2024-01-19', 3),
                                                                       (6, 6, '2024-01-20', 1),
                                                                       (7, 7, '2024-01-21', 5),
                                                                       (8, 8, '2024-01-22', 1),
                                                                       (9, 9, '2024-01-23', 2),
                                                                       (10, 10, '2024-01-24', 1);