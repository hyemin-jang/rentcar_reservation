package rent.view;

import java.util.ArrayList;

public class RunningEndView {
	
	// ��� ���� ���
	public static void getAllList(ArrayList list){
		if(list != null) {
			int length = list.size();
			
			if( length != 0 ){
				for(int index = 0; index < length; index++){			
					System.out.println("�˻�����" + (index+1) + " - " + list.get(index));
				}
			}else {
				System.out.println("��û�Ͻ� ������ �������� �ʽ��ϴ�.");
			}
		}else {
			System.out.println("null�� ������ �ʽ��ϴ�.");
		}

	}
	
	// ���� ��Ȳ ���
	public static void showError(String message){
		System.out.println(message);		
	}

	// ���� ����� �޼��� ���
	public static void showMessage(String message) {
		System.out.println(message);
	}	
	
}