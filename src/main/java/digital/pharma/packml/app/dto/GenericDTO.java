package digital.pharma.packml.app.dto;

public interface GenericDTO<T> {

    void update(T source);
    T createNewInstance();
}
