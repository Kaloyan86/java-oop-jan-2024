package exam_prep.goldDigger.models.discoverer;

public class Anthropologist extends BaseDiscoverer{

    private static final double DEFAULT_ENERGY = 40;

    public Anthropologist(String name) {
        super(name, DEFAULT_ENERGY);
    }
}
