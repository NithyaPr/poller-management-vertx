CREATE TABLE IF NOT EXISTS SERVICES
                              (	"ID" NUMBER NOT NULL AUTO_INCREMENT,
                                "NAME" VARCHAR2(50 BYTE) ,
                           	"URL" VARCHAR2(500 BYTE) ,
                           	"CREATED_DATE" DATE ,
                           	"CREATED_BY" VARCHAR2(50 BYTE) ,
                           	"STATUS" VARCHAR2(10 BYTE) ,
                           	"MODIFIED_DATE" DATE,
                           	"LAST_ACTIVE_DATE" DATE,
                           	"STATUS_DATE" DATE
                              );
CREATE SEQUENCE  IF NOT EXISTS "SERVICES_SEQ"  INCREMENT BY 1 START WITH 1;
