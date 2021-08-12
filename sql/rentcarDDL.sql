-- �� ����
DROP TABLE customer cascade constraint;

-- �ڵ��� ����
DROP TABLE car cascade constraint;

-- ���� ����
DROP TABLE rent cascade constraint;

DROP SEQUENCE customer_idx;
DROP SEQUENCE car_idx;
DROP SEQUENCE rent_idx;

CREATE TABLE customer (
       customer_id          NUMBER	 PRIMARY KEY,
       name               	VARCHAR2(20) NOT NULL,
       phone         		VARCHAR2(20) NOT NULL,
       license              VARCHAR2(20) NOT NULL
);

CREATE TABLE car (
       car_id        		NUMBER PRIMARY KEY,
       model                VARCHAR2(20) NOT NULL,
       brand          		VARCHAR2(20) NOT NULL,
       cartype   			VARCHAR2(20) NOT NULL,
       price 				NUMBER NOT NULL,
       is_rent				VARCHAR2(1) DEFAULT 0
);


CREATE TABLE rent (
       reservation_id       NUMBER PRIMARY KEY,
       startday     		DATE NOT NULL,
       endday  				DATE NOT NULL,
       customer_id			NUMBER NOT NULL,
       car_id				NUMBER NOT NULL,
       returnday			DATE
);

ALTER TABLE rent ADD FOREIGN KEY (customer_id) REFERENCES customer (customer_id);
ALTER TABLE rent ADD FOREIGN KEY (car_id) REFERENCES car (car_id);
ALTER TABEL

CREATE SEQUENCE customer_idx START WITH 1 INCREMENT BY 1 MAXVALUE 10000000 CYCLE NOCACHE;
CREATE SEQUENCE car_idx START WITH 1 INCREMENT BY 1 MAXVALUE 10000000 CYCLE NOCACHE;
CREATE SEQUENCE rent_idx START WITH 1 INCREMENT BY 1 MAXVALUE 10000000 CYCLE NOCACHE;