package rev.project.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ScreenShot {

    private static final String SCREENSHOT_DIR = "Screenshot"; // Directory to store screenshots

    // Method to take a screenshot
    public static String takeScreenshot(WebDriver driver, String scenarioName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        // Ensure the screenshot directory exists
        Path screenshotDir = Paths.get(SCREENSHOT_DIR);
        if (!Files.exists(screenshotDir)) {
            try {
                Files.createDirectory(screenshotDir);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Define the screenshot file name
        String fileName = scenarioName.replaceAll(" ", "_") + ".png";
        File destination = new File(screenshotDir.toString(), fileName);

        try {
            Files.copy(source.toPath(), destination.toPath());
            System.out.println("Screenshot saved: " + destination.getAbsolutePath());
            return destination.getAbsolutePath(); // Return the path of the saved screenshot
        } catch (IOException e) {
            e.printStackTrace();
            return null; // Return null in case of failure
        }
    }
}
