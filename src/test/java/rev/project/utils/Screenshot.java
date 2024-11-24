//package rev.project.utils;
//
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//public class Screenshot implements ITestListener {
//    private static WebDriver driver;
//
//    // Method to set the WebDriver instance
//    public static void setDriver(WebDriver webDriver) {
//        driver = webDriver;
//    }
//
//    @Override
//    public void onTestFailure(ITestResult result) {
//        if (driver != null) {
//            // Capture screenshot on test failure
//            TakesScreenshot screenshot = (TakesScreenshot) driver;
//            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
//
//            // Set file path and name
//            String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
//            String testName = result.getName();
//            File destFile = new File("Screenshot/" + testName + "_" + timestamp + ".png");
//
//            // Save screenshot
//            try {
//                Files.createDirectories(destFile.getParentFile().toPath()); // Create directory if not exists
//                Files.copy(srcFile.toPath(), destFile.toPath());
//                System.out.println("Screenshot saved to: " + destFile.getAbsolutePath());
//            } catch (IOException e) {
//                System.err.println("Failed to save screenshot: " + e.getMessage());
//            }
//        }
//    }
//
//    @Override
//    public void onStart(ITestContext context) {}
//    @Override
//    public void onFinish(ITestContext context) {}
//    @Override
//    public void onTestStart(ITestResult result) {}
//    @Override
//    public void onTestSuccess(ITestResult result) {}
//    @Override
//    public void onTestSkipped(ITestResult result) {}
//    @Override
//    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}
//}
