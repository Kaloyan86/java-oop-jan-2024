package interfaces_and_abstraction.military.mission;

import interfaces_and_abstraction.military.enumm.State;

public interface Mission {

    String getCodeName();

    State getState(); // (Enumeration: "inProgress" or "finished"),

    void completeMission();
}
