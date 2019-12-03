CREATE TABLE BrRobotics.PEDIDOS  ( 
	CODIGO  	INT NOT NULL AUTO_INCREMENT,
	CLIENTE 	VARCHAR(40),
	ENDERECO	VARCHAR(100),
	ESTADO  	VARCHAR(10),
	QTD_ROBO_DOMESTICO 		INTEGER NOT NULL,
	QTD_ROBO_MEDICO 		INTEGER NOT NULL,
    QTD_ROBO_SEGURANCA 		INTEGER NOT NULL,
	TOTAL_ROBO_DOMESTICO   	REAL NOT NULL,
	TOTAL_ROBO_MEDICO   	REAL NOT NULL,
    TOTAL_ROBO_SEGURANCA   	REAL NOT NULL,
	TOTAL   	REAL,
	PRIMARY KEY(CODIGO)
)