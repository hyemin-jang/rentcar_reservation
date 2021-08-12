package rent.view;

import rent.controller.CarController;

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
	}
}