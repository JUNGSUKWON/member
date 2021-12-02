package member;

import java.util.ArrayList;

import com.jsw.util.Util;

import dao.MemberDao;
import dao.MemberDaoImpl;
import dto.MemberDto;

public class MainClass {

	
	public static void main(String[] args) {
		
		//파일에 있는 데이터를 읽어오기
		String filePath="C:\\dev\\file\\전공정보.txt";
		//멤버 정보 DB활용
		MemberDaoImpl dao = new MemberDaoImpl();
//		
		
//		System.out.println("쉼표로 구분되는 데이터 갯수: "+spData.length);
		//읽어온 데이터를 DB에 넣기
		Member member = new Member();
		ArrayList<MemberDto>list=member.getDtoList(filePath);//읽어온데이터
//		for(MemberDto d:list) {
//			System.out.println(d);
//		}
		
//		for(MemberDto d:list) {
//			dao.insert(d);
//		}
		
		//데이터 보기
		
//		ArrayList<MemberDto>slist = dao.selectAll();//전체 다보기
		dao.selectOne("정석원");//하나만 보기

		//데이터 수정
//		dao.update(5);
		
		
	}
}
