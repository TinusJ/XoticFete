package za.co.crosstek.model;

import java.io.Serializable;
import za.co.crosstek.enums.FieldType;

/**
 *
 * @author Tinus
 */
public class ColumnModel implements Serializable {

    private String header;
    private String property;
    private FieldType fieldType;

    public ColumnModel(String header, String property, FieldType fieldType) {
        this.header = header;
        this.property = property;
        this.fieldType = fieldType;
    }

    public FieldType getFieldType() {
        return fieldType;
    }

    public String getHeader() {
        return header;
    }

    public String getProperty() {
        return property;
    }

}
