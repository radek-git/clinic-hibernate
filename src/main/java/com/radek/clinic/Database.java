package com.radek.clinic;

import com.radek.clinic.hibernate.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Optional;

public class Database {

    public static Database instance;
    public static SessionFactory sessionFactory;
    public static Session session;

    public Database() {
        var serviceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();

        var metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();

        sessionFactory = metadata.buildSessionFactory();
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }

        return instance;
    }

    public void close() {
        if (session != null) {
            session.close();
        }
    }

    public Optional<User> getUserByName(String name) {
        try {
            session = sessionFactory.openSession();

            var builder = session.getCriteriaBuilder();
            var query = builder.createQuery(User.class);
            var root = query.from(User.class);

            query.select(root).where(
                    builder.equal(root.get("name"), name)
            );
            return session.createQuery(query).uniqueResultOptional();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            close();
        }

        return Optional.empty();
    }

    public <T> T get(Class<T> clazz, int id) {
        try {
            session = sessionFactory.openSession();

            return session.get(clazz, id);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            close();
        }

        return null;
    }

}
