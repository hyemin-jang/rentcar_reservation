package rent.view;

import rent.controller.CarController;
import rent.model.dto.CarDTO;

public class RunningStartView {
	
	public static void main(String [] args) {
//		System.out.println("***** 모든 Project 검색 *****");
//		CarController.getAllCar();
//		
//		System.out.println("***** 차량 추가 *****");		
//		CarController.addCar(new CarDTO(10, "셀토스", "기아", "SUV", 20000, "0"));    // car_id 자동부여 가능????
//		System.out.println("***** 유효하지 않은  값으로 차량 추가*****");
//		CarController.addCar(new CarDTO(11, "셀토스", "기아", null, 20000, "0"));
//		
//		System.out.println("***** 차량 등록 번호로 차량 삭제 *****");
//		CarController.deleteCar();
//		System.out.println("***** 없는 번호로 삭제 시도시 *****");
//		CarController.deleteCar();
		
		System.out.println("***** 모든 대여 내역 조회 *****");
		CarController.getAllRentList();
		
	}	

}