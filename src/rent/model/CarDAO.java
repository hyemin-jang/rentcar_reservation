package rent.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import rent.model.dto.CarDTO;
import rent.model.dto.RentDTO;
import rent.model.util.DBUtil;

public class CarDAO {

	// 모든 차량 조회 
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
	
	
	// 관리자 - 차량 추가
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
	
//	// 관리자 - 차량 삭제
//	public static boolean deleteCar(int id) throws SQLException{
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		try{
//			con = DBUtil.getConnection();
//			pstmt = con.prepareStatement("delete from car where car_id=?");
//			pstmt.setInt(1, car.getCarId());				
//			
//			int result = pstmt.executeUpdate();
//		
//			if(result == 1){
//				return true;
//			}
//		}finally{
//			DBUtil.close(con, pstmt);
//		}
//		return false;
//	}	
	
	
	
}
