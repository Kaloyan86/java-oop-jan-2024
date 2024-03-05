package interfaces_and_abstraction.military.engineer;

import java.util.Collection;

import interfaces_and_abstraction.military.repair.Repair;

public interface Engineer {

    void addRepair(Repair repair);

    Collection<Repair> getRepairs();
}
