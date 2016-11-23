package com.example;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

/**
 * This UI is the application entry point. A UI may either represent a browser window
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("my-theme")
public class MyUI extends UI {
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setContent(new VerticalLayout() {
            {
                setMargin(true);
                setSpacing(true);

                addComponent(panel(""));
                addComponent(panel(ValoTheme.PANEL_WELL));
            }
        });
    }

    private Panel panel(String styleName) {
        return new Panel("Panel caption") {{
            addStyleName(styleName);

            setContent(new HorizontalLayout() {
                {
                    setMargin(true);
                    setSpacing(true);

                    addComponent(button(""));
                    addComponent(button(ValoTheme.BUTTON_PRIMARY));
                }
            });
        }};
    }

    private Button button(String styleName) {
        return new Button("Click", FontAwesome.CLOUD) {{
            addStyleName(styleName);
        }};
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
