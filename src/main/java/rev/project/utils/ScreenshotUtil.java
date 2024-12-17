package rev.project.utils;



import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ScreenshotUtil {

   private static final String SCREENSHOT_DIR="screenshots";
   public static String takeScreenshot(WebDriver driver,String scenarioName){
       TakesScreenshot ts=(TakesScreenshot)driver;
       File source=ts.getScreenshotAs(OutputType.FILE);
       Path screenshotDir=Paths.get(SCREENSHOT_DIR);
       if(!Files.exists(screenshotDir)){
           try {
               Files.createDirectory(screenshotDir);

           }
           catch (IOException e){
               e.printStackTrace();
           }
       }
       String fileName=scenarioName.replaceAll(" ","_")+".png";
       File destination=new File(screenshotDir.toString(),fileName);
       try {
           Files.copy(source.toPath(),destination.toPath());
           return destination.getAbsolutePath();
       }
       catch (IOException e){
           e.printStackTrace();
           return null;
       }

   }
}
