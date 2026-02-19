
package apachepoi;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SeleniumScreenshotUtil {

    private static final Logger logger =
            LogManager.getLogger(SeleniumScreenshotUtil.class);

    public static void captureFailureScreenshot(WebDriver driver, String testName) {

        try {
            // 1️⃣ Take screenshot from browser
            File src = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);

            // 2️⃣ Timestamp for unique name
            String timestamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

            // 3️⃣ Destination path
            String projectPath = System.getProperty("user.dir");
            File dest = new File(
                    projectPath + "/screenshots/" +
                    testName + "_" + timestamp + ".png"
            );

            dest.getParentFile().mkdirs();

            // 4️⃣ Copy screenshot
            Files.copy(src.toPath(), dest.toPath());

            logger.error("Browser screenshot captured: {}",
                    dest.getAbsolutePath());

        } catch (IOException e) {
            logger.error("Failed to capture browser screenshot", e);
        }
    }
}

