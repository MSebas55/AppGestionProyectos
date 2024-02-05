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
    descripcion VARCHAR(150),
    estado VARCHAR(15),
    fechaini date,
    fechafin date
);

CREATE TABLE tareas (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(70),
    descripcion VARCHAR(200),
    estado VARCHAR(15),
    fechaini date,
    fechafin date,
    proyecto_id INT,
    FOREIGN KEY (proyecto_id) REFERENCES proyectos(id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE usuarios (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(30),
    apellido VARCHAR(30),
    email VARCHAR(35),
    contra VARCHAR(30)
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

insert into tareas (id, nombre, descripción, estado, fechaini, fechafin, proyecto_id) 
VALUES
(1, 'Desarrollo del Módulo de Autenticación', 'Implementar el módulo de autenticación para el sistema', 'En progreso', '2023/08/03', '2023/10/15', 1),
(2, 'Diseño de Interfaz de Usuario', 'Crear la interfaz de usuario intuitiva y atractiva', 'En progreso', '2023/08/16', '2023/09/30', 1),
(3, 'Pruebas de Integración', 'Realizar pruebas de integración para garantizar el funcionamiento correcto', 'Pendiente', '2023/11/01', '2023/11/15', 1),
(4, 'Optimización de Código', 'Revisar y optimizar el código para mejorar el rendimiento', 'Pendiente', '2023/11/20', '2023/12/10', 1),
(5, 'Diseño del Sistema de Inventario', 'Crear el diseño del sistema de inventario según los requisitos', 'En progreso', '2023/08/03', '2023/09/20', 2),
(6, 'Desarrollo de Funcionalidades Principales', 'Implementar las funcionalidades clave del sistema de inventario', 'Pendiente', '2023/09/25', '2023/10/30', 2),
(7, 'Pruebas de Usabilidad', 'Realizar pruebas de usabilidad con usuarios para obtener retroalimentación', 'Pendiente', '2023/11/05', '2023/11/20', 2),
(8, 'Documentación del Proyecto', 'Elaborar la documentación completa del proyecto', 'Pendiente', '2023/11/25', '2023/12/15', 2),
(9, 'Investigación de Nuevas Tecnologías', 'Realizar investigación sobre nuevas tecnologías para automatización', 'En progreso', '2023/08/03', '2023/09/15', 3),
(10, 'Desarrollo de Prototipo', 'Crear un prototipo funcional basado en las tecnologías seleccionadas', 'En progreso', '2023/09/20', '2023/11/10', 3),
(11, 'Pruebas de Eficiencia', 'Realizar pruebas para evaluar la eficiencia y rendimiento del prototipo', 'Pendiente', '2023/11/15', '2023/12/01', 3),
(12, 'Implementación Final', 'Implementar la solución final basada en los resultados de las pruebas', 'Pendiente', '2023/12/05', '2023/12/20', 3),
(13, 'Desarrollo de la Aplicación Móvil', 'Implementar la aplicación móvil para facilitar la comunicación interna en la empresa', 'Acabado', '2023/01/15', '2023/07/20', 4),
(14, 'Desarrollo de Módulos Ágiles', 'Implementar los módulos del sistema basados en metodologías ágiles', 'En progreso', '2023/08/03', '2023/10/15', 5),
(15, 'Pruebas de Rendimiento', 'Realizar pruebas de rendimiento para asegurar la eficiencia del sistema', 'Pendiente', '2023/11/01', '2023/11/15', 5),
(16, 'Diseño de la Plataforma de Comercio Electrónico', 'Crear el diseño de la plataforma para productos artesanales', 'En progreso', '2023/08/03', '2023/09/30', 6),
(17, 'Desarrollo de Funcionalidades', 'Implementar las funcionalidades principales de la plataforma', 'Pendiente', '2023/10/01', '2023/11/15', 6),
(18, 'Implementación de Tecnologías Sostenibles', 'Implementar tecnologías para promover el desarrollo sostenible de energías renovables', 'En progreso', '2023/08/03', '2023/09/20', 7),
(19, 'Pruebas de Sostenibilidad', 'Realizar pruebas para evaluar la sostenibilidad de las tecnologías implementadas', 'Pendiente', '2023/09/21', '2023/10/10', 7),
(20, 'Optimización y Lanzamiento', 'Optimizar el proyecto y realizar el lanzamiento final', 'Pendiente', '2023/10/15', '2023/11/05', 7),
(21, 'Desarrollo de Plataforma Educativa Online', 'Implementar la plataforma educativa online para facilitar el aprendizaje a distancia', 'En progreso', '2023/08/03', '2023/10/15', 8),
(22, 'Diseño de Contenidos', 'Crear y organizar contenidos educativos para la plataforma', 'En progreso', '2023/10/16', '2023/11/30', 8),
(23, 'Desarrollo de Soluciones para Automatización Industrial', 'Implementar soluciones para la automatización eficiente de procesos industriales', 'En progreso', '2023/08/03', '2023/10/20', 9),
(24, 'Pruebas de Implementación', 'Realizar pruebas para asegurar la correcta implementación de las soluciones', 'Pendiente', '2023/10/21', '2023/11/05', 9),
(25, 'Investigación de Tecnologías Médicas', 'Realizar investigación sobre tecnologías innovadoras para el sector médico', 'En progreso', '2023/08/03', '2023/09/15', 10),
(26, 'Desarrollo de Aplicaciones Médicas', 'Crear aplicaciones móviles orientadas a mejorar la salud y el bienestar', 'Pendiente', '2023/09/16', '2023/10/30', 10),
(27, 'Pruebas Clínicas', 'Realizar pruebas clínicas para validar la efectividad de las aplicaciones', 'Pendiente', '2023/11/01', '2023/11/20', 10),
(28, 'Desarrollo de Plataforma de Gestión de Proyectos de Construcción', 'Implementación de una plataforma para gestionar proyectos de construcción', 'Acabado', '2023/01/15', '2023/07/20', 11),
(29, 'Optimización y Mejoras', 'Realizar optimizaciones y mejoras en la plataforma existente', 'En progreso', '2023/08/03', '2023/09/30', 11),
(30, 'Despliegue de Nuevas Funcionalidades', 'Desplegar nuevas funcionalidades según las necesidades de los usuarios', 'Pendiente', '2023/10/01', '2023/11/15', 11),
(31, 'Desarrollo de Aplicaciones para la Salud', 'Creación de aplicaciones móviles orientadas a mejorar la salud y el bienestar', 'En progreso', '2023/08/03', '2023/09/15', 12),
(32, 'Pruebas de Usabilidad', 'Realizar pruebas de usabilidad para garantizar una experiencia de usuario óptima', 'Pendiente', '2023/09/16', '2023/10/01', 12),
(33, 'Lanzamiento al Mercado', 'Planificar y realizar el lanzamiento de las aplicaciones en el mercado', 'Pendiente', '2023/10/02', '2023/10/20', 12),
(34, 'Desarrollo de Plataforma de Colaboración Empresarial', 'Implementación de una plataforma para fomentar la colaboración entre empresas', 'Acabado', '2023/01/15', '2023/07/20', 13),
(35, 'Mejoras Continuas', 'Realizar mejoras continuas en la plataforma existente', 'En progreso', '2023/08/03', '2023/09/30', 13),
(36, 'Atención a Usuarios', 'Brindar soporte y atención a usuarios de la plataforma', 'Pendiente', '2023/10/01', '2023/11/15', 13),
(37, 'Investigación en Agricultura Sostenible', 'Realizar investigación sobre tecnologías para promover la agricultura sostenible', 'En progreso', '2023/08/03', '2023/09/20', 14),
(38, 'Implementación de Tecnologías', 'Implementar tecnologías innovadoras en proyectos agrícolas', 'Pendiente', '2023/09/21', '2023/10/10', 14),
(39, 'Monitoreo y Evaluación', 'Establecer un sistema de monitoreo y evaluación para medir impacto', 'Pendiente', '2023/10/15', '2023/11/05', 14),
(40, 'Desarrollo del Sistema de Monitoreo Ambiental', 'Diseño e implementación de un sistema para monitorear la calidad ambiental', 'En progreso', '2023/08/03', '2023/09/15', 15),
(41, 'Pruebas de Funcionalidad', 'Realizar pruebas para asegurar la correcta funcionalidad del sistema', 'Pendiente', '2023/09/16', '2023/10/01', 15),
(42, 'Lanzamiento del Sistema', 'Planificar y realizar el lanzamiento del sistema al público', 'Pendiente', '2023/10/02', '2023/10/20', 15),
(43, 'Diseño de Videojuegos Educativos', 'Diseñar conceptos y mecánicas para los videojuegos educativos', 'En progreso', '2023/08/03', '2023/09/20', 16),
(44, 'Desarrollo de Escenarios', 'Implementar los escenarios y niveles de los videojuegos', 'Pendiente', '2023/09/21', '2023/10/10', 16),
(45, 'Pruebas de Jugabilidad', 'Realizar pruebas para asegurar la jugabilidad y experiencia del usuario', 'Pendiente', '2023/10/15', '2023/11/05', 16),
(46, 'Optimización de Proyectos de TI', 'Identificar y aplicar mejoras en proyectos de tecnologías de la información', 'Acabado', '2023/01/15', '2023/07/20', 17),
(47, 'Desarrollo de Nuevas Funcionalidades', 'Implementar nuevas funciones según las necesidades de los usuarios', 'En progreso', '2023/08/03', '2023/09/30', 17),
(48, 'Pruebas de Seguridad', 'Realizar pruebas de seguridad para garantizar la integridad de los proyectos', 'Pendiente', '2023/10/01', '2023/11/15', 17),
(49, 'Desarrollo de Soluciones en Asistencia Médica', 'Implementar soluciones basadas en inteligencia artificial para mejorar la asistencia médica', 'En progreso', '2023/08/03', '2023/10/15', 18),
(50, 'Pruebas Clínicas y Evaluación', 'Realizar pruebas clínicas y evaluar la efectividad de las soluciones implementadas', 'Pendiente', '2023/10/16', '2023/11/30', 18),
(51, 'Desarrollo de Plataforma de Streaming', 'Diseño e implementación de una plataforma de streaming para eventos culturales', 'Acabado', '2023/01/15', '2023/07/20', 19),
(52, 'Ampliación de Catálogo', 'Agregar contenido y ampliar el catálogo de eventos culturales', 'En progreso', '2023/08/03', '2023/09/30', 19),
(53, 'Mejoras en la Experiencia del Usuario', 'Implementar mejoras para una experiencia de usuario más fluida', 'Pendiente', '2023/10/01', '2023/11/15', 19),
(54, 'Investigación en Tecnologías de la Educación', 'Realizar investigación sobre tecnologías innovadoras para mejorar la educación', 'En progreso', '2023/08/03', '2023/09/15', 20),
(55, 'Desarrollo de Herramientas Educativas', 'Implementar herramientas educativas basadas en la investigación', 'Pendiente', '2023/09/16', '2023/10/30', 20),
(56, 'Pruebas en Entornos Educativos', 'Realizar pruebas en entornos educativos reales para evaluar la efectividad', 'Pendiente', '2023/11/01', '2023/11/20', 20);

INSERT INTO usuarios (id, nombre, apellido, email, contraseña) VALUES
(1, 'Juan', 'Gómez', 'juan@gmail.com', 'contraseña123'),
(2, 'María', 'López', 'maria@gmail.com', 'contraseña456'),
(3, 'Carlos', 'Martínez', 'carlos@gmail.com', 'contraseña789'),
(4, 'Elena', 'Rodríguez', 'elena@gmail.com', 'contraseña012'),
(5, 'Pedro', 'García', 'pedro@gmail.com', 'contraseña345');

INSERT INTO proyectos_usuarios_tareas (idUsuario, idProyecto, idTarea) VALUES
(1, 1, 1),
(2, 2, 5),
(3, 3, 9),
(4, 4, 13),
(5, 5, 16);