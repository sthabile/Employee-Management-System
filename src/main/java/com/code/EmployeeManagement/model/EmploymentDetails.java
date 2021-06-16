package com.code.EmployeeManagement.model;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Objects;

public class EmploymentDetails implements UserType
{
    private String jobTitle;

    private String dateOfEmployment;


    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getDateOfEmployment() {
        return dateOfEmployment;
    }

    public void setDateOfEmployment(String dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }

    @Override
    public int[] sqlTypes() {
        return new int[]{Types.VARCHAR, Types.VARCHAR};
    }

    @Override
    public Class returnedClass() {
        return EmploymentDetails.class;
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
        String title = rs.getString(names[0]);
        if(rs.wasNull())
            return null;
        String dateOfEmployment = rs.getString(names[1]);

        EmploymentDetails employmentDetails = new EmploymentDetails();
        employmentDetails.setJobTitle(title);
        employmentDetails.setDateOfEmployment(dateOfEmployment);

        return employmentDetails;
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session) throws HibernateException, SQLException {
        if (Objects.isNull(value))
        {
            st.setNull(index, Types.VARCHAR);
            st.setNull(index+1, Types.VARCHAR);
        }
        else
        {
            EmploymentDetails employmentDetails = (EmploymentDetails) value;
            st.setString(index,employmentDetails.getJobTitle());
            st.setString(index+1, employmentDetails.getDateOfEmployment());
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
