package com.cono.dogrami.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

@Component("filedown")  //설정파일에 자동 등록 처리함
public class FileDownloadView extends AbstractView {
	//스프링에서는 뷰클래스를 만들려면,
	//스프링이 제공하는 AbstractView 를 상속받아서
	//오버라이딩한 메소드 안에 기능을 구현하도록 되어 있음

	@Override
	protected void renderMergedOutputModel(
			Map<String, Object> model, 
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 파일 다운로드 처리용 코드 구현함
		// 컨트롤러 메소드에서 리턴한 모델의 값(파일객체)을 추출해서
		// 폴더에서 파일을 읽어서 클라이언트로 파일을 출력(전송) 처리
		
		//컨트롤러에서 뷰리졸버(BeanNameViewResolver)를 거쳐
		//전달된 model 의 정보 추출
		File renameFile = (File)model.get("renameFile");
		File downFile = (File)model.get("originFile");
		
		//한글 파일명 깨지지 않도록 인코딩 처리를 위해 파일명만 추출
		String fileName = downFile.getName();
		
		//클라이언트로 전송하기 위한 설정
		response.setContentType("text/plain; charset=utf-8");
		response.addHeader("Content-Disposition", 
				"attachment; filename=\""
				+ new String(
					fileName.getBytes("UTF-8"), "ISO-8859-1") 
				+ "\"");
		response.setContentLength((int)renameFile.length());
		
		//파일 입출력에 대한 스트림 생성함
		FileInputStream fin = new FileInputStream(renameFile);
		OutputStream out = response.getOutputStream();
		
		//저장 폴더에서 renameFile 을 read() 해서
		//response 로 write() | print() 함 => 스프링에서 제공
		FileCopyUtils.copy(fin, out);
		
		fin.close();
	}



}






