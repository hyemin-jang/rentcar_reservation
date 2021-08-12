package rent.controller;

import java.sql.SQLException;

import rent.model.CarDAO;
import rent.model.RentDAO;
import rent.model.dto.CarDTO;
import rent.model.dto.RentDTO;
import rent.view.RunningEndView;

public class Controller {
	// 모든 차량 검색
	public static void getAllCar(){
		try{
			RunningEndView.getCarList(CarDAO.getAllCar());
		}catch(SQLException s){
			s.printStackTrace();
			RunningEndView.showError("모든 차량 검색시 에러 발생");
		}
	}

	// 모델명으로 검색
	public static void getCarModelList() {
		try {
			RunningEndView.getCarList(CarDAO.getCarModelList());
		} catch (SQLException e) {
			e.printStackTrace();
			RunningEndView.showError("검색하신 모델이 없습니다.");
		}
	}

	// 차종으로 검색
	public static void getCarTypeList() {
		try {
			RunningEndView.getCarList(CarDAO.getCarTypeList());
		} catch (SQLException e) {
			e.printStackTrace();
			RunningEndView.showError("검색하신 차종이 없습니다.");
		}
	}
	
	// 브랜드로 검색
	public static void getCarBrandList() {
		try {
			RunningEndView.getCarList(CarDAO.getCarBrandList());
		} catch (SQLException e) {
			e.printStackTrace();
			RunningEndView.showError("검색하신 브랜드가 없습니다.");
		}
	}
	
	// 현재 대여 가능한 차량 검색
	public static void getCarisRentList() {
		try {
			RunningEndView.getCarList(CarDAO.getCarisRentList());
		} catch (SQLException e) {
			e.printStackTrace();
			RunningEndView.showError("렌트 가능하신 차량이 없습니다.");
		}
	}
	
	// 차량 대여
	public static void addRentList(RentDTO rent) {
		try {
			RentDAO.addRentList(rent);
			RunningEndView.showMessage("예약에 성공했습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
			RunningEndView.showError("차량 예약 실패하였습니다.");
		}
	}
	
	// 차량 반납
	public static void returnRent(int rentID) {
		try {
			RentDAO.returnRent(rentID);
			RunningEndView.showMessage("반납이 완료되었습니다.");
		} catch (SQLException e){
			e.printStackTrace();
			RunningEndView.showError("반납 실패");
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
		return result;   
	}
	
	// 관리자 - 차량 삭제 로직
	public static boolean deleteCar(int id) {
		boolean result = false;
		CarDTO car = null;
		
		try {
			car = CarDAO.getCar(id);   
			result = CarDAO.deleteCar(car);
			RunningEndView.showMessage("차량을 삭제했습니다.");
		} catch (SQLException e) {
//			e.printStackTrace();
			RunningEndView.showError("차량 삭제에 실패하였습니다.");
		} catch (NullPointerException e) {
//			e.printStackTrace();
			RunningEndView.showError("해당 차량이 존재하지 않습니다.");
		}
		return result;   
	}	
	
	// 관리자 - 모든 렌트 내역 검색 로직
	public static void getAllRentList(){
		try{
			RunningEndView.getRentList(RentDAO.getAllRentList());
		}catch(SQLException s){
			s.printStackTrace();
			RunningEndView.showError("에러");
		}		
	}
	
}
