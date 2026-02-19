package apachepoi;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SampleTest {

    private static final Logger logger = LogManager.getLogger(SampleTest.class);

    public static void main(String[] args) {

        logger.info("Test execution started");

        try {
            // Simulate failure
            int result = 10 / 0;

            logger.info("Result: {}", result);

        } catch (Exception e) {
            logger.error("Test failed due to exception", e);

            // Capture screenshot on failure
            ScreenshotUtil.captureFailureScreenshot("DivisionTest");
        }

        logger.info("Test execution finished");
    }
}
