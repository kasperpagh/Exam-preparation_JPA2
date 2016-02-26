/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.PHDStudent;
import entity.Person;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author kaspe
 */
public class Controller
{

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Exam-preparation_JPA2PU");

    public void addPerson(Person p)
    {
        EntityManager em = emf.createEntityManager();
        try
        {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            System.out.println("Person: " + p + " er addet!");
        }
        finally
        {

            em.close();
        }
    }

    public void editPerson(int personID, Person newPersonObject)
    {
        EntityManager em = emf.createEntityManager();
        try
        {
            Person p = em.find(PHDStudent.class, personID);
            System.out.println("her er id på found: " + p.getId());
            em.getTransaction().begin();
            p = newPersonObject;
            em.persist(p);
            em.getTransaction().commit();
        }
        finally
        {

            em.close();
        }
    }

    public Person findPerson(int id)
    {
        EntityManager em = emf.createEntityManager();
        try
        {
            return em.find(Person.class, id);
        }
        finally
        {
            em.close();

        }
    }

    public void deletePerson(int id)
    {
        EntityManager em = emf.createEntityManager();
        try
        {
            Person p = em.find(Person.class, id);
            em.getTransaction().begin();
            em.remove(p);
            em.getTransaction().commit();
        }
        finally
        {
            em.close();

        }
    }

}
