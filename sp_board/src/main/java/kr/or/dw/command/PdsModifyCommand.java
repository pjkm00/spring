package kr.or.dw.command;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kr.or.dw.vo.PdsVO;
import lombok.Data;

@Data
public class PdsModifyCommand extends PdsRegistCommand{

	private int pno;
	private int[] deleteFile;
	
	@Override
	public PdsVO toPdsVO() {
		PdsVO pds = super.toPdsVO();
		pds.setPno(pno);
		return pds;
	}
	
	
}
