package rent.view;

import rent.controller.CarController;

public class RunningStartView {
	
	public static void main(String [] args) {
		System.out.println("***** ������� �˻� *****");
		CarController.getAllCar();
		
		// �𵨸����� �˻� (ex ����ũ, �ƹݶ� ��)
		System.out.println("\n***** �𵨸����� �˻� *****");
		CarController.getCarModelList();
		
		// �������� �˻� (ex ����, suv ��)
		System.out.println("\n***** �������� �˻� *****");
		CarController.getCarTypeList();
	}
}