package com.dotrow.estudiapp.resource;

import com.dotrow.estudiapp.dao.UserDao;
import com.dotrow.estudiapp.model.Usuario;
import com.dotrow.estudiapp.serializer.UserSerializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jboss.resteasy.annotations.providers.jackson.Formatted;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path( "users" )
@Produces( MediaType.APPLICATION_JSON )
public class UsersResource {

    private GsonBuilder builder = new GsonBuilder()
            .setPrettyPrinting()
            .registerTypeAdapter( Usuario.class, new UserSerializer() );
    private Gson gson = builder.create();

    private UserDao userDao = new UserDao();

    @GET
    @Produces( "application/json" )
    @Formatted
    public List<Usuario> list() {
        return userDao.findAll();
    }

    @GET
    @Path( "/{id}" )
    public Response get( @PathParam( "id" ) Long id ) {
        Usuario usuario = userDao.get( id );

        if( usuario != null ) {
            String response = gson.toJson( usuario );
            return Response.ok( response ).build();
        } else {
            return Response.status( Response.Status.NOT_FOUND ).build();
        }
    }

    @POST
    @Consumes( MediaType.APPLICATION_JSON )
    public Response create( String json ) {
        Usuario usuario = gson.fromJson( json, Usuario.class );

        if( usuario != null && userDao.create( usuario ) ) {
            return Response.status( Response.Status.OK ).build();
        } else {
            return Response.status( Response.Status.BAD_REQUEST ).build();
        }
    }

    @PUT
    @Path( "/{id}" )
    @Consumes( MediaType.APPLICATION_JSON )
    public Response update( @PathParam( "id" ) Long id, String json ) {
        Usuario usuario = gson.fromJson( json, Usuario.class );
        usuario.setId( id );

        if( userDao.update( usuario ) ) {
            return Response.status( Response.Status.OK ).build();
        } else {
            return Response.status( Response.Status.BAD_REQUEST ).build();
        }
    }

    @DELETE
    @Path( "/{id}" )
    public Response delete( @PathParam( "id" ) Long id ) {
        Usuario usuario = userDao.get( id );

        if( usuario != null && userDao.delete( usuario ) ) {
            return Response.status( Response.Status.OK ).build();
        } else {
            return Response.status( Response.Status.BAD_REQUEST ).build();
        }
    }

}
