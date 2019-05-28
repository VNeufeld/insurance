package org.jboss.tools.examples.insurance.resource;


import java.math.BigDecimal;
import java.net.URI;

import javax.inject.Inject;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.tools.examples.insurance.business.JobBusiness;
import org.jboss.tools.examples.insurance.entity.Job;


@Path("job")
public class JobResource {

    @Inject
    private JobBusiness jobBusiness;

    @GET
    public Response findAll(){

        return Response
                .ok(jobBusiness.findAll())
                .build();
    }

    @GET
    @Path("/all")
    @Produces("application/json")
    public String getAll(){

        return "Response.ok().entity(.build()";
    }
    
    @GET
    @Path("/test")
    public Response getTest(){

    	String value = " { test : 1 }";
        return Response.ok(value, MediaType.APPLICATION_JSON).build();
    }
    

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id){

        return Response
                .ok(jobBusiness.findById(id)
                        .orElseGet(null))
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response save (@FormParam("companyName") @NotBlank String companyName,
                          @FormParam("description") @NotBlank String description,
                          @FormParam("salary") @NotNull Double salary,
                          @FormParam("office") @NotBlank String office){

        Job job = jobBusiness.save( Job.build(companyName, description, new BigDecimal( salary ), office ));

        return Response
                .created(URI.create("job/"+ job.getId()))
                .build();

    }

}
