package exam_prep.goldDigger.repositories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import exam_prep.goldDigger.models.discoverer.Discoverer;

public class DiscovererRepository implements Repository<Discoverer> {

    private Collection<Discoverer> discoverers;

    public DiscovererRepository() {
        this.discoverers = new ArrayList<>();
    }

    @Override
    public Collection<Discoverer> getCollection() {
        return Collections.unmodifiableCollection(discoverers);
    }

    @Override
    public void add(Discoverer entity) {
        this.discoverers.add(entity);
    }

    @Override
    public boolean remove(Discoverer entity) {
        return this.discoverers.remove(entity);
    }

    @Override
    public Discoverer byName(String name) {
        return this.discoverers.stream()
                               .filter(discoverer -> discoverer.getName().equals(name))
                               .findFirst()
                               .orElse(null);
    }
}
