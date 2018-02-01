package za.co.crosstek.enums;

import org.apache.commons.lang3.text.WordUtils;

/**
 *
 * @author Tinus
 */
public enum CompanyTag {

    POOL_TABLE,
    DANCE_FLOOR,
    SMOKING,
    OUTSIDE_SEATING,
    INDOOR_SEATING,
    DART_BOARDS;

    @Override
    public String toString() {
        return WordUtils.capitalizeFully(name().replaceAll("_", " "));
    }
}
