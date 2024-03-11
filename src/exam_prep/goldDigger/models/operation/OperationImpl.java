package exam_prep.goldDigger.models.operation;

import java.util.Collection;

import exam_prep.goldDigger.models.discoverer.Discoverer;
import exam_prep.goldDigger.models.spot.Spot;

public class OperationImpl implements Operation {

    @Override
    public void startOperation(Spot spot, Collection<Discoverer> discoverers) {

        Collection<String> spots = spot.getExhibits();

        discoverers.forEach(discoverer -> {

            while (discoverer.canDig() && spots.iterator().hasNext()){
                discoverer.dig();
                String currentSpot = spots.iterator().next();
                discoverer.getMuseum().getExhibits().add(currentSpot);
                spots.remove(currentSpot);
            }
        });
    }
}
