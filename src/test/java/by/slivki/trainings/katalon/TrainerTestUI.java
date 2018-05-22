package by.slivki.trainings.katalon;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestPropertySource(locations = "classpath:application-test.properties")
public class TrainerTestUI {

    private WebDriver driver;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testTrainerShowTrainings() throws Exception {
        driver.get("http://localhost:8080/?lang=en");
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("trainer");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("12345678");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        try {
            assertEquals("trainer", driver.findElement(By.id("username")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.linkText("Exit")).click();
    }

    @Test
    public void testTrainerShowReports() throws Exception {
        driver.get("http://localhost:8080/?lang=en");
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("trainer");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("12345678");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//li[2]/a/span")).click();
        try {
            assertEquals("Id", driver.findElement(By.xpath("//div[@id='content']/div/div/b")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("From", driver.findElement(By.xpath("//div[@id='content']/div/div[2]/b")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("Training", driver.findElement(By.xpath("//div[@id='content']/div/div[3]/b")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("Task", driver.findElement(By.xpath("//div[@id='content']/div/div[4]/b")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("CreatedBy", driver.findElement(By.xpath("//div[@id='content']/div/div[5]/b")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.linkText("Exit")).click();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
