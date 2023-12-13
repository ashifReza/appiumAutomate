package automi.shudokkho;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Shbase {
	
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;

	@BeforeClass
	public void configAppium() throws MalformedURLException, InterruptedException {
		
		//create capabilities
		
				UiAutomator2Options options = new UiAutomator2Options();
				options.setDeviceName("pixel7");
				options.setApp("C:\\Users\\Asus\\eclipse-workspace\\shudokkho\\src\\test\\java\\appapk\\lpinQA-[1.8.4]-[84].apk");


				//create object for android user
				driver = new AndroidDriver(new URL("http://192.168.23.143:4723"), options);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				
				//permissionButtons
				
//				driver.findElement(By.xpath("//android.widget.Button[@text='ALLOW']")).click();
//				driver.findElement(By.xpath("//android.widget.Button[@text='ALLOW']")).click();
//				driver.findElement(By.xpath("//android.widget.Button[@text='ALLOW']")).click();
				
//				driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
//				driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
//				driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
				

				//ChooseLogin
				driver.findElement(By.xpath("//android.widget.Button[@text='লগ ইন']")).click();
				//Enter Phone Number(Valid)
				driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/etUserId")).sendKeys("01720111641");
				//Click Login Button
				driver.findElement(By.className("android.widget.Button")).click();
				//Enter received OTP
				driver.findElement(By.id("com.mpower.android.app.lpin.crm:id/etSMSCode")).sendKeys("2351");
				//Click confirm OTP Button
				driver.findElement(By.className("android.widget.Button")).click();
				
				//start reporters
				htmlReporter = new ExtentHtmlReporter("extent.html");

				//create ExtentReports and attach reporter(s)
				extent = new ExtentReports();
				extent.attachReporter(htmlReporter);
	}
	


	
	@AfterClass
	public void tearDown() {

		//calling flush writes everything to the log file
		extent.flush();


		driver.quit();
		service.stop();
		

	}
	
	
	
}
