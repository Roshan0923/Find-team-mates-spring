package com.example.demo.emailNotification;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

@Service
public class EmailSerivce {
	@Autowired
	Iuser_req_p repository;
	
	@Autowired
	private JavaMailSender sender;
	
	@Autowired
	private Configuration config;
	
	public MailResponse sendEmail(MailRequest request, Map<String, Object> model) {
		System.out.println("Inside send mail method");
		MailResponse response = new MailResponse();
		MimeMessage message = sender.createMimeMessage();
		try {
			// set mediaType
			MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
					StandardCharsets.UTF_8.name());
			// add attachment
		//	helper.addAttachment("logo.png", new ClassPathResource("logo.png"));
			String html;
			System.out.println("printing the vlue"+request.getNum());
			if(request.getNum()==1)
			{
				System.out.println("Sending Congratulation mail");
				Template t = config.getTemplate("email-template.ftlh");
				 html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
			}
			else {
				System.out.println("Sending rejection mail");
				Template t1 = config.getTemplate("disqualified-email-template.ftlh");
				 html = FreeMarkerTemplateUtils.processTemplateIntoString(t1, model);
			}
			

			helper.setTo(request.getTo());
			helper.setText(html, true);
			helper.setSubject(request.getSubject());
			helper.setFrom(request.getFrom());
			sender.send(message);

			response.setMessage("mail send to : " + request.getTo());
			response.setStatus(Boolean.TRUE);

		} catch (MessagingException | IOException | TemplateException e) {
			response.setMessage("Mail Sending failure : "+e.getMessage());
			response.setStatus(Boolean.FALSE);
		}

		return response;
	}
	
	
	
	public void delete_request(int project_id,int req_user_id)
	{
		repository.delete_request(project_id, req_user_id);
	}
	public void update_request_status(int project_id, int requested_user_id) {
		repository.update_request_status(project_id, requested_user_id);
	
	}

}
