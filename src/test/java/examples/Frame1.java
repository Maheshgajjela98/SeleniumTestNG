package examples;
		import org.openqa.selenium.By;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.chrome.ChromeDriver;
		import org.openqa.selenium.support.ui.Select;

		public class Frame1 {

			public static void main(String[] args) throws Exception {
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
				driver.findElement(By.id("name")).sendKeys("text1"); // main page
				Thread.sleep(5000);
				driver.switchTo().frame("frm1");  // frame 1
				Select courseName_dd = new Select(driver.findElement(By.id("course")));
				courseName_dd.selectByVisibleText("Java");
				Thread.sleep(5000);
				driver.switchTo().defaultContent();  // main page
				driver.switchTo().frame("frm2");    // frame 2
				driver.findElement(By.id("firstName")).sendKeys("pirnao");
				Thread.sleep(5000);
				driver.switchTo().defaultContent();  // main page
				driver.switchTo().frame("frm1");  // frame 1
				courseName_dd.selectByVisibleText("Dot Net");
				Thread.sleep(5000);
				driver.switchTo().defaultContent(); // main page
				driver.findElement(By.id("name")).clear();
				driver.findElement(By.id("name")).sendKeys("text2");
				
			}

		} 

	
