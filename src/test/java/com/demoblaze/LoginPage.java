package com.demoblaze;

import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseDemo{
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	

}
