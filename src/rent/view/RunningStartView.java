package rent.view;

import rent.controller.CarController;
import rent.model.dto.CarDTO;

public class RunningStartView {
	
	public static void main(String [] args) {
//		System.out.println("***** ��� Project �˻� *****");
//		CarController.getAllCar();
//		
//		System.out.println("***** ���� �߰� *****");		
//		CarController.addCar(new CarDTO(10, "���佺", "���", "SUV", 20000, "0"));    // car_id �ڵ��ο� ����????
//		System.out.println("***** ��ȿ���� ����  ������ ���� �߰�*****");
//		CarController.addCar(new CarDTO(11, "���佺", "���", null, 20000, "0"));
//		
//		System.out.println("***** ���� ��� ��ȣ�� ���� ���� *****");
//		CarController.deleteCar();
//		System.out.println("***** ���� ��ȣ�� ���� �õ��� *****");
//		CarController.deleteCar();
		
		System.out.println("***** ��� �뿩 ���� ��ȸ *****");
		CarController.getAllRentList();
		
	}	

}