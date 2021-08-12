package rent.view;

import java.util.ArrayList;

public class RunningEndView {
	
	// 모든 리스트 출력
	public static void getAllList(ArrayList list){
		if(list != null) {
			int length = list.size();
			
			if( length != 0 ){
				for(int index = 0; index < length; index++){			
					System.out.println("검색정보 " + (index+1) + " - " + list.get(index));
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

