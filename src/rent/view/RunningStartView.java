package rent.view;

import rent.controller.CarController;

public class RunningStartView {
	
	public static void main(String [] args) {
		// ��� ���� �˻�
		System.out.println("***** ������� �˻� *****");
		CarController.getAllCar();
		
		// �𵨸����� �˻� (ex ����ũ, �ƹݶ� ��)
		System.out.println("\n***** �𵨸����� �˻� *****");
		CarController.getCarModelList();
		
		// �������� �˻� (ex ����, suv ��)
		System.out.println("\n***** �������� �˻� *****");
		CarController.getCarTypeList();
		
		// �귣��� �˻� (ex ����, ��� ��)
		System.out.println("\n***** �귣��� �˻� *****");
		CarController.getCarBrandList();
		
		// �뿩������ ���� �˻�
		System.out.println("\n***** �뿩 ������ ���� �˻� *****");
		CarController.getCarisRentList();
	}
}