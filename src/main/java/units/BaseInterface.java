package units;

import java.util.ArrayList;
import java.util.List;

public interface BaseInterface {
    void step(List<Hero> list);
    String getInfo();

    void die();


}
