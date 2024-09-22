package dev.masterflomaster1.jwa.internal.json;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import dev.masterflomaster1.jwa.common.Namespace;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public final class NamespaceListDeserializer implements JsonDeserializer<List<Namespace>> {

    private NamespaceListDeserializer() { }

    @Override
    public List<Namespace> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        List<Namespace> namespaces = new ArrayList<>();
        JsonArray jsonArray = json.getAsJsonArray();

        for (JsonElement element : jsonArray) {
            Namespace namespace = Namespace.of(element.getAsString());
            namespaces.add(namespace);
        }

        return namespaces;
    }

}
