-- customer insert[�� ���� ����]�ƹݶ� ����
insert into customer values(1, '���缮', '010-2384-2842', '11-23-293847-38');
insert into customer values(2, '�ŵ���', '010-3829-3892', '42-38-293832-38');
insert into customer values(3, '�̿���', '010-3298-2938', '23-28-589334-38');

-- car insert[��Ʈī ���� ����]
insert into car values(1, '����ũ', '������', '����', 10000);
insert into car values(2, '�ƹݶ�', '����', '������', 20000);
insert into car values(3, '����', '���', '����', 10000);

-- reservation insert[���� ���� ����]
insert into reservation values(1, TO_DATE('2021-07-21'), TO_DATE('2021-08-20'), 2, 1, 0);
insert into reservation values(2, TO_DATE('2021-08-08'), TO_DATE('2021-08-12'), 3, 2, 0);
insert into reservation values(3, TO_DATE('2021-06-01'), TO_DATE('2021-07-31'), 1, 3, 0);
insert into reservation values(4, TO_DATE('2021-08-11'), TO_DATE('2021-08-12'), 2, 3, 0);

commit;