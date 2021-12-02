package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.MemberDto;

public class MemberDaoImpl implements MemberDao {

	private Connection conn; //DB 커넥션 연결 객체
	private static final String USERNAME = "root";//DBMS접속 시 아이디
	private static final String PASSWORD = "1234";//DBMS접속 시 비밀번호
	private static final String URL = "jdbc:mysql://localhost:3306/aidb";//DBMS접속할 db명
	//생성자에 연결

	public MemberDaoImpl() {

		//디비 연결부분
		try {
			System.out.println("생성자");
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("드라이버 로딩 성공");
		} catch (Exception e) {
			System.out.println("드라이버 로딩 실패 ");
			e.printStackTrace();//예외발생시 일어난 오류를 자세하게 알려줌
			try {
				conn.close();
			} catch (SQLException e1) {    }
		}

	}
	@Override
	public void insert(MemberDto dto) {
		String sql = "INSERT INTO member (num, name, major,email) VALUES (?,?,?,?)";

		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getNum());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getMajor());
			pstmt.setString(4, dto.getEmail());

			int result = pstmt.executeUpdate();
			if(result==1) {
				System.out.println("데이터 삽입 성공!");
			}
		} catch (Exception e) {
			System.out.println("데이터 삽입 실패!");
		}    finally {
			try {
				if(pstmt!=null && !pstmt.isClosed()) {
					pstmt.close();
				}
			} catch (Exception e2) {}
		}
	}

	@Override
	public void selectOne(String name) {
//		MemberDto dto=new MemberDto();
		String sql = "SELECT * FROM member WHERE name = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
//				dto.getNum()=rs.getInt("num");
				System.out.println("num: " + rs.getInt("num"));
				System.out.println("name: " + rs.getString("name"));
				System.out.println("major: " + rs.getString("major"));
				System.out.println("email: " + rs.getString("email"));
			}
		} catch (Exception e) {
			System.out.println("select 메서드 예외발생");
		}    finally {
			try {
				if(pstmt!=null && !pstmt.isClosed()) {
					pstmt.close();
				}
			} catch (Exception e2) {}
		}
		
	}

	@Override
	public ArrayList<MemberDto> selectAll() {
		String sql = "select * from member";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			//			pstmt.setInt(1, num);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("num: " + rs.getInt("num"));
				System.out.println("name: " + rs.getString("name"));
				System.out.println("major: " + rs.getString("major"));
				System.out.println("email: " + rs.getString("email"));
			}
		} catch (Exception e) {
			System.out.println("select 메서드 예외발생");
		}    finally {
			try {
				if(pstmt!=null && !pstmt.isClosed()) {
					pstmt.close();
				}
			} catch (Exception e2) {}
		}
		return null;
	}


	@Override
	public void update(MemberDto dto) {
		String sql = "UPDATE member SET email = ? WHERE  num = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getEmail());
			pstmt.setInt(2, dto.getNum());
			pstmt.executeUpdate();
//			System.out.println("수정된 id: " + id);

		} catch (Exception e) {
			System.out.println("update 예외 발생");
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			} catch (Exception e2) {
			}
		}

	}
	
	public int selectNameEmail(String name, String email) {
		String sql = "SELECT num FROM member WHERE name = ? AND email = ?";
		int num = 0;
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				num = rs.getInt("num");
			}

		} catch (Exception e) {
			System.out.println("SELECT 메서드 예외발생");
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			} catch (Exception e2) {
			}
		}
		return num;
	}





}
