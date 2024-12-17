package rev.project.utils;


import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BrokenLinkValidator {

    // Method to validate links
    public static void validateLinks(List<WebElement> links) {
        for (WebElement link : links) {
            String url = link.getAttribute("href");
            if (url == null || url.isEmpty()) {
                System.out.println("Invalid link: No URL found");
                continue;
            }

            try {
                HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
                connection.setRequestMethod("HEAD");
                connection.connect();

                int responseCode = connection.getResponseCode();
                if (responseCode >= 400) {
                    System.out.println("Broken link: " + url + " - Response Code: " + responseCode);
                } else {
                    System.out.println("Valid link: " + url + " - Response Code: " + responseCode);
                }
            } catch (IOException e) {
                System.out.println("Error checking link: " + url + " - " + e.getMessage());
            }
        }
    }
}
