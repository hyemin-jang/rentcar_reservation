package rent.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import rent.model.dto.CarDTO;
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
}
