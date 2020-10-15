package io.jayms.dbsc.interfaces.model;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(
		name="connection_spec",
		uniqueConstraints=@UniqueConstraint(columnNames={"hostname"})
)
public class ConnectionSpec implements JSONEntity {

	public ConnectionSpec() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String hostname;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "connSpec")
	private Set<Database> databases;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public Set<Database> getDatabases() {
		return databases;
	}

	public void setDatabases(Set<Database> databases) {
		this.databases = databases;
	}

	public void addDatabase(Database database) {
		this.databases.add(database);
	}

	public void removeDatabase(Database database) {
		this.databases.remove(database);
	}

	@Override
	public String toString() {
		return "ConnectionSpec [id=" + id + ", hostname=" + hostname + ", databases=" + databases + "]";
	}

	public static final String ID = "id";
	public static final String HOSTNAME = "hostname";

	@Override
	public JsonObject toJson() {
		JsonObject jsonObject = Json.createObjectBuilder()
				.add(ID, id)
				.add(HOSTNAME, hostname)
				.build();
		return jsonObject;
	}

}
