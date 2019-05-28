package org.jboss.tools.examples.insurance.business;

import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.jboss.tools.examples.insurance.dao.JobDao;
import org.jboss.tools.examples.insurance.entity.Job;

@Stateless
public class JobBusiness {

    @Inject
    private JobDao jobDao;

    public Optional<Job> findById( Job job){

        return jobDao.findById(job);
    }

    public Optional<Job> findById( Long id){

        return jobDao.findById(Job.build(id));
    }

    public List<Job> findAll(){
        return jobDao.findAll();
    }

    public Job save (Job job){

        return jobDao.save(job);
    }

}
