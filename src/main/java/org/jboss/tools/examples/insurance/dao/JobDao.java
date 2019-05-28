package org.jboss.tools.examples.insurance.dao;

import java.util.List;

import javax.ejb.Stateless;

import org.jboss.tools.examples.insurance.entity.Job;

@Stateless
public class JobDao extends Dao<Job> {

    public List<Job> findAll(){

        return em.createQuery("select j from Job j", Job.class)
                .getResultList();

    }

}
