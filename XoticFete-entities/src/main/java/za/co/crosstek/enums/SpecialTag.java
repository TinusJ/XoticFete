package za.co.crosstek.enums;

import org.apache.commons.lang3.text.WordUtils;

/**
 *
 * @author Tinus
 */
public enum SpecialTag {

    BEVERAGE, ALCHOHOL, SHOOTER, BRANDY;

    @Override
    public String toString() {
        return WordUtils.capitalizeFully(name().replaceAll("_", " "));
    }
}
