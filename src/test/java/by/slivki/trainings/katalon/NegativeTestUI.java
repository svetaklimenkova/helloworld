package by.slivki.trainings.katalon;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NegativeTestUI {

    private static WebDriver driver;
    private StringBuffer verificationErrors = new StringBuffer();
    private static final String REGISTRATION = "D://csv/registration.csv";
    private static final String OSTAL = "D://csv/ostal.csv";
    private static final String LOGIN = "\uFEFFlogin";
    private static final String PASSWORD = "password";
    private static final String EMAIL = "email";
    private static final String MESSAGE = "MESSAGE";
    private static final String NAME_CATEGORY = "\uFEFFnameCategory";
    private static final String NAME_TRAINING = "nameTraning";
    private static final String DESCRIPTION = "descriptionTraning";
    private static final String WHOM = "whomTraning";
    private static final String GOAL = "goalTraning";
    private static final String COUNT = "countParticipantTraning";
    private static final String TASK = "taskTraning";
    private static final String STAGE = "stagesTraning";
    private static final String SEARCH = "stagesTraning";


    private static CSVParser registrationCsvParser;
    private static CSVParser ostalCsvParser;

    @BeforeClass
    public static void beforeClass() throws IOException {
        System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Reader reader = Files.newBufferedReader(Paths.get(REGISTRATION));
        registrationCsvParser = new CSVParser(reader, CSVFormat.EXCEL
                .withDelimiter(';')
                .withFirstRecordAsHeader()
                .withIgnoreHeaderCase());
        reader = Files.newBufferedReader(Paths.get(OSTAL));
        ostalCsvParser = new CSVParser(reader, CSVFormat.RFC4180
                .withDelimiter(';')
                .withFirstRecordAsHeader()
                .withIgnoreHeaderCase());
    }

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void afterClass() throws IOException {
        ostalCsvParser.close();
        registrationCsvParser.close();
    }

    @Test
    public void testSignUp() throws Exception {
        for (CSVRecord csvRecord : registrationCsvParser) {
            driver.get("http://localhost:8080/signUp?lang=en");
            driver.findElement(By.id("login")).clear();
            driver.findElement(By.id("login")).sendKeys(csvRecord.get(LOGIN));
            driver.findElement(By.id("mail")).clear();
            driver.findElement(By.id("mail")).sendKeys(csvRecord.get(EMAIL));
            driver.findElement(By.id("password")).clear();
            driver.findElement(By.id("password")).sendKeys(csvRecord.get(PASSWORD));
            driver.findElement(By.id("confirm")).clear();
            driver.findElement(By.id("confirm")).sendKeys(csvRecord.get(PASSWORD));
            driver.findElement(By.id("confirm")).click();
            try {
                assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*//div/div/div[\\s\\S]*$"));
            } catch (Error e) {
                verificationErrors.append(e.toString());
            }
        }
    }

    @Test
    public void testBecomeTrainer() throws Exception {
        for (CSVRecord csvRecord : registrationCsvParser) {
            driver.get("http://localhost:8080/applications/trainer?lang=en");
            driver.findElement(By.id("login")).clear();
            driver.findElement(By.id("login")).sendKeys(csvRecord.get(LOGIN));
            driver.findElement(By.id("mail")).clear();
            driver.findElement(By.id("mail")).sendKeys(csvRecord.get(EMAIL));
            driver.findElement(By.id("MESSAGE")).clear();
            driver.findElement(By.id("MESSAGE")).sendKeys(csvRecord.get(MESSAGE));
            driver.findElement(By.id("btn_sign_up")).click();
            try {
                assertFalse(driver.findElement(By.xpath("//div[5]")).isDisplayed());
            } catch (Error e) {
                verificationErrors.append(e.toString());
            }
        }
    }

    @Test
    public void testForgotPassword() throws Exception {
        for (CSVRecord csvRecord : registrationCsvParser) {
            driver.get("http://localhost:8080/applications/password?lang=en");
            driver.findElement(By.id("mail")).clear();
            driver.findElement(By.id("mail")).sendKeys(csvRecord.get(EMAIL));
            try {
                assertTrue(driver.findElement(By.xpath("//i[@class='glyphicon glyphicon-remove']")).isDisplayed());
            } catch (Error e) {
                verificationErrors.append(e.toString());
            }
        }
    }

    @Test
    public void testChangeEmail() throws Exception {
        driver.get("http://localhost:8080/?lang=en");
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("user");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("12345678");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.get("http://localhost:8080/profile");
        for (CSVRecord csvRecord : registrationCsvParser) {
            driver.findElement(By.id("mail")).clear();
            driver.findElement(By.id("mail")).sendKeys(csvRecord.get(EMAIL));
            driver.findElement(By.id("btn_sign_up")).click();
            try {
                assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Changes saved\\.[\\s\\S]*$"));
            } catch (Error e) {
                verificationErrors.append(e.toString());
            }
        }
        driver.findElement(By.linkText("Exit")).click();
    }

    @Test
    public void testChangePassword() throws Exception {
        driver.get("http://localhost:8080/?lang=en");
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("user");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("12345678");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.get("http://localhost:8080/profile");
        for (CSVRecord csvRecord : registrationCsvParser) {
            driver.findElement(By.id("password")).clear();
            driver.findElement(By.id("password")).sendKeys(csvRecord.get(PASSWORD));
            driver.findElement(By.id("confirm")).clear();
            driver.findElement(By.id("confirm")).sendKeys(csvRecord.get(PASSWORD));
            driver.findElement(By.id("btn_sign_up")).click();
            try {
                assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Changes saved\\.[\\s\\S]*$"));
            } catch (Error e) {
                verificationErrors.append(e.toString());
            }
        }
        driver.findElement(By.linkText("Exit")).click();
    }

    @Test
    public void testSignIn() throws Exception {
        for (CSVRecord csvRecord : registrationCsvParser) {
            driver.get("http://localhost:8080/?lang=en");
            driver.findElement(By.id("username")).clear();
            driver.findElement(By.id("username")).sendKeys(csvRecord.get(LOGIN));
            driver.findElement(By.id("password")).clear();
            driver.findElement(By.id("password")).sendKeys(csvRecord.get(PASSWORD));
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            try {
                assertEquals("Invalid username or password", driver.findElement(By.id("error")).getText());
            } catch (Error e) {
                verificationErrors.append(e.toString());
            }
        }
    }

    @Test
    public void testAddedTraining() throws Exception {
        driver.get("http://localhost:8080/?lang=en");
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("trainer");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("12345678");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.get("http://localhost:8080/trainings/create/?lang=en");
        for (CSVRecord csvRecord : ostalCsvParser) {
            driver.findElement(By.id("title")).clear();
            driver.findElement(By.id("title")).sendKeys("title");
            driver.findElement(By.id("participants")).clear();
            driver.findElement(By.id("participants")).sendKeys(csvRecord.get(COUNT));
            driver.findElement(By.id("for-whom")).clear();
            driver.findElement(By.id("for-whom")).sendKeys(csvRecord.get(WHOM));
            driver.findElement(By.id("goal")).clear();
            driver.findElement(By.id("goal")).sendKeys(csvRecord.get(GOAL));
            driver.findElement(By.id("description")).clear();
            driver.findElement(By.id("description")).sendKeys(csvRecord.get(DESCRIPTION));
            driver.findElement(By.id("ok")).click();
            try {
                assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*//div/div/div[\\s\\S]*$"));
            } catch (Error e) {
                verificationErrors.append(e.toString());
            }
        }
        driver.findElement(By.linkText("Exit")).click();
    }

    @Test
    public void testEditTraining() throws Exception {
        driver.get("http://localhost:8080/?lang=en");
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("trainer");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("12345678");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.get("http://localhost:8080/trainings/edit/1");
        for (CSVRecord csvRecord : ostalCsvParser) {
            driver.findElement(By.id("title")).clear();
            driver.findElement(By.id("title")).sendKeys("title");
            driver.findElement(By.id("participants")).clear();
            driver.findElement(By.id("participants")).sendKeys(csvRecord.get(COUNT));
            driver.findElement(By.id("for-whom")).clear();
            driver.findElement(By.id("for-whom")).sendKeys(csvRecord.get(WHOM));
            driver.findElement(By.id("goal")).clear();
            driver.findElement(By.id("goal")).sendKeys(csvRecord.get(GOAL));
            driver.findElement(By.id("description")).clear();
            driver.findElement(By.id("description")).sendKeys(csvRecord.get(DESCRIPTION));
            driver.findElement(By.id("ok")).click();
            try {
                assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*//div/div/div[\\s\\S]*$"));
            } catch (Error e) {
                verificationErrors.append(e.toString());
            }
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

    @Test
    public void testAddCategory() throws Exception {
        driver.get("http://localhost:8080/?=en");
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("12345678");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.get("http://localhost:8080/categories");
        for (CSVRecord csvRecord : ostalCsvParser) {
            driver.findElement(By.id("category")).clear();
            driver.findElement(By.id("category")).sendKeys(csvRecord.get(NAME_CATEGORY));
            driver.findElement(By.id("add")).click();
            try {
                assertEquals("Category name length should be from 2 to 50 letters.", driver.findElement(By.id("error_message")).getText());
            } catch (Error e) {
                verificationErrors.append(e.toString());
            }
        }
        driver.findElement(By.linkText("Exit")).click();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
