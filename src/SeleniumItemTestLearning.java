import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumItemTestLearning {

	WebElement webEle;
	WebDriverWait waitImplement;

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.navigate().to("https://www.twitter.com");
		driver.navigate().back();
		driver.navigate().forward();
		// driver.quit();

		SeleniumItemTestLearning nonStaticMethod = new SeleniumItemTestLearning();
		nonStaticMethod.staticDropDownSelect(driver);
		Thread.sleep(2000);
		nonStaticMethod.staticDropDownSelectWithActions(driver);
		Thread.sleep(2000);
		nonStaticMethod.fromAndToCitySelectDyanamicDropDown(driver);
	}

	public void staticDropDownSelect(WebDriver driver) {
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();

		webEle = driver.findElement(By.cssSelector("#ctl00_mainContent_DropDownListCurrency"));

		Select selectOption = new Select(webEle);
		System.out.println(selectOption.isMultiple());
		List<WebElement> listFromDropdown = selectOption.getOptions();
		System.out.println("Dropdown size is: " + listFromDropdown.size());
		// This will get the available options from the dropdown list and display them
		System.out.println("Available option from the dropdown are: ");
		for (int i = 0; i < listFromDropdown.size(); i++) {
			System.out.println(listFromDropdown.get(i).getText());
		}
		// Selecting option from index 2 and printing it
		selectOption.selectByIndex(2);
		System.out.println("You have selected " + selectOption.getFirstSelectedOption().getText());
	}

	public void staticDropDownSelectWithActions(WebDriver driver) {

		// Opening passengers dropDown
		driver.findElement(By.id("divpaxinfo")).click();

		waitImplement = new WebDriverWait(driver, Duration.ofSeconds(30));
		waitImplement.until(ExpectedConditions.visibilityOfElementLocated(By.id("hrefIncAdt")));
		// Increasing adult count
		for (int i = 0; i < 5; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
	}

	public void fromAndToCitySelectDyanamicDropDown(WebDriver driver) {
		driver.findElement(By.cssSelector("#ctl00_mainContent_ddl_originStation1_CTXT")).click();
		
	}
}
