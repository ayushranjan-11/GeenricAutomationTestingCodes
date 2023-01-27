import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//This checks broken links for current page or passed url not the whole website.
public class BrokenLinkCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		List<String> passingUrls = new ArrayList<String>();
		passingUrls.add("https://vezitadoc.com/");
//		passingUrls.add("https://ideausher.com/about-us/");
//		passingUrls.add("https://ideausher.com/portfolio/");
//		passingUrls.add("https://ideausher.com/services/");
//		passingUrls.add("https://ideausher.com/services/blockchain-development/");
//		passingUrls.add("https://ideausher.com/apps-development/blockchain-game-development/");
//		passingUrls.add("https://ideausher.com/cross-chain-nft-marketplace-development-company/");
//		passingUrls.add("https://ideausher.com/blog/");
//		passingUrls.add("https://ideausher.com/contact/");

		// Loop for Passing multiple urls
		for (int i = 0; i < passingUrls.size(); i++) {

			driver.get(passingUrls.get(i));

			List<WebElement> links = driver.findElements(By.tagName("a"));
			System.out.println("Total number of links from " + passingUrls.get(i) + " are " + links.size());

			List<String> urlList = new ArrayList<String>();

			for (WebElement e : links) {
				String url = e.getAttribute("href");
				if (url == null || url.isEmpty()) {
					System.out.println(url + " is either not configured for anchor tag or it is empty");
					continue;
				}
				urlList.add(url);
				// checkBrokenLink(url);
			}

			urlList.parallelStream().forEach(e -> checkBrokenLink(e));

		}
		driver.quit();
	}

	public static void checkBrokenLink(String Linkurl) {
		try {

			URL url = new URL(Linkurl);
			HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
			httpUrlConnection.setConnectTimeout(5000);
			httpUrlConnection.connect();

			if (httpUrlConnection.getResponseCode() >= 400) {
				System.out.println(Linkurl + " -- " + httpUrlConnection.getResponseMessage()
						+ " is broken url because code is " + httpUrlConnection.getResponseCode());
			} else {
				System.out.println(Linkurl + " -- " + httpUrlConnection.getResponseMessage() + " responce code is: "
						+ httpUrlConnection.getResponseCode());
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
