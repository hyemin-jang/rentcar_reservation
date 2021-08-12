-- 고객 정보
DROP TABLE customer cascade constraint;

-- 자동차 정보
DROP TABLE car cascade constraint;

-- 예약 정보
DROP TABLE rent cascade constraint;

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
       is_rent				VARCHAR2(1) NOT NULL
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