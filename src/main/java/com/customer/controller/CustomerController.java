package com.customer.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.customer.profileDTO.ProfileDTO;
import com.customer.service.EmailService;
import com.customer.service.ProfileService;

@Controller
public class CustomerController {
	@Autowired
	private ProfileService profileService;

//	@Autowired
//	private JavaMailSender mailSender;
//	
	@Autowired
	private EmailService emailService;

	@GetMapping("/signup")
	public String registers() {
		return "register";
	}

	@PostMapping("/signup")
	public String register(@ModelAttribute ProfileDTO profileDTO, Model model) {
		String password = PasswordGenerate.generateRandomPassword(5);
		profileDTO.setPassword(password);
		profileDTO.setUsername(profileDTO.getEmail());

		int i = profileService.signup(profileDTO);
		if (i != 0) {
			model.addAttribute("msg", "Hi " + profileDTO.getName() + ", you have successfully signed up.");
		} else {
			model.addAttribute("msg", "Error Occured! Try Again");
		}

		return "login";
	}

	@GetMapping("/delete")
	public String DeleteData(@RequestParam("email") String email, Model model) {

		try {
			profileService.delete(email);
			model.addAttribute("success", "Successfully Deleted");

		} catch (Exception e) {

			model.addAttribute("Success", "Error Occured");
		}

		return "redirect:/displayprofile";

	}

	@GetMapping("/pagination")
	public String DisplayPage(Model model, @RequestParam("num") int num) {
		ArrayList<ProfileDTO> users = profileService.profileWithPage(num);
		ArrayList<String> qual = (ArrayList<String>) profileService.qual();
		Double numData = profileService.totalData();
		model.addAttribute("numData", Math.ceil(numData / 3));
		model.addAttribute("qual", qual);
		model.addAttribute("data", users);

		return "wall3";
	}

	@GetMapping("/displayprofile")
	public String DisplayProfile(Model model) {

		ArrayList<ProfileDTO> users = profileService.profile();
		ArrayList<String> qual = (ArrayList<String>) profileService.qual();

		model.addAttribute("qual", qual);
		model.addAttribute("data", users);

		return "wall";

	}

	@GetMapping("/load/image")
	public void findPhoto(@RequestParam String username, HttpServletResponse response) throws IOException {

		response.setContentType("image/png");

		byte[] photo = profileService.srchUserForImage(username);
		ServletOutputStream outputStream = response.getOutputStream();
		if (photo != null && photo.length > 0) {
			outputStream.write(photo);
			outputStream.flush();
		}
		outputStream.close();
	}

	@GetMapping("/displayprofile1")
	public String DisplayProfileByImage(Model model) {

		ArrayList<ProfileDTO> users = profileService.findAllWithPhoto();
		ArrayList<String> qual = (ArrayList<String>) profileService.qual();

		model.addAttribute("qual", qual);
		model.addAttribute("data", users);

		return "wall2";

	}

	@GetMapping("/editData")

	public String EditData(@RequestParam("email") String email, Model model) {

		ProfileDTO profileDTO = profileService.edit(email);
		model.addAttribute("user", profileDTO);
		return "editdata";
	}

	@GetMapping("/loggedUser")

	public String LoggedUser(Model model) {
		Set<ProfileDTO> loggedUsers = ProfileDTO.loggedInUser();
		model.addAttribute("data", loggedUsers);
		return "loggedUser";

	}

	@GetMapping("/manage")

	public String manage() {
		return "manage";
	}

	@PostMapping("/qualfilter")

	public String qualFilter(@RequestParam("qualification") String qual, Model model) {

		ArrayList<ProfileDTO> users = profileService.qualfilter(qual);
		ArrayList<String> q = (ArrayList<String>) profileService.qual();

		model.addAttribute("qual", q);
		model.addAttribute("data", users);
		return "wall";

	}

	@PostMapping("/search")
	public String searchServ(@RequestParam("search") String search, Model model) {

		ArrayList<ProfileDTO> users = profileService.dbsearch(search);
		ArrayList<String> qual = (ArrayList<String>) profileService.qual();
		model.addAttribute("qual", qual);
		model.addAttribute("data", users);
		return "wall";

	}

	@GetMapping("/sort")
	public String sortProfile(@RequestParam("order") String sort, Model model) {
		ArrayList<ProfileDTO> users = profileService.sort(sort);
		ArrayList<String> qual = (ArrayList<String>) profileService.qual();

		model.addAttribute("qual", qual);
		model.addAttribute("data", users);
		return "wall";

	}

	@GetMapping("email")
	public String sendEmail() {
		return "email";
	}

	@PostMapping("/update1")
	public String updateData(@ModelAttribute ProfileDTO profileDTO, Model model) {
		int a = profileService.update(profileDTO);
		if (a != 0) {
			model.addAttribute("success", "Updated Successfully");
		} else {
			model.addAttribute("success", "Updating Error!! Please Try Again.");

		}
		return "redirect:/displayprofile";

	}

	@GetMapping("/signupImage")
	public String imagesign() {
		return "signupImage";
	}

	@PostMapping("/signupImage")
	public String imageSingUp(@ModelAttribute ProfileDTO profileDTO, Model model) {

		String password = PasswordGenerate.generateRandomPassword(5);
		profileDTO.setPassword(password);
		profileDTO.setUsername(profileDTO.getEmail());

		int i = profileService.registerNew(profileDTO);
		if (i != 0) {
			model.addAttribute("msg", "Hi " + profileDTO.getName() + ", you have successfully signed up.");
		} else {
			model.addAttribute("msg", "Error Occured! Try Again");
		}

		return "login";
	}

	@PostMapping("/sendMail")
	public String send(@RequestParam("sendMsgEmail") String email, @RequestParam("subject") String subject,
			@RequestParam("message") String message) {
		// sendEmail(email, subject, message);
		return "redirect:/displayprofile1";

	}

	@PostMapping("/changeImage")
	public String changeImage(@RequestParam("file") MultipartFile file, @RequestParam("username") String username,
			@RequestParam("email") String email, Model model) {

		byte[] oldPic = profileService.srchUserForImage(username);
		int i = profileService.changeImage(username, file);
		byte[] newPic = profileService.srchUserForImage(username);
		emailService.sendPic("shrsaurav1242@gmail.com", username, oldPic, newPic);
		// sendEmail(email, "Update", "You updated your profile picture");

		// sendMimeEmail(email, "Update with Image", "You updated your profile
		// picture");

		// picture");
		if (i != 0) {
			model.addAttribute("success", "Successfully Updated");
		} else {
		}
		return "redirect:/displayprofile1";
	}

//	private void sendEmail(String email, String sub, String emessage) {
//		String recipientAddress = email;
//		String subject = sub;
//		String message = emessage;
//
//		// prints debug info // System.out.println("To: " + recipientAddress); //
//		;
//
//		// creates a simple e-mail object SimpleMailMessage semail = new
//		SimpleMailMessage semail = new SimpleMailMessage();
//		semail.setTo(recipientAddress);
//		semail.setSubject(subject);
//		semail.setText(message);
//
//		// sends the e-mail
//		mailSender.send(semail);
//	}

	/*
	 * private void sendMimeEmail(String email, String sub, String emessage) {
	 * String htmlText = null; try { File file =
	 * ResourceUtils.getFile("classpath:/email/mail.jsp"); String content =
	 * FileUtils.readFileToString(file); htmlText = content;
	 * 
	 * } catch (Exception e) { System.out.println(e.getMessage());
	 * e.printStackTrace(); }
	 * 
	 * Session session = mailSender.createMimeMessage().getSession(); Message
	 * message = new MimeMessage(session); try {
	 * message.setRecipients(Message.RecipientType.TO,
	 * InternetAddress.parse(email)); message.setSubject(sub);
	 * 
	 * MimeMultipart multipart = new MimeMultipart();
	 * 
	 * BodyPart body = new MimeBodyPart();
	 * 
	 * String base64Image;
	 * 
	 * String html =
	 * "<html><body><b> Hey There,</b><br> You changed your profile picture from <img src=data:image/jpeg;base64,"
	 * // + base64Image + " height=200px>" + "<br>to<br> " +
	 * "<img src=https://www.ldatschool.ca/wp-content/uploads/2014/02/A-teachers-journey-with-student-self-advocacy.jpg height=200px>"
	 * + "</body></html>"; body.setContent(html, "text/html");
	 * multipart.addBodyPart(body); // profileService.
	 * 
	 * body.setHeader("Content-Id", "<image>"); message.setContent(multipart);
	 * mailSender.send((MimeMessage) message); } catch (Exception e) {
	 * System.out.println(e.getLocalizedMessage()); e.getStackTrace(); } }
	 * 
	 * public String imgtostr(Part upload) { InputStream inputStream = null; String
	 * base64Image = null; try { if (upload != null) { inputStream =
	 * upload.getInputStream(); } ByteArrayOutputStream outputStream = new
	 * ByteArrayOutputStream(); byte[] buffer = new byte[4096]; int bytesRead = -1;
	 * 
	 * while ((bytesRead = inputStream.read(buffer)) != -1) {
	 * outputStream.write(buffer, 0, bytesRead); }
	 * 
	 * byte[] imageBytes = outputStream.toByteArray();
	 * 
	 * base64Image = Base64.getEncoder().encodeToString(imageBytes);
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } return base64Image; }
	 */

}
