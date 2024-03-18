package exam_prep.goldDigger.core;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import exam_prep.goldDigger.models.discoverer.Anthropologist;
import exam_prep.goldDigger.models.discoverer.Archaeologist;
import exam_prep.goldDigger.models.discoverer.Discoverer;
import exam_prep.goldDigger.models.discoverer.Geologist;
import exam_prep.goldDigger.models.operation.Operation;
import exam_prep.goldDigger.models.operation.OperationImpl;
import exam_prep.goldDigger.models.spot.Spot;
import exam_prep.goldDigger.models.spot.SpotImpl;
import exam_prep.goldDigger.repositories.DiscovererRepository;
import exam_prep.goldDigger.repositories.Repository;
import exam_prep.goldDigger.repositories.SpotRepository;


import static exam_prep.goldDigger.common.ConstantMessages.*;
import static exam_prep.goldDigger.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private Repository<Discoverer> discovererRepository;
    private Repository<Spot> spotRepository;
    private int inspectedSpots;

    public ControllerImpl() {
        this.discovererRepository = new DiscovererRepository();
        this.spotRepository = new SpotRepository();
    }

    @Override
    public String addDiscoverer(String kind, String discovererName) {

        Discoverer discoverer;

        switch (kind) {
            case "Anthropologist":
                discoverer = new Anthropologist(discovererName);
                break;
            case "Archaeologist":
                discoverer = new Archaeologist(discovererName);
                break;
            case "Geologist":
                discoverer = new Geologist(discovererName);
                break;
            default:
                throw new IllegalArgumentException(DISCOVERER_INVALID_KIND);
        }

        this.discovererRepository.add(discoverer);

        return String.format(DISCOVERER_ADDED, kind, discovererName);
    }

    @Override
    public String addSpot(String spotName, String... exhibits) {

        Spot spot = new SpotImpl(spotName);

        Arrays.stream(exhibits)
              .forEach(exhibit -> spot.getExhibits().add(exhibit));

        this.spotRepository.add(spot);

        return String.format(SPOT_ADDED, spotName);
    }

    @Override
    public String excludeDiscoverer(String discovererName) {
        Discoverer discoverer = this.discovererRepository.byName(discovererName);

        if (null == discoverer) {
            throw new IllegalArgumentException(
            String.format(DISCOVERER_DOES_NOT_EXIST, discovererName));
        }

        this.discovererRepository.remove(discoverer);

        return String.format(DISCOVERER_EXCLUDE, discovererName);
    }

    @Override
    public String inspectSpot(String spotName) {

        List<Discoverer> discoverers =
        this.discovererRepository.getCollection()
                                 .stream()
                                 .filter(discoverer -> discoverer.getEnergy() > 45)
                                 .collect(Collectors.toList());

        if (discoverers.isEmpty()) {
            throw new IllegalArgumentException(SPOT_DISCOVERERS_DOES_NOT_EXISTS);
        }

        Spot spot = this.spotRepository.byName(spotName);

        Operation operation = new OperationImpl();

        operation.startOperation(spot, discoverers);

        inspectedSpots++;

        long excludedDiscoverers = discoverers.stream()
                                              .filter(discoverer -> discoverer.getEnergy() == 0)
                                              .count();

        return String.format(INSPECT_SPOT, spotName, excludedDiscoverers);
    }

    @Override
    public String getStatistics() {

        StringBuilder sb = new StringBuilder();

        sb.append(String.format(FINAL_SPOT_INSPECT, inspectedSpots));
        sb.append(System.lineSeparator());
        sb.append(FINAL_DISCOVERER_INFO);

        this.discovererRepository
        .getCollection()
        .forEach(discoverer -> {
            sb.append(System.lineSeparator());
            sb.append(String.format(FINAL_DISCOVERER_NAME, discoverer.getName()));
            sb.append(System.lineSeparator());
            sb.append(String.format(FINAL_DISCOVERER_ENERGY, discoverer.getEnergy()));
            sb.append(System.lineSeparator());

            if (discoverer.getMuseum().getExhibits().isEmpty()) {
                sb.append(String.format(FINAL_DISCOVERER_MUSEUM_EXHIBITS, "None"));
            } else {
                String museums = String.join(FINAL_DISCOVERER_MUSEUM_EXHIBITS_DELIMITER,
                                             discoverer.getMuseum().getExhibits());

                sb.append(String.format(FINAL_DISCOVERER_MUSEUM_EXHIBITS, museums));
            }
        });

        return sb.toString();
    }
}
