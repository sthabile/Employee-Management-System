package com.code.EmployeeManagement.model;


import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Objects;


public class ContactDetails implements UserType
{
    private String unitNo;
    private String streetNo;
    private String suburb;

    public String getUnitNo() {
        return unitNo;
    }

    public void setUnitNo(String unitNo) {
        this.unitNo = unitNo;
    }

    public String getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(String streetNo) {
        this.streetNo = streetNo;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    @Override
    public int[] sqlTypes() {
        return new int[]{Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};
    }

    @Override
    public Class returnedClass()
    {
        return ContactDetails.class;
    }

    @Override
    public boolean equals(Object x, Object y) throws HibernateException
    {
        return false;
    }

    @Override
    public int hashCode(Object x) throws HibernateException
    {
        return 0;
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] details, SharedSessionContractImplementor session, Object owner) throws HibernateException, SQLException
    {
        String unitNo = rs.getString(details[0]);

        if (rs.wasNull())  // will check if unitNo is null
            return null;

        String streetNumber = rs.getString(details[1]);
        String suburb = rs.getString(details[2]);

        ContactDetails contactDetails = new ContactDetails();

        contactDetails.setUnitNo(unitNo);
        contactDetails.setStreetNo(streetNumber);
        contactDetails.setSuburb(suburb);

        return contactDetails;
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session) throws HibernateException, SQLException
    {
        if (Objects.isNull(value)) {
            st.setNull(index, Types.VARCHAR);
            st.setNull(index + 1, Types.VARCHAR);
            st.setNull(index + 2, Types.VARCHAR);
        } else {
            ContactDetails contactDetails = (ContactDetails) value;
            st.setString(index,contactDetails.getUnitNo());
            st.setString(index+1,contactDetails.getStreetNo());
            st.setString(index+2,contactDetails.getSuburb());
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
