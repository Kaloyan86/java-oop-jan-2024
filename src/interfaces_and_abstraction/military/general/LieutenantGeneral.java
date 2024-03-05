package interfaces_and_abstraction.military.general;

import java.util.Collection;

import interfaces_and_abstraction.military.privvate.Private;

public interface LieutenantGeneral {

    Collection<Private> getPrivates();

    void addPrivate(Private priv);
}
