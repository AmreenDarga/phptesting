package net.testcases.testcases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Flight extends home{

	public Flight() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}


	
	By Source=By.xpath("//div[@id='s2id_location_from']");
    By Destination=By.xpath("//div[@id='s2id_location_to']");
    By departure =By.xpath("//input[@id='FlightsDateStart']");
    By returnBack=By.xpath("//input[@id='FlightsDateEnd']");

    By state=By.xpath("//span[contains(text(),'First')]");
    By Adult=By.xpath("//div[contains(@class,'row gap-5')]//div[1]//div[1]//div[1]//div[1]//input[1]");
    By Child=By.xpath("//div[@id='flights']//div[contains(@class,'col-md-3 col-xs-12')]//div[2]//div[1]//div[1]//div[1]//input[1]");
    By Infant=By.xpath("//div[contains(@class,'col-md-3 col-xs-12')]//div[3]//div[1]//div[1]//div[1]//input[1]");
    By Done=By.xpath("//button[@id='sumManualPassenger']");
    By Search=By.xpath("//button[contains(@class,'btn-primary btn btn-block')]");
    
    

     public void Source_name() throws InterruptedException  
     {
    	 driver.findElement(Source).click();
     	 driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/input[1]")).sendKeys(p.getProperty("source"));
     	 driver.findElement(By.xpath("//div[@class='select2-result-label']")).click();
     }
     
     public void Destination_name() throws InterruptedException  
     {
    	 driver.findElement(Destination).click();
     	 driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[1]/input[1]")).sendKeys(p.getProperty("destination"));
   	     driver.findElement(By.xpath("//div[@class='select2-result-label']")).click();
     }
  

     public void Departure_date() throws InterruptedException
     {
    	
    	 driver.findElement(departure).click();
    	 String s1=driver.findElement(By.xpath("//div[7]//nav[1]//div[2]")).getText();//month
    		do
    		{
    		 driver.findElement(By.xpath("//body[@class='with-waypoint-sticky']/div[@id='datepickers-container']/div[7]/nav[1]/div[3]/*[1]")).click();//next
    		 s1=driver.findElement(By.xpath("//div[7]//nav[1]//div[2]")).getText();//month}
    		 
    	 }while(s1.equalsIgnoreCase(p.getProperty("departure")));
    	List<WebElement> dates=driver.findElements(By.xpath("//*[@id='datepickers-container']/div[1]/div/div[1]/div[2]/div"));
    	int count=driver.findElements(By.xpath("//*[@id='datepickers-container']/div[1]/div/div[1]/div[2]/div")).size();
    	System.out.println("count"+count);
    		
    	
    	 for(int i=0;i<count;i++)
    	 {
    		 String date=driver.findElements(By.xpath("//*[@id='datepickers-container']/div[1]/div/div[1]/div[2]/div")).get(i).getText();
    		 if(date.equals(p.getProperty("destDate")))
    		 {
    			 driver.findElement(By.xpath("//*[@id='datepickers-container']/div[1]/div/div[1]/div[2]/div[contains(text(),"+p.getProperty("destDate")+")]")).click();		 
    		 }
    	 }
    	
     }
     
     public void roundtrip()
     {
     	 driver.findElement(By.xpath("//label[contains(text(),'Round Trip')]")).click(); 
     }
      

  public void Return_date() throws InterruptedException
  {
  	
 	 driver.findElement(returnBack).click();
 	 Thread.sleep(500);
 	
 	 String s1=driver.findElement(By.xpath("//div[8]//nav[1]")).getText();//month
 		do
 	 {
 		 driver.findElement(By.xpath("//body[contains(@class,'with-waypoint-sticky')]/div[@id='datepickers-container']/div[1]/nav[1]/div[3]/*")).click();//next
 		 s1=driver.findElement(By.xpath("//div[8]//nav[1]")).getText();//month}
 		 
 	 }
 		while(s1.equalsIgnoreCase(p.getProperty("return")));
 		List<WebElement> dates=driver.findElements(By.xpath("//*[@id='datepickers-container']/div[1]/div/div[1]/div[2]/div"));
 		int count=driver.findElements(By.xpath("//*[@id='datepickers-container']/div[1]/div/div[1]/div[2]/div")).size();
 		System.out.println("count"+count);
 		
 	
 	 for(int i=0;i<count;i++)
 	 {
 		 String date=driver.findElements(By.xpath("//*[@id='datepickers-container']/div[1]/div/div[1]/div[2]/div")).get(i).getText();
 		 if(date.equals(p.getProperty("ret_date")))
 		 {
 			 driver.findElement(By.xpath("//*[@id='datepickers-container']/div[1]/div/div[1]/div[2]/div[contains(text(),"+p.getProperty("ret_date")+")]")).click();

 		 
 		 }
 	 }
 	
  }
  
  public void AdultOption()
  {
 

 	 driver.findElement(Adult).click();
 	 driver.findElement(By.xpath("//div[contains(@class,'row gap-5')]//div[1]//div[1]//div[1]//div[1]//span[3]//button[1]")).click();
  	 driver.findElement(Child).click();
  	 driver.findElement(By.xpath("//div[contains(@class,'row gap-10 mb-15 align-items-end')]//div[2]//div[1]//div[1]//div[1]//span[3]//button[1]")).click();
  	 driver.findElement(Infant).click();
  	 driver.findElement(By.xpath("//div[contains(@class,'col-md-3 col-xs-12')]//div[3]//div[1]//div[1]//div[1]//span[3]//button[1]")).click();driver.findElement(By.xpath("//button[@class='btn-primary btn btn-block']")).click();
   
  }
 
  	 
  public void type()
  {
  	 driver.findElement(By.xpath("//div[@class='form-icon-left flightclass']//a[@class='chosen-single']")).sendKeys(p.getProperty("Type"));
 }
  	
  
public static void main(String[] args) throws IOException {
try
{
	Flight f=new Flight();
	f.launchbrowser();
	f.Flight();
	f.Source_name();
	f.Destination_name();
	f.Departure_date();
	f.AdultOption();
	Thread.sleep(100);

}

catch(InterruptedException e)
{	
	}

}
}