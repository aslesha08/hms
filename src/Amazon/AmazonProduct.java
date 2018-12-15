package Amazon;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AmazonProduct {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver","D:\\aslesha\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://www.amazon.in");
		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//a[@id='nav-link-shopall']"))).build().perform();
		a.moveToElement(driver.findElement(By.xpath("//span[@role='navigation'][@aria-label='Women']"))).build().perform();
		driver.findElement(By.linkText("Watches")).click();
		driver.findElement(By.xpath("//input[@type='checkbox'][@name='s-ref-checkbox-1480914031']")).click();
		driver.findElement(By.linkText("Analogue")).click();
		Thread.sleep(5000);
		List<WebElement> product=driver.findElements(By.xpath("//a[@class='a-link-normal s-access-detail-page s-overflow-ellipsis s-color-twister-title-link a-text-normal']/h2"));
		System.out.println(product.size());
		
		for(WebElement e: product) {
			String s=e.getText();
			if(s.contains("Women's")) {
				System.out.println(s);
			}

			else {
				System.out.println(false);
			
			
			
		}
		}
/*for(int i=0;i<product.size();i++) {
				
				if(product.get(i).isDisplayed()) {
					System.out.println(product.get(i).getText());
					product.get(i).click();
					
					System.out.println(driver.getCurrentUrl());
					driver.navigate().back();
					//product=driver.findElements(By.xpath("//a[@class='a-link-normal s-access-detail-page s-overflow-ellipsis s-color-twister-title-link a-text-normal']/h2"));
				
				}
			
			}*/
	}

}
