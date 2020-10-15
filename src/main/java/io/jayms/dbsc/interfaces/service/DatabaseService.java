package io.jayms.dbsc.interfaces.service;

import io.jayms.dbsc.interfaces.model.Database;
import io.jayms.dbsc.interfaces.model.Report;

import javax.enterprise.context.ApplicationScoped;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public interface DatabaseService {

    Response listAllDatabases();

    Response getAllReports(long dbId);

    Response getDatabase(long id);

    Response create(JsonObject databaseJson);

    Response update(Database database);

    Response delete(long id);
}
