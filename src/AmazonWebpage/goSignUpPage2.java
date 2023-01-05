package AmazonWebpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class goSignUpPage2 {

		WebDriver driver = null;


		public void goToSignupPage() {
			String baseUrl = "https://www.amazon.com/";
			System.setProperty("webdriver.chrome.driver","C:\\Users\\davet\\Downloads\\chromedriver_win32(1)\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(baseUrl);
			WebElement signinButton = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
			signinButton.click();
			WebElement createaccountLink = driver.findElement(By.id("createAccountSubmit"));
			createaccountLink.click();
			
			WebElement customerName = driver.findElement(By.id("ap_customer_name"));
			WebElement emailInput = driver.findElement(By.id("ap_email"));
			WebElement passwordInput = driver.findElement(By.id("ap_password"));
			WebElement passwordInput2 = driver.findElement(By.id("ap_password_check"));
			WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"auth-continue\"]/span"));
			
			customerName.sendKeys("12");
			emailInput.sendKeys("invalidEmail");
			passwordInput.sendKeys("123456");
			passwordInput2.sendKeys("12345");
			continueButton.click();
			
		}
}