package demo;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
public class demoqademo1 {
public static void main(String[] args)
{
System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\git\\SeleniumJavaFramework1\\SeleniumJavaFramework\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
    
    WebDriver driver = new ChromeDriver();
    driver.get("https://demoqa.com/broken");
    driver.manage().window().maximize();
    List<WebElement> links = driver.findElements(By.tagName("a"));

    
    System.out.println(links.size());

    for (int i = 0; i < links.size(); i++) {             
        System.out.println(links.get(i).getText());
        WebElement elem = links.get(i);
		String linkUrl = elem.getAttribute("href");
		if (linkUrl != null) {
	        try {
	        	URL url = new URL("http://the-internet.herokuapp.com/status_codes/500");

	        	
	    		HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
	    		httpURLConnect.setConnectTimeout(5000);
	    		httpURLConnect.connect();


	    		if(httpURLConnect.getResponseCode() >= 400){
	    			System.out.println("http://the-internet.herokuapp.com/status_codes/500"+" - "
	    					+httpURLConnect.getResponseMessage()+"is a broken link");
	    		}    
	    	
	    		else{
	    			System.out.println("http://the-internet.herokuapp.com/status_codes/500"+" - "+httpURLConnect.getResponseMessage());
	    		}

	    		// Disconnect URL Connection
	    		httpURLConnect.disconnect();
	        } catch (IOException e) {
	            System.out.println("IOException occurred for link: " + linkUrl + " - " + e.getMessage());
	        }
	    } else {
	        System.out.println("Link is null, skipping...");
	    }
   }
}
}
