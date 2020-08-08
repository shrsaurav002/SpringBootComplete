package com.customer.service;

public interface EmailServiceInt {

	String sendPic(String from, String to, byte[] oldPic, byte[] newPic);

}
