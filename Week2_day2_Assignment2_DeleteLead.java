package seleniumJavaWeek2.day2;

import javax.naming.directory.SearchResult;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Week2_day2_Assignment2_DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver1 = new ChromeDriver();

//		* 1	Launch the browser
			driver1.get("http://leaftaps.com/opentaps/control/main");
			
//		* 2	Enter the username
			//grand parent to grand child
			driver1.findElement(By.xpath("//div[@id='form']//input[@id='username']")).sendKeys("DemoSalesManager");

//		* 3	Enter the password
			//elder cousong to younger cousin
			driver1.findElement(By.xpath("//input[@id='username']/following::input[@id='password']")).sendKeys("crmsfa");

//		* 4	Click Login
			driver1.findElement(By.xpath("//input[@value='Login']")).click();
			
//		* 5	Click crm/sfa link
			driver1.findElement(By.xpath("//div[@id='label']/a")).click();
			
//		* 6	Click Leads link
			driver1.findElement(By.xpath("//a[contains(text(),'Leads')]")).click();
			
//		* 7	Click Find leads
			//grand parent to grand child
			driver1.findElement(By.xpath("//ul[@class='shortcuts']//a[contains(text(),'Find Leads')]")).click();
				
//		8	Click on Phone
			driver1.findElement(By.xpath("//span[contains(text(),'Phone')]")).click();
			
//		9	Enter phone number
			driver1.findElement(By.xpath("//input[@name='phoneCountryCode']")).clear();
			driver1.findElement(By.xpath("//input[@name='phoneCountryCode']")).sendKeys("1");
			driver1.findElement(By.xpath("//input[@name='phoneAreaCode']")).sendKeys("12");
			driver1.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("2147483647");
			
//		10	Click find leads button
			driver1.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
			Thread.sleep(3000);
			
//		11	Capture lead ID of First Resulting lead
			String LeadID = driver1.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
		
//		12	Click First Resulting lead
			driver1.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
			
//		13	Click Delete
			driver1.findElement(By.xpath("//a[contains(text(),'Delete')]")).click();
			
//		14	Click Find leads
			driver1.findElement(By.xpath("//a[contains(text(),'Find Leads')]")).click();
			
//		15	Enter captured lead ID
			driver1.findElement(By.xpath("//input[@name='id']")).sendKeys(LeadID);
			
//		16	Click find leads button
			driver1.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
			Thread.sleep(2000);
			
//		17	Verify message "No records to display" in the Lead List. This message confirms the successful deletion
			String SearchResult = driver1.findElement(By.xpath("//div[contains(text(),'No records to display')]")).getText();
			if (SearchResult.equals("No records to display"))
				System.out.println("The deletion is successful");
			
//		18	Close the browser (Do not log out)
			driver1.close();
				
	}

}
