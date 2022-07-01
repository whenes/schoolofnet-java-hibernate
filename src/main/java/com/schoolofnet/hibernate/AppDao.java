package com.schoolofnet.hibernate;

import com.schoolofnet.model.HibernateSession;
import com.schoolofnet.model.Options;
import com.schoolofnet.model.User;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class AppDao {
    public static void main(String[] args) {
        //CRUD
        Session session = HibernateSession.getSessionFactory().openSession();
        create(session);
        read(session);
        update(session);
    }
    //C
    private static void create(Session session) {
        Options option = new Options();
        option.setName("option1");
        option.setUser(new User());
        session.beginTransaction();
        session.save(option);
        session.getTransaction().commit();
    }
    //R
    private static void read(Session session) {
        List<Options> options = new ArrayList<>();
        session.beginTransaction();
//        options = session.createCriteria(Options.class).list();
//        options = session.createQuery("from Options").list();
        options = session.createQuery("from Options").getResultList();

        Options option = session.find(Options.class, 1);
        session.getTransaction().commit();
        System.out.println(options);
        System.out.println(option.getName());
    }
    //U
    private static void update(Session session) {
        session.beginTransaction();
        Options option = session.find(Options.class, 1);
        Options option1 = session.find(Options.class, 2);
        if (option != null) {
            option.setName("Update test");
            session.update(option);

            option1.setName("update teste 2");
            session.saveOrUpdate(option1);
        }
        session.getTransaction().commit();
    }
    //D
    private static void delete(Session session) {
        session.beginTransaction();
        Options option = session.find(Options.class, 1);
        Options option1 = session.find(Options.class, 2);
        if (option != null) {
            session.remove(option);
            session.delete(option1);
        }
        session.getTransaction().commit();
    }
}
