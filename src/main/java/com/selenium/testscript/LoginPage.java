package com.selenium.testscript;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

public class LoginPage {

    public static WebDriver driver = null;
    public static By username = By.id("login-username");
    public static By lgpassword = By.id("login-passwd");
    public static By login = By.id("login-signin");
    public static String strUsername;
    public static String strPassword;
    public static String baseDir="Enter your unzip location"

    public static void OpenUrl() {
        System.setProperty("webdriver.chrome.driver", baseDir+"/JTestFrameWork/resources/chromedriver");
        driver = new ChromeDriver();
        String baseUrl = "https://login.yahoo.com/?.src=ym&.intl=us&.lang=en-US&.done=https%3a//mail.yahoo.com";
        driver.manage().window().maximize();
        driver.get(baseUrl);
        System.out.println("URL Successfully Opened");
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

        // TODO Auto-generated method stub

    }

    public static void setUserName() {
        // TODO Auto-generated method stub
        System.out.println("vsan9394");
        System.out.println(strUsername);
        //fOLSOM)98
        driver.findElement(username).sendKeys(strUsername);
        driver.findElement(By.id("login-signin")).click();

    }

    public static void setPassword() {
        // TODO Auto-generated method stub
        System.out.println(strPassword);
        driver.findElement(lgpassword).sendKeys(strPassword);
        driver.findElement(By.id("login-signin")).click();

    }

    public static void readCredfromExcel(){
        // TODO Auto-generated method stub
        try {
            File src = new File(baseDir+"/JTestFrameWork/resources/Cred.xlsx");
            FileInputStream fis = new FileInputStream(src);
            @SuppressWarnings("resource")
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);
            strUsername = sheet.getRow(1).getCell(0).getStringCellValue();
            strPassword = sheet.getRow(1).getCell(1).getStringCellValue();
            System.out.println("User name"+strUsername);
            System.out.println("User name"+strPassword);
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        }
    }

    public static void loginToWorkStation() {
        // TODO Auto-generated method stub
        System.out.println("strUsername");
        LoginPage.setUserName();
        LoginPage.setPassword();
        LoginPage.clickLogin();
    }

    public void tearDown() {
        if(driver!=null) {
            System.out.println("Closing chrome browser");
            driver.quit();
        }
    }

    private static void clickLogin() {
        // TODO Auto-generated method stub

    }

    public static void main(String[] args) {
        LoginPage lp = new LoginPage();
        try {
            lp.readCredfromExcel();
            lp.OpenUrl();
            lp.setUserName();
            lp.setPassword();
    //        lp.tearDown();
        }catch (Exception e){
            System.out.println("Error");
        }
    }


}
