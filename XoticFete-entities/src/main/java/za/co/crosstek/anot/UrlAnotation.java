package za.co.crosstek.anot;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author Tinus
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface UrlAnotation {

    /**
     * Form URL
     *
     * @return
     */
    String form() default "form";

    /**
     * List URL
     *
     * @return
     */
    String list() default "list";

    /**
     * View URl
     *
     * @return
     */
    String view() default "view";

}
