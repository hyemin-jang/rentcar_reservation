package rent.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Scanner;

import rent.model.CarDAO;
import rent.model.RentDAO;
import rent.model.dto.CarDTO;
import rent.model.dto.RentDTO;
import rent.view.RunningEndView;

public class Controller {
	// 모든 차량 검색
	public static void getAllCar(){
		try{
			RunningEndView.getAllList(CarDAO.getAllCar());
		}catch(SQLException s){
			s.printStackTrace();
			RunningEndView.showError("모든 차량 검색시 에러 발생");
		}
	}

	// 모델명으로 검색
	public static void getCarModelList() {
		try {
			RunningEndView.getAllList(CarDAO.getCarModelList());
		} catch (SQLException e) {
			e.printStackTrace();
			RunningEndView.showError("검색하신 모델이 없습니다.");
		}
	}

	// 차종으로 검색
	public static void getCarTypeList() {
		try {
			RunningEndView.getAllList(CarDAO.getCarTypeList());
		} catch (SQLException e) {
			e.printStackTrace();
			RunningEndView.showError("검색하신 차종이 없습니다.");
		}
	}
	
	// 브랜드로 검색
	public static void getCarBrandList() {
		try {
			RunningEndView.getAllList(CarDAO.getCarBrandList());
		} catch (SQLException e) {
			e.printStackTrace();
			RunningEndView.showError("검색하신 브랜드가 없습니다.");
		}
	}
	
	// 현재 대여 가능한 차량 검색
	public static void getCarisRentList() {
		try {
			RunningEndView.getAllList(CarDAO.getCarisRentList());
		} catch (SQLException e) {
			e.printStackTrace();
			RunningEndView.showError("렌트 가능하신 차량이 없습니다.");
		}
	}
	
	// 차량 대여
	public static void addRentList(RentDTO rent) {
		try {
			RentDAO.addRentList(rent);
			RunningEndView.showMessage("예약에 성공했습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
			RunningEndView.showError("차량 예약 실패하였습니다.");
		}
	}
	
	// 차량 반납
	public static void returnRent(int rentID) {
		try {
			RentDAO.returnRent(rentID);
			RunningEndView.showMessage("반납이 완료되었습니다.");
		} catch (SQLException e){
			e.printStackTrace();
			RunningEndView.showError("반납 실패");
		}
	}
	
	// 관리자 - 차량 등록 로직
	public static boolean addCar(CarDTO car) {
		boolean result = false;
		
		try {
			result = CarDAO.addCar(car);
			RunningEndView.showMessage("차량을 등록했습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
			RunningEndView.showError("차량 등록에 실패하였습니다.");
		}
		return result;   
	}
	
	// 관리자 - 차량 삭제 로직
	public static boolean deleteCar(int id) {
		boolean result = false;
		CarDTO car = null;
		
		try {
			car = CarDAO.getCar(id);   
			result = CarDAO.deleteCar(car);
			RunningEndView.showMessage("차량을 삭제했습니다.");
		} catch (SQLException e) {
//			e.printStackTrace();
			RunningEndView.showError("차량 삭제에 실패하였습니다.");
		} catch (NullPointerException e) {
//			e.printStackTrace();
			RunningEndView.showError("해당 차량이 존재하지 않습니다.");
		}
		return result;   
	}
	
	// 관리자 - 모든 렌트 내역 검색 로직
	public static void getAllRentList(){
		try{
			RunningEndView.getAllList(RentDAO.getAllRentList());
		}catch(SQLException s){
			s.printStackTrace();
			RunningEndView.showError("에러");
		}		
	}
	
	
	// 시작 메뉴
	public static void startMenu() {
		System.out.println("***** 안녕하세요! 플레이렌트카입니다. *****");			
		int choice = -1;
		
		while (true) {			
			System.out.println("\n메뉴를 선택해주세요.");	
			System.out.println("\n0.메뉴 종료하기 \t1.모든 차량 조회하기  \t2.모델명으로 검색   \t3.차종으로 검색 "
							+ "\n4.브랜드로 검색 \t5.대여 가능 차량 조회 \t6.차량 대여하기 \t7. 차량 반납하기"
							+ "\n\n[관리자 메뉴]"
							+ "\n8.차량 추가  \t9.차량 삭제 \t10.모든 대여 내역 조회");
							
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			try {
				choice = Integer.parseInt(br.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			} catch (NumberFormatException e) {
//				e.printStackTrace();
				System.out.println("숫자로 입력해주세요.");
			}
			
			if (choice == 0) {
				System.out.println("\n이용해 주셔서 감사합니다.");
				break;
				
			} else if (choice == 1) {
				getAllCar();
				
			} else if (choice == 2) {
				getCarModelList();
				
			} else if (choice == 3) {
				getCarTypeList();
				
			} else if (choice == 4) {
				getCarBrandList();
				
			} else if (choice == 5) {
				getCarisRentList();
				
			} else if (choice == 6) {
				Scanner sc = new Scanner(new InputStreamReader(System.in));
				System.out.println("반납할 날짜를 입력하세요. (yyyy-mm-dd 형태로 입력)");
				String endDay = sc.next();
				System.out.println("고객번호를 입력하세요.");
				int customerId = Integer.parseInt(sc.next());
				System.out.println("차량번호를 입력하세요.");
				int carType = Integer.parseInt(sc.next());				
				addRentList(new RentDTO(endDay, customerId, carType));
				
			} else if (choice == 7) {
				returnRent(2);   // 미완성
				
			} else if (choice == 8) {
				Scanner sc = new Scanner(new InputStreamReader(System.in));
				System.out.println("차량 모델을 입력하세요.");
				String model = sc.next();
				System.out.println("차량 브랜드를 입력하세요.");
				String brand = sc.next();
				System.out.println("차종을 입력하세요.");
				String carType = sc.next();
				System.out.println("대여료를 입력하세요.");
				int price = 0;
				try {
					price = Integer.parseInt(sc.next());
				} catch(NumberFormatException e) {
//					e.printStackTrace();
					System.out.println("숫자를 입력하지 않아 기본값 0으로 저장됩니다.");
				}				
				addCar(new CarDTO(model, brand, carType, price));
				
			} else if (choice == 9) {
				Scanner sc = new Scanner(new InputStreamReader(System.in));
				int carId = 0;
				try {
					carId = Integer.parseInt(sc.next());
				} catch(NumberFormatException e) {
//					e.printStackTrace();
					System.out.println("숫자로 입력해주세요.");
				}		
				deleteCar(carId);
			} else if (choice == 10) {
				getAllRentList();
			} 
			
		}
		
	}

}
