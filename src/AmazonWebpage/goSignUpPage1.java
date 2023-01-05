package AmazonWebpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class goSignUpPage1 {

	public static void main(String[] args) {
		String browser = "chrome";
		WebDriver driver = null;

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "\\Users\\davet\\Downloads\\chromedriver_win32(1)\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.firefox.driver", "\\Users\\davet\\Downloads\\chromedriver_win32(1)\\chromedriver.exe");
			driver = new FirefoxDriver();
		}

		driver.get("http://google.com");
		WebElement searchInputBox = driver.findElement(By.name("q"));
		searchInputBox.sendKeys("talentTech");
		WebElement body =  driver.findElement(By.tagName("body"));
		body.click();
		//driver.close();
	}

}