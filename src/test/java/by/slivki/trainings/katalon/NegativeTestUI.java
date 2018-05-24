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
import static org.junit.Assert.assertFalse;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestPropertySource(locations = "classpath:application-test.properties")
public class NegativeTestUI {

    private WebDriver driver;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testSignIn() throws Exception {
        driver.get("http://localhost:8080/?lang=en");
        driver.findElement(By.xpath("//main")).click();
        driver.findElement(By.linkText("Sign Up")).click();
        driver.findElement(By.xpath("//label")).click();
        driver.findElement(By.id("login")).clear();
        driver.findElement(By.id("login")).sendKeys("${login}");
        driver.findElement(By.xpath("//div[2]/label")).click();
        driver.findElement(By.id("mail")).clear();
        driver.findElement(By.id("mail")).sendKeys("email");
        driver.findElement(By.xpath("//div[3]/label")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("//div[4]/label")).click();
        driver.findElement(By.id("confirm")).clear();
        driver.findElement(By.id("confirm")).sendKeys("password");
        driver.findElement(By.id("confirm")).click();
        // Warning: verifyTextNotPresent may require manual changes
        try {
            assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*//div/div/div[\\s\\S]*$"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @Test
    public void testAddedTraining() throws Exception {
        driver.get("http://localhost:8080/?lang=en");
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("trainer");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("12345678");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//div[@id='result']/div/div/a/div")).click();
        driver.findElement(By.xpath("//div/div/ul/li/a/span")).click();
        driver.findElement(By.id("add")).click();
        driver.findElement(By.id("title")).click();
        driver.findElement(By.id("title")).clear();
        driver.findElement(By.id("title")).sendKeys("title");
        driver.findElement(By.id("participants")).click();
        driver.findElement(By.id("participants")).clear();
        driver.findElement(By.id("participants")).sendKeys("${countParticipantTraning}");
        driver.findElement(By.id("for-whom")).click();
        driver.findElement(By.id("for-whom")).clear();
        driver.findElement(By.id("for-whom")).sendKeys("${whomTraning}");
        driver.findElement(By.id("goal")).click();
        driver.findElement(By.id("goal")).clear();
        driver.findElement(By.id("goal")).sendKeys("${goalTraning}");
        driver.findElement(By.id("description")).click();
        driver.findElement(By.id("description")).clear();
        driver.findElement(By.id("description")).sendKeys("${descriptionTraning}");
        driver.findElement(By.id("ok")).click();
        driver.findElement(By.xpath("//div[@id='content']/div/div[4]/label")).click();
        // Warning: verifyTextNotPresent may require manual changes
        try {
            assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*//div/div/div[\\s\\S]*$"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.linkText("Exit")).click();
    }

    @Test
    public void testSearchTraining() throws Exception {
        driver.get("http://localhost:8080/?lang=en");
        driver.findElement(By.id("username")).click();
        driver.findElement(By.xpath("//div/div/div[2]")).click();
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("user");
        driver.findElement(By.xpath("//div/div/div[2]")).click();
        driver.findElement(By.xpath("//div/div/div")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("12345678");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.id("search")).click();
        driver.findElement(By.id("show-search")).click();
        driver.findElement(By.xpath("//div[@id='content']/div/div[3]/label")).click();
        driver.findElement(By.xpath("//div[@id='content']/div/div[3]/label")).click();
        driver.findElement(By.id("search")).click();
        driver.findElement(By.id("search")).clear();
        driver.findElement(By.id("search")).sendKeys("${nameTraning}");
        driver.findElement(By.xpath("//div[@id='content']/div/div[4]/label")).click();
        driver.findElement(By.id("trainer")).clear();
        driver.findElement(By.id("trainer")).sendKeys("tr");
        driver.findElement(By.xpath("//div[@id='content']/div/div[5]/label")).click();
        driver.findElement(By.id("for-whom")).clear();
        driver.findElement(By.id("for-whom")).sendKeys("${whomTraning}");
        driver.findElement(By.xpath("//div[@id='content']/div/div[6]/label")).click();
        driver.findElement(By.id("goal")).clear();
        driver.findElement(By.id("goal")).sendKeys("${goalTraning}");
        driver.findElement(By.id("adv-search")).click();
        driver.findElement(By.linkText("Exit")).click();
    }


    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
