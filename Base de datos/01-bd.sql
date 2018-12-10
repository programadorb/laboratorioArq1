connect 'jdbc:derby://localhost:1530/lab1;user=root;password=root;create=true;';

create table venta(
    codigo varchar(64) primary key,
    cliente varchar(64),
    vehiculo varchar(64),
    valor float
);

create table Cliente(
    cedula varchar(64) primary key,
    nombre varchar(128),
    apellido varchar(128),
    telefono varchar(64),
    direccion varchar(128)
);

create table vehiculo(
    matricula varchar(64) primary key,
    marca varchar(64),
    modelo varchar(64),
    color varchar(64),
    precio varchar(64),
    foto varchar(128)
);
