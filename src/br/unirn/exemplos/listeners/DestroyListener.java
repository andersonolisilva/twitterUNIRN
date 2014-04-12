package br.unirn.exemplos.listeners;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class DestroyListener
 *
 */
@WebListener
public class DestroyListener implements ServletContextListener {

	/**
	 * Default constructor. 
	 */
	public DestroyListener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
	}

	/***
	 * O Tomcat as vezes não consegue desregistrar os drivers quando necessário. Fazendo isto por ele...
	 */
	public void contextDestroyed(ServletContextEvent arg0) {
		Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            Driver driver = drivers.nextElement();
            try {
                DriverManager.deregisterDriver(driver);
                System.err.printf("deregistering jdbc driver: %s", driver);
            } catch (SQLException e) {
            	System.err.printf("Error deregistering driver %s", driver);
            }

        }
	}

}
