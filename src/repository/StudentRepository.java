package repository;

import entity.StudentEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.SessionFactoryConfiguration;

public class StudentRepository {
    Session session = SessionFactoryConfiguration.getInstance().getSession();

    public Integer saveStudent(StudentEntity studentEntity) {
        Transaction transaction = session.beginTransaction();
        try {
            Integer id = (Integer) session.save(studentEntity);
            transaction.commit();
            return id;
        } catch (Exception e) {
            transaction.rollback();
            System.out.println("An error occurred: " + e.getMessage());
            return -1;
        }

    }

    public StudentEntity getStudent(Integer id) {
        return session.get(StudentEntity.class, id);
    }

    public void updateStudent(StudentEntity studentEntity) {
        Transaction transaction = session.beginTransaction();
        try {
            session.update(studentEntity);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        }
    }

    public void deleteStudent(StudentEntity studentEntity) {
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(studentEntity);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        }
    }
}
