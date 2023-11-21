package br.com.thr3r.controllers;

import org.jboss.resteasy.reactive.RestPath;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.RestResponse.ResponseBuilder;

import br.com.thr3r.domain.models.dtos.UserDTO;
import br.com.thr3r.domain.models.forms.UserForm;
import br.com.thr3r.services.UserService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.UriInfo;

@Path("user")
public class UserController {
    @Inject
    private UserService userService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public RestResponse<?> findAll() throws Exception {
        return ResponseBuilder.ok(userService.findAll()).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public RestResponse<?> findById(@RestPath(value = "id") long id) throws Exception {
        return ResponseBuilder.ok(userService.findById(id)).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public RestResponse<?> save(@Valid UserForm form, @Context UriInfo uriInfo) throws Exception {
        UserDTO userDTO = userService.save(form);
        return ResponseBuilder.created(uriInfo.getAbsolutePathBuilder().path(String.valueOf(userDTO.getId())).build()).entity(userDTO).build(); 
    }
}
