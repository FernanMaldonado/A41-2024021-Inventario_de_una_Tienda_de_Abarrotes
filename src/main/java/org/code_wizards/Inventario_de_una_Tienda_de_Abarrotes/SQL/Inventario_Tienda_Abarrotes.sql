drop database if exists Inventario_Tienda_Abarrotes;
Create database Inventario_Tienda_Abarrotes ;
Use Inventario_Tienda_Abarrotes;

Create Table Cliente (
	idCliente int auto_increment,
	nombre varchar (64),
    apellido varchar (64),
    telefono varchar (16),
    email varchar(60) not null,
    contrasena varchar(50) not null,
    nit varchar(50) not null,
    constraint pk_Clientes primary key (idCliente)
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

select * from productos;