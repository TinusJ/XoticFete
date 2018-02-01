package za.co.crosstek.enums;

import org.apache.commons.lang3.text.WordUtils;

/**
 *
 * @author Tinus
 */
public enum TopUpType {

    /**
     * Notification Cost 1c
     */
    NOTIFICATION(0.01d),
    /**
     * Email Cost 5c
     */
    EMAIL(0.05d),
    /**
     * SMS Cost 30c
     */
    SMS(0.3d);

    private final Double itemCost;

    private TopUpType(Double itemCost) {
        this.itemCost = itemCost;
    }

    public Double getItemCost() {
        return itemCost;
    }

    @Override
    public String toString() {
        return WordUtils.capitalizeFully(name().replaceAll("_", " "));
    }
}
