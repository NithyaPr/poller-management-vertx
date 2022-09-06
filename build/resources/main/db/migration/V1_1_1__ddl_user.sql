CREATE TABLE IF NOT EXISTS USERS
                              (	"ID" NUMBER NOT NULL AUTO_INCREMENT,
                                "NAME" VARCHAR2(50 BYTE) ,

                           	"CREATED_DATE" DATE ,
                           	"CREATED_BY" VARCHAR2(50 BYTE) ,
                           	"STATUS" VARCHAR2(10 BYTE) ,
                           	"MODIFIED_DATE" DATE
                              );
CREATE SEQUENCE  IF NOT EXISTS "USERS_SEQ"  INCREMENT BY 1 START WITH 1;
