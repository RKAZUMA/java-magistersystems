/*
SCRIPT DE TRABAJO CLASE 1. 
JAVA + DDBB. 
MAGISTER SYSTEMS
JULIÁN R. FIGUEROA.
*/

#################
# DATABASE
#################

-- Si existe una DB llamada magister la elimina
drop database if exists magister;

-- Crea una DB llamada magister si no existe
create database if not exists magister;

-- Selecciona magister para futuras ejecuciones
use magister;

#################
# TABLES
#################

-- Muestra tablas en magister
show tables;

-- Crea la tabla users
create table if not exists users (
	id int auto_increment not null primary key,
	username varchar(45) not null unique,
	name varchar(45) not null,
	age int
) auto_increment = 1;

-- La sentencia alter permite agregar, cambiar o eliminar columnas de la tabla
alter table users add nacionalidad varchar(45);

-- Describe las columnas de la tabla users
describe users;

-- Inserta un registro manualmente
insert into users (id, username, name, age)
-- los siguientes valores
values (1, 'un_username', 'Un Nombre con Tíldes y Mayúsculas', 45);

-- El registro manualmente puede no llevar el id, porque es auto_increment
insert into users (username, name, age)
-- los siguientes valores
values ('otro_username', 'Otro Nombre', 32);

-- Carga la información de un archivo de texto
load data infile 'D:\\Dropbox\\Java MS\\clase_1\\ejercicios\\users_data.txt'
-- en la tabla users
into table users
-- con los campos de texto encerrados en comillas y separados por barras verticales
fields enclosed by '"' terminated by '|'
-- los registros los separa un salto de línea
lines terminated by '\r\n'
-- en el orden a continuación
(username, name, age);

-- Muestra todos los datos de la tabla users
select * from users;

-- Modifica un registro
update users set name = 'Falcao García'
-- donde se cumpla una condición
where username = 'un_username';

-- Elimina registros de la tabla usuarios
delete from users
-- donde el id sea mayor a cero (básicamente todos)
where id > 0;

-- Crear una tabla con llaves foráneas que referencian a otra
create table if not exists bikes (
	id int auto_increment not null primary key,
	brand varchar(45),
	price int,
	-- En este caso la columna owner referencia la columna id de la tabla users
	-- como llave foránea
	owner int not null references users(id)
) auto_increment = 1;

-- Elimina la tabla usuarios
drop table if exists users;