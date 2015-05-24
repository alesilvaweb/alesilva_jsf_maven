
package com.alesilva.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
    
    private static final SessionFactory sessionfactory;
    public static String HIBERNATE_SESSION = "hibernate_session";
    
    static {
        try {
           
            System.out.println("Tentando abrir uma SF");
            Configuration configuration = new Configuration().configure();
            StandardServiceRegistryBuilder serviceregistry = (StandardServiceRegistryBuilder) new StandardServiceRegistryBuilder().
                            applySettings(configuration.getProperties()).build();
            sessionfactory = configuration.buildSessionFactory((ServiceRegistry) serviceregistry);
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
