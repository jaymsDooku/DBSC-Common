package io.jayms.dbsc.interfaces.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import io.jayms.dbsc.interfaces.model.ConnectionSpec;

public interface ConnectionSpecRepository {

	void create(ConnectionSpec connSpec);

	ConnectionSpec update(ConnectionSpec connSpec);
	
	ConnectionSpec find(long id);
	
	List<ConnectionSpec> findAll();

	void delete(long id);
	
}
