package rent.view;

import java.util.ArrayList;

import rent.model.dto.CarDTO;

public class RunningEndView {
	
	//모든 프로젝트들 출력
	public static void getAllCar(ArrayList<CarDTO> getAllCar){
		if(getAllCar != null) {
			int length = getAllCar.size();  //저장된 데이터 개수 반환 
			
			if( length != 0 ){
				for(int index = 0; index < length; index++){			
					System.out.println("검색정보 " + (index+1) + " - " + getAllCar.get(index));
				}
			}else {
				System.out.println("요청하신 프로젝트 정보는 1도 없습니다.");
			}
		}else {
			System.out.println("요청하신 프로젝트들 정보는 없습니다.");
		}

	}
	
	//예외 상황 출력
	public static void showError(String message){
		System.out.println(message);		
	}	
}
