package com.apress.springrecipes.course.jpa;

import com.apress.springrecipes.course.Course;
import com.apress.springrecipes.course.CourseDao;

import javax.persistence.*;
import java.util.List;

public class JpaCourseDao implements CourseDao {

    private EntityManagerFactory entityManagerFactory;

    public JpaCourseDao() {
        entityManagerFactory = Persistence.createEntityManagerFactory("course");
    }

    @Override
    public Course store(Course course) {
        EntityManager manager = entityManagerFactory.createEntityManager();
        EntityTransaction tx = manager.getTransaction();
        try {
            tx.begin();
            Course persisted = manager.merge(course);
            tx.commit();
            return persisted;
        } catch (RuntimeException e) {
            tx.rollback();
            throw e;
        } finally {
            manager.close();
        }
    }

    @Override
    public void delete(Long courseId) {
        EntityManager manager = entityManagerFactory.createEntityManager();
        EntityTransaction tx = manager.getTransaction();
        try {
            tx.begin();
            Course course = manager.find(Course.class, courseId);
            manager.remove(course);
            tx.commit();
        } catch (RuntimeException e) {
            tx.rollback();
            throw e;
        } finally {
            manager.close();
        }
    }

    @Override
    public Course findById(Long courseId) {
        EntityManager manager = entityManagerFactory.createEntityManager();
        try {
            return manager.find(Course.class, courseId);
        } finally {
            manager.close();
        }
    }

    @Override
    public List<Course> findAll() {
        EntityManager manager = entityManagerFactory.createEntityManager();
        try {
            TypedQuery<Course> query = manager.createQuery("select course from Course course", Course.class);
            return query.getResultList();
        } finally {
            manager.close();
        }
    }
}
