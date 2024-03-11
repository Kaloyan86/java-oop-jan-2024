package exam_prep.goldDigger.models.spot;

import java.util.ArrayList;
import java.util.Collection;

import static exam_prep.goldDigger.common.ExceptionMessages.SPOT_NAME_NULL_OR_EMPTY;

public class SpotImpl implements Spot {

    private String name;
    private Collection<String> exhibits;

    public SpotImpl(String name) {
        this.setName(name);
        this.exhibits = new ArrayList<>();
    }

    @Override
    public Collection<String> getExhibits() {
        return this.exhibits;
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (null == name || name.trim().isBlank()){
            throw new NullPointerException(SPOT_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }
}
