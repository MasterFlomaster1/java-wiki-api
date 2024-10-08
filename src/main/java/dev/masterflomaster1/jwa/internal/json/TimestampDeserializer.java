package dev.masterflomaster1.jwa.internal.json;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.time.Instant;

public final class TimestampDeserializer implements JsonDeserializer<Instant> {

    private TimestampDeserializer() { }

    @Override
    public Instant deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        // The field "expiry" may contain the value "infinity" instead of a valid ISO 8601 date
        if ("infinity".equals(json.getAsString()))
            return null;

        return Instant.parse(json.getAsString());
    }

}
