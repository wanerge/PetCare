INSERT INTO tblEstados (nombre_estado)
VALUES
('Pendiente'),
('Confirmada'),
('Cancelada'),
('Finalizada');

INSERT INTO tblGeneros (nombre_genero) 
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

INSERT INTO tblTipoUsuarios (tipo_usuario)
VALUES
    ('Cliente'),
    ('Veterinario');
    
INSERT INTO tblServicios (nombre_servicio, descripcion, precio) 
VALUES 
  ('Consulta general', 'Evaluación médica básica para revisar la salud general, síntomas o signos de enfermedad.', 25000),
  ('Vacunación', 'Inyección de vacuna antirrábica, contra infecciones, pentavalente para prevenir enfermedades graves', 40000),
  ('Desparasitación (oral o inyectable)', 'Eliminación de parásitos internos en una sola sesión', 20000),
  ('Hemograma', 'Pruebas de sangre para diagnosticar condiciones internas o infecciones', 37000),
  ('Radiografia', 'Dianóstico de huesos, fracturas o pulmones mediante imágenes radiográficas', 40000),
  ('Microchip','Implantación de chip subcutáneo para identificar al animal',60000),
  ('Limpieza dental', 'Eliminación de sarro, limpieza y extracción de piezas dentales cuando están deterioradas', 50000),
  ('Hospitalización(UCI)','Cuidados intensivos para animales críticos; incluye monitoreo y medicamentos',50000),
  ('Spa y peluquería canina','Servicio de baño corte de pelo y cepillado para mantener la higiene y buen aspecto', 50000),
  ('Spa y peluquería felina','Servicio de baño corte de pelo y cepillado para mantener la higiene y buen aspecto', 40000),
  ('Atención a domicilio','Consulta o atención médica realizada en la casa del cliente(ideal si la mascota no se puede movilizar)', 55000);