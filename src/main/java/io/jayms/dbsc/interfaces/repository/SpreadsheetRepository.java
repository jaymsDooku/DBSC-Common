package io.jayms.dbsc.interfaces.repository;

import io.jayms.dbsc.interfaces.model.Report;
import io.jayms.dbsc.interfaces.model.Spreadsheet;

import javax.enterprise.context.ApplicationScoped;
import javax.json.JsonObject;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;
import java.util.List;

public interface SpreadsheetRepository {

    void create(Spreadsheet spreadsheet);

    void update(Spreadsheet spreadsheet);

    Spreadsheet find(long id);

    List<Spreadsheet> findAll(long reportId);

    List<Spreadsheet> findAll();

    void delete(long id);

}
