CREATE TABLE tblTipoUsuarios (
  id_tipo_usuario serial PRIMARY KEY,
  tipo_usuario varchar(20) NOT NULL
);

CREATE TABLE tblUsuarios (
  id_usuario serial PRIMARY KEY,
  correo varchar(50) NOT NULL UNIQUE,
  clave_hash varchar(200) NOT NULL,
  token_sesion varchar(200),
  fecha_inicio timestamp,
  fecha_expiracion timestamp,
  id_tipo_usuario integer NOT NULL,
CONSTRAINT constraint_1 FOREIGN KEY (id_tipo_usuario) REFERENCES tblTipoUsuarios (id_tipo_usuario)
);

CREATE TABLE tblClientes (
  id_cliente serial PRIMARY KEY,
  nombre varchar(50) NOT NULL,
  apellido varchar(50) NOT NULL,
  telefono varchar(10) NOT NULL,
  direccion varchar(50),
  id_usuario integer NOT NULL UNIQUE,
  CONSTRAINT constraint_1 FOREIGN KEY (id_usuario) REFERENCES tblUsuarios (id_usuario)
);

CREATE TABLE tblEspecies (
  id_especie serial PRIMARY KEY,
  nombre_especie varchar(20) NOT NULL
);

CREATE TABLE tblGeneros (
  id_genero serial PRIMARY KEY,
  nombre_genero varchar(20) NOT NULL
);

CREATE TABLE tblMascotas (
  id_mascota serial PRIMARY KEY,
  id_cliente integer NOT NULL,
  nombre varchar(50) NOT NULL,
  id_especie integer NOT NULL,
  fecha_nacimiento timestamp NOT NULL,
  id_genero integer NOT NULL,
  peso numeric(20, 2) NOT NULL,
  CONSTRAINT constraint_1 FOREIGN KEY (id_cliente) REFERENCES tblClientes (id_cliente),
  CONSTRAINT constraint_2 FOREIGN KEY (id_especie) REFERENCES tblEspecies (id_especie),
  CONSTRAINT constraint_3 FOREIGN KEY (id_genero) REFERENCES tblGeneros (id_genero)
);

CREATE TABLE tblEspecialidades (
  id_especialidad serial PRIMARY KEY,
  nombre_especialidad varchar(30) NOT NULL
);

CREATE TABLE tblVeterinarios (
  id_veterinario serial PRIMARY KEY,
  nombre varchar(50) NOT NULL,
  apellido varchar(50) NOT NULL,
  telefono varchar(10) NOT NULL,
  id_usuario integer NOT NULL UNIQUE,
  CONSTRAINT constraint_1 FOREIGN KEY (id_usuario) REFERENCES tblUsuarios (id_usuario)
);

CREATE TABLE tblVeterinarioXEspecialidad (
  id_veterinario integer NOT NULL,
  id_especialidad integer NOT NULL,
  CONSTRAINT constraint_1 FOREIGN KEY (id_veterinario) REFERENCES tblVeterinarios (id_veterinario),
  CONSTRAINT constraint_2 FOREIGN KEY (id_especialidad) REFERENCES tblEspecialidades (id_especialidad)
);

CREATE TABLE tblEstados (
  id_estado serial PRIMARY KEY,
  nombre_estado varchar(15) NOT NULL
);

CREATE TABLE tblServicios (
  id_servicio serial PRIMARY KEY,
  nombre_servicio varchar(50) NOT NULL,
  descripcion text NOT NULL,
  precio numeric(20, 2) NOT NULL
);

CREATE TABLE tblCitas (
  id_cita serial PRIMARY KEY,
  id_cliente integer NOT NULL,
  id_mascota integer NOT NULL,
  id_veterinario integer NOT NULL,
  fecha_cita date NOT NULL,
  hora_cita time NOT NULL,
  id_estado integer NOT NULL,
  CONSTRAINT constraint_1 FOREIGN KEY (id_cliente) REFERENCES tblClientes (id_cliente),
  CONSTRAINT constraint_2 FOREIGN KEY (id_mascota) REFERENCES tblMascotas (id_mascota),
  CONSTRAINT constraint_3 FOREIGN KEY (id_veterinario) REFERENCES tblVeterinarios (id_veterinario),
  CONSTRAINT constraint_4 FOREIGN KEY (id_estado) REFERENCES tblEstados (id_estado)
);

CREATE TABLE tblCitaXServicio (
  id_cita integer NOT NULL,
  id_servicio integer NOT NULL,
  CONSTRAINT constraint_1 FOREIGN KEY (id_cita) REFERENCES tblCitas (id_cita),
  CONSTRAINT constraint_2 FOREIGN KEY (id_servicio) REFERENCES tblServicios (id_servicio)
);

CREATE UNIQUE INDEX index_1 ON tblVeterinarioXEspecialidad USING btree (id_veterinario, id_especialidad);
CREATE UNIQUE INDEX index_2 ON tblCitaXServicio USING btree (id_cita, id_servicio);
