package rent.view;

import rent.controller.CarController;

public class RunningStartView {
	
	public static void main(String [] args) {
		System.out.println("***** 모든 차량 검색 *****");
		CarController.getAllCar();
		
		System.out.println("\n***** 모델명으로 검색 *****");
		CarController.getCarModelList();
		
		System.out.println("\n***** 차종으로 검색 *****");
		CarController.getCarTypeList();
	}
}