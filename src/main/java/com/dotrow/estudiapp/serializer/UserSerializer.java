package com.dotrow.estudiapp.serializer;

import com.dotrow.estudiapp.model.Usuario;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class UserSerializer implements JsonSerializer<Usuario> {

    @Override
    public JsonElement serialize( Usuario src, Type typeOfSrc, JsonSerializationContext context ) {
        JsonObject object = new JsonObject();

        object.addProperty( "id", src.getId() );
        object.addProperty( "email", src.getCorreo() );

        return object;
    }

}
