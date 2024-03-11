package exam_prep.goldDigger;

import exam_prep.goldDigger.core.Controller;
import exam_prep.goldDigger.core.ControllerImpl;
import exam_prep.goldDigger.core.Engine;
import exam_prep.goldDigger.core.EngineImpl;

public class Main {

    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
