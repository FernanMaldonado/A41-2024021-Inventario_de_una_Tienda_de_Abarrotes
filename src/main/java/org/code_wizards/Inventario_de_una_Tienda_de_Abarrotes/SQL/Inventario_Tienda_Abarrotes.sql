drop database if exists Inventario_Tienda_Abarrotes;
Create database Inventario_Tienda_Abarrotes ;
Use Inventario_Tienda_Abarrotes;

Create Table Cliente (
	idCliente int auto_increment,
	nombre varchar (64),
    apellido varchar (64),
    telefono varchar (16),
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

Create Table Factura(
	idFactura int auto_increment,
    idCliente int not null,
    idCategoria int not null,
    idProducto int not null,
    total decimal(10,2) default 0.00,
    cantidad int not null,
    constraint pk_factura primary key (idFactura),
     constraint fk_factura_cliente foreign key(idCliente)references
		Cliente(idCliente),
    constraint fk_factura_categoria foreign key(idCategoria)references
		Categoria(idCategoria),
        constraint fk_factura_producto foreign key(idProducto)references
		productos(idProducto)
	);

insert into Cliente (nombre, apellido, telefono, nit)
values
('Carlos', 'Ramírez', '5551-2345', '12345-21');

insert into Categoria(nombreCategoria,descripcion)
values("Gaseaosa","Bebida con alto grado de Azucar");

insert into productos(idCategoria,nombreProducto,marca,descripcion,precio)
values(1,"Coca-Cola","Coca-Cola","Bebida Azucarada",19.00);

insert into Factura (idCliente,idCategoria,idProducto,total,cantidad)
values
(1,1,1,19.00,1);

select * from productos;