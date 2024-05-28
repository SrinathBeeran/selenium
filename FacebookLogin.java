package learning_Program.Programs;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookLogin {
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://en-gb.facebook.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.findElement(By.partialLinkText("Create new account")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("srinath");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("beeran");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("srinathbeeran@gmail.com");

		WebElement date=driver.findElement(By.xpath("//select[@name='birthday_day']"));
		printdropdown(date,"19");

		WebElement month=driver.findElement(By.xpath("//select[@name='birthday_month']"));
		printdropdown(month,"Sep");

		WebElement year=driver.findElement(By.xpath("//select[@name='birthday_year']"));
		printdropdown(year,"1997");

		driver.findElement(By.xpath("//input[@value='2']")).click();

		driver.findElement(By.xpath("//button[@name='websubmit']")).click();
		
		driver.quit();



	}
	public static void printdropdown(WebElement ele,String value)
	{
		Select sel=new Select(ele);
		List<WebElement> option=sel.getOptions();
		for(WebElement options:option)
		{
			if(options.getText().equals(value))
			{
				options.click();
				break;
			}
		}
	}

}
