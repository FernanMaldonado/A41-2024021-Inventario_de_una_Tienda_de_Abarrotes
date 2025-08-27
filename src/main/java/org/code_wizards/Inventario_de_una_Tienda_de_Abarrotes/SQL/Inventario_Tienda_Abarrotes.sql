drop database if exists Inventario_Tienda_Abarrotes;
Create database Inventario_Tienda_Abarrotes ;
Use Inventario_Tienda_Abarrotes;

Create Table Cliente (
    idCliente INT AUTO_INCREMENT,
    nombre VARCHAR(64) NOT NULL,
    apellido VARCHAR(64) NOT NULL,
    genero ENUM('Masculino', 'Femenino', 'Otro') NOT NULL,
    fechaNacimiento DATE NOT NULL,
    telefono VARCHAR(16),
    correo VARCHAR(100) NOT NULL UNIQUE,
    contrasena VARCHAR(255) NOT NULL,
    direccion VARCHAR(150),
    nit VARCHAR(20) UNIQUE,
    fechaRegistro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    activo BOOLEAN DEFAULT TRUE,
    CONSTRAINT pk_Cliente PRIMARY KEY (idCliente)
);

Create Table Categoria(
	idCategoria int auto_increment,
    nombreCategoria varchar(50) not null,
    descripcion varchar(75) not null,
     constraint pk_categoria primary key (idCategoria)
);

Create table Productos (
	idProducto int auto_increment,
    idCategoria int not null,
    nombreProducto varchar(50) not null,
    marca varchar(50) not null,
    descripcion varchar(120) not null,
    precio int ,
	constraint pk_productos primary key (idProducto),
    constraint fk_productos_categoria foreign key(idCategoria)references
		Categoria(idCategoria)
);

insert into Categoria(nombreCategoria,descripcion)
values("Gaseaosa","Bebida con alto grado de Azucar");

insert into productos(idCategoria,nombreProducto,marca,descripcion,precio)
values(1,"Coca-Cola","Coca-Cola","Bebida Azucarada",19.00);

select * from Cliente;