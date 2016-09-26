# optics-annotation
Java Annotation to be used to derive Optics functions (Lenses, Views) automatically from annotated Classes

Example (AnnotherClass is omitted for brevity)

@Optics
public class SomeClass
{
  String x;
  AnotherClass another;
  
  public SomeClass setX(String x)
  {
    this.x = x;
    return this;
  }

  public String getX()
  {
    return x;
  }
  
  public AnotherClass getAnother()
  {
    return another;
  }
  
  public void setAnother(AnotherClass an)
  {
    this.another = an;
  }
}

produces

public abstract class SomeClassOptics {
  public static OptionalLens<SomeClass, String> X = new OptionalLens<>(new Lens<>(SomeClass::getX, (a,b) -> a.setX(b)));

  public static OptionalLens<SomeClass, AnotherClass> Another = new OptionalLens<>(new Lens<>(SomeClass::getAnother, (a,b) -> {a.setAnother(b); return a;}));

  public static OptionalIntLens<SomeClass> Another_Value = Another.andThen(de.c.seiler.AnotherClassOptics.Value);

  public static OptionalView<SomeClass, Boolean> Another_Flag = Another.andThen(de.c.seiler.AnotherClassOptics.Flag);
}

use "utilityClass" to specify the class where the optics will be placed (default is $classname+"Optics")

use "exclude" to exclude fields from processing
