package automi.shudokkho;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;


public class InstantRecordService extends Shbase {
	
	public ExtentTest test;
	
	@Test
	public void instant() throws InterruptedException {
		
		// creates a toggle for the given test, adds all log events under it    
		test = extent.createTest("Instant Record Service", "All types of instant services");
				
		//Enter Instant service page
		driver.findElement(By.xpath("//android.widget.TextView[@text='সেবা প্রদান']")).click();
		
		//next day
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acivNextTreatment")).click();
		
		//previous day
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acivBackTreatment")).click();
		
		//select service type
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acsServiceTypeTreatment")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='অসুস্থতার সেবা']")).click();
		
		//write farmer details
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acactvNameTreatment")).click();
		driver.pressKey(new io.appium.java_client.android.nativekey.KeyEvent(AndroidKey.A));
		Thread.sleep(5000);
		driver.pressKey(new io.appium.java_client.android.nativekey.KeyEvent(AndroidKey.R));
		driver.pressKey(new io.appium.java_client.android.nativekey.KeyEvent(AndroidKey.DPAD_DOWN));
		driver.pressKey(new io.appium.java_client.android.nativekey.KeyEvent(AndroidKey.DPAD_DOWN));
		driver.pressKey(new io.appium.java_client.android.nativekey.KeyEvent(AndroidKey.DPAD_DOWN));
		driver.pressKey(new io.appium.java_client.android.nativekey.KeyEvent(AndroidKey.DPAD_DOWN));
		driver.pressKey(new io.appium.java_client.android.nativekey.KeyEvent(AndroidKey.ENTER));
		test.log(Status.PASS, "Test Case - 36: Use autosuggests for a farmer");
		
		//select animal
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acsAnimalTreatment")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='গরু']")).click();
				
		//select animal type
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acsAnimalTypeTreatment")).click();
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='ষাঁড়']")).click();
		
		//select medicine<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<START
		//medicine button
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/fabMedicine")).click();
		//disease select
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acsDisease")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='আঘাত জনিত ব্যাথা']")).click();
		//medicine for selected disease
		driver.findElement(By.xpath("//android.widget.TextView[@text='Antihistaminic']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Inj. Alarvet']")).click();
		//prescription forward(from database)
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acivSubmitDialog")).click();
		test.log(Status.PASS, "Test Case - 45: Validate sickness list to Medicine types > Medicine list branching inside prescription (Successful)");
		//extra medicine input
		driver.findElement(By.xpath("//android.widget.EditText[1]")).sendKeys("test medicine");
	    //prescription select
		driver.findElement(By.xpath("//android.widget.LinearLayout/android.widget.ImageView")).click();
		//prescription forward(user input)
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acivSubmitDialog")).click();
		test.log(Status.PASS, "Test Case - 46: Add new medicine (Successful)");
		//submit medicine
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/mbSubmitMedicine")).click();
		//select medicine<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<END
		
		
		//next day input
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acetNextDayTreatment")).clear();
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acetNextDayTreatment")).sendKeys("1");
		String nextday = driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acetNextDayTreatment")).getText();
		if(nextday == "2") {
		test.log(Status.PASS, "Test Case - 47: Reschedule next visit (Successful)");
		}else {
					test.log(Status.FAIL, "Test Case - 47: Reschedule next visit");
		}
		
		//submit treatment
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/mbSubmitTreatment")).click();
		//service fee tracking reminder
		if (driver.findElements(By.id("com.mpower.android.app.lpin.crm:id/actvMsgCustomDialog")).size() > 0) {
		test.log(Status.PASS, "Test Case - 51: Service fee tracking reminder (Successful)");
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/actvNegCustomDialog")).click();
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/actvNegCustomDialog")).click();
		} else {
		        	test.log(Status.FAIL, "Test Case - 51: Service fee tracking reminder");
		}
		test.log(Status.PASS, "Test Case - 34: Start a service record form");
		test.log(Status.PASS, "Test Case - 35: Add a new farmer");
		
		
		//repeat for fee submission

		//sync
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/sync")).click();
		//Enter Instant service page
		driver.findElement(By.xpath("//android.widget.TextView[@text='সেবা প্রদান']")).click();
		//select service type
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acsServiceTypeTreatment")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='অসুস্থতার সেবা']")).click();
		//write farmer details
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acactvNameTreatment")).click();
		driver.pressKey(new io.appium.java_client.android.nativekey.KeyEvent(AndroidKey.R));
		Thread.sleep(5000);
		driver.pressKey(new io.appium.java_client.android.nativekey.KeyEvent(AndroidKey.I));
		driver.pressKey(new io.appium.java_client.android.nativekey.KeyEvent(AndroidKey.DPAD_DOWN));
		driver.pressKey(new io.appium.java_client.android.nativekey.KeyEvent(AndroidKey.DPAD_DOWN));
		driver.pressKey(new io.appium.java_client.android.nativekey.KeyEvent(AndroidKey.ENTER));
		//change name
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acactvNameTreatment")).sendKeys("Richard Pakiza");
		//select animal
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acsAnimalTreatment")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='গরু']")).click();
		//select animal type
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acsAnimalTypeTreatment")).click();
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='ষাঁড়']")).click();
		//medicine button
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/fabMedicine")).click();
		//disease select
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acsDisease")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='আঘাত জনিত ব্যাথা']")).click();
		//medicine for selected disease
		driver.findElement(By.xpath("//android.widget.TextView[@text='Antihistaminic']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Inj. Alarvet']")).click();
		//prescription forward(from database)
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acivSubmitDialog")).click();
		//submit medicine
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/mbSubmitMedicine")).click();
		//fee submission<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<START
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/mbCollectionTreatment")).click();
		//manual medicine input
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acetMed")).sendKeys("50");
		//Bill input
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acetBillCollection")).sendKeys("200");
		//Payment received input
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acetPaymentCollection")).sendKeys("100");
		//scroll to submit button
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"নিশ্চিত করুন\"));"));
		//submit payment details
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/mbSubmitTreatment")).click();

		if (driver.findElements(By.id("com.mpower.android.app.lpin.crm:id/actvMsgCustomDialog")).size() > 0) {
			test.log(Status.PASS, "Test Case - 52: Send message to farmer reminder (Successful)");
        } else {
        	test.log(Status.FAIL, "Test Case - 52: Send message to farmer reminder");
        }

		//select "No" for prescription SMS
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/actvNegCustomDialog")).click();
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/actvPosCustomDialog")).click();
		test.log(Status.PASS, "Test Case - 37: Edit an existing farmer (Successful)");
		test.log(Status.PASS, "Test Case - 48: Add Service fee (Successful)");
		//fee submission<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<END
				
		//repeat for artificial insemination
		
		//sync
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/sync")).click();
				
		//Enter Instant service page
		driver.findElement(By.xpath("//android.widget.TextView[@text='সেবা প্রদান']")).click();
		
		//select service type
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acsServiceTypeTreatment")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='কৃত্রিম প্রজনন']")).click();
		
		//write farmer details
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acactvNameTreatment")).click();
		driver.pressKey(new io.appium.java_client.android.nativekey.KeyEvent(AndroidKey.R));
		Thread.sleep(5000);
		driver.pressKey(new io.appium.java_client.android.nativekey.KeyEvent(AndroidKey.I));
		driver.pressKey(new io.appium.java_client.android.nativekey.KeyEvent(AndroidKey.DPAD_DOWN));
		driver.pressKey(new io.appium.java_client.android.nativekey.KeyEvent(AndroidKey.DPAD_DOWN));
		driver.pressKey(new io.appium.java_client.android.nativekey.KeyEvent(AndroidKey.ENTER));
		
		//select animal type
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acsAnimalTypeTreatment")).click();
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='গাভী']")).click();
		//select animal breed
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acsAnimalBreedTreatment")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='রেড চিটাগাং ক্রস']")).click();
		//select animal age
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acsAnimalAge")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='৮ দাঁত']")).click();
		//select animal color
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acsAnimalColor")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='সাদা-কালো']")).click();
		//select breed date
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/tvMatingDate")).click();
		driver.findElement(By.id("android:id/button1")).click();
		//select animal sign
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acsIdentificationMark")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='ঘাড়ে কাটা দাগ']")).click();
		//failed insemination
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acsFatingMatingNumber")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='২ বার']")).click();
		//scroll to submit button
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"সেইভ করুন\"));"));
		//select OX kind
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acsOxKind")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='হলেস্টেইন ফ্রিজিয়ান']")).click();
		//select bull percentage
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acsBloddPercentage")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='৭৫%']")).click();
		//select bull number
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acsBullNumber")).click();
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='লিখুন']")).click();
		//fill bull Information
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/etBullId")).sendKeys("228");
		test.log(Status.PASS, "Test Case - 42: Add Bull number in Artificial Insemination (Successful)");
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/etBullName")).sendKeys("Alex Winston");
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/etBullPrice")).sendKeys("1100");
		//select number of animal in farm
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acsAnimalNumberInFarm")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='৬ - ১০']")).click();
		//camera operations
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acibCameraProfile")).click();
		driver.findElement(By.id("com.android.camera2:id/shutter_button")).click();
		driver.findElement(By.id("com.android.camera2:id/done_button")).click();
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/textViewUpload")).click();
		test.log(Status.PASS, "Test Case - 43: Take/upload photo of cow in Artificial Insemination (Successful)");
		//select milk yes/no
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acsMilking")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='হ্যাঁ']")).click();
		//medicine button
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/fabMedicine")).click();
		//disease select
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acsDisease")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='আঘাত জনিত ব্যাথা']")).click();
		//medicine for selected disease
		driver.findElement(By.xpath("//android.widget.TextView[@text='Antihistaminic']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Inj. Alarvet']")).click();
		//prescription forward(from database)
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acivSubmitDialog")).click();
		//submit medicine
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/mbSubmitMedicine")).click();
		//next day input
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acetNextDayTreatment")).clear();
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acetNextDayTreatment")).sendKeys("1");
		//scroll to submit button
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"সেইভ করুন\"));"));
		//submit treatment
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/mbSubmitTreatment")).click();
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/actvNegCustomDialog")).click();
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/actvNegCustomDialog")).click();
		
	
				
		//repeat for service change case		
		//sync
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/sync")).click();
				
		//Enter Instant service page
		driver.findElement(By.xpath("//android.widget.TextView[@text='সেবা প্রদান']")).click();
		
		//select service type
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acsServiceTypeTreatment")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='কৃত্রিম প্রজনন']")).click();
		
		//write farmer details
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acactvNameTreatment")).click();
		driver.pressKey(new io.appium.java_client.android.nativekey.KeyEvent(AndroidKey.R));
		Thread.sleep(5000);
		driver.pressKey(new io.appium.java_client.android.nativekey.KeyEvent(AndroidKey.I));
		driver.pressKey(new io.appium.java_client.android.nativekey.KeyEvent(AndroidKey.DPAD_DOWN));
		driver.pressKey(new io.appium.java_client.android.nativekey.KeyEvent(AndroidKey.DPAD_DOWN));
		
		//select animal type
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acsAnimalTypeTreatment")).click();
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='গাভী']")).click();
		//select animal breed
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acsAnimalBreedTreatment")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='রেড চিটাগাং ক্রস']")).click();
		//select animal age
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acsAnimalAge")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='৮ দাঁত']")).click();
		//select animal color
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acsAnimalColor")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='সাদা-কালো']")).click();
		//select breed date
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/tvMatingDate")).click();
		driver.findElement(By.id("android:id/button1")).click();
		//select animal sign
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acsIdentificationMark")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='ঘাড়ে কাটা দাগ']")).click();
		//failed insemination
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acsFatingMatingNumber")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='২ বার']")).click();
		//scroll to submit button
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"সেইভ করুন\"));"));
		//select OX kind
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acsOxKind")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='হলেস্টেইন ফ্রিজিয়ান']")).click();
		//select bull percentage
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acsBloddPercentage")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='৭৫%']")).click();
		//select bull number
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acsBullNumber")).click();
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='লিখুন']")).click();
		//fill bull Information
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/etBullId")).sendKeys("228");
		test.log(Status.PASS, "Test Case - 42: Add Bull number in Artificial Insemination (Successful)");
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/etBullName")).sendKeys("Alex Winston");
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/etBullPrice")).sendKeys("1100");		

		//scroll to top service type
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"সেবার ধরন\"));"));
		//select service type
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/acsServiceTypeTreatment")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='অসুস্থতার সেবা']")).click();
		
		if (driver.findElements(By.xpath("//android.widget.TextView[@text='ষাঁড় আইডি']")).size() > 0) {
			test.log(Status.FAIL, "Test Case - 44: Service type change after filling random fields");
        } else {
        	test.log(Status.PASS, "Test Case - 44: Service type change after filling random fields (Successful)");
        }
		
		extent.flush();
				
				
				
				
				
				
	}

}
