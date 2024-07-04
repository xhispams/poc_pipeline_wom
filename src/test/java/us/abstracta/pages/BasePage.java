package us.abstracta.pages;

import com.microsoft.playwright.Page;
import java.nio.file.Paths;

public class BasePage {
    protected final Page page;

    public BasePage(Page page) {
        this.page = page;
    }

    public void navigateTo(String url) {
        page.navigate(url);
    }

    public void clickElement(String selector) {
        page.click(selector);
    }

    public void fillInputField(String selector, String text) {
        page.fill(selector, text);
    }

    public void waitForTimeout(int milliseconds) {
        page.waitForTimeout(milliseconds);
    }

    public void waitForSelector(String selector) {
        page.waitForSelector(selector);
    }

    public String getTextContent(String selector) {
        return page.textContent(selector);
    }

    public void screenshot(String path) {
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)));
    }
}