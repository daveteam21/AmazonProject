package AmazonWebpage;

import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonSignUp2 {

	public static void main(String[] args) {
								// key                    value 
		System.setProperty("webdriver.chrome.driver","C:\\Users\\davet\\Downloads\\chromedriver_win32(1)\\chromedriver.exe");
	
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://google.com");
	}

}
