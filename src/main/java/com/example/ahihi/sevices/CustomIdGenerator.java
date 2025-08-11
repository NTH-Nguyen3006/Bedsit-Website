package com.example.ahihi.sevices;

import java.io.Serializable;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomIdGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object)
            throws HibernateException {
        var timestampStr = String.valueOf(new java.util.Date().getTime());
        return UUID.randomUUID().toString().substring(0, 5)
                .concat(timestampStr.substring(timestampStr.length() - 6));
    }

}
