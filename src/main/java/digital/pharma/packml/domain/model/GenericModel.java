package digital.pharma.packml.domain.model;

public interface GenericModel<T> {

    void update(T source);
    Long getId();
    T createnewInstance();

}
