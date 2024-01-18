DROP DATABASE IF EXISTS gestionProyectos;

CREATE DATABASE gestionProyectos;

USE gestionProyectos;

DROP TABLE IF EXISTS proyectos;
DROP TABLE IF EXISTS usuarios;
DROP TABLE IF EXISTS tareas;
DROP TABLE IF EXISTS proyectos_usuarios_proyectos;

CREATE TABLE proyectos (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(30) UNIQUE,
    descripción VARCHAR(100),
    estado VARCHAR(15),
    fechaini datetime,
    fechafin datetime
);

CREATE TABLE tareas (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(30) UNIQUE,
    descripción VARCHAR(100),
    estado VARCHAR(15),
    fechaini datetime,
    fechafin datetime
);

CREATE TABLE usuarios (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(30),
    apellido VARCHAR(30),
    email VARCHAR(35),
    contraseña VARCHAR(30),
    rol VARCHAR(15)
);

CREATE TABLE proyectos_usuarios_proyectos (
    idUsuario INTEGER,
    idTarea INTEGER,
    idProyecto INTEGER,
    PRIMARY KEY (idUsuario, idTarea, idProyecto),
	FOREIGN KEY (idUsuario)
		REFERENCES usuarios (id)
		ON UPDATE CASCADE
    	ON DELETE CASCADE,
	FOREIGN KEY (idTarea)
		REFERENCES tareas (id)
		ON UPDATE CASCADE
    	ON DELETE CASCADE,
	FOREIGN KEY (idProyecto)
		REFERENCES proyectos (id)
		ON UPDATE CASCADE
    	ON DELETE CASCADE
);