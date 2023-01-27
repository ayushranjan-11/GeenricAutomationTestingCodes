
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class RahulShettyLinkTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// WebDriver driver = new EdgeDriver();
		// WebDriver driver = new EdgeDriver();
		// WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		RahulShettyLinkTest rslt = new RahulShettyLinkTest();
		rslt.inputProvideLoginPage(driver, "Ayush", "Ayush@123");
		rslt.forgotPasswordPage(driver);
		String passwordGet = rslt.forgotPasswordPageInput(driver);
		Thread.sleep(5000);
		String passwordFinal = passwordGet(passwordGet);
		rslt.inputProvideLoginPageToLoginNow(driver, "Ayush", passwordFinal);
		Thread.sleep(5000);
		rslt.verifyingPageAfterLogin(driver);
		Thread.sleep(2000);
		rslt.visitUsButtonClick(driver);
	}

	public void inputProvideLoginPage(WebDriver driver, String userName, String password) {

		// provide link to browser
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.navigate().to("https://rahulshettyacademy.com/locatorspractice/");
		// Provide inputs to the available field. Input is given by .sendKeys()
		driver.findElement(By.id("inputUsername")).sendKeys(userName);
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='chkboxOne']")).click();
		driver.findElement(By.className("signInBtn")).click();

		// As below code requires time so we have to add wait.Below code add wait to the
		// code for item to be visible.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println(driver.findElement(By.cssSelector(".error")).getText());
	}

	public void forgotPasswordPage(WebDriver driver) {
		driver.findElement(By.linkText("Forgot your password?")).click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// driver.findElement(By.xpath("//button[normalize-space()='Go to
		// Login']")).click();
		// This xpath is pure from the parent and child traverse
		driver.findElement(By.xpath("//div/button[@class='reset-pwd-btn']")).click();
	}

	// In this method we are grabbing displayed text and extracting password
	public String forgotPasswordPageInput(WebDriver driver) throws InterruptedException {
		// Name input
		driver.findElement(By.xpath("//form/input[@placeholder='Name']")).sendKeys("Ayush");
		driver.findElement(By.xpath("//form/input[@placeholder='Email']")).sendKeys("ayush@yopmail.com");
		driver.findElement(By.xpath("//form/input[@placeholder='Phone Number']")).sendKeys("ayush@yopmail.com");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//form/input[@placeholder='Phone Number']")).clear();
		driver.findElement(By.xpath("//form/input[@placeholder='Phone Number']")).sendKeys("7033525577");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[normalize-space()='Reset Login']")).click();
		System.out.println(driver.findElement(By.xpath("//p[@class='infoMsg']")).getText());
		String infoText = driver.findElement(By.xpath("//p[@class='infoMsg']")).getText();

		// Login text button to Sign in page
		driver.findElement(By.xpath("//button[normalize-space()='Go to Login']")).click();

		return infoText;
	}

	public void inputProvideLoginPageToLoginNow(WebDriver driver, String userName, String password) {

		// provide link to browser
		// driver.get("https://rahulshettyacademy.com/locatorspractice/");
		// Provide inputs to the available field. Input is given by .sendKeys()
		driver.findElement(By.id("inputUsername")).sendKeys(userName);
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		// driver.findElement(By.xpath("//input[@id='chkboxOne']")).click();

		boolean isChecked = driver.findElement(By.xpath("//input[@id='chkboxOne']")).isEnabled();
		System.out.println(isChecked);
		if (!isChecked) {
			driver.findElement(By.xpath("//input[@id='chkboxOne']")).click();
		} else {
			System.out.println("Checkbox is already checked");
		}

		driver.findElement(By.className("signInBtn")).click();

	}

	public void verifyingPageAfterLogin(WebDriver driver) {

		String loginSuccessfulTextGrab = driver
				.findElement(By.xpath("//p[normalize-space()='You are successfully logged in.']")).getText();
		// TestNG framework method Assert
		Assert.assertEquals(
				driver.findElement(By.xpath("//p[normalize-space()='You are successfully logged in.']")).getText(),
				"You are successfully logged in.");
		if (loginSuccessfulTextGrab != null) {
			// System.out.println(loginSuccessfulTextGrab);
			driver.findElement(By.className("logout-btn")).click();

		} else {
			System.out.println("Login failed");
		}

	}

	public void visitUsButtonClick(WebDriver driver) {
		driver.findElement(By.xpath("//button[@id='visitUsTwo']")).click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}

	// This method splits the sentence and extract text which is password
	public static String passwordGet(String textGrab) { // textGrab = Please use temporary password 'rahulshettyacademy'
														// to Login.

		String[] textArray = textGrab.split("'"); // 0th index = Please use temporary password 1st index =
													// rahulshettyacademy' to Login.
		// String semiFinalPassword = textArray[1];
		String finalPassword = textArray[1].split("'")[0]; // textArray[1]= rahulshettyacademy' to Login. (Now this will
															// be split with .split("'")[0] command)
		// finalPassword will save rahulshettyacademy with this .split("'")[0] command.

//		String[] secondTextArray = semiFinalPassword.split("'");
//		String finalPassword = secondTextArray[0];
//		Ye upar jo 2 command hai ye wahi karenge jo "textArray[1].split("'")[0]" karenge 

		return finalPassword;
	}

}
