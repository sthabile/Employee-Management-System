package com.code.EmployeeManagement.model;

import org.hibernate.annotations.Columns;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.usertype.UserType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@TypeDef(name = "EmploymentDetails", typeClass = EmploymentDetails.class,
        defaultForType = UserType.class)
@TypeDef(name = "ContactDetails", typeClass = ContactDetails.class,
        defaultForType = UserType.class)

@TypeDef(name = "PersonalDetails", typeClass = PersonalDetails.class,
        defaultForType = UserType.class)
@Entity
@Table(name = "employees")
public class Employee
{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Columns(columns = {
            @Column(name = "firstname"),
            @Column(name = "surname"),
            @Column(name = "date_of_birth"),
            @Column(name = "id_number"),
            @Column(name = "gender"),
            @Column(name = "marital_status")
    })
    private PersonalDetails personalDetails;

    @Columns(columns = {
            @Column(name = "unit_number"),
            @Column(name = "street_number"),
            @Column (name = "Suburb")
    })
    private ContactDetails contactDetails;

    @Columns(columns = {
            @Column(name = "job_title"),
            @Column(name = "date_of_employment")
    })
    private EmploymentDetails employmentDetails;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ContactDetails getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(ContactDetails contactDetails) {
        this.contactDetails = contactDetails;
    }

    public PersonalDetails getPersonalDetails() {
        return personalDetails;
    }

    public void setPersonalDetails(PersonalDetails personalDetails) {
        this.personalDetails = personalDetails;
    }

    public EmploymentDetails getEmploymentDetails() {
        return employmentDetails;
    }

    public void setEmploymentDetails(EmploymentDetails employmentDetails) {
        this.employmentDetails = employmentDetails;
    }
}
