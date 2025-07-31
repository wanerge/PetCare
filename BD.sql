

INSERT INTO tblestados(nombre_estado)
VALUES
("Pendiente"),
("Confirmada"),
("Cancelada"),
("Finalizada");



INSERT INTO tblGenero (nombre_genero) 
VALUES  ('Macho'), ('Hembra');


INSERT INTO tblEspecialidades (nombre_especialidad) 
VALUES  ('Medicina Interna'), 
        ('Cirugía'),
        ('Dermatología'),
        ('Cardiología'),
        ('Oncología'),
        ('Neurología'),
        ('Oftalmología'),
        ('Ortopedia'),
        ('Anestesiología'),
        ('Reproducción'),
        ('Animales De Compañia');
INSERT INTO tblEspecies (nombre_especie)
VALUES
    ('Perro'),
    ('Gato'),
    ('Hamster'),
    ('Huron'),
    ('Conejo'),
    ('Tortuga'),
    ('Lagarto'),
    ('Ave'),
    ('Caballo'),
    ('Raton'),
    ('Serpiente');

INSERT INTO tblTipoUsuario (tipo_usuario)
VALUES
    ('Cliente'),
    ('Veterinario');