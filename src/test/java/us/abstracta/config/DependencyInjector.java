package us.abstracta.config;

import com.microsoft.playwright.Page;
import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.MutablePicoContainer;
import org.picocontainer.behaviors.Caching;

public class DependencyInjector {

    private static final MutablePicoContainer container = new DefaultPicoContainer(new Caching());

    static {
        container.addComponent("chromiumPage", PlaywrightConfig.createPage("chromium", false));
        container.addComponent("firefoxPage", PlaywrightConfig.createPage("firefox", true));
        container.addComponent("webkitPage", PlaywrightConfig.createPage("webkit", true));
    }

    public static <T> T getInstance(Class<T> clazz) {
        return container.getComponent(clazz);
    }

    public static Page getPage(String browserName) {
        return (Page) container.getComponent(browserName + "Page");
    }
}