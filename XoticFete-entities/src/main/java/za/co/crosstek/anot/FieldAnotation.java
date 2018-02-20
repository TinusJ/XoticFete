package za.co.crosstek.anot;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import za.co.crosstek.enums.FieldExclusion;
import za.co.crosstek.enums.FieldType;

/**
 *
 * @author Tinus
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FieldAnotation {

    /**
     * This will be the label for the field
     *
     * @return
     */
    String label() default "No Label";

    /**
     * This will be the description / title for the field
     *
     * @return
     */
    String description() default "No Description";

    /**
     * Rank order
     *
     * @return
     */
    int rank() default 0;

    /**
     * This will list all exclusion where field should not be shown
     *
     * @return
     */
    FieldExclusion[] exclusions() default {};

    /**
     * This will determine what to render on screen
     *
     * @return
     */
    FieldType type() default FieldType.AUTO;
}
