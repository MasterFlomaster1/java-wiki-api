package dev.masterflomaster1.jwa.internal.json;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import dev.masterflomaster1.jwa.common.Namespace;

import java.lang.reflect.Type;

public class NamespaceDeserializer implements JsonDeserializer<Namespace> {

    @Override
    public Namespace deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return Namespace.of(json.getAsString());
    }

}
