package io.jayms.dbsc.interfaces.service;

import io.jayms.dbsc.interfaces.model.Report;
import io.jayms.dbsc.interfaces.model.Spreadsheet;

import javax.enterprise.context.ApplicationScoped;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public interface ReportService {

    Response listAllReports();

    Response getAllSpreadsheets(long reportId);

    Response getReport(long id);

    Response create(JsonObject reportJson);

    Response update(Report report);

    Response delete(long id);

    Response execute(long id);

    Response getScheduledReports();

    Response schedule(long id);

    Response stopScheduling(long id);

}
