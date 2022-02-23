package com.naveen.githubdemo.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** This annotation is used to describe the developer friendly description about multiple fields.
 *
 * @author Romit Saxena
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD})
public @interface FieldDescriptorDocs {
    FieldDescriptorDoc[] value();
}
