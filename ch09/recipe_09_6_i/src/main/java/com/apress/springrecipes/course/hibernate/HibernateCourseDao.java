package com.apress.springrecipes.course.hibernate;

import com.apress.springrecipes.course.Course;
import com.apress.springrecipes.course.CourseDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import org.hibernate.dialect.PostgreSQL95Dialect;

import java.util.List;

public class HibernateCourseDao implements CourseDao {

    private final SessionFactory sessionFactory;

    public HibernateCourseDao() {

        Configuration configuration = new Configuration()
                .setProperty(AvailableSettings.URL, "jdbc:postgresql://localhost:5432/course")
                .setProperty(AvailableSettings.USER, "postgres")
                .setProperty(AvailableSettings.PASS, "password")
                .setProperty(AvailableSettings.DIALECT, PostgreSQL95Dialect.class.getName())
                .setProperty(AvailableSettings.SHOW_SQL, String.valueOf(true))
                .setProperty(AvailableSettings.HBM2DDL_AUTO, "update")
                .addClass(Course.class);
        sessionFactory = configuration.buildSessionFactory();
    }

    @Override
    public Course store(Course course) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.getTransaction();
        try {
            tx.begin();
            session.saveOrUpdate(course);
            tx.commit();
            return course;
        } catch (RuntimeException e) {
            tx.rollback();
            throw e;
        } finally {
            session.close();
        }

    }

    @Override
    public void delete(Long courseId) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.getTransaction();
        try {
            tx.begin();
            Course course = session.get(Course.class, courseId);
            session.delete(course);
            tx.commit();
        } catch (RuntimeException e) {
            tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public Course findById(Long courseId) {
        Session session = sessionFactory.openSession();
        try {
            return session.get(Course.class, courseId);
        } finally {
            session.close();
        }
    }

    @Override
    public List<Course> findAll() {
        Session session = sessionFactory.openSession();
        try {
            return session.createQuery("SELECT c FROM Course c", Course.class).list();
        } finally {
            session.close();
        }
    }
}
