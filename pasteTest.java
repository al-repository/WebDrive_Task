package com.thomsonreuters.ctrack.qa.rcj.cms.step.calendar;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import static net.bytebuddy.matcher.ElementMatchers.is;

public class pasteTest
{
	@Test
	public void test() throws InterruptedException {
		WebDriver webDriver = new FirefoxDriver();
		webDriver.get("https://pastebin.com/");
		newPastePage newPastePage = new newPastePage(webDriver);
		newPastePage.enterPaste("how to gain dominance among developers", "git config --global user.name  \"New Sheriff in Town\"\n"
				+ "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n"
				+ "git push origin master --force");

		webDriver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		String enteredTitle = newPastePage.getTitle();
		String enteredPaste = newPastePage.getPaste();
		String enteredHighlight = newPastePage.getStyle();
		newPastePage.submit();

		createdPastePage createdPastePage = new createdPastePage(webDriver);
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		assertEquals("Title not equal:", enteredTitle, createdPastePage.getTitle());
		assertEquals("Paste not equal:", enteredPaste, createdPastePage.getPaste());
		assertEquals("Highlight not equal:", enteredHighlight, createdPastePage.getStyle());
		webDriver.quit();
		webDriver.close();
	}
}
