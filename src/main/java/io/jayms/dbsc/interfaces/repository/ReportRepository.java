package io.jayms.dbsc.interfaces.repository;

import io.jayms.dbsc.interfaces.model.Database;
import io.jayms.dbsc.interfaces.model.Report;

import javax.enterprise.context.ApplicationScoped;
import javax.json.JsonObject;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;
import java.util.List;

public interface ReportRepository {

    void create(Report report);

    void update(Report report);

    Report find(long id);

    List<Report> findAll(long databaseId);

    List<Report> findAll();

    void delete(long id);

}
