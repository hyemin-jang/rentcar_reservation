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
	}
}