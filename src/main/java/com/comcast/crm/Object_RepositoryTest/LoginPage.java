package com.comcast.crm.Object_RepositoryTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//Rule1: Create a seprate java class
	//Rule2: Object Creating
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submintButton")
	private WebElement loginbtn;
	
	//Rule3: Object Initialization
	
	//Rule4: Object Encapsulation
	public WebElement getUsername() {
		return usernameEdt;
	}

	public WebElement getPassword() {
		return passwordEdt;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}
	
	//Rule5: provide Action
	public void loginToApp(String url, String username, String password) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get(url);
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginbtn.click();
		
	}
	}


