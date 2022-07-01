package com.schoolofnet.hibernate;

import com.schoolofnet.model.Address;
import com.schoolofnet.model.HibernateSession;
import com.schoolofnet.model.Options;
import com.schoolofnet.model.User;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main( String[] args ) {
        Session session = HibernateSession.getSessionFactory().openSession();
        System.out.println(session);
        Options option = new Options();
        option.setId(1);
        option.setName("opção 1");
        Options option1 = new Options();
        option1.setId(2);
        option1.setName("opção 2");
        List<Options> options = new ArrayList<>();
        options.add(option);
        options.add(option1);

        User user = new User();
        Address address = new Address();
        address.setNumber(2);
        address.setStreet("aaaa");

        user.setName("Will");
        user.setLastname("A");
        user.setUsername("willa");
        user.setOptions(options);

        address.setUser(user);
        user.setAddress(address);
    }
}
