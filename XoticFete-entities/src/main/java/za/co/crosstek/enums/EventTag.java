package za.co.crosstek.enums;

import org.apache.commons.lang3.text.WordUtils;

/**
 *
 * @author Tinus
 */
public enum EventTag {

    BAND,
    PERFORMER,
    DJ,
    COMPETITION,
    LIVE,
    POOL,
    DANCE,
    SPORT,
    DARTS,
    ARTIST,
    KARAOKE,
    BEER_PONG,
    BEACH,
    FOAM_PARTY;

    @Override
    public String toString() {
        return WordUtils.capitalizeFully(name().replaceAll("_", " "));
    }
}
