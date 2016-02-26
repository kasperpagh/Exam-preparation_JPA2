/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.DATE;

/**
 *
 * @author kaspe
 */
/*
Jeg bruger inheritanceType JOINED, fordi jeg syntes det giver en mere logisk database struktur, med en tabel til hvert af de to "personlighedstyper". 
Man kan altså (teoretisk set) søge i blandt alle persisterede personer i en tabel på navn og lign. og så se på DTYPE hvilken tabel man skal søge videre info i
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Person implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;
    private String lastName;
    @Temporal(DATE)
    private Date birthDate;
    private int age;
    private boolean isMarried;
    @ElementCollection(fetch = FetchType.LAZY)
    @OneToOne
    private List<Person> supervisors = new ArrayList();
    @ElementCollection(fetch = FetchType.LAZY)
    @OneToOne
    private List<Person> supervised = new ArrayList();

    public Person()
    {
    }
    

    public Person(String firstName, String lastName, Date birthDate, int age, boolean isMarried)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.age = age;
        this.isMarried = isMarried;
    }
    
    public void addSupervisor(Person p)
    {
        supervisors.add(p);   
        p.addSupervised(this);
        
    }
    
    public void addSupervised(Person p)
    {
        supervised.add(p);
        p.addSupervisor(this);
    }   
    

    public List<Person> getSupervisors()
    {
        return supervisors;
    }
    

    public void setSupervisors(List<Person> supervisors)
    {
        this.supervisors = supervisors;
    }

    public List<Person> getSupervised()
    {
        return supervised;
    }

    public void setSupervised(List<Person> supervised)
    {
        this.supervised = supervised;
    }

    
    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public Date getBirthDate()
    {
        return birthDate;
    }

    public void setBirthDate(Date birthDate)
    {
        this.birthDate = birthDate;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public boolean isIsMarried()
    {
        return isMarried;
    }

    public void setIsMarried(boolean isMarried)
    {
        this.isMarried = isMarried;
    }

}
