package Large_Dataset;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
    public WebDriver driver;

    // @Parameters("browserName")
    @org.testng.annotations.Test
    public void ChromeTest() throws InterruptedException {
        //if (browser.equalsIgnoreCase("chrome")) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Deepti Pandit\\IdeaProjects\\Sandbox\\Resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://metis-sandbox.test.eanadev.org/");
        // maximize the browser
        driver.manage().window().maximize();

        //Get started
        driver.findElement(By.xpath("/html/body/sb-root/div[3]/sb-sandbox-navigation/main/div[2]/sb-home/div/a")).click();
        WebElement track = driver.findElement(By.xpath("//*[@id=\"dataset-to-track\"]"));
        track.click();
        track.sendKeys("862");
        driver.findElement(By.xpath("/html/body/sb-root/div[3]/sb-sandbox-navigation/main/div[2]/div[3]/span[2]/button/span[2]")).click();
        driver.findElement(By.xpath("/html/body/sb-root/div[3]/sb-sandbox-navigation/main/div[2]/sb-progress-tracker/sb-dataset-info/ul/li[1]/ul/li[3]/span[2]/a/span")).click();
        WebElement text = driver.findElement(By.xpath("/html/body/sb-root/div[3]/sb-sandbox-navigation/main/div[2]/sb-progress-tracker/sb-dataset-info/ul/li[1]/ul/li[3]/span[2]/lib-modal/div/div/div[2]/p/p[1]"));
        System.out.println("Error message is : " + text.getText());
    }
}
