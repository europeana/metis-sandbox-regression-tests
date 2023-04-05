package Step_Size;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Chrome_Test {
    public WebDriver driver;

    // @Parameters("browserName")
    @Test
    public void ChromeTest() throws InterruptedException {
        //if (browser.equalsIgnoreCase("chrome")) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Deepti Pandit\\IdeaProjects\\Sandbox\\Resources\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://metis-sandbox.test.eanadev.org/");

        // maximize the browser
        driver.manage().window().maximize();

        //Get started
        driver.findElement(By.xpath("/html/body/sb-root/div[3]/sb-sandbox-navigation/main/div[2]/sb-home/div/a")).click();

        // Create new data set
        driver.findElement(By.xpath("/html/body/sb-root/div[3]/sb-sandbox-navigation/main/div[2]/ul/li/label/a")).click();

        //Enter a valid name
        driver.findElement(By.xpath("/html/body/sb-root/div[3]/sb-sandbox-navigation/main/div[2]/sb-upload/form/div[1]/input")).sendKeys("Automation_Step_size_chrome");

        // Selecting a country from drop down
        WebElement country_drop_down = driver.findElement(By.id("country"));
        Select select = new Select(country_drop_down);
        select.selectByVisibleText("San Marino");
        select.selectByIndex(49);

        //Selecting a language from language drop down
        WebElement language_drop_down = driver.findElement(By.id("language"));
        Select select1 = new Select(language_drop_down);
        select1.selectByVisibleText("Turkish");
        select1.selectByIndex(47);

        //Selection of file upload
        WebElement radio1 = driver.findElement(By.xpath("/html/body/sb-root/div[3]/sb-sandbox-navigation/main/div[2]/sb-upload/form/div[4]/lib-protocol-field-set/div[1]/div/label[1]/input"));
        radio1.click();

        //uploading the zip file
        WebElement chooseFile = driver.findElement(By.xpath("/html/body/sb-root/div[3]/sb-sandbox-navigation/main/div[2]/sb-upload/form/div[4]/lib-protocol-field-set/div[2]/lib-file-upload/input"));
        chooseFile.sendKeys("C:\\Users\\Deepti Pandit\\IdeaProjects\\Sandbox\\Records\\all_record_types_1.zip");

        //Initializing the step size
        WebElement stepsize = driver.findElement(By.xpath("//*[@id=\"stepSize\"]"));
        stepsize.clear();
        stepsize.sendKeys("3");

        // Submit the request
        WebElement submit_button = driver.findElement(By.xpath("/html/body/sb-root/div[3]/sb-sandbox-navigation/main/div[2]/sb-upload/form/button/span[2]"));
        submit_button.submit();
        Thread.sleep(10000);

        //Verifying the step size
        WebElement step_size = driver.findElement(By.cssSelector("span.step-progress:nth-child(30)"));
        System.out.println("Number of Published records as per initialized step size : "+ step_size.getText());

        //Close the browser
        driver.close();

    }
}
