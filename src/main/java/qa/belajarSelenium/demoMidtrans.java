package qa.belajarSelenium;

import static org.testng.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.Dimension;

public class demoMidtrans {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver;
		WebDriverWait wait;

		// set driver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\CCA\\Downloads\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 10);
		String homePage = driver.getWindowHandle();
		driver.get("https://demo.midtrans.com/");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'SIGN UP  →')] ")));
		driver.findElement(By.xpath("//a[contains(text(),'SIGN UP  →')]")).click();
		Thread.sleep(5000);
		driver.switchTo().window(homePage);
		driver.findElement(By.xpath("//a[contains(text(),'BUY NOW')]")).click();
		driver.findElement(By.xpath("//body/div[@id='container']/div[1]/div[1]/div[2]/div[2]/div[2]/img[1]")).click();
		driver.findElement(By.xpath("//label[contains(text(),'Set advanced rules')]")).click();
		driver.findElement(By.xpath("//label[contains(text(),'Redirection')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Start')]")).click();
		driver.quit();
		
		
	}

}
