CREATE TABLE if not exists tc_pessoa(
CPF_CNPJ varchar(14) NOT NULL,
NOME varchar(255) NOT NULL,
TELEFONE varchar(12) NOT NULL,
EMAIL varchar(100) NOT NULL,
PRIMARY KEY (CPF_CNPJ)
);

CREATE TABLE if not exists tc_usuario(
USERNAME varchar(14) NOT NULL,
SENHA varchar(255) NOT NULL,
USER_ROLE varchar(60) NOT NULL,
PRIMARY KEY (USERNAME)
);

CREATE TABLE if not exists tc_cliente(
ID_PESSOA varchar(14) NOT NULL,
permite_notificacoes boolean NOT NULL,
PRIMARY KEY (ID_PESSOA),
FOREIGN KEY (ID_PESSOA) REFERENCES tc_pessoa(CPF_CNPJ)
);

CREATE TABLE if not exists tc_administrador(
ID_PESSOA varchar(14) NOT NULL,
DATA_NASCIMENTO date NOT NULL,
DATA_ADMISSAO date NOT NULL,
FUNCAO varchar(30) NOT NULL,
PRIMARY KEY (ID_PESSOA),
FOREIGN KEY (ID_PESSOA) REFERENCES tc_pessoa(CPF_CNPJ)
);

CREATE TABLE if not exists tc_motorista(
ID_PESSOA varchar(14) NOT NULL,
CARTEIRA_MOTORISTA varchar(10) NOT NULL,
VENCIMENTO_CARTA date NOT NULL,
TIPO_CARTA varchar(10) NOT NULL,
PRIMARY KEY (ID_PESSOA),
FOREIGN KEY (ID_PESSOA) REFERENCES tc_pessoa(CPF_CNPJ)
);


CREATE TABLE if not exists tc_caminhao(
PLACA varchar(7) NOT NULL,
MODELO varchar(30) NOT NULL,
ANO_FABRICACAO varchar(4) NOT NULL,
CARGA_MAXIMA int NOT NULL,
ALTURA float,
QTD_EIXOS int,
TIPO_CARROCERIA varchar(30),
PRIMARY KEY (PLACA)
);

CREATE TABLE if not exists tc_carga(
ID int NOT NULL AUTO_INCREMENT,
TIPO_CARGA varchar(30) NOT NULL,
DIMENSOES varchar(30) NOT NULL,
ORIGEM varchar(30) NOT NULL,
DESTINO varchar(30) NOT NULL,
CLIENTE varchar(50) NOT NULL,
SOLICITANTE varchar(50) NOT NULL,
PRIMARY KEY (ID)
);

CREATE TABLE if not exists tc_rota(
ID int NOT NULL AUTO_INCREMENT,
ID_CAMINHAO varchar(7) NOT NULL,
ORIGEM varchar(30) NOT NULL,
PRIMARY KEY (ID),
FOREIGN KEY (ID_CAMINHAO) REFERENCES tc_caminhao(PLACA)
);

CREATE TABLE if not exists tc_ponto_parada(
ID int NOT NULL AUTO_INCREMENT,
ID_ROTA int NOT NULL,
DESTINO varchar(30) NOT NULL,
DATA_CHEGADA date NOT NULL,
PRIMARY KEY (ID),
FOREIGN KEY (ID_ROTA) REFERENCES tc_rota(ID)
);
