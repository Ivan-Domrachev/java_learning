-- ЧТЕНИЕ ДАННЫХ --

-- 1. Все товары дороже 50000 руб.
SELECT * FROM product WHERE price > 50000;

-- 2. Заказы с информацией о товаре и покупателе
SELECT o.id, p.description, c.first_name, c.last_name, o.quantity, o.order_date
FROM orders o
         JOIN product p ON o.product_id = p.id
         JOIN customer c ON o.customer_id = c.id;

-- 3. Покупатели с количеством их заказов
SELECT c.id, c.first_name, c.last_name, COUNT(o.id) as order_count
FROM customer c
         LEFT JOIN orders o ON c.id = o.customer_id
GROUP BY c.id;

-- 4. Товары с низким остатком (< 15)
SELECT description, quantity FROM product WHERE quantity < 15;

-- 5. Самый популярный товар
SELECT p.description, SUM(o.quantity) as total_ordered
FROM orders o
         JOIN product p ON o.product_id = p.id
GROUP BY p.description
ORDER BY total_ordered DESC
    LIMIT 1;

-- ИЗМЕНЕНИЕ ДАННЫХ --

-- 6. Обновить цену товара
UPDATE product SET price = 64999.00 WHERE id = 1;

-- 7. Увеличить количество товара
UPDATE product SET quantity = quantity + 10 WHERE id = 3;

-- 8. Изменить имя покупателя
UPDATE customer SET first_name = 'Николай' WHERE id = 2;

-- УДАЛЕНИЕ ДАННЫХ --

-- 9. Удалить заказ
DELETE FROM orders WHERE id = 5;

-- 10. Удалить товары с нулевым остатком
DELETE FROM product WHERE quantity = 0;