package vero.vero;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VeroAutomation {

	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		
		ChromeDriver driver=new ChromeDriver();
		//FirefoxDriver driver = new FirefoxDriver();
		
		WebDriverWait wait = new WebDriverWait(driver,3);
		
		driver.manage().window().maximize();
		driver.get("https://www.vero-screening.com/CandidatePortal/en-GB/account/login");
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className("vt-login-username"))));
		
		
		WebElement Username =  driver.findElement(By.className("vt-login-username"));
		Username.sendKeys("shraddha76667@gmail.com");
		
		WebElement Password =  driver.findElement(By.className("vt-login-password"));
		Password.sendKeys("Testing123$");
		
		WebElement Loginbtn = driver.findElement(By.id("loginBtn"));
		Loginbtn.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className("ve-standard-button-continue"))));
		
		WebElement ContinueBtn =  driver.findElement(By.className("ve-standard-button-continue"));
		ContinueBtn.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.className("VeroList-FirstItem")));

		
		List<WebElement> questionnaire = driver.findElements(By.className("VeroList-FirstItem"));
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", questionnaire.get(0));
		
		Thread.sleep(3000);
		
		//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className("VeroList-Item"))));
		
       
		List<WebElement> PersonalDetails = driver.findElements(By.className("VeroList-Item"));
		
		executor.executeScript("arguments[0].click();", PersonalDetails.get(0));
		Thread.sleep(2000);
		WebElement Title = driver.findElement(By.id("ans_2358053_sel"));
		Title.sendKeys("Mr"+Keys.ENTER);
		WebElement ForeName = driver.findElement(By.id("ans_2358054"));
		ForeName.sendKeys("Test"+Keys.ENTER);
		WebElement SurName = driver.findElement(By.id("ans_2358055"));
		SurName.sendKeys("User"+Keys.ENTER);
		WebElement MiddleName = driver.findElement(By.id("ans_2358056_sel"));
		MiddleName.sendKeys("No"+Keys.ENTER);
		WebElement LegalName = driver.findElement(By.id("ans_2358058_sel"));
		LegalName.sendKeys("Yes"+Keys.ENTER);
		WebElement PreviousName = driver.findElement(By.id("ans_2358060_sel"));
		PreviousName.sendKeys("No"+Keys.ENTER);
		
		List<WebElement> DateSelect = driver.findElements(By.className("partialDateSelect"));
		DateSelect.get(0).sendKeys("15" +Keys.ENTER);
		DateSelect.get(1).sendKeys("March" +Keys.ENTER);
		DateSelect.get(2).sendKeys("1991" +Keys.ENTER);
		
		WebElement Gender = driver.findElement(By.id("ans_2358063_sel"));
		Gender.sendKeys("Male"+Keys.ENTER);
		WebElement ContactMethod = driver.findElement(By.id("ans_2358064_sel"));
		ContactMethod.sendKeys("M"+Keys.ENTER);
		WebElement MailId = driver.findElement(By.id("ans_2358065"));
		MailId.sendKeys("test@gmail.com"+Keys.ENTER);
		WebElement MobileNo = driver.findElement(By.id("ans_2358066"));
		MobileNo.sendKeys("9876543210"+Keys.ENTER);
		WebElement Nationality = driver.findElement(By.id("ans_2358068_sel"));
		Nationality.sendKeys("Indian"+Keys.ENTER);
		
		
		
		Thread.sleep(1500);
		
		executor.executeScript("arguments[0].click();", PersonalDetails.get(2));
		Thread.sleep(1500);
		WebElement NationalIdNumber = driver.findElement(By.className("VeroList-Name"));
		executor.executeScript("arguments[0].click();", NationalIdNumber);
		
		Thread.sleep(2000);
		List<WebElement> IssueByCountry = driver.findElements(By.className("dropdown-selector"));
		IssueByCountry.get(0).sendKeys("India"+Keys.ENTER);
		Thread.sleep(2000);
		
		IssueByCountry.get(1).sendKeys("Aadhaar"+Keys.ENTER);
		Thread.sleep(2000);
		String ActualIdCardNumber = "12345678910";
		WebElement IdCardNo = driver.findElement(By.className("NationalityNationalIdentificationNumber"));
		IdCardNo.sendKeys(ActualIdCardNumber+Keys.ENTER);
		Thread.sleep(2000);
		
		if (IdCardNo.getAttribute("data-val-orig").toLowerCase().length()<12)
		{
			driver.findElement(By.className("badger-error")).isDisplayed();
			System.out.println(IdCardNo.getAttribute("data-val-orig").toLowerCase()+" is a incorrect entry, 12 digits only");
		}else
		{
			driver.findElement(By.className("badger-valid")).isDisplayed();
			System.out.println(IdCardNo.getAttribute("data-val-orig").toLowerCase()+" is a correct entry");
		}
		
		WebElement signoutButton=driver.findElements(By.className("menu-item-wide")).get(0);
		signoutButton.click();
		Thread.sleep(1000);
		
		driver.quit();
		
		

	}

}
