-- customer insert[고객 정보 저장]아반떼 차종
insert into customer values(customer_idx.NEXTVAL, '유재석', '010-2384-2842', '11-23-293847-38');
insert into customer values(customer_idx.NEXTVAL, '신동엽', '010-3829-3892', '42-38-293832-38');
insert into customer values(customer_idx.NEXTVAL, '이영자', '010-3298-2938', '23-28-589334-38');

-- car insert[렌트카 정보 저장]
insert into car values(car_idx.NEXTVAL, '스파크', '쉐보레', '경차', 10000, '0');
insert into car values(car_idx.NEXTVAL, '아반떼', '현대', '준중형', 20000, '0');
insert into car values(car_idx.NEXTVAL, '레이', '기아', '경차', 10000, '0');

-- rent insert[예약 정보 저장]
insert into rent values(rent_idx.NEXTVAL, TO_DATE('2021-07-21'), TO_DATE('2021-08-01'), 2, 1, TO_DATE('2021-08-01'));
insert into rent values(rent_idx.NEXTVAL, TO_DATE('2021-08-08'), TO_DATE('2021-08-10'), 3, 2, TO_DATE('2021-08-10'));
insert into rent values(rent_idx.NEXTVAL, TO_DATE('2021-06-01'), TO_DATE('2021-07-31'), 1, 3, TO_DATE('2021-07-31'));
insert into rent values(rent_idx.NEXTVAL, TO_DATE('2021-08-02'), TO_DATE('2021-08-04'), 2, 3, TO_DATE('2021-08-04'));

commit;
