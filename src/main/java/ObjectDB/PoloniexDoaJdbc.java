package ObjectDB;

import CreatorListObject.JsonPoloniexObject;
import ObjectDB.DbSystemException.DbException;

import java.sql.SQLException;

public interface PoloniexDoaJdbc {
    void insertObject(JsonPoloniexObject jsonPoloniexObject) throws DbException, SQLException;
    void someSelect() throws DbException, SQLException;
}
