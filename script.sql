use devm211;

create table pessoa(
	idpessoa int primary key auto_increment,
    nomePessoa varchar(60) not null,
    cpf varchar(20) unique,
    endereco varchar(60),
    telefone varchar(20),
    idade int,
    status boolean
);

create table carro(
	 idCarro int primary key auto_increment,
	 placa varchar(8),
     marca varchar(20),
     modelo varchar(20),
     anoFabricacao date,
     anoModelo date,
     cor varchar(20),
	 nPortasint int(4),
     foreign key (idPesoa) references pessoa(idPessoa)
);