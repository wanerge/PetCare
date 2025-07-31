INSERT INTO tblestados(nombre_estado)
VALUES
("Pendiente"),
("Confirmada"),
("Cancelada"),
("Finalizada");

CREATE TABLE "public"."tblGenero" (
  "id_genero" serial PRIMARY KEY,
  "nombre_genero" varchar(20) NOT NULL
)

INSERT INTO tblGenero (id_genero, nombre_genero) 
VALUES  (1, 'Macho');

INSERT INTO tblGenero (id_genero, nombre_genero) 
VALUES  (2, 'Hembra');


CREATE TABLE "public"."tblEspecialidades" (
  "id_especialidad" serial PRIMARY KEY,
  "nombre_especialidad" varchar(25) NOT NULL
)

INSERT INTO tblGenero (id_especialidad, nombre_especialidad) 
VALUES  (1, 'Medicina Interna');

INSERT INTO tblGenero (id_especialidad, nombre_especialidad) 
VALUES  (1, 'Cirugía');

INSERT INTO tblGenero (id_especialidad, nombre_especialidad) 
VALUES  (1, 'Dermatología');

INSERT INTO tblGenero (id_especialidad, nombre_especialidad) 
VALUES  (1, 'Cardiología');

INSERT INTO tblGenero (id_especialidad, nombre_especialidad) 
VALUES  (1, 'Oncología');

INSERT INTO tblGenero (id_especialidad, nombre_especialidad) 
VALUES  (1, 'Neurología');

INSERT INTO tblGenero (id_especialidad, nombre_especialidad) 
VALUES  (1, 'Oftalmología');

INSERT INTO tblGenero (id_especialidad, nombre_especialidad) 
VALUES  (1, 'Ortopedia');

INSERT INTO tblGenero (id_especialidad, nombre_especialidad) 
VALUES  (1, 'Anestesiología');

INSERT INTO tblGenero (id_especialidad, nombre_especialidad) 
VALUES  (1, 'Reproducción');

INSERT INTO tblGenero (id_especialidad, nombre_especialidad) 
VALUES  (1, 'Animales Exóticos,');

INSERT INTO tblGenero (id_especialidad, nombre_especialidad) 
VALUES  (1, 'Animales Granja,');

INSERT INTO tblGenero (id_especialidad, nombre_especialidad) 
VALUES  (1, 'Animales Salvajes,');

INSERT INTO tblGenero (id_especialidad, nombre_especialidad) 
VALUES  (1, 'Animales De Compañia,');