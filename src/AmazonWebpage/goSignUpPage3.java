package AmazonWebpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class goSignUpPage3 {

	WebDriver driver = null;

	@Test

	public void goToSignupPage() throws InterruptedException {
		String baseUrl = "https://www.amazon.com/";
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\davet\\Downloads\\chromedriver_win32(1)\\chromedriver.exe");
		driver = new ChromeDriver(); // open up the chrome driver
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

		customerName.sendKeys("Joe");
		Thread.sleep(100); // It will pause for a second
		emailInput.sendKeys("invalidEmail");
		Thread.sleep(100);
		passwordInput.sendKeys("123456");
		Thread.sleep(100);
		passwordInput2.sendKeys("123456");
		Thread.sleep(100);
		// System.out.println(continueButton.getText()); show you can get text in any
		// element
		continueButton.click();
		Thread.sleep(100);

		WebElement errormessageElement = driver
				.findElement(By.xpath("//*[@id=\"auth-email-invalid-claim-alert\"]/div/div"));
		WebElement errorIcon = driver.findElement(
				By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/form/div/div/div[2]/div[4]/div/i"));

		String errormessage = errormessageElement.getText();
		Assert.assertEquals(errormessage,
				"Wrong or Invalid email address or mobile phone number. Please correct and try again.");
		Assert.assertEquals(errorIcon.isDisplayed(), true); // false, "Icon was not displayed" can add to your test

	}

	@Test
	public void noSixCharactersTest() {

		String baseUrl = "https://www.amazon.com/";
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\davet\\Downloads\\chromedriver_win32(1)\\chromedriver.exe");
		driver = new ChromeDriver(); // open up the chrome driver
		driver.get(baseUrl);

		WebElement signinButton = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
		signinButton.click();
		WebElement createaccountLink = driver.findElement(By.id("createAccountSubmit"));
		createaccountLink.click();

		// *[@id="auth-password-invalid-password-alert"]/div/div

		// System.out.println(errormessage);

	}
}
