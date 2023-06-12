-- Ирина, подруга Пети, решила создать свой бизнес по продаже цветов. Начать
-- она решила с самых основ: создать соответствующую базу данных для своего
-- бизнеса. Она точно знает, что будет продавать Розы по 100 золотых монет за
-- единицу, Лилии по 50 и Ромашки по 25.

create table if not exists flowers
(
    id    serial primary key,
    title varchar(100) check ( title <> '' ) not null,
    price integer                            not null
);
--Insert data
insert into flowers (title, price)
values ('Розы', 100);
insert into flowers (title, price)
values ('Лилии', 50);
-- insert into flowers (title, price) values ('Ромашки', 25);
insert into flowers
values (nextval('books_id_seq'), 'Ромашки', 25);

-- Помимо этого, ей хочется хранить данные своих покупателей (естественно они
-- дали согласие на хранение персональной информации). Сохранять нужно Имя
-- и Номер телефона.
create table if not exists clients
(
    id    serial primary key,
    name  varchar(50) not null,
    phone varchar(30) not null check (regexp_like(phone, '^\d{11}$'))
);
insert into clients (name, phone)
values ('Анна', '79601234567'),
       ('Вениамин', '79001234567'),
       ('Инга', '79510001122'),
       ('Николай', '79605552030'),
       ('Петр', '79085052139');

-- И, конечно, данные самого заказа тоже нужно как-то хранить! Ирина пока не
-- продумала поля, но она точно хочет следовать следующим правилам:
-- ● в рамках одного заказа будет продавать только один вид цветов
-- (например, только розы)
-- ● в рамках одного заказа можно купить от 1 до 1000 единиц цветов.

create table if not exists orders
(
    id        serial primary key,
    client_id integer references clients (id)                  not null,
    flower_id integer references flowers (id)                  not null,
    amount    integer check ( amount >= 1 and amount <= 1000 ) not null,
    date      timestamp                                        not null
);

insert into orders (client_id, flower_id, amount, date)
values (2, 2, 10, '2022-09-01'),
       (2, 2, 5, '2022-09-10'),
       (2, 6, 12, '2022-09-15'),
       (3, 1, 3, '2022-09-30'),
       (3, 1, 6, '2022-10-02'),
       (4, 6, 11, '2022-10-10'),
       (5, 6, 50, '2022-10-12'),
       (4, 6, 7, '2022-10-15'),
       (4, 2, 3, '2022-10-20'),
       (2, 1, 5, '2022-10-22');

-- 1. По идентификатору заказа получить данные заказа и данные клиента,
-- создавшего этот заказ
select o.*, c.*
from orders o
         inner join clients c on c.id = o.client_id
         inner join flowers f on o.flower_id = f.id
where o.id = 21;

-- 2. Получить данные всех заказов одного клиента по идентификатору
-- клиента за последний месяц
select *
from orders o
         inner join clients c on c.id = o.client_id
         inner join flowers f on o.flower_id = f.id
where c.id = 2
  and o.date > now() - interval '1 month';

-- 3. Найти заказ с максимальным количеством купленных цветов, вывести их
-- название и количество
select *
from orders o
         inner join flowers f on o.flower_id = f.id
where o.amount = (select max(amount) from orders);

select *
from orders o
         inner join flowers f on o.flower_id = f.id
order by o.amount desc
limit 1;

select f.title, max(o.amount)
from orders o
         inner join flowers f on o.flower_id = f.id
group by f.title
order by 2 desc
limit 1;

-- 4. Вывести общую выручку (сумму золотых монет по всем заказам) за все
-- время
select sum(o.amount * f.price) as total
from orders o inner join flowers f on f.id = o.flower_id;