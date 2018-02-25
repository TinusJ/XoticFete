package za.co.crosstek.enums;

/**
 *
 * @author Tinus
 */
public enum FieldType {

    /**
     * This will auto determine based on class type
     */
    AUTO,
    
    TEXT,
    /**
     * This will generate a Rating bar (Should be moved to own anot)
     */
    RATING,
    /**
     * This will generate a QR CODE from the String
     */
    QRCODE,
    /**
     * This will generate a Attachment(Should be moved to own anot)
     */
    ATTACHMENT,
    /**
     * This will generate a Cell field
     */
    CELL,
    /**
     * Currency field
     */
    CURRENCY,
    /**
     * This will generate a Password field.
     */
    PASSWORD;
}
