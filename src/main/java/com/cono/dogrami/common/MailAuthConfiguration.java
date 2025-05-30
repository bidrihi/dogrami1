package com.cono.dogrami.common;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailAuthConfiguration {
	@Bean
    public JavaMailSender NaverMailService(){
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();

        javaMailSender.setHost("smtp.naver.com");  // SMTP 서버명
        javaMailSender.setUsername("s941204"); // 네이버 아이디
        javaMailSender.setPassword("s12357"); // 네이버 비밀번호

        javaMailSender.setPort(465); // SMTP 포트

        javaMailSender.setJavaMailProperties(getMailProperties()); // 메일 인증서버 가져오기

        return javaMailSender;
    }

    // 메일 인증서버 정보 가져오기
	private Properties getMailProperties() {
	    Properties properties = new Properties();
	    properties.setProperty("mail.transport.protocol", "smtps"); // 프로토콜 설정
	    properties.setProperty("mail.smtps.auth", "true"); // smtps 인증
	    properties.remove("mail.smtp.starttls.enable"); // smtp strattles 사용 제거
	    properties.setProperty("mail.debug", "true"); // 디버그 사용 
	    properties.setProperty("mail.smtp.ssl.trust", "smtp.naver.com"); // ssl 인증 서버 (smtp 서버명) 
	    properties.setProperty("mail.smtps.ssl.enable", "true"); // smtps SSL 사용 

	    return properties;
	}
}
