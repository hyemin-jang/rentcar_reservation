package rent.view;

import java.util.ArrayList;

import rent.model.dto.CarDTO;
import rent.model.dto.RentDTO;

public class RunningEndView {
	
	// 모든 리스트 출력
	public static void getCarList(ArrayList<CarDTO> list){
		if(list != null) {
			int length = list.size();
			
			if( length != 0 ){
				System.out.println("-------------------------------------------------");
				System.out.println("| no. |  모델  |  브랜드  |  차종   |   대여 금액  | 대여 여부  |");
				System.out.println("-------------------------------------------------");
				for(int index = 0; index < length; index++){			
					System.out.println(list.get(index));
				}
			}else {
				System.out.println("해당 내역이 없습니다.");
			}
		}else {
			System.out.println("null 값은 허용되지 않습니다.");
		}

	}
	
	public static void getRentList(ArrayList<RentDTO> list){
		if(list != null) {
			int length = list.size();
			
			if( length != 0 ){
				System.out.println("---------------------------------------------------------------------------------------------");
				System.out.println("| no. |        대여 날짜                  |        반납 날짜               |  고객No. |  차량No. |      실반납 날짜               |");
				System.out.println("---------------------------------------------------------------------------------------------");
				for(int index = 0; index < length; index++){			
					System.out.println(list.get(index));
				}
			}else {
				System.out.println("해당 내역이 없습니다.");
			}
		}else {
			System.out.println("null 값은 허용되지 않습니다.");
		}

	}
	
	// 예외 상황 출력
	public static void showError(String message){
		System.out.println(message);		
	}

	// 정상 수행시 메세지 출력
	public static void showMessage(String message) {
		System.out.println(message);
	}	
	
}

