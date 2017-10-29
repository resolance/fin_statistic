package CreatorListObject;

import java.io.IOException;
import java.util.List;

public interface PoloniexDao {
    void load() throws IOException;

    List<JsonPoloniexObject> getPoloniexObjectList();

    JsonPoloniexObject getPair(String namePair);
}