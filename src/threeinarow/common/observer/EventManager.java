package threeinarow.common.observer;

import threeinarow.matrix.atd.Matrix;

import java.util.HashMap;
import java.util.Map;

public class EventManager {
    Map<OperationType, Listener> listeners;

    public EventManager() {
        listeners = new HashMap<>();
    }

    public void subscribe(OperationType operationType, Listener listener) {
        listeners.put(operationType, listener);
    }

    public void notify(OperationType operationType, Matrix matrix) {
        Listener listener = listeners.get(operationType);
        listener.update(matrix);
    }
}
