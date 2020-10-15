package io.jayms.dbsc.interfaces.model;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Set;

@Entity
@Table(name = "database")
public class Database implements JSONEntity {

	public Database() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private int port;
	private String username;
	private String password;

	@Enumerated(EnumType.STRING)
	private DatabaseType databaseType;

	private String databasePath;

	@JsonbTransient
	@ManyToOne
	@JoinColumn(name="conn_id")
	private ConnectionSpec connSpec;

	@OneToMany(cascade=CascadeType.ALL, mappedBy="database")
	private Set<Report> reports;

	@Transient
	private HikariConfig hikariConfig;

	@Transient
	private HikariDataSource hikariDataSource;
	
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
	
	public int getPort() {
		return port;
	}
	
	public void setPort(int port) {
		this.port = port;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public DatabaseType getType() {
		return databaseType;
	}

	public void setType(DatabaseType databaseType) {
		this.databaseType = databaseType;
	}

	public void setDatabasePath(String databasePath) {
		this.databasePath = databasePath;
	}

	public String getDatabasePath() {
		return databasePath;
	}

	public ConnectionSpec getConnectionSpec() {
		return connSpec;
	}

	public void setConnectionSpec(ConnectionSpec connSpec) {
		this.connSpec = connSpec;
	}

	public Set<Report> getReports() {
		return reports;
	}

	public void setReports(Set<Report> reports) {
		this.reports = reports;
	}

	public void addReport(Report report) {
		this.reports.add(report);
	}

	public void removeReport(Report report) {
		this.reports.remove(report);
	}

	@Override
	public String toString() {
		return "DatabaseItem{" +
				"id=" + id +
				", name='" + name + '\'' +
				", port=" + port +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", databaseType=" + databaseType +
				", connSpec=" + connSpec.getId() +
				", reports=" + reports +
				'}';
	}

	public Connection connection() throws SQLException {
		if (hikariDataSource == null) {
			/*Properties properties = new Properties();
			properties.setProperty("dataSourceClassName", databaseType.getDataSourceClassName());
			properties.setProperty("dataSource.user", username);
			properties.setProperty("dataSource.password", password);
			properties.setProperty("dataSource.databaseName", name);
			properties.setProperty("dataSource.portNumber", Integer.toString(port));
			properties.setProperty("dataSource.serverName", connSpec.getHostname());
			if (databaseType == DatabaseType.ORACLE) {
				properties.setProperty("dataSource.url", "jdbc:oracle:thin:@" + connSpec.getHostname() + ":" + port + ":xe");
			}*/

			hikariConfig = new HikariConfig();
			//hikariConfig.setDataSourceClassName(databaseType.getDataSourceClassName());
			hikariConfig.setUsername(username);
			hikariConfig.setPassword(password);
			if (databaseType == DatabaseType.ORACLE) {
				hikariConfig.setJdbcUrl("jdbc:oracle:thin:@" + connSpec.getHostname() + ":" + port + ":xe");
			}
			hikariDataSource = new HikariDataSource(hikariConfig);
		}
		return hikariDataSource.getConnection();
	}

	public static final String ID = "id";
	public static final String NAME = "name";
	public static final String PORT = "port";
	public static final String USERNAME = "username";
	public static final String PASSWORD = "password";
	public static final String DATABASE_TYPE = "databaseType";
	public static final String DATABASE_PATH = "databasePath";
	public static final String CONN_SPEC = "connSpec";

	@Override
	public JsonObject toJson() {
		JsonObject jsonObject = Json.createObjectBuilder()
				.add(ID, id)
				.add(NAME, name)
				.add(PORT, port)
				.add(USERNAME, username)
				.add(PASSWORD, password)
				.add(DATABASE_TYPE, databaseType.toString())
				.add(DATABASE_PATH, databasePath)
				.add(CONN_SPEC, connSpec.getId())
				.build();
		return jsonObject;
	}
	
}
