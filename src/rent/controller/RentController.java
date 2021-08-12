package rent.controller;

import java.sql.SQLException;
import rent.model.RentDAO;
import rent.model.dto.RentDTO;
import rent.view.RunningEndView;

public class RentController {
	// 차량 렌트하는 로직
	public static boolean addRentList(RentDTO rent) {
		boolean result = false;

		try {
			result = RentDAO.addRentList(rent);
			RunningEndView.showMessage("예약에 성공했습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
			RunningEndView.showError("차량 예약 실패하였습니다.");
		}
		return result;
	}

	// 관리자 - 모든 렌트 내역 검색 로직
	public static void getAllRentList(){
		try{
			RunningEndView.getAllList(RentDAO.getAllRentList());
		}catch(SQLException s){
			s.printStackTrace();
			RunningEndView.showError("에러");
		}		
	}
	
}
