package rent.view;

import rent.controller.CarController;

public class RunningStartView {
	
	public static void main(String [] args) {
		System.out.println("***** ��� ���� �˻� *****");
		CarController.getAllCar();
		
		System.out.println("\n***** �𵨸����� �˻� *****");
		CarController.getCarModelList();
		
		System.out.println("\n***** �������� �˻� *****");
		CarController.getCarTypeList();
	}
}