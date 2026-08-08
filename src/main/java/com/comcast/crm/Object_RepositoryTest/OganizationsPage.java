package com.comcast.crm.Object_RepositoryTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OganizationsPage {
	WebDriver driver;
	public OganizationsPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "img[@title='Create Organization...']")
	private WebElement createNewOrgBtn;
	
	public WebElement getCreateNewOrgBtn() {
		return createNewOrgBtn;
	}
	
	
	
	

}
