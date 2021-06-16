package com.code.EmployeeManagement.model;

import org.hibernate.HibernateException;
import org.hibernate.PessimisticLockException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;
import org.springframework.security.core.parameters.P;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Objects;

public class PersonalDetails implements UserType {

    private String name;
    private String surname;
    private String dateOfBirth;
    private String identityNumber;
    private String gender;
    private String maritalStatus;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surName) {
        this.surname = surName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    @Override
    public int[] sqlTypes() {

        return new int[]{
                Types.VARCHAR,
                Types.VARCHAR,
                Types.VARCHAR,
                Types.VARCHAR,
                Types.VARCHAR,
                Types.VARCHAR
        };
    }

    @Override
    public Class returnedClass() {
        return PersonalDetails.class;
    }

    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
        return false;
    }

    @Override
    public int hashCode(Object x) throws HibernateException {
        return 0;
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner) throws HibernateException, SQLException {
        String name = rs.getString(names[0]);

        if (rs.wasNull())  // will check if unitNo is null
            return null;

        String surname = rs.getString(names[1]);
        String dateOfBirth = rs.getString(names[2]);
        String idNumber = rs.getString(names[3]);
        String gender = rs.getString(names[4]);
        String maritalStatus = rs.getString(names[5]);

        PersonalDetails personalDetails = new PersonalDetails();

        personalDetails.setName(name);
        personalDetails.setSurname(surname);
        personalDetails.setDateOfBirth(dateOfBirth);
        personalDetails.setIdentityNumber(idNumber);
        personalDetails.setGender(gender);
        personalDetails.setMaritalStatus(maritalStatus);

        return personalDetails;
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session) throws HibernateException, SQLException {
        if (Objects.isNull(value))
        {
            st.setNull(index, Types.VARCHAR);
            st.setNull(index + 1, Types.VARCHAR);
            st.setNull(index + 2, Types.VARCHAR);
            st.setNull(index+3, Types.VARCHAR);
            st.setNull(index+4, Types.VARCHAR);
            st.setNull(index+5, Types.VARCHAR);
        }
        else
            {
            PersonalDetails personalDetails = (PersonalDetails) value;
            st.setString(index,personalDetails.getName());
            st.setString(index+1,personalDetails.getSurname());
            st.setString(index+2,personalDetails.getDateOfBirth());
            st.setString(index+3, personalDetails.getIdentityNumber());
            st.setString(index+4, personalDetails.getGender());
            st.setString(index+5, personalDetails.getMaritalStatus());
        }
    }

    @Override
    public Object deepCopy(Object value) throws HibernateException {
        return null;
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(Object value) throws HibernateException {
        return null;
    }

    @Override
    public Object assemble(Serializable cached, Object owner) throws HibernateException {
        return null;
    }

    @Override
    public Object replace(Object original, Object target, Object owner) throws HibernateException {
        return null;
    }
}
