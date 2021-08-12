package rent.controller;

import java.sql.SQLException;

import rent.model.CarDAO;
import rent.model.RentDAO;
import rent.model.dto.CarDTO;
import rent.view.RunningEndView;

public class CarController {
	// 모든 차량 검색 로직
	public static void getAllCar(){
		try{
			RunningEndView.getAllList(CarDAO.getAllCar());
		}catch(SQLException s){
			s.printStackTrace();
			RunningEndView.showError("모든 프로젝트 검색시 에러 발생");
		}
	}
	
	// 관리자 - 차량 등록 로직
	public static boolean addCar(CarDTO car) {
		boolean result = false;
		
		try {
			result = CarDAO.addCar(car);
			RunningEndView.showMessage("차량을 등록했습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
			RunningEndView.showError("차량 등록에 실패하였습니다.");
		}
		return result;   // 차량등록 실패한경우 false
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
