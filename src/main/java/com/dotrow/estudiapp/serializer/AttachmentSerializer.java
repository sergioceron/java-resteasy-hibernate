package com.dotrow.estudiapp.serializer;

import com.dotrow.estudiapp.model.Attachment;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class AttachmentSerializer implements JsonSerializer<Attachment> {

    @Override
    public JsonElement serialize( Attachment src, Type typeOfSrc, JsonSerializationContext context ) {
        JsonObject object = new JsonObject();

        object.addProperty( "id", src.getId() );
        object.addProperty( "filename", src.getFilename() );

        return object;
    }

}
