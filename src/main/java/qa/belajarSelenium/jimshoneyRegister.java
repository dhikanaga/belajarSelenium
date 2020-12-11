package qa.belajarSelenium;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.github.javafaker.Faker;

public class jimshoneyRegister {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// set driver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\CCA\\Downloads\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.get("https://jimshoneyofficial.com/");

		Faker fake = new Faker();
		String nik = fake.idNumber().valid().replaceAll("[^a-zA-Z0-9]", "");
		String userName = fake.name().fullName().replaceAll("[^a-zA-Z0-9]", "");
		String email = userName + "@mail.com";
		String password = nik + userName;
		

		WebElement btnProfile = driver
				.findElement(By.xpath("//header/div[1]/div[2]/div[1]/div[4]/ul[1]/li[3]/a[1]/i[1]"));
		WebElement fieldKTP = driver.findElement(By.id("idnumber"));
		WebElement fieldBirthday = driver.findElement(By.cssSelector("#birthday"));
		Select oselect = new Select(driver.findElement(By.id("gender")));
		WebElement fieldUserName = driver.findElement(By.id("reg_username"));
		WebElement fieldEmail = driver.findElement(By.id("reg_email"));
		WebElement fieldPassword = driver.findElement(By.id("reg_password"));
		WebElement btnRegister = driver.findElement(By.name("register"));

		btnProfile.click();
		fieldKTP.sendKeys(nik + nik);
		fieldBirthday.sendKeys("22101984");
		oselect.selectByVisibleText("Male");
		fieldUserName.sendKeys(userName);
		fieldEmail.sendKeys(email);
		fieldPassword.sendKeys(password);
		btnRegister.click();

		String confirmationMessage = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div/div")).getText();
		Assert.assertEquals("We sent you a verification email. Check and verify your account. Resend Confirmation Email", confirmationMessage);

		driver.quit();

	}
}
