package com.skoogle.desktop.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author alanterriaga
 * @project skoogle-desktop
 */
public class JSONSerializer extends JsonSerializer<Date> {

    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public void serialize(Date value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeString(format.format(value));
    }
}
