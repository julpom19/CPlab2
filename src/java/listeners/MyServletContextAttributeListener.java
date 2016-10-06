/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

/**
 *
 * @author Интернет
 */
@WebListener()
public class MyServletContextAttributeListener implements ServletContextAttributeListener{

    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        ServletContext context = event.getServletContext();
        context.log("Атрибут " + event.getName() + " було додано");
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        ServletContext context = event.getServletContext();
        context.log("Атрибут " + event.getName() + " було видалено");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        ServletContext context = event.getServletContext();
        context.log("Атрибут " + event.getName() + " було замінено");
    }
    
}
