package Duplicate_Records;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Firefox_Test {
    public WebDriver driver;

    @Test
    public void FirefoxTest() throws InterruptedException {
        System.setProperty("webdriver.firefox.driver", "C:\\Users\\Deepti Pandit\\IdeaProjects\\Sandbox\\Resources\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://metis-sandbox.test.eanadev.org/");
        // maximize the browser
        driver.manage().window().maximize();

        //Get started
        driver.findElement(By.xpath("/html/body/sb-root/div[3]/sb-sandbox-navigation/main/div[2]/sb-home/div/a")).click();

        // Create new data set
        driver.findElement(By.xpath("/html/body/sb-root/div[3]/sb-sandbox-navigation/main/div[2]/ul/li/label/a")).click();

        //Enter a valid name
        driver.findElement(By.xpath("/html/body/sb-root/div[3]/sb-sandbox-navigation/main/div[2]/sb-upload/form/div[1]/input")).sendKeys("Automation_Duplicate_records_firefox");

        // Selecting a country from drop down
        WebElement country_drop_down = driver.findElement(By.id("country"));
        Select select = new Select(country_drop_down);
        select.selectByVisibleText("Canada");
        select.selectByIndex(10);

        //Selecting a language from language drop down
        WebElement language_drop_down = driver.findElement(By.id("language"));
        Select select1 = new Select(language_drop_down);
        select1.selectByVisibleText("Catalan");
        select1.selectByIndex(8);

        //Selection of file upload
        WebElement radio1 = driver.findElement(By.xpath("/html/body/sb-root/div[3]/sb-sandbox-navigation/main/div[2]/sb-upload/form/div[4]/lib-protocol-field-set/div[1]/div/label[1]/input"));
        radio1.click();

        //uploading the zip file
        WebElement chooseFile = driver.findElement(By.xpath("/html/body/sb-root/div[3]/sb-sandbox-navigation/main/div[2]/sb-upload/form/div[4]/lib-protocol-field-set/div[2]/lib-file-upload/input"));
        chooseFile.sendKeys("C:\\Users\\Deepti Pandit\\IdeaProjects\\Sandbox\\Records\\record_with_duplicate_3_records.zip");

        //Initializing the step size
        WebElement stepsize = driver.findElement(By.xpath("//*[@id=\"stepSize\"]"));
        stepsize.clear();
        stepsize.sendKeys("1");

        // Submit the request
        WebElement submit_button = driver.findElement(By.xpath("/html/body/sb-root/div[3]/sb-sandbox-navigation/main/div[2]/sb-upload/form/button/span[2]"));
        submit_button.submit();
        Thread.sleep(20000);
//        Thread.sleep(1000*60*15);

        //Verifying number of duplicate records
        WebElement duplicate_count = driver.findElement(By.xpath("/html/body/sb-root/div[3]/sb-sandbox-navigation/main/div[2]/sb-progress-tracker/div/div[2]/span[7]/a/span"));
        System.out.println("Number of Duplicate records in the dataset are : " + duplicate_count.getText());

        //Verifying the text of duplicate records
        WebElement duplicate_rec = driver.findElement(By.xpath("/html/body/sb-root/div[3]/sb-sandbox-navigation/main/div[2]/sb-progress-tracker/div/div[2]/span[8]/a/span"));
        duplicate_rec.click();
        WebElement duplicate_text = driver.findElement(By.xpath("/html/body/sb-root/div[3]/sb-sandbox-navigation/main/div[2]/sb-progress-tracker/div/lib-modal/div/div/div[2]/p/div/ul/li[3]"));
        System.out.println("Error message : " + duplicate_text.getText());

        //Close the error pop-up
        WebElement close_pop_up = driver.findElement(By.cssSelector("div.footer:nth-child(3) > p:nth-child(1) > button:nth-child(1)"));
        close_pop_up.click();
        Thread.sleep(4000);

        //Verifying the number of published records
        WebElement records_count = driver.findElement(By.cssSelector("span.step-progress:nth-child(30)"));
        System.out.println("Number of Published records are : " + records_count.getText());

       //Close the browser
          driver.close();
    }
}


