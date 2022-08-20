package common.models;

import lombok.Data;

@Data
public class Primitive {
    public Object field;

    public Primitive(Object field) {
        this.field = field;
    }
}
