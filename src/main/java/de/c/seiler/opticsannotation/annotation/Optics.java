package de.c.seiler.opticsannotation.annotation;

import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Target;

@Target(TYPE)
public @interface Optics
{
  String utilityClass() default "";
  String[] exclude() default {};
}
