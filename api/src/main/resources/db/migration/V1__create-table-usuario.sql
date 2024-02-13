create table usuarios (
    id bigint not null auto_increment,
    nome varchar(100) not null,
    dataNascimento varchar(100) not null,
    cpf varchar(100) not null,
    cep varchar(100)not null,

    primary key(id)
);
