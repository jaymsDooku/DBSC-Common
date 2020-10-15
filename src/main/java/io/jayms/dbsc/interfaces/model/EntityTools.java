package io.jayms.dbsc.interfaces.model;

import javax.json.JsonObject;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class EntityTools {

    public static <T extends JSONEntity> List<JsonObject> toJson(List<T> entities) {
        return entities.stream()
                .map(e -> e.toJson())
                .collect(Collectors.toList());
    }

}
