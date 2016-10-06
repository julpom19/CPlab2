/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 *
 * @author Интернет
 */
@WebListener()
public class MyHttpSessionAttributeListener implements HttpSessionAttributeListener{

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        ServletContext context = event.getSession().getServletContext();
        context.log("Атрибут Http-cеансу " + event.getName() + " було додано");
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        ServletContext context = event.getSession().getServletContext();
        context.log("Атрибут Http-cеансу " + event.getName() + " було видалено");
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        ServletContext context = event.getSession().getServletContext();
        context.log("Атрибут Http-cеансу " + event.getName() + " було замінено");
    }
    
}
