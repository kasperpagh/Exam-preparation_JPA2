/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entity.PHDStudent;
import entity.Person;
import facade.Controller;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author kaspe
 */
public class Tester
{

    public static void main(String[] args)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Exam-preparation_JPA2PU");
        EntityManager em = emf.createEntityManager();
        Persistence.generateSchema("Exam-preparation_JPA2PU", null);
        Controller c = new Controller();

        //Test af addPerson
        Person p = new PHDStudent("llama wool farming");
        c.addPerson(p);

//        Test af editPerson
//        Person p1 = new PHDStudent("Llamas ware boring anyways!");
//        c.editPerson(1, p1);


        //Test af findPerson
        em.getTransaction().begin();
        em.persist(new PHDStudent("test af findPerson"));
        em.getTransaction().commit();
        System.out.println("Her skulle vi gerne finde 'test af findPerson'");

        PHDStudent bob = (PHDStudent) c.findPerson(2);
        System.out.println("Her er det jeg faktisk fandt: " + bob.getDissSubject());
        
        
        //Test af deletePerson
        c.deletePerson(1);
        
    }

}
