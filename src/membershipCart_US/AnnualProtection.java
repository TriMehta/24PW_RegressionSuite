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

public class AnnualProtection {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\Tripti.Mehta\\OneDrive - Pethealth Inc\\Desktop\\Automation\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.24petwatch.com/");
	}

	@Test
	public void AnnualMembership() {
		WebElement dropDown = driver.findElement(By.cssSelector("a[id='button-bb96d5d337'] span[class='cmp-button__text']"));
		dropDown.click();
        
		WebElement getStarted = driver.findElement(By.cssSelector("a[id='button-2a448f7e0b'] span[class='cmp-button__text']"));
		getStarted.click();

	}

	@Test
	public void AnnualQuote() throws InterruptedException {
		Thread.sleep(3000);
		WebElement petName = driver.findElement(By.xpath("//input[@id='input-f643d97dee']"));
		petName.sendKeys("Zimba");
		WebElement petType = driver.findElement(By.xpath("//label[normalize-space()='Dog']"));
		petType.click();
		WebElement petCategory = driver.findElement(By.xpath("//label[normalize-space()='Purebred']"));
		petCategory.click();
		Thread.sleep(2000);

		// auto suggestive drop down
		WebElement petBreed = driver.findElement(By.xpath("//input[@id ='input-2d4175d9a0']"));
		petBreed.sendKeys("gol");
		petBreed.sendKeys(Keys.DOWN);
		Thread.sleep(5000);
		String addPetBreed = "return document.getElementById('input-2d4175d9a0').value";
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
		WebElement petMicrochip = driver.findElement(By.xpath("//input[@id='input-bef6a78934']"));
		petMicrochip.sendKeys("3876512348");
		WebElement petEmail = driver.findElement(By.xpath("//input[@id='input-da14a0d91d']"));
		petEmail.sendKeys("t@gmail.com");
		WebElement petZipCode = driver.findElement(By.xpath("//input[@id='input-6edcd6d41e']"));
		petZipCode.sendKeys("92101");
		
		//checking PetInfo Checkbox
		WebElement petInfoCheckbox = driver.findElement(By.xpath("//span[@class='check']"));
		petInfoCheckbox.click();
		boolean petInfoflag = petInfoCheckbox.isDisplayed();
		System.out.println("petInfoflag");

		if (petInfoflag == true) {
			petInfoCheckbox.click();
		}

		Thread.sleep(3000);

		WebElement ContinueBtn = driver.findElement(By.xpath("//span[@class='cmp-button__text']"));
		ContinueBtn.click();
		Thread.sleep(2000);
	}
		
	   @Test
	   public void SummaryQuote() throws InterruptedException {
			// Add Pet
			Thread.sleep(3000);
			WebElement addNewPet = driver.findElement(By.xpath("//span[@class='cmp-cartsummary--addpetinline-header-add']"));
			addNewPet.click();
			driver.findElement(By.xpath("//input[@id='input-eb28e3b0e7']")).sendKeys("Bruno");
			driver.findElement(By.xpath("//label[normalize-space()='Dog']")).click();
			driver.findElement(By.xpath("//label[normalize-space()='Mixed']")).click();
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
			driver.findElement(By.xpath("//input[@id='input-e8f9dac079']")).sendKeys("3876512345");
			Thread.sleep(3000);
			
			WebElement cartSummaryCheckbox = driver.findElement(By.xpath("//span[@class='check']"));

			boolean cartSummaryflag = cartSummaryCheckbox.isDisplayed();
			System.out.println("bool3");

			if (cartSummaryflag == true) {
				cartSummaryCheckbox.click();
			}
			Thread.sleep(3000);
			WebElement addPetBtn = driver.findElement(By.xpath("//span[normalize-space()='Add pet']"));
			addPetBtn.click();
			
			WebElement AddToCart = driver.findElement(By.xpath("//a[@id='addtocartbutton-8cc3b2cfb2']//span[@class='cmp-button__text'][normalize-space()='Add to Cart']"));
			AddToCart.click();
			
			  JavascriptExecutor jse = (JavascriptExecutor) driver;
			   jse.executeScript("window.scrollBy(0,2500);"); 
			   Thread.sleep(2000);
			 

			WebElement paymentBtn = driver.findElement(By.xpath("//span[normalize-space()='Proceed to Payment']"));
			paymentBtn.click();
			Thread.sleep(2000);
		}

		
		/*
		 * @AfterClass public void tearDown() { driver.quit();
		 * 
		 * }
		 */
		 
	}



