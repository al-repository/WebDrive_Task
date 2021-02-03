package com.thomsonreuters.ctrack.qa.rcj.cms.step.calendar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class createdPastePage
{
	protected WebDriver driver;

	private By titleBy = By.className("info-top");
	private By styleBy = By.className("btn -small h_800");
	private By pasteBy = By.className("textarea");

	public createdPastePage(WebDriver driver){
		this.driver = driver;
	}

	public String getTitle() {
		return driver.findElement(titleBy).getText();
	}

	public String getPaste(){
		return driver.findElement(pasteBy).getText();
	}

	public String getStyle(){
		return driver.findElement(styleBy).getText();
	}


}
