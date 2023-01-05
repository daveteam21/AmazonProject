package AmazonWebpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class goAmazonSignUpPage {

	WebDriver driver = null;

	@BeforeClass

	public void goSignUpPage() throws InterruptedException {
		String baseUrl = "https://www.amazon.com/";
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\davet\\Downloads\\chromedriver_win32(1)\\chromedriver.exe");
		driver = new ChromeDriver(); // open up the chrome driver
		driver.get(baseUrl);

		WebElement signinButton = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
		signinButton.click();
		Thread.sleep(3000);
		WebElement createaccountLink = driver.findElement(By.id("createAccountSubmit"));
		createaccountLink.click();
		Thread.sleep(3000);
	}
	
	
	public void signUp(String name,String email, String password1, String password2) {
		WebElement customerName = driver.findElement(By.id("ap_customer_name"));
		WebElement emailInput = driver.findElement(By.id("ap_email"));
		WebElement passwordInput = driver.findElement(By.id("ap_password"));
		WebElement passwordInput2 = driver.findElement(By.id("ap_password_check"));
		WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"auth-continue\"]/span"));
		
		customerName.sendKeys(name);
		emailInput.sendKeys(email);
		passwordInput.sendKeys(password1);
		passwordInput2.sendKeys(password2);
		continueButton.click();
		
	}
@Test
	public void invalidEmailSignup() throws InterruptedException {
		signUp("Joe","InvaildEmail.com","1@#$%1", "1@#$%1");
		Thread.sleep(1000); 
		WebElement errormessageElement = driver.findElement(By.id("auth-email-invalid-claim-alert"));
		WebElement errorIcon = driver.findElement(By.xpath("//*[@id=\"auth-email-invalid-claim-alert\"]/div/i"));

		String errormessage = errormessageElement.getText();
		Assert.assertEquals(errormessage,
				"Wrong or Invalid email address or mobile phone number. Please correct and try again.");
		Assert.assertEquals(errorIcon.isDisplayed(), true); // false, "Icon was not displayed" can add to your test

	}
@Test
	public void noSixCharactersTest() throws InterruptedException {
		signUp("Joe","VaildEmail@gmail.com","1@#$%1", "1@#$%1");
		Thread.sleep(1000); 

		WebElement errorPasswordmessageElement = driver.findElement(By.id("auth-password-invalid-password-alert"));
		WebElement errorIcon = driver.findElement(By.xpath("//*[@id=\"auth-passwordCheck-missing-alert\"]/div/i"));

		String errormessage2 = errorPasswordmessageElement.getText();
		Assert.assertEquals(errormessage2, "Minimum 6 characters required");
		Assert.assertEquals(errorIcon.isDisplayed(), true); // false, "Icon was not displayed" can add to your test
	}
@Test
	public void notMatchingPassword() throws InterruptedException {      
		signUp("Joe","VaildEmail@gmail.com","123456", "#$%111");


		WebElement mismatchPasswordmessageElement = driver.findElement(By.id("auth-password-mismatch-alert"));
		WebElement errorIcon3 = driver.findElement(By.xpath("//*[@id=\"auth-password-mismatch-alert\"]/div/i"));

		String errormessage3 = mismatchPasswordmessageElement.getText();
		Assert.assertEquals(errormessage3, "Passwords must match");
		Assert.assertEquals(errorIcon3.isDisplayed(), true); // false, "Icon was not displayed" can add to your test

	}
@Test
	public void noNumbername() throws InterruptedException {

		signUp("11","VaildEmail@gmail.com","1@#$%1", "1@#$%1");
	Thread.sleep(1000);

	}
@Test
	public void invalidMoblieNumber() throws InterruptedException {
		signUp("John Dole","1111111111111111111","1@#$%1", "1@#$%1");
		Thread.sleep(1000);

		WebElement errorMessageElement = driver.findElement(By.xpath("//*[@id=\"auth-error-message-box\"]/div/h4"));
		String problemMessage = errorMessageElement.getText();
		Assert.assertEquals(problemMessage, "There was a problem");
		WebElement errorIcon5 = driver.findElement(By.xpath("//*[@id=\"auth-error-message-box\"]/div/i"));
		Assert.assertEquals(errorIcon5.isDisplayed(), true);

	}
	
@Test
	public void blankInfoNoSignIn() throws InterruptedException {

		signUp("","","","");
		Thread.sleep(3000);
		
		WebElement errorNameElement = driver.findElement(By.xpath("//*[@id=\"auth-customerName-missing-alert\"]/div/div"));
		WebElement erroricon = driver.findElement(By.xpath("//*[@id=\"auth-customerName-missing-alert\"]/div/i"));

		String errormessage3 = errorNameElement.getText();
		Assert.assertEquals(errormessage3, "Enter your name");
		Assert.assertEquals(erroricon.isDisplayed(), true); // false, "Icon was not displayed" can add to your test
		
		WebElement errorEmailElement = driver.findElement(By.xpath("//*[@id=\"auth-email-missing-alert\"]/div/div"));
		WebElement errorIcon = driver.findElement(By.xpath("//*[@id=\"auth-email-missing-alert\"]/div/i"));

		String errormessage = errorEmailElement.getText();
		Assert.assertEquals(errormessage, "Enter your email or mobile phone number");
		Assert.assertEquals(errorIcon.isDisplayed(), true); // false, "Icon was not displayed" can add to your test
		
		WebElement errorPasswordmessageElement = driver.findElement(By.xpath("//*[@id=\"auth-password-missing-alert\"]/div/div"));
		WebElement errorIcon2 = driver.findElement(By.xpath("//*[@id=\"auth-password-missing-alert\"]/div/i"));

		String errormessage2 = errorPasswordmessageElement.getText();
		Assert.assertEquals(errormessage2, "Minimum 6 characters required");
		Assert.assertEquals(errorIcon2.isDisplayed(), true); // false, "Icon was not displayed" can add to your test
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();

}
}