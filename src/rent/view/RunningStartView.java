package rent.view;

import rent.controller.CarController;
import rent.controller.RentController;
import rent.model.dto.CarDTO;

public class RunningStartView {

	public static void main(String[] args) {
		// 모든 차량 검색
		System.out.println("***** 모든차량 검색 *****");
		CarController.getAllCar();

		// 모델명으로 검색 (ex 스파크, 아반떼 등)
		System.out.println("\n***** 모델명으로 검색 *****");
		CarController.getCarModelList();

		// 차종으로 검색 (ex 경차, suv 등)
		System.out.println("\n***** 차종으로 검색 *****");
		CarController.getCarTypeList();

		// 브랜드로 검색 (ex 현대, 기아 등)
		System.out.println("\n***** 브랜드로 검색 *****");
		CarController.getCarBrandList();

		// 대여가능한 차량 검색
		System.out.println("\n***** 대여 가능한 차량 검색 *****");
		CarController.getCarisRentList();
		
		System.out.println("\n***** 차량 대여 *****");
		RentController.addRentList();

		// 관리자 - 차량 추가
//		System.out.println("\n***** 차량 추가 *****");
//		CarController.addCar(new CarDTO(10, "셀토스", "기아", "SUV", 20000, "0")); // car_id 자동부여 가능????
//		System.out.println("***** 유효하지 않은  값으로 차량 추가 *****");
//		CarController.addCar(new CarDTO(11, "셀토스", "기아", null, 20000, "0"));
//
//		System.out.println("***** 차량 등록 번호로 차량 삭제 *****");
//		CarController.deleteCar();
//		System.out.println("\n***** 없는 번호로 삭제 시도시 *****");
//		CarController.deleteCar();
//
//		System.out.println("\n***** 모든 대여 내역 조회 *****");
//		CarController.getAllRentList();
	}
}