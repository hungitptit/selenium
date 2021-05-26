/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selenium;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.openqa.grid.common.SeleniumProtocol.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static selenium.SeleniumTest.driver;

/**
 *
 * @author Admin
 */
public class SeleniumTheodoids {
    
	private WebDriver driver;
	private String  baseUrl;
    public SeleniumTheodoids() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HUNG\\Desktop\\chromedriver.exe");
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        baseUrl = "http://localhost:8080/hospital";
    }
    
   
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
  
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class Selenium.
     */
    // Bấm nút tìm kiếm theo họ tên
    @Test
	public void testSelenium1() {
        try {
            driver.get(baseUrl+ "/theodoids.jsp");  
            WebElement btnHoten = driver.findElement(By.id("btn-hoten"));
            Thread.sleep(100);
            btnHoten.click();
            
            Thread.sleep(500);
            
            String expected_url=baseUrl+"/person.jsp";
            String actual_url= driver.getCurrentUrl();
            assertEquals(expected_url, actual_url);
            
            
            

        }catch (Exception e) {
		}
		driver.close();
	}
        
        //Nhập tên đúng , bấm nút tìm kiếm
	@Test
	public void testSelenium2() {
        try {
            driver.get(baseUrl+ "/person.jsp");  
         
           
 
            
            WebElement searchText = driver.findElement(By.name("name"));
            Thread.sleep(100);
            searchText.sendKeys("hung");
            
            Thread.sleep(100);
            WebElement btnTim = driver.findElement(By.id("btn-search"));
            btnTim.click();
            
            Thread.sleep(500);
            WebElement tbl = driver.findElement(By.id("table"));
             assertEquals(tbl, null);
            //Assert.assertNull(tbl);

        }catch (Exception e) {
		}
		driver.close();
	}
	
	//Nhập kí tự đặc biệt vào ô tìm kiếm
	

}
