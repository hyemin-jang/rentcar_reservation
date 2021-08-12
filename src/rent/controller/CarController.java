package rent.controller;

import java.sql.SQLException;

import rent.model.CarDAO;
import rent.model.RentDAO;
import rent.model.dto.CarDTO;
import rent.view.RunningEndView;

public class CarController {
	// ��� ���� �˻�
	public static void getAllCar(){
		try{
			RunningEndView.getAllList(CarDAO.getAllCar());
		}catch(SQLException s){
			s.printStackTrace();
			RunningEndView.showError("��� ���� �˻��� ���� �߻�");
		}
	}

	// �𵨸����� �˻�
	public static void getCarModelList() {
		try {
			RunningEndView.getAllList(CarDAO.getCarModelList());
		} catch (SQLException e) {
			e.printStackTrace();
			RunningEndView.showError("�˻��Ͻ� ���� �����ϴ�.");
		}
	}

	// �������� �˻�
	public static void getCarTypeList() {
		try {
			RunningEndView.getAllList(CarDAO.getCarTypeList());
		} catch (SQLException e) {
			e.printStackTrace();
			RunningEndView.showError("�˻��Ͻ� ������ �����ϴ�.");
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
		return result;   
	}
	
	// ������ - ���� ���� ����
	public static boolean deleteCar(int id) {
		boolean result = false;
		CarDTO car = null;
		
		try {
			car = CarDAO.getCar(id);   // null
			result = CarDAO.deleteCar(car);
			RunningEndView.showMessage("������ �����߽��ϴ�.");
		} catch (SQLException e) {
			e.printStackTrace();
			RunningEndView.showError("���� ������ �����Ͽ����ϴ�.");
		} catch (NullPointerException e) {
			e.printStackTrace();
			RunningEndView.showError("�ش� ������ �������� �ʽ��ϴ�.");
		}
		return result;   
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

