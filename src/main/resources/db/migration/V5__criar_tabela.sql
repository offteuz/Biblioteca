create sequence seq_categoria
    start with 1
    increment by 1
    nocache;

create sequence seq_livro
    start with 1
    increment by 1
    nocache;

create table t_categoria
(
    id_categoria integer default seq_categoria.nextval not null,
    nome         varchar2(100)                         not null,
    primary key (id_categoria)
);

create table t_livro
(
    id_livro              integer default seq_livro.nextval not null,
    titulo                varchar2(100)                     not null,
    autor                 varchar2(100)                     not null,
    descricao             varchar2(300),
    ano_lancamento        date,
    quantidade            integer,
    quantidade_disponivel integer,
    id_categoria          integer,
    primary key (id_livro),
    constraint fk_categoria foreign key (id_categoria) references t_categoria (id_categoria)
);