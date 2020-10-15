package io.jayms.dbsc.interfaces.repository;

import io.jayms.dbsc.interfaces.model.ConnectionSpec;
import io.jayms.dbsc.interfaces.model.Database;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;
import java.util.List;

public interface DatabaseRepository {

    void create(Database database);

    void update(Database database);

    Database find(long id);

    List<Database> findAll(long connSpecId);

    List<Database> findAll();

    void delete(long id);

}
