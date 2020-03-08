package com.skoogle.desktop.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.stereotype.Component;

/**
 * @author alanterriaga
 * @project skoogle-desktop
 */
@Component
public class JSONDeserialize extends JsonDeserializer<Date> {

    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String date = jsonParser.getText();
        Date dateSer = null;

        try {
            dateSer = format.parse(date);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        return dateSer;
    }
}
