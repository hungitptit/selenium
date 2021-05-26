/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selenium;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.openqa.grid.common.SeleniumProtocol.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Admin
 */
public class SeleniumTest {
    
    public SeleniumTest() {
    }
    
    static WebDriver driver;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HUNG\\Desktop\\chromedriver.exe");
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:8080/hospital/Login.jsp");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class Selenium.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Selenium.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    @Test
    public void testDN1() {
        WebElement txtusername= driver.findElement(By.id("tvUserName"));
        WebElement txtpass= driver.findElement(By.id("txPassword"));
        
        txtusername.sendKeys("hungitptit");
        txtpass.sendKeys("manutd1998");
        driver.findElement(By.id("buttonLogin")).click();
        String expected_url="http://localhost:8080/Hospital/LoginSuccess.jsp";
        String actual_url= driver.getCurrentUrl();
        assertEquals(expected_url, actual_url);
    }
    
    @Test
    public void testDN2() {
        WebElement txtusername= driver.findElement(By.id("tvUserName"));
        WebElement txtpass= driver.findElement(By.id("txPassword"));
        
        txtusername.sendKeys("huynghiem");
        txtpass.sendKeys("12345");
        driver.findElement(By.id("buttonLogin")).click();
        String expected_url="http://localhost:8080/Hospital/LoginSuccess.js";
        String actual_url= driver.getCurrentUrl();
        assertEquals(expected_url, actual_url);
    }

    
}
