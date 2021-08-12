package rent.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import rent.model.dto.RentDTO;
import rent.model.util.DBUtil;

public class RentDAO {

	// 관리자 - 모든 대여 내역 조회
	public static ArrayList<RentDTO> getAllRentList() throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<RentDTO> rentList = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from rent");
			rset = pstmt.executeQuery();
			
			rentList = new ArrayList<RentDTO>();
			while (rset.next()) {
				rentList.add(new RentDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getInt(4), rset.getInt(5), rset.getString(6)));
			}
		} catch(SQLException s){
			s.printStackTrace();
			throw s;
		}finally {
			DBUtil.close(con, pstmt, rset);
		}
		return rentList;
	}
}
