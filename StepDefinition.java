package stepdef;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {

	public ChromeDriver driver;
	public ChromeOptions options;
	

	@Given("Launch the browser and load the URL")
	public void launchBrowser() {
		options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://login.salesforce.com/");
	}

	@When("Enter the username as {string}")
	public void enterUserName(String uName) {
		driver.findElement(By.id("username")).sendKeys(uName);
	}

	@When("Enter the password as {string}")
	public void enterPassword(String pWord) {
		driver.findElement(By.id("password")).sendKeys(pWord);

	}

	@When("Click the login button")
	public void clickLoginButton() {
		driver.findElement(By.id("Login")).click();
	}

	@When("Click on the toggle menu button in the left corner")
	public void clickOnToggleButton() throws InterruptedException {
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement clickToggle = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
		js.executeScript("arguments[0].click();", clickToggle);
	}

	@When("Click on View All and select Sales from the App Launcher.")
	public void click_on_view_all_and_select_sales_from_the_app_launcher() throws InterruptedException {
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement clickViewAll = driver.findElement(By.xpath("(//button[@class='slds-button'])[2]"));
		js.executeScript("arguments[0].click();", clickViewAll);
		Thread.sleep(3000);
		WebElement clickSales = driver.findElement(By.xpath("//p[text()='Sales']"));
		js.executeScript("arguments[0].click();", clickSales);
	}

	@When("Click on the Opportunity tab.")
	public void click_on_the_opportunity_tab() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement clickOpportunity = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		js.executeScript("arguments[0].click();", clickOpportunity);

	}

	@When("Click on the New button.")
	public void click_on_the_new_button() {
		driver.findElement(By.xpath("//div[text()='New']")).click();
	}

	@When("Enter the Opportunity name as {string}")
	public void enter_the_opportunity_name_as(String opportunityName) {
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(opportunityName);
	}

	@When("Enter Amount as {string}")
	public void enter_amount_as(String amount) {
		driver.findElement(By.xpath("//input[@name='Amount']")).sendKeys(amount);

	}

	@When("Choose the close date as Today.")
	public void choose_the_close_date_as_today() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement clickCloseDate = driver.findElement(By.xpath("//input[@name='CloseDate']"));
		js.executeScript("arguments[0].click();", clickCloseDate);
		Thread.sleep(3000);
		WebElement clickToday = driver.findElement(By.xpath("//button[text()='Today']"));
		js.executeScript("arguments[0].click();", clickToday);
	}

	@When("Select Stage as Need Analysis")
	public void select_stage_as_need_analysis() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement stage = driver.findElement(By.xpath("(//button[contains(@class,'slds-combobox__input')])[2]"));
		js.executeScript("arguments[0].click();", stage);
		driver.findElement(By.xpath("//span[@class='slds-media__body']//span[text()='Needs Analysis']")).click();
	    
	}

	@When("Click on the Save button")
	public void click_on_the_save_button() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement clickSave = driver.findElement(By.xpath("(//button[text()='Save'])[2]"));
	    js.executeScript("arguments[0].click();", clickSave);
	}

	@Then("verify the Opportunity Name")
	public void verify_the_opportunity_name() {
		String verOpportunity = driver
				.findElement(By.xpath("//slot[contains(@class,'slds-page-header')]/lightning-formatted-text"))
				.getText();
		if (verOpportunity.equals("vimalraj")|| verOpportunity.equals("vimal")) {
			System.out.println("Opportunity created successfully");
		} else {
			System.out.println("Opportunity was not created");
		}
	}

}
