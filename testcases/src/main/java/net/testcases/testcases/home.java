package net.testcases.testcases;

import java.io.IOException;
import java.sql.Driver;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class home extends browser{

		public home() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

		By My_Account=By.xpath("//div[@class='dropdown dropdown-login dropdown-tab']//a[@id='dropdownCurrency']");
        By Login=By.xpath("//a[@class='dropdown-item active tr']");
        By Sign_Up=By.xpath("//a[@class='dropdown-item tr']");
        By hotels=By.xpath("//a[contains(@class,'text-center hotels active')]");
        By Flight=By.xpath("//a[contains(text(),'Flights')]");
        By Tour=By.xpath("//li[@class='text-center active']//a[@class='text-center']");
       
	

        public void Sign_Up() throws InterruptedException
        {
        	Thread.sleep(1000);
        	driver.findElement(My_Account).click();
        	driver.findElement(Sign_Up).click();	
        }
        
        
        public void Login()
        {
        	driver.findElement(My_Account).click();
        	driver .findElement(Login).click();	
        }
        
        
        public void Hotels()
        {
        	
        	driver.findElement(hotels).click();	
        }
        
        public void Flight()
        {
        	
        	driver.findElement(Flight).click();	
        }
     
        public void Tour()
        {
        	driver.findElement(Tour).click();
        }

public static void main(String[]args) throws IOException{
	try {

	home h=new home();
	h.Sign_Up();
	h.Login();
	h.Hotels();
	h.Flight();
	h.Tour();
}
	catch(InterruptedException e)
	{
			

		}

}
}
