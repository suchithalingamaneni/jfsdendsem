package com.klef.jfsd.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ClientDemo {

    public static void main(String[] args) {
        ClientDemo clientDemo = new ClientDemo();
       // clientDemo.addClient();
       clientDemo.viewallClients();
    }

    private void addClient() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Client client = new Client();
        client.setName("suchitha");
        client.setGender("Female");
        client.setAge(11);
        client.setLocation("vijayawada");
        client.setEmail("suchitha.com");
        client.setMobile("9988118709");

        session.persist(client);

        transaction.commit();
        System.out.println("Client added successfully: " + client);
        session.close();
        sessionFactory.close();
    }

    private void viewallClients() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Query<Client> query = session.createQuery("FROM Client", Client.class);
        List<Client> clients = query.getResultList();

        System.out.println("List of all clients:");
        for (Client client : clients) {
            System.out.println(client);
        }
        session.close();
        sessionFactory.close();
    }
}
