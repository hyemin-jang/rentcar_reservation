# 🚗 플레이렌트카
> 고객이 차량 조회/대여/반납을 할 수 있고, 관리자는 차량 등록/삭제/모든 대여 내역을 조회할 수 있는 렌트카 예약 시스템

제약사항 : 당일 대여만 가능

# 1. Modeling
![image](https://user-images.githubusercontent.com/74531573/129319247-d86c26e5-917b-4bc1-adf8-7958e8e2acc7.png)


# 2. SQL

## DDL

```sql
DROP TABLE customer cascade constraint;
DROP TABLE car cascade constraint;
DROP TABLE rent cascade constraint;

DROP SEQUENCE customer_idx;
DROP SEQUENCE car_idx;
DROP SEQUENCE rent_idx;

CREATE TABLE customer (
       customer_id          NUMBER	 PRIMARY KEY,
       name               	VARCHAR2(20) NOT NULL,
       phone         		    VARCHAR2(13) NOT NULL,
       license              VARCHAR2(20) NOT NULL
);

CREATE TABLE car (
       car_id        		NUMBER PRIMARY KEY,
       model            VARCHAR2(50) NOT NULL,
       brand          	VARCHAR2(20) NOT NULL,
       cartype   			  VARCHAR2(20) NOT NULL,
       price 				    NUMBER NOT NULL,
       is_rent				  VARCHAR2(1) DEFAULT '0'
);

CREATE TABLE rent (
       rent_id       		NUMBER PRIMARY KEY,
       startday     		DATE NOT NULL,
       endday  				  DATE NOT NULL,
       customer_id			NUMBER NOT NULL,
       car_id				    NUMBER,
       returnday			  DATE DEFAULT NULL       
);

ALTER TABLE rent ADD FOREIGN KEY (customer_id) REFERENCES customer (customer_id);
ALTER TABLE rent ADD FOREIGN KEY (car_id) REFERENCES car (car_id) ON DELETE SET NULL;

CREATE SEQUENCE customer_idx START WITH 1 INCREMENT BY 1 MAXVALUE 10000000 CYCLE NOCACHE;
CREATE SEQUENCE car_idx START WITH 1 INCREMENT BY 1 MAXVALUE 10000000 CYCLE NOCACHE;
CREATE SEQUENCE rent_idx START WITH 1 INCREMENT BY 1 MAXVALUE 10000000 CYCLE NOCACHE;
```

## DML

```sql
-- customer insert[고객 정보 저장]
insert into customer values(customer_idx.NEXTVAL, '유재석', '010-2384-2842', '11-23-293847-38');
insert into customer values(customer_idx.NEXTVAL, '신동엽', '010-3829-3892', '42-38-293832-38');
insert into customer values(customer_idx.NEXTVAL, '이영자', '010-3298-2938', '23-28-589334-38');
insert into customer values(customer_idx.NEXTVAL, '신지혜', '010-1232-8313', '23-23-173723-70');
insert into customer values(customer_idx.NEXTVAL, '차재훈', '010-9373-1743', '12-38-127942-27');
insert into customer values(customer_idx.NEXTVAL, '장혜민', '010-7124-3813', '98-02-379134-63'); 

-- car insert[렌트카 정보 저장]
insert into car values(car_idx.NEXTVAL, '스파크', '쉐보레', '경차', 10000, '0');
insert into car values(car_idx.NEXTVAL, '아반떼', '현대', '준중형', 20000, '0');
insert into car values(car_idx.NEXTVAL, '레이', '기아', '경차', 10000, '0');
insert into car values(car_idx.NEXTVAL, '트레블레이저', '쉐보레', 'SUV', 25000, '0');
insert into car values(car_idx.NEXTVAL, 'K5', '기아', '중형', 10000, '0');
insert into car values(car_idx.NEXTVAL, 'S500', '벤츠', '세단', 60000, '0');

-- rent insert[예약 정보 저장]
insert into rent values(rent_idx.NEXTVAL, TO_DATE('2021-07-21'), TO_DATE('2021-08-01'), 2, 1, TO_DATE('2021-08-01'));
insert into rent values(rent_idx.NEXTVAL, TO_DATE('2021-08-08'), TO_DATE('2021-08-10'), 3, 2, TO_DATE('2021-08-10'));
insert into rent values(rent_idx.NEXTVAL, TO_DATE('2021-06-01'), TO_DATE('2021-07-31'), 1, 3, TO_DATE('2021-07-31'));
insert into rent values(rent_idx.NEXTVAL, TO_DATE('2021-08-02'), TO_DATE('2021-08-04'), 2, 5, TO_DATE('2021-08-04'));

commit;
```

# 3. Class Diagram
![classDiagram](https://user-images.githubusercontent.com/74531573/129318723-4b8a60e6-7027-451d-bf59-8857bba222b3.gif)



# 4. Function

[고객]

1. 모든 차량 조회하기
2. 조건으로 차량 조회하기 (모델명, 차종, 브랜드)
    - 조건에 맞는 차량 존재하지 않을 시 예외처리
3. 대여 가능한 차량 조회
4. 차량 대여하기
    - 반납예정일, 고객번호, 차량번호만 입력받도록 함 (예약번호, 대여일은 자동 생성)
    - 없는 차량 번호로 대여 시 예외처리
5. 차량 반납하기
    - 없는 예약번호로 반납 시 예외처리
6. 예약 조회하기 
    - 없는 고객명으로 예약 조회 시 예외처리
7. 고객 등록하기

[관리자]

1. 차량 등록하기
    - 차량 모델, 브랜드, 제조사, 가격만 입력받도록 함 (등록번호, 대여여부 자동 생성)
    - 차량 가격에 숫자 형태로 입력하지 않을 시 예외처리
2. 차량 삭제하기
    - 예약중인 차량 삭제시 rent 테이블에서 해당 차량의 car_id 값을 Null로 변경하고 삭제하기

 

# 5. Code Review

- 차량 대여 기능 - 없는 차량 번호로 예약 시도해도 예약 성공 메세지 출력   / 해결 완료
- 차량 삭제 기능 - car 테이블에서 차량 삭제시, rent 테이블에서 해당 car_id가 Null로 바뀜 (ON DELETE SET NULL) → null 말고 차량번호와 구별되는 다른 숫자로 바꾸기  / 미완성
- 고객 테이블 - 현재 고객 추가 기능만 있어서 다른 메소드도 구현하면 좋겠다  / 개선 예정 (ex. 고객 리스트 조회 기능 ...)

# 6. 미흡한 점

- 차량 대여 기능 - 현 날짜보다 이전 날짜 입력시 / 없는 고객번호 입력시에 대한 예외처리
- 사용자 잘못 입력시 재입력 받기
