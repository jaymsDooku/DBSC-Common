package io.jayms.dbsc.interfaces.model;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.io.File;
import java.time.Instant;

@Entity
@Table(name = "spreadsheet")
public class Spreadsheet implements JSONEntity {

    public Spreadsheet() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String location;

    @JsonbTransient
    @ManyToOne
    @JoinColumn(name="report_id")
    private Report report;

    private Instant creation;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    @Transient
    public File getFile() {
        return new File(location);
    }

    public void setReport(Report report) {
        this.report = report;
    }

    public Report getReport() {
        return report;
    }

    public void setCreation(Instant creation) {
        this.creation = creation;
    }

    public Instant getCreation() {
        return creation;
    }

    public static final String ID = "id";
    public static final String LOCATION = "location";
    public static final String CREATION = "creation";
    public static final String REPORT = "report";

    @Override
    public JsonObject toJson() {
        JsonObject jsonObject = Json.createObjectBuilder()
                .add(ID, id)
                .add(LOCATION, location)
                .add(CREATION, creation.toEpochMilli())
                .add(REPORT, report.getId())
                .build();
        return jsonObject;
    }

}
