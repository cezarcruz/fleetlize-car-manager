package com.fleetlize.webapp.gateways.database;

public class Queries {

  public static final String INSERT_CAR_MODEL = "INSERT INTO CAR_MODEL (MANUFACTURER_ID, MODEL_NAME, CREATION_DATE, MODEL_YEAR) " +
      "VALUES (:MANUFACTURER_ID, :MODEL_NAME, :CREATION_DATE, :MODEL_YEAR)";

  public static final String INSERT_CAR = "INSERT INTO CAR (PLATE, MILEAGE, CAR_MODEL_ID, CREATION_DATE) VALUES (:PLATE, :MILEAGE, :CAR_MODEL, :CREATION_DATE)";

  public static final String FIND_CAR_MODEL = "SELECT CM.ID AS MODEL_ID, CM.MANUFACTURER_ID, MA.NAME, CM.MODEL_NAME, CM.MODEL_YEAR, CM.CREATION_DATE, CM.UPDATE_DATE FROM CAR_MODEL CM " +
      "INNER JOIN MANUFACTURER MA ON MA.MANUFACTURER_ID = CM.MANUFACTURER_ID ";

  public static final String FIND_CAR_MODEL_BY_ID = "SELECT CM.ID AS MODEL_ID, CM.MANUFACTURER_ID, MA.NAME, CM.MODEL_NAME, CM.MODEL_YEAR, CM.CREATION_DATE, CM.UPDATE_DATE, MA.CREATION_DATE AS MA_CREATION_DATE, MA.UPDATE_DATE AS MA_UPDATE_DATE FROM CAR_MODEL CM " +
      "INNER JOIN MANUFACTURER MA ON MA.MANUFACTURER_ID = CM.MANUFACTURER_ID WHERE CM.ID = :ID";

  public static final String DELETE_CAR_MODEL_BY_ID = "DELETE FROM CAR_MODEL WHERE ID = :ID";

  public static final String UPDATE_CAR_MODEL = "UPDATE CAR_MODEL SET MANUFACTURER_ID = :MANUFACTURER_ID, MODEL_NAME = :MODEL_NAME, MODEL_YEAR = :MODEL_YEAR, UPDATE_DATE = :UPDATE_DATE WHERE ID = :ID";

  public static final String INSERT_CATEGORY = "INSERT INTO CATEGORY (NAME, DAILY_PRICE) VALUES (:NAME, :DAILY_PRICE)";

  public static final String FIND_CATEGORY_BY_ID = "SELECT CATEGORY_ID, NAME, DAILY_PRICE FROM CATEGORY WHERE CATEGORY_ID = :ID";
}
