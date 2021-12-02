package member;

import java.util.ArrayList;

import com.jsw.util.Util;

import dto.MemberDto;

public class Member {
	
	public ArrayList<MemberDto> getDtoList(String filePath) {
		
		ArrayList<MemberDto> reList = new ArrayList<MemberDto>();
		ArrayList<String> spList=Util.readLineFileList(filePath);
		for(String s:spList) {
			MemberDto dto = new MemberDto();
			String[]sp = s.split(",");
			dto.setNum(Integer.parseInt(sp[0]));
			dto.setName(sp[1]);
			dto.setMajor(sp[2]);
			dto.setEmail(sp[3]);
			reList.add(dto);
		}
		return reList;
	
	}
}
