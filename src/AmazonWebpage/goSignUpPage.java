package AmazonWebpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class goSignUpPage {

	WebDriver driver = null;

	@BeforeClass
	public void goToSignupPage() {
		String baseUrl = "https://www.amazon.com/";
		System.setProperty("webdriver.chrome.driver","C:\\Users\\davet\\Downloads\\chromedriver_win32(1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(baseUrl);
		WebElement signinButton = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
		signinButton.click();
		WebElement createaccountLink = driver.findElement(By.id("createAccountSubmit"));
		createaccountLink.click();
	}
	

	@Test
	public void invalidEmailSignUpTest() throws InterruptedException {
		signUp("invalidEmail", "Abcdefgh1&");
		Thread.sleep(1000);
		WebElement errorTextElement = driver.findElement(By.id("ap_email"));   // here 
		WebElement errorIcon = driver.findElement(By.xpath("//form/div[1]/div[2]/*[name()='svg']"));

		String errorText = errorTextElement.getText();
		Assert.assertEquals(errorText, "Wrong or Invalid email address or mobile phone number. Please correct and try again.");

		Assert.assertEquals(errorIcon.isDisplayed(), true, "Icon was not displayed");

	}

	/*@Test
	public void noNumberPasswordTest() {
		signUp("validemail@gmail.com", "A&abcdethf");
		WebElement errorIcon = driver.findElement(By.xpath("//form/div[2]/div[2]/*[name()='svg']"));
		Assert.assertEquals(errorIcon.isDisplayed(), true, "Error icon wasa not displayed");
		
		WebElement validationIcon = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[1]/div/div[3]/li[3]/*[name()='svg']/*[name()='circle']"));
		String fillColor = validationIcon.getAttribute("fill");
		Assert.assertEquals(fillColor, "#D9212C", "Citcle icon is not red");
	}
*/
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

	public void signUp(String email, String password) {
		WebElement emailInput = driver.findElement(By.name("email"));
		WebElement passwordInput = driver.findElement(By.name("new-password"));
		WebElement signUpButton = driver.findElement(By.xpath("//button[1]/span[1]"));

		emailInput.sendKeys(email);
		passwordInput.sendKeys(password);
		signUpButton.click();
	}
}