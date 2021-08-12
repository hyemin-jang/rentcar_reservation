package rent.view;

import rent.controller.CarController;
import rent.model.dto.CarDTO;

public class RunningStartView {
	
	public static void main(String [] args) {
		System.out.println("***** 모든차량 검색 *****");
		CarController.getAllCar();
		
		// 모델명으로 검색 (ex 스파크, 아반떼 등)
		System.out.println("\n***** 모델명으로 검색 *****");
		CarController.getCarModelList();
		
		// 차종으로 검색 (ex 경차, suv 등)
		System.out.println("\n***** 차종으로 검색 *****");
		CarController.getCarTypeList();
		
		// 차량 추가
		System.out.println("\n***** 차량 추가 *****");		
		CarController.addCar(new CarDTO(5, "셀토스", "기아", "SUV", 20000, "0"));    // car_id 자동부여 가능????
		System.out.println("***** 유효하지 않은  값으로 차량 추가*****");
		CarController.addCar(new CarDTO(11, "셀토스", "기아", null, 20000, "0"));
		
		// 차량 삭제
		System.out.println("***** 차량 등록 번호로 차량 삭제 *****");
		CarController.deleteCar(5);
		System.out.println("\n***** 없는 번호로 삭제 시도시 *****");
		CarController.deleteCar(5);
		
		// 모든 대여 내역 조회
		System.out.println("\n***** 모든 대여 내역 조회 *****");
		CarController.getAllRentList();
	}
}