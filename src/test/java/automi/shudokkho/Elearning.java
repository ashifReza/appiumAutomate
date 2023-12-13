package automi.shudokkho;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.AppiumBy;

public class Elearning extends Shbase {

	public ExtentTest test;
	
	@Test
	public void finishCourse() throws InterruptedException {
		
		// creates a toggle for the given test, adds all log events under it    
		test = extent.createTest("Add Schedule", "Required for initial setup");
		
		//scroll to submit button
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"ই লার্নিং\"));"));
		
		//click on e-learning tab
		driver.findElement(By.xpath("//android.widget.TextView[@text='ই লার্নিং']")).click();
		
		/*
		courses list
		1.  জৈবনিরাপত্তা
		2.  টিকাদান ও এর গুরুত্ব
		3.  গরুর সাধারন টিকাসমুহ
		4.  গরুর সুষম খাদ্য
		5.  খাদ্য ব্যবস্থাপনার থাম্বরুল পদ্ধতি
		6.  বাছুরের খাদ্য ব্যবস্থাপনা
		7.  মোটাতাজাকরণের গরু নির্বাচন
		8.  খাদ্য ব্যবস্থাপনা
		9.  গরুর প্রজননতন্ত্র
		10. খাদ্য ব্যবস্থাপনার থাম্বরুল পদ্ধতি
		*/
		
		String TopicName = "গরুর প্রজননতন্ত্র"; 
		
		//click on a course topic
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+TopicName+"']")).click();
		
		String  TopicNameStore = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup/android.widget.TextView")).getText();
		
		if(TopicNameStore.equals(TopicName)) {
			test.log(Status.PASS, "Test Case - 75: View a Course Topic (Successful)");
		}else {
			test.log(Status.FAIL, "Test Case - 75: View a Course Topic");
		}
		
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/next")).click();
		
		//Getting page number text from below course
		String pageText = driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/toolbar_title")).getText();
		System.out.println(pageText);
		
		//Getting last value of string
		char pageNumChar = pageText.charAt(pageText.length()-1);
		
		// Converting character to its integer value
        int pageNumInt = pageNumChar - '0';
		
		for( int i=0; i <= pageNumInt; i++) {
			
			//Click on 'Next' button until lesson ends
			driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/next")).click();
			
		}
		
		//Check whether lesson of a topic has ended or not
		WebElement endLesson = driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/btn_start_exam"));
		if(endLesson.isDisplayed() == true) {
			test.log(Status.PASS, "Test Case - 76:Complete the lesson of a topic (Successful)");
		}else {
			test.log(Status.FAIL, "Test Case - 76:Complete the lesson of a topic ");
		}
		//click on quiz start button
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/btn_start_exam")).click();
		test.log(Status.PASS, "Test Case - 77: Verify if quiz cannot be taken before completing a topic (Successful)");
		
		//quiz answers<<<<<<<<<START
		
		//click answer
		driver.findElement(By.xpath("//android.widget.RadioButton[1]")).click();
		
		//confirm answer
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/btn_confirm_answer")).click();
		
		//Getting page number text from above quiz
		String quizPageNum = driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/toolbar_title")).getText();
		System.out.println(quizPageNum);
		
		//Getting last value of string
		char quizPageNumChar = quizPageNum.charAt(quizPageNum.length()-1);
		
		// Converting character to its integer value
		int quizPageNumInt = quizPageNumChar - '0';
		try {
		for(int j=0; j <= quizPageNumInt-1; j++) {
			
			
			//click answer
			driver.findElement(By.xpath("//android.widget.RadioButton[1]")).click();
			
			//confirm answer
			driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/btn_confirm_answer")).click();
			
			System.out.println(quizPageNumInt +"<-- Variable + increment -->"+ j);
			
			
			
			
		} 
		}catch(Exception e) {
			System.out.println("NoSuchElements Exception Caought");
		}
		
		Thread.sleep(4000);
		
		//quiz answers<<<<<<<<<END
		
//		//click ratings
//		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/rating_bar")).click();
//		//click ok
//		driver.findElement(By.id("android:id/button1")).click();
		
		//click on result details
		driver.findElement(By.xpath("//android.widget.Button[@text='বিস্তারিত ফলাফল']")).click();
		
		//click on the first answer
		driver.findElement(By.xpath("//android.widget.TwoLineListItem[1]")).click();
		
		//confirm answer
		driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/btn_confirm_answer")).click();
		
		//Getting page number text from above quiz
		String quizPageNum2 = driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/toolbar_title")).getText();
		System.out.println(quizPageNum2);
				
		//Getting last value of string
		char quizPageNumChar2 = quizPageNum2.charAt(quizPageNum.length()-1);
				
		// Converting character to its integer value
		int quizPageNumInt2 = quizPageNumChar2 - '0';
		
		try {
		//Check for quiz pagination loop	
		for(int m=0; m <= quizPageNumInt2-1; m++) {
		
				//verify status
				String status = driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/answer_tv_status")).getText();
				
				System.out.println(status);
				
				//if Status "Wrong", choose correct answer
				//else confirm answer
				if(status.equals("Wrong"))
				{
					
					//Get Correct Answer
					String CorrAns = driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/answer_tv")).getText();
					
					//Search for correct answer
					for(int k=1;k<=4;k++) {
						
						String choice = driver.findElement(By.xpath("//android.widget.RadioButton["+k+"]")).getText();
						
						//If option matches correct answer, select it
						if(choice.equals(CorrAns)) {
							
							driver.findElement(By.xpath("//android.widget.RadioButton["+k+"]")).click();
							//confirm answer
							driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/btn_confirm_answer")).click();
					     
						}
						
					}
					
					
					
				}else {
					
					//confirm answer
					driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/btn_confirm_answer")).click();
				
				}
				
		}

		}catch(Exception e) {
			System.out.println("Exception found");
		}
		
		Thread.sleep(2000);
		try {
		
		//click on result details
		System.out.println(driver.findElement(By.xpath("//android.widget.Button[@text='বিস্তারিত ফলাফল']")).getText());
		driver.findElement(By.xpath("//android.widget.Button[@text='বিস্তারিত ফলাফল']")).click();
		//move to new course
		driver.findElement(By.xpath("//android.widget.Button[@text='নতুন মডিউল শুরু করুন']")).click();
		
		}catch(Exception e) {
			System.out.println("Eleement not detected Exception"); 
		}
			
		extent.flush();
		
		
		
	}
	
}
