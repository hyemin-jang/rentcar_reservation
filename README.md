# 🚗 플레이렌트카

> 고객이 차량 조회/대여/반납을 할 수 있고, 관리자는 차량 등록/삭제/모든 대여 내역을 조회할 수 있는 렌트카 예약 시스템

# 1. Contributor
- 차재훈 
- 신지혜
- 장혜민

# 2. Environment
- JDK 1.8
- Oracle 11g XE
- Eclipse photon

# 3. Modeling
![image](https://user-images.githubusercontent.com/74531573/129319247-d86c26e5-917b-4bc1-adf8-7958e8e2acc7.png)



# 4. Class Diagram
![classDiagram](https://user-images.githubusercontent.com/74531573/129318723-4b8a60e6-7027-451d-bf59-8857bba222b3.gif)



# 5. Function

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

 

# 👩‍🏫 Presentation Notion Link
https://www.notion.so/c74dff75a1114fb5afc979ad527fcb96
