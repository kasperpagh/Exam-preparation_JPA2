/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.DATE;

/**
 *
 * @author kaspe
 */
@Entity
public class Student extends Person
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int matNr;
    @Temporal(DATE)
    private Date matDate;
    @ElementCollection(fetch = FetchType.LAZY)
    @OneToMany(cascade = CascadeType.ALL)
    List<Grade> grades = new ArrayList();

    public Student()
    {
    }

    public Student(int matNr, Date matDate)
    {
        this.matNr = matNr;
        this.matDate = matDate;
    }

    public int getMatNr()
    {
        return matNr;
    }

    public void setMatNr(int matNr)
    {
        this.matNr = matNr;
    }

    public Date getMatDate()
    {
        return matDate;
    }

    public void setMatDate(Date matDate)
    {
        this.matDate = matDate;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

}
