package dao;

import java.util.ArrayList;

import dto.MemberDto;

public interface MemberDao {

	//데이터를 넣기
	public void insert(MemberDto dto);
	
	//데이터를 보고
	//데이터 한개보기
	public void selectOne(String name);
	
	//데이터 전체보기
	public ArrayList<MemberDto> selectAll();
	
	//데이터를 수정
//	public void update(MemberDto dto);



	public void update(MemberDto dto);
	
	
	
	
	
}
