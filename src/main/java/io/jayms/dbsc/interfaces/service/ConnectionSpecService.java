package io.jayms.dbsc.interfaces.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.jayms.dbsc.interfaces.model.ConnectionSpec;
import io.jayms.dbsc.interfaces.model.Database;
import io.jayms.dbsc.interfaces.model.Report;

public interface ConnectionSpecService {

	Response listAllConnSpecs();

	Response getConnSpec(long id);

	Response getAllDatabases(long connSpecId);

	Response create(ConnectionSpec spec);

	Response update(ConnectionSpec spec);

	Response delete(long id);
	
}
