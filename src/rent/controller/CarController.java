package rent.controller;

import java.sql.SQLException;

import rent.model.CarDAO;
import rent.model.RentDAO;
import rent.model.dto.CarDTO;
import rent.view.RunningEndView;

public class CarController {
	// ��� ���� �˻� ����
	public static void getAllCar(){
		try{
			RunningEndView.getAllList(CarDAO.getAllCar());
		}catch(SQLException s){
			s.printStackTrace();
			RunningEndView.showError("��� ������Ʈ �˻��� ���� �߻�");
		}
	}
	
	// ������ - ���� ��� ����
	public static boolean addCar(CarDTO car) {
		boolean result = false;
		
		try {
			result = CarDAO.addCar(car);
			RunningEndView.showMessage("������ ����߽��ϴ�.");
		} catch (SQLException e) {
			e.printStackTrace();
			RunningEndView.showError("���� ��Ͽ� �����Ͽ����ϴ�.");
		}
		return result;   // ������� �����Ѱ�� false
	}
	
	
	// ������ - ��� ��Ʈ ���� �˻� ����
	public static void getAllRentList(){
		try{
			RunningEndView.getAllList(RentDAO.getAllRentList());
		}catch(SQLException s){
			s.printStackTrace();
			RunningEndView.showError("����");
		}		
	}
}
