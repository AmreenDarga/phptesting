package net.testcases.testcases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Hotel extends home{

	public Hotel() throws IOException {
		super();
		
	}

	
	By Hotel_name=By.xpath("//div[@id='s2id_autogen1']");
    By Check_in=By.xpath("//input[@id='checkin']");
    By Check_out=By.xpath("//input[@id='checkout']");
    By Adult=By.xpath("//div[contains(@class,'col o2')]//input[contains(@placeholder,'0')]");
    By Child=By.xpath("//div[contains(@class,'col 01')]//input[contains(@placeholder,'0')]");
    
    By search=By.xpath("//div[contains(@class,'col-md-2 col-xs-12 o1')]//button[contains(@class,'btn btn-primary btn-block')][contains(text(),'Search')]");
    
    
     public void Hotel_name() throws InterruptedException  {
    	 driver.findElement(Hotel_name).click();
     	 driver.findElement(By.xpath("//div[@id='select2-drop']//input[@class='select2-input']")).sendKeys(p.getProperty("hotel_name"));
     	 driver.findElement(By.xpath("//div[contains(text(),'India')]")).click();
     	 
     	
     }

    public void Check_in() throws InterruptedException
     {
    	
    	 driver.findElement(Check_in).click();
    	 Thread.sleep(1000);
    	
    	 String s1=driver.findElement(By.xpath("//div[1]//nav[1]//div[2] ")).getText();//month
    		do
    	 {
    		 driver.findElement(By.xpath("//body[contains(@class,'with-waypoint-sticky')]/div[@id='datepickers-container']/div[1]/nav[1]/div[3]/*[1]")).click();//next
    		 s1=driver.findElement(By.xpath("//div[1]//nav[1]//div[2]")).getText();//month}
    		 
    	 }
    		while(s1.equalsIgnoreCase(p.getProperty("check_in")));
    		List<WebElement> dates=driver.findElements(By.xpath("//*[@id='datepickers-container']/div[1]/div/div[1]/div[2]/div"));
    		int count=driver.findElements(By.xpath("//*[@id='datepickers-container']/div[1]/div/div[1]/div[2]/div")).size();
    		System.out.println("count"+count);
    		
    	
    	 for(int i=0;i<count;i++)
    	 {
    		 String date=driver.findElements(By.xpath("//*[@id='datepickers-container']/div[1]/div/div[1]/div[2]/div")).get(i).getText();
    		 if(date.equals(p.getProperty("indate")))
    		 {
    			 driver.findElement(By.xpath("//*[@id='datepickers-container']/div[1]/div/div[1]/div[2]/div[contains(text(),"+p.getProperty("indate")+")]")).click();

    		 
    		 }
    	 }
    	
     }
     

    public void Check_out() throws InterruptedException
     {
    	
    	 driver.findElement(Check_out).click();
    	 Thread.sleep(1000);
    	
    	 String s1=driver.findElement(By.xpath("//div[@id='datepickers-container']//div[2]//nav[1]//div[2]")).getText();//month
    		do
    	 {
    		 driver.findElement(By.xpath("//body[@class='with-waypoint-sticky']/div[@id='datepickers-container']/div[2]/nav[1]/div[3]/*[1]")).click();//next
    		 s1=driver.findElement(By.xpath("//div[@id='datepickers-container']//div[2]//nav[1]//div[2]")).getText();//month}
    		 
    	 }
    		while(s1.equalsIgnoreCase(p.getProperty("check_out")));
    		List<WebElement> dates=driver.findElements(By.xpath("//*[@id='datepickers-container']/div[1]/div/div[1]/div[2]/div"));
    		int count=driver.findElements(By.xpath("//*[@id='datepickers-container']/div[1]/div/div[1]/div[2]/div")).size();
    		System.out.println("count"+count);
    		
    	
    	 for(int i=0;i<count;i++)
    	 {
    		 String date=driver.findElements(By.xpath("//*[@id='datepickers-container']/div[2]/div/div/div[2]/div")).get(i).getText();
    		 if(date.equals(p.getProperty("outdate")))
    		 {
    			 driver.findElement(By.xpath("//*[@id='datepickers-container']/div[2]/div/div/div[2]/div[contains(text(),"+p.getProperty("outdate")+")]")).click();

    		 
    		 }
    	 }
    	
     }
     
     
     public void AdultOption()
     {
    	 
    	 driver.findElement(Adult).click();
    	 driver.findElement(By.xpath("//div[contains(@class,'col o2')]//button[contains(@class,'btn btn-white bootstrap-touchspin-up')][contains(text(),'+')]")).click();
    	 driver.findElement(Child).click();
    	 driver.findElement(By.xpath("//div[contains(@class,'col 01')]//button[contains(@class,'btn btn-white bootstrap-touchspin-up')][contains(text(),'+')]")).click();
    	 driver.findElement(search).click();
     }
     	 
     	 
     	 
     
    
public static void main(String[] args) throws IOException {
try
{
	Hotel h=new Hotel();
	h.launchbrowser();
	h.Hotel_name();
	h.Check_in();
	h.Check_out();
	h.AdultOption();

}
catch(InterruptedException e)
{
	}

}
}