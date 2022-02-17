 package com.qa.labcorp;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Lab {

	public static void main(String[] args) {
System.setProperty("webdriver.gecko.driver","C:\\Users\\girid\\Downloads\\selenium\\geckodriver.exe");
		
		WebDriver driver=new FirefoxDriver();
		
		driver.get("https://www.labcorp.com");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5000));
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
	
	WebElement careerlink=driver.findElement(By.xpath("//*[@id='topofpage']/div/footer/div[1]/div/div[1]/div/nav[1]/ul/li[3]/a"));
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("arguments[0].click()", careerlink);
	driver.findElement(By.xpath("//input[@data-ph-at-id='globalsearch-input' and @au-target-id='162']")).sendKeys("Java Application Architect");
	WebElement searchbutton=driver.findElement(By.xpath("//*[@id=\"ph-search-backdrop\"]/ppc-content/i"));
	jse.executeScript("arguments[0].click()", searchbutton);
	
	driver.findElement(By.xpath("//a[@data-ph-at-job-title-text='Java Application Architect' and @data-ph-at-job-location-text='Burlington, North Carolina, United States']")).click();
String  ExpectedJobTitle=driver.findElement(By.xpath("//div[@data-ph-at-id='job-info']/h1")).getText();
Assert.assertSame(ExpectedJobTitle ,"Java Application Architect");
System.out.println("JobTitle as Expected");
String jobLocation =  "Durham, North Carolina, United States";
String  jobId="Job Id : 21-75212" ;
// getPageSource() to get page source
if ( driver.getPageSource().contains(" Burlington, North Carolina, United States ")){
   System.out.println("JobLocation " + jobLocation + " as expected ");
} else
{
   System.out.println("JobLoction " + jobLocation  + " not as expected ");
   }
if ( driver.getPageSource().contains("Job Id : 21-75212 ")){
	   System.out.println("Jobid" + jobId+ " as expected ");
	} 
else 
	{
		System.out.println("Jobid" + jobId + " not as expected ");
	}
Assert.assertTrue(driver.getPageSource().contains("3+ year experience with hands-on application architecture for large enterprise solutions. "));
System.out.println("Information about experience is present");
Assert.assertTrue(driver.getPageSource().contains("using tools such as Maven, Gradle, Git, Sonar, Jenkins, Jira."));
System.out.println("Information about tools is present");
Assert.assertTrue(driver.getPageSource().contains("The Application Architect will provide technical leadership in our agile development teams"));
System.out.println("Information abour responsbilities is present");
WebElement ApplyNowButton=driver.findElement(By.xpath("//ppc-content[ @data-ph-id='ph-page-element-page4-3AOSpW']" ));
jse.executeScript("arguments[0].click()", ApplyNowButton);


//proceeding page verification
Assert.assertTrue(driver.getPageSource().contains("Burlington"));
System.out.println("cityname as expected as previous page");
Assert.assertTrue(driver.getPageSource().contains("NC"));
System.out.println("state as expected as previous page ");
Assert.assertTrue(driver.getPageSource().contains("Java Application Architect "));
System.out.println("JobTitle as  expected as prevoius page");
Assert.assertTrue(driver.getPageSource().contains("21-75212"));
System.out.println("JobTitle as  expected as prevoius page");


Assert.assertTrue(driver.getPageSource().contains("3+ year experience with hands-on application architecture for large enterprise solutions. "));
System.out.println("Information about experience is present");
Assert.assertTrue(driver.getPageSource().contains("using tools such as Maven, Gradle, Git, Sonar, Jenkins, Jira."));
System.out.println("Information about tools is present");
Assert.assertTrue(driver.getPageSource().contains("The Application Architect will provide technical leadership in our agile development teams"));
System.out.println("Information abour responsbilities is present");
/*Actions action =new Actions(driver);
WebElement tooltipbutton=driver.findElement(By.xpath("//button[@type='button' and @ng-disabled='!canApply']"));
action.moveToElement(tooltipbutton).build().perform();
WebElement closetooltipbutton=driver.findElement(By.xpath("//button[@class='close closebutton ae-button']"));
jse.executeScript("arguments[0].click()",closetooltipbutton );
WebElement ReturnToSearchButton=driver.findElement(By.xpath("//button[@class='btn btn-secondary ae-button']"));
jse.executeScript("arguments[0].click()",ReturnToSearchButton );*/
driver.close();
}
}


