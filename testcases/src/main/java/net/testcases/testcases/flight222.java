
    
package net.testcases.testcases;


import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class flight222 extends home{


    public flight222() throws IOException {
        super();
    }
    
    
    By location=By.xpath("//div[@id='s2id_autogen13']");
    By tour_type=By.xpath("//div[@id='tourtype_chosen']//a[contains(@class,'chosen-single')]");
    By date=By.xpath("//input[@id='DateTours']");
    By guests=By.xpath("//div[contains(@class,'col-md-12')]//input[contains(@placeholder,'0')]");    
    By search=By.xpath("//div[contains(@class,'ftab-inner menu-horizontal-content')]//button[contains(@class,'btn btn-primary btn-block')][contains(text(),'Search')]");
    Actions action=new Actions(driver);
    
    
    
    /*public void gotIt()
    {
        By got=By.xpath("//*[@id='cookyGotItBtn']");
        driver.findElement(got).click();
    
    }*/
    
    public void by_city_name() throws InterruptedException
    {
        driver.findElement(location).click();
        driver.findElement(By.xpath("//div[@id='select2-drop']//input[contains(@class,'select2-input')]")).sendKeys(p.getProperty("tour_destination"));
        Thread.sleep(500);
        driver.findElement(By.xpath("//div[contains(text(),'Trip')]")).click();
                
    }
    
    
    public void pick_checkIn()
    {
        driver.findElement(date).click();
        String current_month=driver.findElement(By.xpath("//div[4]//nav[1]//div[2]")).getText();
        System.out.println(current_month);
        do{
            driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[4]/nav[1]/div[3]/*")).click();
            current_month=driver.findElement(By.xpath("//div[4]//nav[1]//div[2]")).getText();
        }while(current_month.equals(p.getProperty("checkInM")));
        
        List<WebElement> dates=driver.findElements(By.xpath("//div[@id='datepickers-container']//div[2]//div//div//div[2]/div"));
        int count=dates.size();
        System.out.println("count"+count);
        
        for(int i=0;i<count;i++)
        {
            String date=driver.findElements(By.xpath("//div[@id='datepickers-container']//div[2]//div//div//div[2]/div")).get(i).getText();
            //String inputdate=prop.getProperty("checkInDate");
            if(date.equals(p.getProperty("checkInD")))
            {
                driver.findElement(By.xpath("//div[@id='datepickers-container']//div[2]//div//div//div[2]/div[contains(text(),"+p.getProperty("checkInD")+")]")).click();
            }
        }
        
            
    }
    public void select_guest()
    {
        driver.findElement(guests).click();
        driver.manage().timeouts().implicitlyWait(90,TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[contains(@class,'col-md-12')]//button[contains(@class,'btn btn-white bootstrap-touchspin-up')][contains(text(),'+')]")).click();
        
        
    }
   public void select_tourtype()
   {
      driver.findElement(tour_type).click();
      driver.manage().timeouts().implicitlyWait(90,TimeUnit.SECONDS);
      WebElement menu=driver.findElement(By.xpath("//div[@id='tourtype_chosen']//input[contains(@class,'chosen-search-input')]"));
      action.moveToElement(menu).perform();
      driver.findElement(By.xpath("//div[@id='tourtype_chosen']//input[contains(@class,'chosen-search-input')]")).sendKeys(p.getProperty("tour_type"));
      driver.findElement(By.xpath("//div[@id='tourtype_chosen']//input[contains(@class,'chosen-search-input')]")).sendKeys(Keys.ENTER);
      
      /*String val="";
      do
      {
        val=driver.findElement(By.xpath("//select[@id='tourtype']//option")).getText();
        driver.findElement(By.xpath("//select[@id='tourtype']")).sendKeys(Keys.ARROW_DOWN);    
      }while(val.equals(prop.getProperty("tour_type")));
      */
      
   }
   public void click_search()
   {
       driver.findElement(search).click();
          
   }
    /*public static void main(String[] args) throws IOException, InterruptedException {
        Tours t=new Tours();
        t.launchBrowser(driver);
        t.Maximize(driver);
        t.tours();
        t.by_city_name();
        t.pick_checkIn();
        t.select_guest();
        t.select_tourtype();
        t.click_search();
        */


}







