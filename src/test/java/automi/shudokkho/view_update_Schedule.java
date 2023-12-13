package automi.shudokkho;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.AppiumBy;

public class view_update_Schedule extends Shbase {
	
	public ExtentTest test;
	
	@Test
	public void beforeRecordOPS() {
		
		// creates a toggle for the given test, adds all log events under it    
		test = extent.createTest("View/update Schedule", "All schedule list functions");
		
		//Enter Schedule page
		driver.findElement(By.xpath("//android.widget.TextView[@text='আপনার শিডিউল']")).click();
		
		//Previous date
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acivBackRoutine")).click();
		//Next Date
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acivNextRoutine")).click();
		test.log(Status.PASS, "Test Case - 10: View Schedule (Successful)");
		
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acivNextRoutine")).click();
		//click on any schedule
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/llRoutine")).click();
		
		//View farmer profile
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/fabProfileRoutineItem")).click();
		if (driver.findElements(By.xpath("//android.widget.TextView[@text='খামারির প্রোফাইল']")).size() > 0) {
			test.log(Status.PASS, "Test Case - 13: Farmer Details (Successful)");
			driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
        } else {
        	test.log(Status.FAIL, "Test Case - 13: Farmer Details (Not Viewed)");
        }
		
		//Edit schedule
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/fabEditRoutineItem")).click();
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acactvFarmerNameNewVisit")).sendKeys("Edited Farmer One");
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/mbSubmitNewVisit")).click();
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/actvPosCustomDialog")).click();
		test.log(Status.PASS, "Test Case - 14: Edit Schedule (Successful)");
		
		//Delete Schedule
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/llRoutine")).click();
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/fabDeleteRoutineItem")).click();
		test.log(Status.PASS, "Test Case - 15: Delete Schedule (Successful)");
		
		
		extent.flush();
		
		
		
	}

}
