package rent.view;

import rent.controller.CarController;

public class RunningStartView {
	
	public static void main(String [] args) {
		System.out.println("***** ��� Project �˻� *****");
		CarController.getAllCar();
		
//		���� �𵨺� ��ȸ (�ƹݶ�, �Ÿ ��)- ����
		System.out.println("\n***** ���� �𵨺� ��ȸ *****");
		CarController.getCarModelList();
		
//		������ ��ȸ (����, suv ��) - ����
		System.out.println("\n***** ������ ��ȸ *****");
		CarController.getCarTypeList();
	}
}