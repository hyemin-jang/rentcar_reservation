package rent.controller;

import java.sql.SQLException;

import probono.exception.NotExistException;
import probono.model.ProbonoService;
import rent.view.RunningEndView;

public class RentController {

	public static void addRentList(Integer rentId, String endday, Integer user_id, Integer car_id) {
		try{
			boolean r = ProbonoService.updateProbono(probonoId, probonoPurpose);
			RunningEndView.updateView(r, probonoId);			
		}catch(SQLException s){
			s.printStackTrace();
			RunningEndView.showError("프로보노 id로 프로보노 목적 변경 오류 재시도 하세요");
		}
//		catch(NotExistException s){
//			s.printStackTrace();
//			RunningEndView.showError("프로보노 id 재 확인후 재시도 하세요");
//		}
	}

}
