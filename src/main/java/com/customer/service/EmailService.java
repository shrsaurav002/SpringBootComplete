package com.customer.service;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

@Service
public class EmailService implements EmailServiceInt {
	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private SpringTemplateEngine templateEngine;

	@Override
	public String sendPic(String from, String to, byte[] oldPic, byte[] newPic) {
		try {
			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
					StandardCharsets.UTF_8.name());
			Context context = new Context();
			Map<String, Object> props = new HashMap<>();
			props.put("name", from);
			props.put("sign", "By Saurav Shrestha");
			props.put("address", "9451 Lee Hwy, VA");
			props.put("email", "shrsaurav1242@gmail.com");
			context.setVariables(props);
			String html = templateEngine.process("mail", context);
			helper.setTo(to);
			helper.setText(html, true);
			helper.setSubject("Updated your Profile Pic");
			helper.setFrom(from);
			InputStreamSource oldProfilePicSource = new ByteArrayResource(oldPic);
			helper.addInline("oldPhoto", oldProfilePicSource, "image/png");
			InputStreamSource newProfilePicSource = new ByteArrayResource(newPic);
			helper.addInline("newPhoto", newProfilePicSource, "image/png");
			// InputStreamSource oldProfilePicSource=new ByteArrayResource(oldPic)

			File file1 = new ClassPathResource("image/1.png", EmailService.class.getClassLoader()).getFile();
			byte[] bytes = Files.readAllBytes(file1.toPath());
			InputStreamSource signatureSource = new ByteArrayResource(bytes);
			helper.addInline("signature", signatureSource, "image/png");

			javaMailSender.send(message);

		} catch (Exception e) {
			e.getStackTrace();
			System.out.println(e.getMessage());
		}
		return "done";
	}
}
