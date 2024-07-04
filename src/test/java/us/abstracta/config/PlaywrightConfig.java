package us.abstracta.config;

import com.microsoft.playwright.*;

public class PlaywrightConfig {

    private static Playwright playwright = Playwright.create();

    public static Page createPage(String browserName, boolean headless) {
        Browser browser;
        switch (browserName) {
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(headless));
                break;
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(headless));
                break;
            case "webkit":
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(headless));
                break;
            default:
                throw new IllegalArgumentException("Invalid browser name: " + browserName);
        }
        return browser.newPage();
    }
}