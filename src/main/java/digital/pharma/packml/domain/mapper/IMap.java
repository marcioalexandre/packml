package digital.pharma.packml.domain.mapper;

import digital.pharma.packml.infra.entity.PropertyEntity;
import org.mapstruct.Named;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public interface IMap {
    @Named("mapFromEntity")
    default Set<HashMap<String,String>> mapFromEntity(Set<PropertyEntity> properties, String type){
        if (properties != null) {
            Set<HashMap<String, String>> props = Arrays.asList(new HashMap<String, String>())
                    .stream()
                    .collect(Collectors.toSet());
            props.clear();
            properties.stream()
                    .forEach(property -> {
                        if (property.getType().equals(type)) {
                            HashMap<String, String> value = new HashMap<>();
                            value.put(property.getName(), property.getValue());
                            props.add(value);
                        }
                    });
            return props;
        }
        return null;
    }

    @Named("mapFromHash")
    default Set<PropertyEntity> mapFromHash(Set<HashMap<String,String>> properties){
        if (properties != null) {
            Set<PropertyEntity> props = new HashSet<PropertyEntity>();
            properties.forEach(property ->
                    property.entrySet().forEach(hashProperty ->
                            props.add(PropertyEntity.builder()
                                    .name(hashProperty.getKey())
                                    .value(hashProperty.getValue())
                                    .build())));
            return props;
        }
        return null;
    }

    default Set<HashMap<String,String>> mapComponentFromEntity(Set<PropertyEntity> value){
        if (value != null)
            return mapFromEntity(value, "component");
        return null;
    }

    default Set<PropertyEntity> mapComponentFromHash(Set<HashMap<String,String>> value){
        if (value != null)
            return mapFromHash(value);
        return null;
    }
}
