
package com.alesilva.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {
    
    private static final SessionFactory sessionfactory;
     public static String HIBERNATE_SESSION = "hibernate_session";
    
     static {
        try {
           
            System.out.println("Tentando abrir uma SF");
            Configuration configuration = new Configuration().configure();
            
         ServiceRegistry serviceRegistry = (ServiceRegistry) new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            
            sessionfactory = configuration.buildSessionFactory(serviceRegistry);
            System.out.println("SF criada corretamente");
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao iniciar Session Factory"+ e);
            throw new ExceptionInInitializerError(e);
        }

    }

    public static SessionFactory getSessionfactory() {
        return sessionfactory;
    }
}
