CREATE TABLE StarkSystem.PEDIDOS  ( 
	CODIGO  	INT NOT NULL AUTO_INCREMENT,
	CLIENTE 	VARCHAR(40),
	ENDERECO	VARCHAR(100),
	ESTADO  	VARCHAR(10),
	QTD_REATOR_SOLAR INTEGER NOT NULL,
	QTD_REATOR_ARK INTEGER NOT NULL,
	TOTAL_REATOR_SOLAR   	REAL NOT NULL,
	TOTAL_REATOR_ARK   	REAL NOT NULL,
	TOTAL   	REAL,
	PRIMARY KEY(CODIGO)
)