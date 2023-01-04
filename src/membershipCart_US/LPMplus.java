package membershipCart_US;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LPMplus {
	WebDriver driver;
	
	@BeforeClass
	public void setUp() { 
	System.setProperty("webdriver.edge.driver","C:\\Users\\Tripti.Mehta\\OneDrive - Pethealth Inc\\Desktop\\Automation\\msedgedriver.exe"); 
	driver = new EdgeDriver(); driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://www.24petwatch.com/lost-pet-protection/lpm-plus"); 
	  }
	 
	 @Test
	  public void SelectMembership() {
	 
	  WebElement dropDown = driver.findElement(By.cssSelector("a[href*='#']"));
	  dropDown.click(); 
	  WebElement petProtection = driver.findElement(By.xpath("//a[@class='cmp-navigation__item-link'][normalize-space()='Pet Protection Membership']" )); 
	  petProtection.click(); 
	  WebElement getStarted = driver.findElement(By.xpath("//a[@id='button-190a685589']"));
	  getStarted.click();
	 }
	 
	
	@Test
	public void AddPetForm() throws InterruptedException{
		WebElement petName = driver.findElement(By.id("input-817f9fe9db"));
		petName.sendKeys("Bruno");
		WebElement petType = driver.findElement(By.xpath("//label[normalize-space()='Dog']"));
		petType.click();
		WebElement petCategory = driver.findElement(By.xpath("//label[normalize-space()='Purebred']"));
		petCategory.click();
		Thread.sleep(2000);
		
		// auto suggestive dropdown
		WebElement petBreed = driver.findElement(By.xpath("//input[@id='input-9c24b30104']"));
		petBreed.sendKeys("Gol");
		petBreed.sendKeys(Keys.DOWN);
		Thread.sleep(3000);

		// JavascriptExecutor API to select Pet's breed
		String addPetBreed = "return document.getElementById('input-9c24b30104').value";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String petBreedText = (String) js.executeScript(addPetBreed);
		System.out.println("Option selected is from" + petBreedText);
		while (!(petBreedText.equalsIgnoreCase("Goldendoodle"))) {
			petBreed.sendKeys(Keys.DOWN);
			Thread.sleep(3000);
			petBreedText = (String) js.executeScript(addPetBreed);
		}
		petBreed.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		WebElement petMicrochip = driver.findElement(By.id("input-9f5b3064ac"));
		petMicrochip.sendKeys("1234567894");
		WebElement emailID = driver.findElement(By.id("input-f95492ac44"));
		emailID.sendKeys("t@gmail.com");
		WebElement zipCode = driver.findElement(By.id("input-aa64781142"));
		zipCode.sendKeys("92101");
		WebElement petInfoCheckbox = driver.findElement(By.xpath("//span[@class='check']"));
		petInfoCheckbox.click();
		boolean petInfoFlag = petInfoCheckbox.isDisplayed();
		System.out.println("petInfoFlag");
		
		if (petInfoFlag == true) {
			petInfoCheckbox.click();
		}
		Thread.sleep(3000);
		WebElement continueButton = driver.findElement(By.xpath("//span[@class='cmp-button__text']"));
		continueButton.click();
		Thread.sleep(2000);
	}
    @Test
    public void SummaryQuote() throws InterruptedException
    {
    	WebElement addNewPet = driver.findElement(By.xpath("//span[@class='cmp-cartsummary--addpetinline-header-add']"));
    	addNewPet.click();
    	WebElement newPetName = driver.findElement(By.xpath("//input[@id='input-eb28e3b0e7']"));
    	newPetName.sendKeys("Appy");
    	WebElement newPetType = driver.findElement(By.xpath("//label[normalize-space()='Dog']"));
    	newPetType.click();
    	WebElement newPetCategory = driver.findElement(By.xpath("//label[normalize-space()='Mixed']"));
    	newPetCategory.click();
    	Thread.sleep(3000);
    	
    	// auto suggestive dropdown
    	WebElement newPetBreed = driver.findElement(By.xpath("//input[@id='input-59b3cb5a93']"));
        newPetBreed.sendKeys("Ger");
    	newPetBreed.sendKeys(Keys.DOWN);

    	String addNewPetBreed = "return document.getElementById('input-59b3cb5a93').value";

    			// use JavascriptExecutor API
    	JavascriptExecutor js1 = (JavascriptExecutor) driver;
    	String addPetBreedText = (String) js1.executeScript(addNewPetBreed);
    	System.out.println("Output is selected from" + addPetBreedText);
    	while (!(addPetBreedText.equalsIgnoreCase("German Shepherd Dog Mix"))) {
    				newPetBreed.sendKeys(Keys.DOWN);
    				Thread.sleep(3000);
    				addPetBreedText = (String) js1.executeScript(addNewPetBreed);
    			}
    			newPetBreed.sendKeys(Keys.ENTER);
    			Thread.sleep(3000);
    			
    			WebElement newPetMicrochip = driver.findElement(By.xpath("//input[@id='input-e8f9dac079']"));
    			newPetMicrochip.sendKeys("3876512345");
    			
    			WebElement cartSummaryCheckbox = driver.findElement(By.xpath("//span[@class='check']"));

    			boolean cartSummaryflag = cartSummaryCheckbox.isDisplayed();
    			System.out.println("bool3");

    			if (cartSummaryflag == true) {
    				cartSummaryCheckbox.click();
    			}
    			Thread.sleep(3000);
    			WebElement addPetBtn = driver.findElement(By.xpath("//span[normalize-space()='Add pet']"));
    			addPetBtn.click();
		        
    			WebElement addToCart = driver.findElement(By.xpath("//a[@id='addtocartbutton-fe16fa0927']"));
    			addToCart.click();
    			JavascriptExecutor jse = (JavascriptExecutor) driver;
    			jse.executeScript("window.scrollBy(0,2500);");
    			Thread.sleep(2000);
    			
    			WebElement ProceedToPayment = driver.findElement(By.xpath("//div[@class='proceedtopayment button cmp-button--styleprimary']//a[@id='next']"));
    			ProceedToPayment.click();
    			Thread.sleep(2000);
    }
}

