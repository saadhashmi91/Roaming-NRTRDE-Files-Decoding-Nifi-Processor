package com.veon.rafm.roamingfraud.processors.NrtrdeDecodeProcessor.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.bouncycastle.util.encoders.Hex;
import org.openmuc.jasn1.ber.types.BerOctetString;


import java.io.IOException;

public class ByteArraySerializer extends JsonSerializer<BerOctetString> {

    @Override
    public void serialize(BerOctetString bytes, JsonGenerator jgen,
                          SerializerProvider provider) throws IOException,
            JsonProcessingException {
      //  jgen.writeStartArray();

       // jgen.writeString(new String((bytes.value)));
        //jgen.writeEndArray();

        String val= new String((bytes.value));
        new ObjectMapper().enable(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED).writeValue(jgen, val);

    }



}

