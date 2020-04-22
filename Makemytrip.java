package makeMyTrip;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Makemytrip {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//One way
		String click1=driver.findElementByXPath("//*[@id=\"root\"]/div/div[2]/div/div/div[1]/ul/li[1]").getAttribute("class");
        System.out.println("Is 'Oneway' selected?" + click1);
        
		//From City
		driver.findElementById("fromCity").click();
		WebElement a=driver.findElementByXPath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/div/div/div/input");
		a.sendKeys("tri");
		Thread.sleep(2000);
		a.sendKeys(Keys.ARROW_DOWN);
		a.sendKeys(Keys.ARROW_DOWN);
		a.sendKeys(Keys.ENTER);
	    System.out.println("From City:" +driver.findElementById("fromCity").getAttribute("value"));
		
		//To City
		WebElement b=driver.findElementByXPath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/div/div/div/input");
	    b.sendKeys("che");
	    Thread.sleep(2000);
		b.sendKeys(Keys.ARROW_DOWN);
		b.sendKeys(Keys.ENTER);
		System.out.println("To City:" +driver.findElementById("toCity").getAttribute("value"));
		
		//Departure
		driver.findElementByXPath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[1]/span[2]").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[2]/div[3]/div[1]/div[2]/div").click();
		System.out.println("Deputure:" + driver.findElementByXPath("(//p[@class=\"blackText font20 code\"])[1]").getText());
		
		//Round Trip
		driver.findElementByXPath("//*[@id=\"root\"]/div/div[2]/div/div/div[1]/ul/li[2]/span").click();
		System.out.println("Round Trip is clicked");
		
		//Return 
		driver.findElementByXPath("(//span[@class=\"lbl_input latoBold appendBottom10\"])[2]").click();
		driver.findElementByXPath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div[5]/div[3]/div/p").click();
		System.out.println("Return:" + driver.findElementByXPath("(//p[@class=\"blackText font20 code\"])[2]").getText());
	
		//Travellers & Class
		driver.findElementByXPath("(//span[@class=\"lbl_input latoBold appendBottom10\"])[3]").click();
		driver.findElementByXPath("(//ul[@class=\"guestCounter font12 darkText\"]/li[2])[1]").click();
		driver.findElementByXPath("(//ul[@class=\"guestCounter font12 darkText\"]/li[1])[2]").click();
		driver.findElementByXPath("(//ul[@class=\"guestCounter font12 darkText\"]/li[2])[3]").click();
		driver.findElementByXPath("//ul[@class=\"guestCounter classSelect font12 darkText\"]/li[3]").click();
		driver.findElementByXPath("//button[text()=\"APPLY\"]").click();
		System.out.println("Travellers & Class:" + driver.findElementByXPath("(//p[@class=\"blackText font20 code\"])[3]").getText());
		
		//Search
		driver.findElementByXPath("//a[text()=\"Search\"]").click();
		System.out.println("Result:" +driver.findElementByXPath("//p[text()=\"No flights found\"]").getText());
		
		//close
		driver.close();
		
	}

}
