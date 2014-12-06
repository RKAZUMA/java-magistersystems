/*
SCRIPT DE TRABAJO CLASE 2. 
JAVA + DDBB. 
MAGISTER SYSTEMS
JULIÁN R. FIGUEROA.
*/

###############
# PREPARACION
###############
drop database if exists magister;
create database if not exists magister;
use magister;
drop table if exists users;
drop table if exists bikes;
create table if not exists users (
	id int auto_increment not null primary key,
	username varchar(45) not null unique,
	name varchar(45) not null,
	age int
) auto_increment = 1;
create table if not exists bikes (
	id int auto_increment not null primary key,
	brand varchar(45),
	price int,
	owner int not null references users(id)
) auto_increment = 1;
load data infile 'D:\\Dropbox\\Java MS\\clase_2\\ejercicios\\users_data.txt'
into table users
fields enclosed by '"' terminated by '|'
lines terminated by '\r\n'
(username, name, age);
load data infile 'D:\\Dropbox\\Java MS\\clase_2\\ejercicios\\bikes_data.txt'
into table bikes
fields enclosed by '"' terminated by '|'
lines terminated by '\r\n'
(brand, price, owner);

###############
# CLASE
###############

#------------------------------------------------------------
-- Cómo obtener registros con llaves foráneas?
-- Guardar la referencia de un usuario en una variable
select @user_id := id from users where username = 'abc123';

-- E inserta el registro
insert into bikes
(brand, price, owner)
values ('myBrand', 1200, @user_id);

select b.* from bikes b, users u
where u.username = 'un_username' and
u.id = b.owner;
#-------------------------------------------------------------

-- Uso de la cláusula where
select * from users
where age > 30;

-- Operaciones con cadenas
-- http://dev.mysql.com/doc/refman/5.0/es/string-functions.html
select * from users
where name like 'j%';

select * from users
where name like '%s';

select * from users
where username like '%user%';

select * from users
where username like '%a_e%';

select * from users
where name like '%\'%';

select * from users
where name like '%\\%';

select * from users
where age is null 
or age < 15
or username like '%user%';

-- Trabajo con tuplas
select * from users order by id asc;
select * from users order by username desc;
select * from users order by name asc;
select * from users order by age desc;

-- Conjuntos
-- Union
(select id, username from users) union all (select id, brand from bikes);
-- Intersect
select b.* from users as u, bikes as b where u.username in (select b.brand from bikes);
select u.*, b.* from users as u, bikes as b where b.owner = u.id;
select u.username as 'uinfo', b.price as 'binfo' from users as u, bikes as b where b.owner = u.id;
-- Except
select b.* from users as u, bikes as b where b.brand in (select username from users);
select * from users where username not in('rocky');

-- Valores numéricos
select min(price) from bikes;
select avg(age) from users;
select max(age) from users;
select @cheapest := min(price) from bikes;
select b.* from bikes as b where b.price = @cheapest;
select b.* from bikes as b where b.price in (select min(price) from bikes);
-- colocar null una o varias edades
select count(age) from users;
select (sum(price) - max(age)) from users, bikes;

-- Agrupamientos
select * from users group by age;

#-----------------
-- Vistas
#-----------------

-- Creación de una vista simple
create view users_view as select * from users;

-- Renombrando
rename table users_view to view_users;

-- Información de metadatos de la vista creada
show create view view_users;

-- Crea o reemplaza una vista
create or replace view view_users as select username, age from users;

-- Tablas Vs Vistas
create view bikes as select * from bikes;


#-----------------
-- Ejemplo claro de vistas
#-----------------

create table purchases (
	id int auto_increment not null primary key,
	quantity int not null,
	price int not null
) auto_increment = 1;

insert into purchases (quantity, price) values
(3, 560),
(5, 860),
(8, 170),
(4, 390),
(2, 640),
(4, 230),
(6, 700),
(7, 230),
(2, 640),
(7, 730);

-- Creación de la vista como combinación de entidades
create view view_purchases as 
select *, quantity*price from purchases;
select * from view_purchases;

-- Concatenación de columnas string
create or replace view view_users as 
select id, concat(username,' - ',name) as 'name - username' from users
where username not like '%user%' and username not like '%usuario%';
select * from view_users;

-- Usrs > 30años con bici
create or replace view view_users_30_bikes as
select u.*, b.id as id_b, b.brand, b.price, b.owner from users as u, bikes as b 
where b.owner = u.id
and u.age > 30;
select * from view_users_30_bikes;

-- Creación de categorías basadas en datos
create or replace view cheap_bikes as
select *, 'cheap' as category from bikes
where price < (select avg(price) from bikes);
create or replace view expensive_bikes as
select *, 'expensive' as category from bikes
where price > (select avg(price) from bikes);
create or replace view view_prices_bikes as
(select * from cheap_bikes) union (select * from expensive_bikes);
select * from view_prices_bikes order by id;







