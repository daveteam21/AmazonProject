package AmazonWebpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class goSignUpPage5 {

	WebDriver driver = null;

	@BeforeClass

	public void goSignUpPage() {
		String baseUrl = "https://www.amazon.com/";
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\davet\\Downloads\\chromedriver_win32(1)\\chromedriver.exe");
		driver = new ChromeDriver(); // open up the chrome driver
		driver.get(baseUrl);

		WebElement signinButton = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
		signinButton.click();
		WebElement createaccountLink = driver.findElement(By.id("createAccountSubmit"));
		createaccountLink.click();
	}

	@Test
	public void noMatchingPassword() throws InterruptedException {

		WebElement customerName = driver.findElement(By.id("ap_customer_name"));
		WebElement emailInput = driver.findElement(By.id("ap_email"));
		WebElement passwordInput = driver.findElement(By.id("ap_password"));
		WebElement passwordInput2 = driver.findElement(By.id("ap_password_check"));
		WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"auth-continue\"]/span"));

		customerName.sendKeys("Joe");
		emailInput.sendKeys("VaildEmail@gmail.com");
		passwordInput.sendKeys("123456");
		passwordInput2.sendKeys("#$%111");
		continueButton.click();
		Thread.sleep(100);
	}

//	@AfterClass
//	public void closeBrowser() {
	//	driver.quit();
//	}
}
