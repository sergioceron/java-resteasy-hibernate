package com.dotrow.estudiapp.deserializer;

import com.dotrow.estudiapp.model.Usuario;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class UserDeserializer implements JsonDeserializer<Usuario> {

    @Override
    public Usuario deserialize( JsonElement json, Type type, JsonDeserializationContext context ) throws JsonParseException {
        String email = json.getAsJsonObject().get( "email" ).getAsString();
        String password = json.getAsJsonObject().get( "password" ).getAsString();

        Usuario usuario = new Usuario( email, password );

        return usuario;
    }

}
