package br.com.thr3team.config.infra.handlers;

import br.com.thr3team.domain.exceptions.ClientException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.resource.NotSupportedException;
import jakarta.ws.rs.NotAllowedException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;

public class ExceptionHandler implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable arg0) {
        return switch (arg0) {
            case EntityNotFoundException e -> Response.status(Status.NOT_FOUND).entity("").build();
            case NotAllowedException e -> Response.status(Status.METHOD_NOT_ALLOWED).entity("").build();
            case NotSupportedException e -> Response.status(Status.UNSUPPORTED_MEDIA_TYPE).entity("").build();
            case ClientException e -> Response.status(Status.NOT_FOUND).entity("").build();
            case Exception e -> Response.status(Status.INTERNAL_SERVER_ERROR).entity("").build();
            default -> Response.status(418).entity("").build();
        };
    }
    
}
