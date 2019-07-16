CREATE TABLE MANUFACTURER (
	MANUFACTURER_ID INT AUTO_INCREMENT,
	NAME VARCHAR(255) NOT NULL,
	CREATION_DATE TIMESTAMP NOT NULL,
	UPDATE_DATE TIMESTAMP NULL DEFAULT NULL,
	PRIMARY KEY (MANUFACTURER_ID)
)

CREATE TABLE CAR_MODEL (
	ID INT AUTO_INCREMENT,
	MANUFACTURER_ID INT NOT NULL,
	MODEL_NAME VARCHAR(255) NOT NULL,
	MODEL_YEAR INT(4) NOT NULL,
	CREATION_DATE TIMESTAMP NOT NULL,
	UPDATE_DATE TIMESTAMP NULL DEFAULT NULL ,
	PRIMARY KEY (ID),
	CONSTRAINT FK_MANUFACTURER FOREIGN KEY (MANUFACTURER_ID) REFERENCES MANUFACTURER(MANUFACTURER_ID)
)