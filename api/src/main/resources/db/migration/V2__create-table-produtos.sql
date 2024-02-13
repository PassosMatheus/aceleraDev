create table produtos (
    id bigint not null auto_increment,
    nome varchar(100) not null,
    preco int(50) not null,
    quantidade int(50) not null,

    primary key(id)
);
