CREATE TABLE ROOMS(
  ROOM_ID BIGINT PRIMARY KEY auto_increment,
  NAME VARCHAR(16) NOT NULL,
  ROOM_NUMBER CHAR(2) NOT NULL UNIQUE,
  BED_INFO CHAR(2) NOT NULL
);

CREATE TABLE GUESTS(
  GUEST_ID BIGINT PRIMARY KEY auto_increment,
  FIRST_NAME VARCHAR(64),
  LAST_NAME VARCHAR(64),
  EMAIL_ADDRESS VARCHAR(64),
  ADDRESS VARCHAR(64),
  COUNTRY VARCHAR(32),
  STATE VARCHAR(12),
  PHONE_NUMBER VARCHAR(24)
);

CREATE TABLE RESERVATIONS(
  RESERVATION_ID BIGINT PRIMARY KEY auto_increment,
  ROOM_ID BIGINT NOT NULL,
  GUEST_ID BIGINT NOT NULL,
  RES_DATE DATE
);

ALTER TABLE RESERVATIONS ADD FOREIGN KEY (ROOM_ID) REFERENCES ROOMS(ROOM_ID);
ALTER TABLE RESERVATIONS ADD FOREIGN KEY (GUEST_ID) REFERENCES GUESTS(GUEST_ID);
CREATE INDEX IDX_RES_DATE_ ON RESERVATIONS(RES_DATE);

CREATE SEQUENCE RESERVATIONS_SEQ
  START WITH 2
  INCREMENT BY 50;

CREATE SEQUENCE GUESTS_SEQ
  START WITH 201
  INCREMENT BY 50;
