package rent.view;

import java.util.ArrayList;

import rent.model.dto.CarDTO;

public class RunningEndView {
	
	// 모든 차량 출력
	public static void getAllCar(ArrayList<CarDTO> getAllCar){
		if(getAllCar != null) {
			int length = getAllCar.size();
			
			if( length != 0 ){
				for(int index = 0; index < length; index++){			
					System.out.println("검색정보" + (index+1) + " - " + getAllCar.get(index));
				}
			}else {
				System.out.println("요청하신 차량 정보가 존재하지 않습니다.");
			}
		}else {
			System.out.println("null은 허용되지 않습니다.");
		}

	}
	
	public static void showError(String message){
		System.out.println(message);		
	}
}
