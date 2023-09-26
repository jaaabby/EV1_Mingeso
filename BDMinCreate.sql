CREATE TABLE estudiante
(
    rut_estud char[10] PRIMARY KEY,
    apellidos_estud char[30] NOT NULL,
    nombres_estud char[30] NOT NULL,
    fecha_nac date NOT NULL,
    tipo_colegio char[13] NOT NULL,
    nombre_colegio char[30] NOT NULL,
    año_egreso Int NOT NULL,
    tipo_pago char[7] NOT NULL, --CONTADO/CUOTAS
    cant_cuotas int
    --nro cuotas pagadas
    --monto total pagado
    --fecha ult pago
    --saldo por pagar
    --nro cuotas atrasadas
);

CREATE TABLE pago
(
    id_pago serial PRIMARY KEY,
    fecha_pago date NOT NULL,
    monto_pago money NOT NULL,
    rut_estud char[10] UNIQUE NOT NULL,
    FOREIGN KEY (rut_estud) REFERENCES estudiante(rut_estud)
)