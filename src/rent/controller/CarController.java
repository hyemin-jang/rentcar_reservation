package rent.controller;

import java.sql.SQLException;

import rent.model.CarDAO;
import rent.view.RunningEndView;

public class CarController {
	//모든 프로젝트 검색 로직
	public static void getAllCar(){
		try{
			RunningEndView.getAllCar(CarDAO.getAllCar());
		}catch(SQLException s){
			s.printStackTrace();
			RunningEndView.showError("모든 프로젝트 검색시 에러 발생");
		}
	}
}
