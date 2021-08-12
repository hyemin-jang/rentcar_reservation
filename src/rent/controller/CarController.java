package rent.controller;

import java.sql.SQLException;

import rent.model.CarDAO;
import rent.view.RunningEndView;

public class CarController {

	// 모든 차량 검색
	public static void getAllCar(){
		try{
			RunningEndView.getAllCar(CarDAO.getAllCar());
		}catch(SQLException s){
			s.printStackTrace();
			RunningEndView.showError("모든 차량 검색시 에러 발생");
		}
	}

	// 모델명으로 검색
	public static void getCarModelList() {
		try {
			RunningEndView.getAllCar(CarDAO.getCarModelList());
		} catch (SQLException e) {
			e.printStackTrace();
			RunningEndView.showError("검색하신 모델이 없습니다.");
		}
	}

	// 차종으로 검색
	public static void getCarTypeList() {
		try {
			RunningEndView.getAllCar(CarDAO.getCarTypeList());
		} catch (SQLException e) {
			e.printStackTrace();
			RunningEndView.showError("검색하신 차종이 없습니다.");
		}
	}
}
