package rent.controller;

import java.sql.SQLException;

import rent.model.CarDAO;
import rent.view.RunningEndView;

public class CarController {

	// ��� ���� �˻�
	public static void getAllCar(){
		try{
			RunningEndView.getAllCar(CarDAO.getAllCar());
		}catch(SQLException s){
			s.printStackTrace();
			RunningEndView.showError("��� ���� �˻��� ���� �߻�");
		}
	}

	// �𵨸����� �˻�
	public static void getCarModelList() {
		try {
			RunningEndView.getAllCar(CarDAO.getCarModelList());
		} catch (SQLException e) {
			e.printStackTrace();
			RunningEndView.showError("�˻��Ͻ� ���� �����ϴ�.");
		}
	}

	// �������� �˻�
	public static void getCarTypeList() {
		try {
			RunningEndView.getAllCar(CarDAO.getCarTypeList());
		} catch (SQLException e) {
			e.printStackTrace();
			RunningEndView.showError("�˻��Ͻ� ������ �����ϴ�.");
		}
	}
}
