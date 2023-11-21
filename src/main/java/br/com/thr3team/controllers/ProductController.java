package br.com.thr3team.controllers;

import org.jboss.resteasy.reactive.RestPath;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.RestResponse.ResponseBuilder;

import br.com.thr3team.services.ProductService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("product")
public class ProductController {

    @Inject
    private ProductService productService;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public RestResponse<?> findAll() throws Exception {
        return ResponseBuilder.ok(productService.findAll()).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public RestResponse<?> findById(@RestPath(value = "id") long id) throws Exception {
        return ResponseBuilder.ok(productService.findById(id)).build();
    }
}
