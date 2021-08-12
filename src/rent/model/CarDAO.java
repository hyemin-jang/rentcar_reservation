package rent.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import rent.model.dto.CarDTO;
import rent.model.util.DBUtil;

public class CarDAO {

	// ��� ���� �˻�
	public static ArrayList<CarDTO> getAllCar() throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<CarDTO> carList = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from car");
			rset = pstmt.executeQuery();
			
			carList = new ArrayList<CarDTO>();
			while (rset.next()) {
				carList.add(new CarDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getInt(5), rset.getString(6)));
			}
		} catch(SQLException s){
			s.printStackTrace();
			throw s;
		}finally {
			DBUtil.close(con, pstmt, rset);
		}
		return carList;
	}

	// �𵨸����� �˻�
	public static ArrayList<CarDTO> getCarModelList() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<CarDTO> carList = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("SELECT * FROM car where model='����ũ'");
			rset = pstmt.executeQuery();
			
			carList = new ArrayList<CarDTO>();
			while (rset.next()) {
				carList.add(new CarDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getInt(5), rset.getString(6)));
			}
		} catch(SQLException s){
			s.printStackTrace();
			throw s;
		}finally {
			DBUtil.close(con, pstmt, rset);
		}
		return carList;
	}
	
	// �������� �˻�
	public static ArrayList<CarDTO> getCarTypeList() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<CarDTO> carList = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("SELECT * FROM car where cartype='����'");
			rset = pstmt.executeQuery();
			
			carList = new ArrayList<CarDTO>();
			while (rset.next()) {
				carList.add(new CarDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getInt(5), rset.getString(6)));
			}
		} catch(SQLException s){
			s.printStackTrace();
			throw s;
		}finally {
			DBUtil.close(con, pstmt, rset);
		}
		return carList;
	}
	
	// ���� �߰�
	public static boolean addCar(CarDTO car) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into car values (?,?,?,?,?,?)");
			pstmt.setInt(1, car.getCarId());
			pstmt.setString(2, car.getModel());
			pstmt.setString(3, car.getBrand());
			pstmt.setString(4, car.getCarType());
			pstmt.setInt(5, car.getPrice());
			pstmt.setString(6, car.getIsRent());
			
			int result = pstmt.executeUpdate();
		
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}	
	
	// ���� ��Ϲ�ȣ�� ���� �˻�
	public static CarDTO getCar(int id) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		CarDTO car = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from car where car_id=?");
			pstmt.setInt(1, id);
			rset = pstmt.executeQuery();
			
			while (rset.next()) {
				car = new CarDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getInt(5), rset.getString(6));
			}
			
		} catch(SQLException s){
			s.printStackTrace();
			throw s;
		}finally {
			DBUtil.close(con, pstmt, rset);
		}
		return car;
	}
	
	// ���� ����
	public static boolean deleteCar(CarDTO car) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("delete from car where car_id=?");
			pstmt.setInt(1, car.getCarId());				
			
			int result = pstmt.executeUpdate();
		
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}	

}