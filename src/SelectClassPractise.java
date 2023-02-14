import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectClassPractise {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();
//        Dimension dimension = new Dimension(1080,720);
//        driver.manage().window().setSize(dimension);

        WebElement currencyDropdown = driver.findElement(By.xpath("//select[@id='ctl00_mainContent_DropDownListCurrency']"));

        Select staticDropdown = new Select(currencyDropdown);
        staticDropdown.selectByIndex(2);
        List<WebElement> currencyAvailableOptions = staticDropdown.getOptions();
        System.out.println(currencyAvailableOptions.size());

        for (int i=0;i<currencyAvailableOptions.size();i++) {
            //System.out.println(currencyAvailableOptions.get(i).getText());
            try {
                Thread.sleep(2000);
            } catch (Exception e) {

            }
            staticDropdown.selectByIndex(i);
            System.out.println("Current selected option is "+staticDropdown.getFirstSelectedOption().getText());
        }
    }
}
