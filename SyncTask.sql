DROP DATABASE IF EXISTS SyncTask;

CREATE DATABASE SyncTask;

USE SyncTask;

DROP TABLE IF EXISTS proyectos;
DROP TABLE IF EXISTS usuarios;
DROP TABLE IF EXISTS tareas;
DROP TABLE IF EXISTS proyectos_usuarios_proyectos;

CREATE TABLE proyectos (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) UNIQUE,
    descripción VARCHAR(150),
    estado VARCHAR(15),
    fechaini date,
    fechafin date
);

CREATE TABLE tareas (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(30) UNIQUE,
    descripción VARCHAR(100),
    estado VARCHAR(15),
    fechaini date,
    fechafin date
);

CREATE TABLE usuarios (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(30),
    apellido VARCHAR(30),
    email VARCHAR(35),
    contraseña VARCHAR(30),
    rol VARCHAR(15)
);

CREATE TABLE proyectos_usuarios_tareas (
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

insert into proyectos (id, nombre, descripción, estado, fechaini, fechafin) values 
(1, 'Optimización de Procesos Empresariales', 'Proyecto de desarrollo de software para optimizar procesos empresariales', 'En progreso', '2023/08/03', '2024/08/04'),
(2, 'Sistema de Gestión de Inventario', 'Diseño e implementación de un sistema de gestión de inventario', 'En progreso', '2023/08/03', '2024/08/04'),
(3, 'Desarrollo de Nuevas Tecnologías', 'Investigación y desarrollo de nuevas tecnologías para la automatización de tareas', 'En progreso', '2023/08/03', '2024/08/04'),
(4, 'Comunicación Interna Móvil', 'Desarrollo de una aplicación móvil para facilitar la comunicación interna en la empresa', 'Acabado', '2023/01/15', '2023/07/20'),
(5, 'Sistema de Gestión de Proyectos Ágiles', 'Implementación de un sistema de gestión de proyectos basado en metodologías ágiles', 'En progreso', '2023/08/03', '2024/08/04'),
(6, 'Plataforma de Comercio Electrónico Artesanal', 'Diseño de una plataforma de comercio electrónico para productos artesanales', 'En progreso', '2023/08/03', '2024/08/04'),
(7, 'Desarrollo Sostenible de Energías Renovables', 'Implementación de tecnologías para promover el desarrollo sostenible de energías renovables', 'En progreso', '2023/08/03', '2024/08/04'),
(8, 'Plataforma Educativa de Aprendizaje Online', 'Creación de una plataforma educativa online para facilitar el aprendizaje a distancia', 'En progreso', '2023/08/03', '2024/08/04'),
(9, 'Automatización de Procesos Industriales', 'Desarrollo de soluciones para la automatización eficiente de procesos industriales', 'En progreso', '2023/08/03', '2024/08/04'),
(10, 'Innovación en Tecnologías Médicas', 'Investigación y desarrollo de tecnologías innovadoras para el sector médico', 'En progreso', '2023/08/03', '2024/08/04'),
(11, 'Plataforma de Gestión de Proyectos de Construcción', 'Diseño e implementación de una plataforma para gestionar proyectos de construcción de manera eficiente', 'Acabado', '2023/01/15', '2023/07/20'),
(12, 'Desarrollo de Aplicaciones para la Salud', 'Creación de aplicaciones móviles orientadas a mejorar la salud y el bienestar', 'En progreso', '2023/08/03', '2024/08/04'),
(13, 'Plataforma de Colaboración Empresarial', 'Desarrollo de una plataforma para fomentar la colaboración entre empresas', 'Acabado', '2023/01/15', '2023/07/20'),
(14, 'Innovación en Agricultura Sostenible', 'Investigación y aplicación de tecnologías para promover la agricultura sostenible', 'En progreso', '2023/08/03', '2024/08/04'),
(15, 'Sistema de Monitoreo Ambiental', 'Diseño e implementación de un sistema para monitorear y analizar la calidad ambiental', 'En progreso', '2023/08/03', '2024/08/04'),
(16, 'Desarrollo de Videojuegos Educativos', 'Creación de videojuegos educativos para facilitar el aprendizaje en entornos escolares', 'En progreso', '2023/08/03', '2024/08/04'),
(17, 'Plataforma de Gestión de Proyectos de TI', 'Diseño e implementación de una plataforma para gestionar proyectos de tecnologías de la información', 'Acabado', '2023/01/15', '2023/07/20'),
(18, 'Inteligencia Artificial en Asistencia Médica', 'Desarrollo de soluciones basadas en inteligencia artificial para mejorar la asistencia médica', 'En progreso', '2023/08/03', '2024/08/04'),
(19, 'Plataforma de Streaming Cultural', 'Creación de una plataforma de streaming para promover eventos culturales y artísticos', 'Acabado', '2023/01/15', '2023/07/20'),
(20, 'Innovación en Tecnologías de la Educación', 'Investigación y desarrollo de tecnologías innovadoras para mejorar la educación', 'En progreso', '2023/08/03', '2024/08/04');

