package io.jayms.dbsc.interfaces.service;

import io.jayms.dbsc.interfaces.model.Spreadsheet;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public interface SpreadsheetService {

    Response listAllSpreadsheets();

    Response getSpreadsheet(long id);

    Response delete(long id);

}
