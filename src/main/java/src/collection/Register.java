package src.collection;

public interface Register<T> {
    void enqueueEmergency(T emergency);
    T dequeueEmergency();
    T peekEmergency();
    Boolean isEmpty();
    Integer count();
}
