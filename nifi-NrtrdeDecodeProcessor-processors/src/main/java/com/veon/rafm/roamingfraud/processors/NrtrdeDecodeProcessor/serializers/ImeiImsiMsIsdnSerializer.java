package com.veon.rafm.roamingfraud.processors.NrtrdeDecodeProcessor.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.veon.rafm.roamingfraud.processors.NrtrdeDecodeProcessor.nrtrde.BCDString;
import org.bouncycastle.util.encoders.Hex;

import java.io.IOException;

public class ImeiImsiMsIsdnSerializer extends JsonSerializer<BCDString> {

    @Override
    public void serialize(BCDString bytes, JsonGenerator jgen,
                          SerializerProvider provider) throws IOException,
            JsonProcessingException {
       // ObjectMapper objectMapper = new ObjectMapper()
         //       .enable(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED);

        String val= new String(Hex.encode(bytes.value)).replaceAll("f","");
        new ObjectMapper().enable(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED).writeValue(jgen, val);

      //  jgen.writeStartArray();

       // jgen.writeString(new String(Hex.encode(bytes.value)).replaceAll("f",""));
       // jgen.writeEndArray();

    }



}
