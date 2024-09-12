package dev.masterflomaster1.jwa.json;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.time.Instant;

public class TimestampDeserializer implements JsonDeserializer<Instant> {

    @Override
    public Instant deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return Instant.parse(json.getAsString());
    }

}
