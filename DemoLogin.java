package learning_Program.Programs;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoLogin {
	static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("DemoSalesManager");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		driver.findElement(By.partialLinkText("Accounts")).click();
		driver.findElement(By.partialLinkText("Create Account")).click();
		driver.findElement(By.xpath("//input[@id='accountName']")).sendKeys("srinathbeeran1");
		driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("selenium Automation Tester");
		
		//Select the values from the dropdown
		WebElement industry=driver.findElement(By.xpath("//select[@name='industryEnumId']"));
		selectValuesFromDropdown(industry,"Computer Software");
		
		WebElement ownership=driver.findElement(By.xpath("//select[@name='ownershipEnumId']"));
		selectValuesFromDropdown(ownership,"S-Corporation");
		
		WebElement source=driver.findElement(By.xpath("//select[@id='dataSourceId']"));
		selectValuesFromDropdown(source,"Employee");
		
		WebElement Marketing=driver.findElement(By.xpath("//select[@id='marketingCampaignId']"));
		selectValuesFromDropdown(Marketing,"eCommerce Site Internal Campaign");
		
		WebElement state=driver.findElement(By.xpath("//select[@id='generalStateProvinceGeoId']"));
		selectValuesFromDropdown(state,"Texas");
		
		//click to create an account
		driver.findElement(By.xpath("//input[@value='Create Account']")).click();
		
		//WebElement name=driver.findElement(By.xpath("//span[text()='srinathbeeran  (15664)']"));
		//String Names=name.getText();
		
		//Assert.assertEquals(true, Names);
		
		//driver.quit();
		
	}
	public static void selectValuesFromDropdown(WebElement ele,String value) 
	{
		Select sel=new Select(ele);
		List<WebElement> option=sel.getOptions();
		for(WebElement s:option)
		{
			if(s.getText().equals(value)){
				s.click();
				break;
			}
		}
	}

}
