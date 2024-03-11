package exam_prep.goldDigger.models.operation;

import exam_prep.goldDigger.models.discoverer.Discoverer;
import exam_prep.goldDigger.models.spot.Spot;

import java.util.Collection;

public interface Operation {
    void startOperation(Spot spot, Collection<Discoverer> discoverers);

}
