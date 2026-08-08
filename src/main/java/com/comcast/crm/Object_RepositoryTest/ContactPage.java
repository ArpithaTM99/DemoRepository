package com.comcast.crm.Object_RepositoryTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	WebDriver driver;
	public ContactPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "dvHeaderText")
	private WebElement headerMsg;
	
	@FindBy(xpath="//img[@title='Crate Contact...']")
	private WebElement createNewOrgBtn;
	
	public WebElement getHeaderMsg() {
		return headerMsg;
	}

	public WebElement getCreateNewOrgBtn() {
		return createNewOrgBtn;
	}
		

}
