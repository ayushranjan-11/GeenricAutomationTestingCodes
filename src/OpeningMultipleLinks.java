import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class OpeningMultipleLinks {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.co.in");
        // Below code open multiple link in the same browser
        List<String> urlString = new ArrayList<>();
        urlString.add("https://www.google.co.in");
        urlString.add("https://www.facebook.com");
        urlString.add("https://www.twitter.com");
        urlString.add("https://www.instagram.com");
        urlString.add("https://www.stackoverflow.com");

        //Thread.sleep(5000);
        // driver.navigate().to(urlString.get(0).toString());
        for (String s : urlString) {
            openingMultipleLinks(driver, s);
        }

        Thread.sleep(2000);
        driver.close();
    }

    public static void openingMultipleLinks(WebDriver driver, String url)  {
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        System.out.println(driver.getTitle());
        //Thread.sleep(2000);

    }
}
