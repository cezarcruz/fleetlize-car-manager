CREATE TABLE IF NOT EXISTS MANUFACTURER (
	MANUFACTURER_ID INT AUTO_INCREMENT,
	NAME VARCHAR(255) NOT NULL,
	CREATION_DATE TIMESTAMP NOT NULL,
	UPDATE_DATE TIMESTAMP NULL DEFAULT NULL,
	PRIMARY KEY (MANUFACTURER_ID)
);

CREATE TABLE IF NOT EXISTS CATEGORY (
  CATEGORY_ID INT AUTO_INCREMENT,
  CATEGORY_NAME VARCHAR(50) NOT NULL,
  DAILY_PRICE INT(5) NOT NULL,
  PRIMARY KEY (CATEGORY_ID)
);

CREATE TABLE IF NOT EXISTS CAR_MODEL (
	CAR_MODEL_ID INT AUTO_INCREMENT,
	MANUFACTURER_ID INT NOT NULL,
	MODEL_NAME VARCHAR(255) NOT NULL,
	MODEL_YEAR INT(4) NOT NULL,
	CATEGORY_ID int DEFAULT NULL,
	CREATION_DATE TIMESTAMP NOT NULL,
	UPDATE_DATE TIMESTAMP NULL DEFAULT NULL ,
	PRIMARY KEY (CAR_MODEL_ID),
	CONSTRAINT FK_MANUFACTURER FOREIGN KEY (MANUFACTURER_ID) REFERENCES MANUFACTURER(MANUFACTURER_ID),
	CONSTRAINT FK_CAR_MODEL FOREIGN KEY (CATEGORY_ID) REFERENCES CATEGORY(CATEGORY_ID)
);


CREATE TABLE IF NOT EXISTS CAR (
	CAR_ID INT AUTO_INCREMENT,
	PLATE VARCHAR(7) NOT NULL,
	MILEAGE INT NOT NULL,
	CAR_MODEL_ID INT NOT NULL,
  CREATION_DATE TIMESTAMP NOT NULL,
  UPDATE_DATE TIMESTAMP NULL DEFAULT NULL,
	PRIMARY KEY (CAR_ID, PLATE),
	CONSTRAINT FK_CAR_CAR_MODEL FOREIGN KEY (CAR_MODEL_ID) REFERENCES CAR_MODEL(CAR_MODEL_ID)
);
