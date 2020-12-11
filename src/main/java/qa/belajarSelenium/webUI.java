package qa.belajarSelenium;

import static org.testng.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class webUI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		WebDriver driver;
		WebDriverWait wait;
		
		//set driver
		System.setProperty("webdriver.chrome.driver","C:\\Users\\CCA\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 10);
		driver.get("https://demo.opensourcepos.org/login/");
		String title = driver.getTitle();
		
		//object repository
		By inputUsername = By.xpath("//body/div[@id='login']/form[1]/div[1]/div[2]/div[1]/input[1]");
		By inputPassword = By.xpath("//body/div[@id='login']/form[1]/div[1]/div[2]/div[2]/input[1]");
		By btnLogin = By.xpath("//body/div[@id='login']/form[1]/div[1]/div[2]/input[1]");
		
		//action
		driver.findElement(inputUsername).sendKeys("admin");
		driver.findElement(inputPassword).sendKeys("password");
		driver.findElement(btnLogin).click();
		
		//assertion
		String errorMessage = driver.findElement(By.xpath("//div[contains(text(),'Geçersiz Kullanıcı Adı veya Parola.')]")).getText();
		Assert.assertEquals("Geçersiz Kullanıcı Adı veya Parola.", errorMessage);
		System.out.println("Web title: " + title);
		driver.quit();
		
	
	}
}