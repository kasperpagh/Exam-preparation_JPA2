/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 *
 * @author kaspe
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Employee extends Person
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int soSecNr;
    private float wage;
    private String taxClass;

    public Employee()
    {
    }

    public Employee(int soSecNr, float wage, String taxClass)
    {
        this.soSecNr = soSecNr;
        this.wage = wage;
        this.taxClass = taxClass;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public int getSoSecNr()
    {
        return soSecNr;
    }

    public void setSoSecNr(int soSecNr)
    {
        this.soSecNr = soSecNr;
    }

    public float getWage()
    {
        return wage;
    }

    public void setWage(float wage)
    {
        this.wage = wage;
    }

    public String getTaxClass()
    {
        return taxClass;
    }

    public void setTaxClass(String taxClass)
    {
        this.taxClass = taxClass;
    }

}
