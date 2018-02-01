package za.co.crosstek.enums;

import org.apache.commons.lang3.text.WordUtils;

/**
 *
 * @author Tinus
 */
public enum CompanyType {

    BAR,
    SPORTS_BAR,
    RESTAURANT,
    CLUB;

    @Override
    public String toString() {
        return WordUtils.capitalizeFully(name().replaceAll("_", " "));
    }
}
