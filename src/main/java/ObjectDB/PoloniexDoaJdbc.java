package ObjectDB;

import CreatorListObject.JsonPoloniexObject;
import ObjectDB.DBSystemExaption.DBException;

import java.sql.SQLException;

public interface PoloniexDoaJdbc {
    void insertObject(JsonPoloniexObject jsonPoloniexObject) throws DBException, SQLException;

    void someSelect() throws DBException, SQLException;


}
