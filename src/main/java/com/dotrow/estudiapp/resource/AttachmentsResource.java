package com.dotrow.estudiapp.resource;

import com.dotrow.estudiapp.dao.AttachmentDao;
import com.dotrow.estudiapp.model.Attachment;
import com.dotrow.estudiapp.serializer.AttachmentSerializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.io.IOUtils;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Path( "attachments" )
@Produces( MediaType.APPLICATION_JSON )
public class AttachmentsResource {

    private final String UPLOAD_DIR = "/tmp/";

    private GsonBuilder builder = new GsonBuilder()
            .setPrettyPrinting()
            .registerTypeAdapter( Attachment.class, new AttachmentSerializer() );
    ;
    private Gson gson = builder.create();

    private AttachmentDao attachmentDao = new AttachmentDao();

    @POST
    @Path( "/upload" )
    @Consumes( "multipart/form-data" )
    public Response uploadFile( MultipartFormDataInput input, @HeaderParam( "note_id" ) Long note_id ) throws IOException {
        Map<String, List<InputPart>> uploadForm = input.getFormDataMap();
        List<InputPart> inputParts = uploadForm.get( "attachment" );
        String filename = UPLOAD_DIR + getRandomFilename();

        for( InputPart inputPart : inputParts ) {
            try {
                InputStream inputStream = inputPart.getBody( InputStream.class, null );
                byte[] bytes = IOUtils.toByteArray( inputStream );
                writeFile( bytes, filename );
            } catch( Exception e ) {
                e.printStackTrace();
            }
        }

        Attachment attachment = new Attachment( filename );

        if( attachmentDao.create( attachment ) ) {
            return Response.status( Response.Status.OK ).build();
        } else {
            return Response.status( Response.Status.BAD_REQUEST ).build();
        }
    }

    private void writeFile( byte[] content, String filename ) throws IOException {
        File file = new File( filename );

        if( !file.exists() ) {
            file.createNewFile();
        }

        FileOutputStream fop = new FileOutputStream( file );

        fop.write( content );
        fop.flush();
        fop.close();
    }

    private String getRandomFilename() {
        SimpleDateFormat sdf = new SimpleDateFormat( "ddMMyyhhmmssSSS" );
        String timestamp = sdf.format( new Date() );

        Random random = new Random();
        Integer randomNumber = random.nextInt( 900 ) + 100;

        String filename = String.format( "%s%s", timestamp, randomNumber.toString() );
        return filename;
    }

}
