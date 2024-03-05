package interfaces_and_abstraction.military.commando;

import java.util.Collection;

import interfaces_and_abstraction.military.mission.Mission;

public interface Commando {

    void addMission(Mission mission);

    Collection<Mission> getMissions();
}
