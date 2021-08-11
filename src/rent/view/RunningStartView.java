package rent.view;

import rent.controller.CarController;

public class RunningStartView {
	
	public static void main(String [] args) {
		System.out.println("***** 모든 Project 검색 *****");
		CarController.getAllCar();
		
//		차량 모델별 조회 (아반떼, 쏘나타 등)- 지혜
		System.out.println("\n***** 차량 모델별 조회 *****");
		CarController.getCarModelList();
		
//		차종별 조회 (경차, suv 등) - 지혜
		System.out.println("\n***** 차종별 조회 *****");
		CarController.getCarTypeList();
	}
}