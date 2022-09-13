package seleniumJavaWeek2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Week2_day2_Assignment2_EditLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver1 = new ChromeDriver();
		
//		/*http://leaftaps.com/opentaps/control/main
//		
//		* 1	Launch the browser
			driver1.get("http://leaftaps.com/opentaps/control/main");
			driver1.manage().window().maximize();
			
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
					
//		* 8	Enter first name
			//grand parent to grand child
			driver1.findElement(By.xpath(" //div[@class='x-tab-panel-bwrap']//input[@name='firstName']")).sendKeys("sowmiya");
			
//		* 9	Click Find leads button
			driver1.findElement(By.xpath("//button[text()='Find Leads']")).click();
			
			Thread.sleep(4000);
			
//		* 10 Click on first resulting lead
			String FirstElement = driver1.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
			driver1.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
			//System.out.println(FirstElement);
//		* 11 Verify title of the page
			String title = "View Lead | opentaps CRM";
			if(title.equals(driver1.getTitle()))
				{
			
//		* 12 Click Edit
				driver1.findElement(By.xpath("//div[@class='frameSectionExtra']/a[contains(text(),'Edit')]")).click();;
				
//		* 13 Change the company name
				driver1.findElement(By.id("updateLeadForm_companyName")).clear();
				String NewCompName = "Bala ltd.";
				driver1.findElement(By.id("updateLeadForm_companyName")).sendKeys(NewCompName);
				
//		* 14 Click Update
				driver1.findElement(By.xpath("//input[@value='Update']")).click();
				
//		* 15 Confirm the changed name appears
				String updatedCompName=driver1.findElement(By.xpath("//span[@id='viewLead_companyName_sp']")).getText();
				String temp = NewCompName+" "+"("+FirstElement+")";
				System.out.println(temp);
				if(updatedCompName.equals(temp))
				{
						System.out.println("Update Company name is successful"); 

				}
							
//		* 16 Close the browser (Do not log out)
				driver1.close();
			}
	}

}
