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
public class demoqademo {
public static void main(String[] args)
{
System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\git\\SeleniumJavaFramework1\\SeleniumJavaFramework\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
    
    WebDriver driver = new ChromeDriver();
    driver.get("https://demoqa.com/broken");
    driver.manage().window().maximize();

    List<WebElement> images = driver.findElements(By.tagName("img"));
    System.out.println("Total number of Images on the Page are " + images.size());
    for(int index=0;index<images.size();index++)
    {
        WebElement image= images.get(index);
        String imageURL= image.getAttribute("src");
        System.out.println("URL of Image " + (index+1) + " is: " + imageURL);
        try
        {
            URL url = new URL("https://demoqa.com/broken");
 HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
            httpURLConnect.setConnectTimeout(5000);
            httpURLConnect.connect();
            if(httpURLConnect.getResponseCode()>=400)
            {
            	System.out.println("HTTP STATUS - " + httpURLConnect.getResponseMessage() + "is a broken link");
            }    
       
            //Fetching and Printing the response code obtained
            else{
                System.out.println("HTTP STATUS - " + httpURLConnect.getResponseMessage());
            }
        }catch (Exception e) {
      }
        try {
            boolean imageDisplayed = (Boolean) ((JavascriptExecutor) driver).executeScript("return (typeof arguments[0].naturalWidth !=\"undefined\" && arguments[0].naturalWidth > 0);", image);
            if (imageDisplayed) {
                System.out.println("DISPLAY - OK");
            }else {
                 System.out.println("DISPLAY - BROKEN");
            }
        } 
        catch (Exception e) {
        	System.out.println("Error Occured");
        }

}
}}
