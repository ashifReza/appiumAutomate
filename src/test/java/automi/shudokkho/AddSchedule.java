package automi.shudokkho;

import org.openqa.selenium.By;
import org.testng.annotations.Test;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;

public class AddSchedule extends Shbase implements farmerDetails {

	public ExtentTest test;
	
	@Test
	public void AddFarmer() throws InterruptedException {
		
		// creates a toggle for the given test, adds all log events under it    
		test = extent.createTest("Add Schedule", "Required for initial setup");
		
		
		//click on "Add Record/Schedule"
		driver.findElement(By.xpath("//android.widget.TextView[@text='নতুন কল রেকর্ড']")).click();
		
		//Mandatory Field Validation-------------------------------------------<<<<<<<<<<<<<<<<<<START
		//(No Input)
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/mbSubmitNewVisit")).click();
		if (driver.findElements(By.id("com.mpower.android.app.lpin.crm:id/notification")).size() > 0) {
			test.log(Status.FAIL, "Test Case - 8: Mandatory field validation (Submitted with no input)");
        } else {
        	test.log(Status.PASS, "Test Case - 8: Mandatory field validation (Successful (Cannot submit for no input))");
        }
		
		//Only Farmer name
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acactvFarmerNameNewVisit")).sendKeys(farmerName);
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/mbSubmitNewVisit")).click();
		if (driver.findElements(By.id("com.mpower.android.app.lpin.crm:id/notification")).size() > 0) {
			test.log(Status.FAIL, "Test Case - 8: Mandatory field validation (Submitted with only farmer name)");
        } else {
        	test.log(Status.PASS, "Test Case - 8: Mandatory field validation (Successful (for only farmer name input))");
        }
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acactvFarmerNameNewVisit")).clear();
		
		//Only Address
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acactvAddressNewVisit")).sendKeys(Address);
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/mbSubmitNewVisit")).click();
		if (driver.findElements(By.id("com.mpower.android.app.lpin.crm:id/notification")).size() > 0) {
			test.log(Status.FAIL, "Test Case - 8: Mandatory field validation (Submitted with no input)");
        } else {
        	test.log(Status.PASS, "Test Case - 8: Mandatory field validation (Successful(for only address input))");
        }
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acactvAddressNewVisit")).clear();
		
		//Only Mobile Number
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acactvFarmerNameNewVisit")).sendKeys(" ");
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acactvMobileNewVisit")).sendKeys(MobileNumber1);
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acactvAddressNewVisit")).sendKeys(" ");
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acivNextNewVisit")).click();
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/mbSubmitNewVisit")).click();
		if (driver.findElements(By.id("com.mpower.android.app.lpin.crm:id/notification")).size() > 0) {
			test.log(Status.FAIL, "Test Case - 8: Mandatory field validation (Submitted with only mobile number)");
			driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/sync")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//android.widget.TextView[@text='নতুন কল রেকর্ড']")).click();
			
        } else {
        	test.log(Status.PASS, "Test Case - 8: Mandatory field validation (Successful for (only mobile number input))");
        	driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acactvAddressNewVisit")).clear();
        }
		
		//Mandatory Field Validation-------------------------------------------<<<<<<<<<<<<<<<<<<END
		
		//Input Field Validation-----------------------------------------------<<<<<<<<<<<<<<<<<<START
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acactvFarmerNameNewVisit")).sendKeys("58305)#$@$*");
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acactvMobileNewVisit")).sendKeys("48493JIWJIF(#$(@)$@)");
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acactvAddressNewVisit")).sendKeys("43o84(*#($(");
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acivNextNewVisit")).click();
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/mbSubmitNewVisit")).click();
		if (driver.findElements(By.id("com.mpower.android.app.lpin.crm:id/notification")).size() > 0) {
			test.log(Status.FAIL, "Test Case - 9: Input field Validation");
			driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/sync")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//android.widget.TextView[@text='নতুন কল রেকর্ড']")).click();
			
        } else {
        	test.log(Status.PASS, "Test Case - 9: Input field validation (Successful)");
        	driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acactvFarmerNameNewVisit")).clear();
    		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acactvMobileNewVisit")).clear();
    		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acactvAddressNewVisit")).clear();
        }
		//Input Field Validation-----------------------------------------------<<<<<<<<<<<<<<<<<<END
		
		//Enter Farmer Name
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acactvFarmerNameNewVisit")).sendKeys(farmerName);
		
		//Enter Mobile No
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acactvMobileNewVisit")).sendKeys(MobileNumber2);
		
		//Enter Address
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acactvAddressNewVisit")).sendKeys(Address);
		
		//Check for Previous Date
		//Date-->Previous Button
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acivBackNewVisit")).click();
		test.log(Status.PASS, "Test Case - 6: Add schedule past time (Successful)");
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/mbSubmitNewVisit")).click();
		if (driver.findElements(By.id("com.mpower.android.app.lpin.crm:id/notification")).size() > 0) {
			test.log(Status.FAIL, "Test Case - 6: Add schedule past time");
        } else {
        	test.log(Status.PASS, "Test Case - 6: Add schedule past time");
        }

		//Date-->Next Button
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acivNextNewVisit")).click();
				
		//Hour Select
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acsTimeNewVisit")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='3']")).click();
		
		//Enter minute
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/etMinutesNextVisit")).clear();
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/etMinutesNextVisit")).click();
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/etMinutesNextVisit")).sendKeys("25");
		
		//AM or PM select
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acsMidDayNewVisit")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='PM']")).click();
		
		//Click Submit Button
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/mbSubmitNewVisit")).click();
		
		test.log(Status.PASS, "Test Case - 1: Add a new farmer (Successful)");
		test.log(Status.PASS, "Test Case - 4: Add a schedule (Successful)");
		
		//Sync
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/sync")).click();
		Thread.sleep(3000);
		
		//click on "Add Record/Schedule"
		driver.findElement(By.xpath("//android.widget.TextView[@text='নতুন কল রেকর্ড']")).click();
		
		//Check for Duplicate<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<START
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acactvFarmerNameNewVisit")).sendKeys(farmerName);
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acactvMobileNewVisit")).sendKeys(MobileNumber2);
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acactvAddressNewVisit")).sendKeys(Address);
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acivNextNewVisit")).click();
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acsTimeNewVisit")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='3']")).click();
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/etMinutesNextVisit")).clear();
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/etMinutesNextVisit")).click();
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/etMinutesNextVisit")).sendKeys("25");
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acsMidDayNewVisit")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='PM']")).click();
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/mbSubmitNewVisit")).click();
		if (driver.findElements(By.id("com.mpower.android.app.lpin.crm:id/notification")).size() > 0) {
			test.log(Status.FAIL, "Test Case - 5: Add duplicate schedule");
			driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/sync")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//android.widget.TextView[@text='নতুন কল রেকর্ড']")).click();
			
        } else {
        	test.log(Status.PASS, "Test Case - 5: Add duplicate schedule (Successful)");
        	driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acactvFarmerNameNewVisit")).clear();
    		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acactvMobileNewVisit")).clear();
    		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acactvAddressNewVisit")).clear();
        }
		//Check for Duplicate<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<END
		
		//Check for Notification<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<START
		driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/sync")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='নতুন কল রেকর্ড']")).click();
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acactvFarmerNameNewVisit")).sendKeys(farmerName);
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acactvMobileNewVisit")).sendKeys(MobileNumber2);
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acactvAddressNewVisit")).sendKeys(Address);
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acsTimeNewVisit")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='3']")).click();
		//Check for Notification<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<END
		
//>>>>>>//auto-suggestion check
		//Sync
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/sync")).click();
		Thread.sleep(3000);
		
		//click on "Add Record/Schedule"
		driver.findElement(By.xpath("//android.widget.TextView[@text='নতুন কল রেকর্ড']")).click();
		
		//enter farmer name with auto-suggest
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acactvFarmerNameNewVisit")).click();
		driver.pressKey(new io.appium.java_client.android.nativekey.KeyEvent(AndroidKey.A));
		Thread.sleep(5000);
		driver.pressKey(new io.appium.java_client.android.nativekey.KeyEvent(AndroidKey.R));
		driver.pressKey(new io.appium.java_client.android.nativekey.KeyEvent(AndroidKey.DPAD_DOWN));
		driver.pressKey(new io.appium.java_client.android.nativekey.KeyEvent(AndroidKey.ENTER));
		test.log(Status.PASS, "Test Case - 2: Use autosuggests for a farmer");
		//change name
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acactvFarmerNameNewVisit")).sendKeys("Richardina Holland");
		//Date-->Next Button
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acivNextNewVisit")).click();
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/mbSubmitNewVisit")).click();
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/actvPosCustomDialog")).click();
//>>>>>>//auto-suggestion check		
		
		extent.flush();
	}
	

	
	
	
}
