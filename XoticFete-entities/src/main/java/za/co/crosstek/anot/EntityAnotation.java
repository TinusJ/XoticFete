package za.co.crosstek.anot;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import za.co.crosstek.enums.EntityAttribute;

/**
 *
 * @author Tinus
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface EntityAnotation {

    /**
     * Label of the Entity
     *
     * @used Menu Item Name,
     * @return
     */
    String label() default "No Label";

    /**
     * Description of the Entity
     *
     * @used Title of the menu Item,
     * @return
     */
    String description() default "No Description";

    /**
     * Icon of the Entity
     *
     * @used Icon of the Menu Item,
     * @return
     */
    String icon() default "No Icon";

    /**
     * Rank of the Entity
     *
     * @used Sublist Order, Menu Rank Order
     * @return
     */
    int rank() default 0;

    EntityAttribute[] attributes() default {};

    /**
     * This will contain the custom urls for -Form -List -View
     *
     * @return
     */
    UrlAnotation url() default @UrlAnotation;
}
