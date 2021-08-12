package rent.view;

import rent.controller.CarController;
import rent.model.dto.CarDTO;

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
		
		// ���� �߰�
		System.out.println("\n***** ���� �߰� *****");		
		CarController.addCar(new CarDTO(5, "���佺", "���", "SUV", 20000, "0"));    // car_id �ڵ��ο� ����????
		System.out.println("***** ��ȿ���� ����  ������ ���� �߰�*****");
		CarController.addCar(new CarDTO(11, "���佺", "���", null, 20000, "0"));
		
		// ���� ����
		System.out.println("***** ���� ��� ��ȣ�� ���� ���� *****");
		CarController.deleteCar(5);
		System.out.println("\n***** ���� ��ȣ�� ���� �õ��� *****");
		CarController.deleteCar(5);
		
		// ��� �뿩 ���� ��ȸ
		System.out.println("\n***** ��� �뿩 ���� ��ȸ *****");
		CarController.getAllRentList();
	}
}