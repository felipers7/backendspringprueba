# Prueba de backend para fullstack


establecer base de datos POSTGRES

user: admin
password: admin
database: pruebafullstack
puerto: 5432


# SQL para crear database y generar datos de entrada

CREATE DATABASE pruebafullstack;

CREATE TABLE coordenadas (id SERIAL, latitud VARCHAR(255), longitud VARCHAR(255), campo1 VARCHAR(255), campo2 VARCHAR(255), PRIMARY KEY(id));
CREATE TABLE app_users(
	id SERIAL,
	username VARCHAR(255) NOT NULL,
	email VARCHAR(255) NOT NULL,
	password VARCHAR(255) NOT NULL,
	role VARCHAR(255) NOT NULL,
	PRIMARY KEY(id)
);

INSERT INTO coordenadas (latitud,longitud,campo1,campo2) VALUES ('-12.123','-21.321','info1','info2');
INSERT INTO coordenadas (latitud,longitud,campo1,campo2) VALUES ('-123.123','-321.321','info1','info2');
INSERT INTO app_users (username,email,password,role) 
VALUES ('admin','','$2a$12$ocxZm5QGeP/0IagvB2fGLOWwb7Gm3ITnKdnCf9s4XsDMUvFl4R8Ci','admin');


# Cómo ejecutar

El backend no está dockerizado pero se hizo build con Maven
se puede compilar desde INTELLIJ con java 17 +
o ejecutar el jar dentro del a carpeta target

java -jar fullstacktest-0.0.1-SNAPSHOT.jar


# Test unitarios en la carpeta de src/test

# El frontend

El frontend sí está dockerizado y se puede ejecutar construyendo y corriendo las imágenes

docker build –t angular-frontend .

docker run –d –p 4200:80 angular-frontend

Usuario y contraseña del frontend: admin