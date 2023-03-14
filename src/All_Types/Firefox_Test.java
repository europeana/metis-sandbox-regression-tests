package All_Types;

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
        driver.findElement(By.xpath("/html/body/sb-root/div[3]/sb-sandbox-navigation/main/div[2]/sb-upload/form/div[1]/input")).sendKeys("Deepti_All_types_1");

        // Selecting a country from drop down
        WebElement country_drop_down = driver.findElement(By.id("country"));
        Select select = new Select(country_drop_down);
        select.selectByVisibleText("Europe");
        select.selectByIndex(17);

        //Selecting a language from language drop down
        WebElement language_drop_down = driver.findElement(By.id("language"));
        Select select1 = new Select(language_drop_down);
        select1.selectByVisibleText("Dutch");
        select1.selectByIndex(13);

        //Selection of file upload
        WebElement radio1 = driver.findElement(By.xpath("/html/body/sb-root/div[3]/sb-sandbox-navigation/main/div[2]/sb-upload/form/div[4]/lib-protocol-field-set/div[1]/div/label[1]/input"));
        radio1.click();

        //uploading the zip file
        WebElement chooseFile = driver.findElement(By.xpath("/html/body/sb-root/div[3]/sb-sandbox-navigation/main/div[2]/sb-upload/form/div[4]/lib-protocol-field-set/div[2]/lib-file-upload/input"));
        chooseFile.sendKeys("C:\\Users\\Deepti Pandit\\Documents\\Records\\Sandbox_Test\\all_record_types_1.zip");

        //Initializing the step size
        WebElement stepsize = driver.findElement(By.xpath("//*[@id=\"stepSize\"]"));
        stepsize.clear();
        stepsize.sendKeys("1");

        // Submit the request
        WebElement submit_button = driver.findElement(By.xpath("/html/body/sb-root/div[3]/sb-sandbox-navigation/main/div[2]/sb-upload/form/button/span[2]"));
        submit_button.submit();
        Thread.sleep(30000);

        //Verifying the number of published records
        WebElement records_count = driver.findElement(By.cssSelector("span.step-progress:nth-child(30)"));
        System.out.println("Number of Published records are : " + records_count.getText());

        //Verifying the dataset name, date and time dataset was created
        WebElement dataset_info = driver.findElement(By.xpath("/html/body/sb-root/div[3]/sb-sandbox-navigation/main/div[2]/sb-progress-tracker/sb-dataset-info/ul/li[1]/ul"));
        System.out.println("Dataset info : "+ dataset_info.getText());

        //Fetching the dataset id
        WebElement dataset_id = driver.findElement(By.xpath("/html/body/sb-root/div[3]/sb-sandbox-navigation/main/div[2]/sb-progress-tracker/sb-dataset-info/ul/li[2]/ul/li[1]"));
        System.out.println("Dataset Id is : " + dataset_id.getText());

        //Close the browser
        driver.close();
    }
}

