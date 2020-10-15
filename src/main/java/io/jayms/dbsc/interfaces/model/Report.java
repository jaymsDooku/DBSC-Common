package io.jayms.dbsc.interfaces.model;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.time.Duration;
import java.time.Instant;
import java.util.Set;

@Entity
@Table(name = "report")
public class Report implements JSONEntity {

	public Report() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String query;
	private String destination;
	private Instant lastExecutionTime;
	private Duration executionInterval;

	@JsonbTransient
	@ManyToOne
	@JoinColumn(name="database_id")
	private Database database;

	@OneToMany(cascade=CascadeType.ALL, mappedBy="report")
	private Set<Spreadsheet> spreadsheets;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Instant getLastExecutionTime() {
		return lastExecutionTime;
	}

	public void setLastExecutionTime(Instant lastExecutionTime) {
		this.lastExecutionTime = lastExecutionTime;
	}

	public Duration getExecutionInterval() {
		return executionInterval;
	}

	public void setExecutionInterval(Duration executionInterval) {
		this.executionInterval = executionInterval;
	}

	public Database getDatabase() {
		return database;
	}

	public void setDatabase(Database database) {
		this.database = database;
	}
	
	public Set<Spreadsheet> getSpreadsheets() {
		return spreadsheets;
	}

	public void setSpreadsheets(Set<Spreadsheet> spreadsheets) {
		this.spreadsheets = spreadsheets;
	}

	@Override
	public String toString() {
		return "ReportItem{" +
				"id=" + id +
				", name='" + name + '\'' +
				", database=" + database.getId() +
				'}';
	}

	public static final String ID = "id";
	public static final String NAME = "name";
	public static final String QUERY = "query";
	public static final String DESTINATION = "destination";
	public static final String LAST_EXECUTION_TIME = "lastExecutionTime";
	public static final String EXECUTION_INTERVAL = "executionInterval";
	public static final String DB = "database";

	@Override
	public JsonObject toJson() {
		JsonObject jsonObject = Json.createObjectBuilder()
				.add(ID, id)
				.add(NAME, name)
				.add(QUERY, query)
				.add(DESTINATION, destination)
				.add(LAST_EXECUTION_TIME, lastExecutionTime.toEpochMilli())
				.add(EXECUTION_INTERVAL, executionInterval.toMillis())
				.add(DB, database.getId())
				.build();
		return jsonObject;
	}
	
}
