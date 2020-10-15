package io.jayms.dbsc.interfaces.spreadsheet;

import io.jayms.dbsc.interfaces.model.Report;
import io.jayms.dbsc.interfaces.model.Spreadsheet;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;

public interface SpreadsheetGenerator {

    Spreadsheet generate(Report report);

}
