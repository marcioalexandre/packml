package digital.pharma.packml.infra.entity;

public interface GenericEntity<T> {

    void update(T source);
    T createNewInstance();
}
