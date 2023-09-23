CREATE TABLE estudiante
(
    rut_estud Int PRIMARY KEY,
    apellidos_estud char[30] NOT NULL,
    nombres_estud char[30] NOT NULL,
    fecha_nac date NOT NULL,
    tipo_colegio char[13] NOT NULL,
    nombre_colegio char[30] NOT NULL,
    año_egreso Int NOT NULL
);