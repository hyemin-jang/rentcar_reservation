package rent.view;

import java.util.ArrayList;

import rent.model.dto.CarDTO;

public class RunningEndView {
	
	// ��� ���� ���
	public static void getAllCar(ArrayList<CarDTO> getAllCar){
		if(getAllCar != null) {
			int length = getAllCar.size();
			
			if( length != 0 ){
				for(int index = 0; index < length; index++){			
					System.out.println("�˻�����" + (index+1) + " - " + getAllCar.get(index));
				}
			}else {
				System.out.println("��û�Ͻ� ���� ������ �������� �ʽ��ϴ�.");
			}
		}else {
			System.out.println("null�� ������ �ʽ��ϴ�.");
		}

	}
	
	public static void showError(String message){
		System.out.println(message);		
	}
}
