package snippets.jee.course_management_jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import snippets.jee.course_management_jpa.entity.Course;
import snippets.jee.course_management_jpa.entity.JPAEntityFactoryBean;

@Component
public class CourseDAO {

    @Autowired
    JPAEntityFactoryBean entityFactoryBean;

    public List<Course> getCourses() {
        //Get entity manager
        EntityManagerFactory entityManagerFactory = entityFactoryBean.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //Execute Query
        TypedQuery<Course> courseTypedQuery = entityManager.createNamedQuery("Course.findAll", Course.class);
        List<Course> courses = courseTypedQuery.getResultList();
        entityManager.close();
        return courses;
    }

}
