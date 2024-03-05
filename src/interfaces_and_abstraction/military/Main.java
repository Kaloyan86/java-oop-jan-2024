package interfaces_and_abstraction.military;

public class Main {

    public static void main(String[] args) {

    }
}

/*
     Interfaces:
        Soldier - int getId(), String getFirstName(), String getLastName()
        Private - double getSalary()
        LieutenantGeneral - Collection<Private> getPrivates(), void addPrivate(Private priv)
        SpecialisedSoldier - String getCorps(); "Airforces" or "Marines" (Enumeration)
        Engineer - void addRepair(Repair repair), Collection<Repair> getRepairs()
        Repair - String getPartName(), int getWorkedHours
        Commando - void addMission(Mission mission), Collection<Mission> getMissions()
        Mission - String getCodeName(), String getState() (Enumeration: "inProgress" or "finished"),
        void completeMission()
        Spy - int getCodeNumber()



 */