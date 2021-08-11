package rent.view;

import rent.controller.CarController;

public class RunningStartView {
	
	public static void main(String [] args) {
		System.out.println("***** 모든 Project 검색 *****");
		CarController.getAllCar();
	}
}