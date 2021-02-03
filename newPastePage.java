package com.thomsonreuters.ctrack.qa.rcj.cms.step.calendar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class newPastePage
{
	protected WebDriver driver;

	private By titleBy = By.name("PostForm[name]");
	private By highlightBy = By.id("select2-postform-format-container");
	private By highlightValue = By.xpath("//li[text()='Bash']");
	private By expirationValue = By.xpath("//li[text()='10 Minutes']");
	private By codeBy = By.name("PostForm[text]");
	private By expirationBy = By.id("select2-postform-expiration-container");
	private By submitBy = By.xpath("//*[@id=\"w0\"]/div[5]/div[1]/div[8]/button");

	public newPastePage(WebDriver driver)
	{
		this.driver = driver;
	}

	public newPastePage enterPaste(String title, String code)
	{
		driver.findElement(codeBy).sendKeys(code);
		driver.findElement(titleBy).sendKeys(title);
		WebElement highlightDrpdwn = driver.findElement(highlightBy);
		highlightDrpdwn.click();
		driver.findElement(highlightValue).click();
		WebElement expirationDrpdwn = driver.findElement(expirationBy);
		expirationDrpdwn.click();
		driver.findElement(expirationValue).click();

		return new newPastePage(driver);
	}

	public String getTitle()
	{
		return driver.findElement(titleBy).getText();
	}

	public String getPaste()
	{
		return driver.findElement(codeBy).getText();
	}

	public String getStyle()
	{
		return driver.findElement(highlightBy).getText();
	}

	public void submit()
	{
		driver.findElement(submitBy).click();
	}
}
