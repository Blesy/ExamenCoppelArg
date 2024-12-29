use store;
CREATE TABLE IF NOT EXISTS tasks
(id BIGINT NOT NULL PRIMARY KEY auto_increment,
tarea VARCHAR(100) not null,
categoria varchar(100),
completado bool
);
INSERT INTO tasks (tarea, categoria, completado)
VALUES ('Probar examen', 'general', false);