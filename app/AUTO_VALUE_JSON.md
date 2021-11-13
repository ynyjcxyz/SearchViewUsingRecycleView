## @GenerateTypeAdapter

There is an annotation in the `auto-value-gson-runtime` artifact called `@GenerateTypeAdapter`. This annotation
can be set on types to indicate to the extension that you want the generated adapter to be a top level class in the same
package. The name of this class will be the AutoValue class's name plus `_GsonTypeAdapter` suffix.

Types annotated with this can also be (de)serialized dynamically at runtime with a provided runtime `TypeAdapterFactory`
implementation in the annotation called `FACTORY`. The type name and generated typeadapter class's name *must not be obfuscated*
for this to work. The extension that runs during annotation processing will automatically generate custom
.pro rules for Proguard/R8 for this, so it should require no extra configuration.

When this annotation is used, there will be no intermediate AutoValue class generated (as opposed to the default logic,
which generates an intermediate class and generates the `TypeAdapter` as a static inner class of it). There is no need
to declare a static `TypeAdapter<...> typeAdapter()` method anymore for this case, though you can optionally define
one if you still want to use the `@GsonTypeAdapterFactory` generator for them.

`@GenerateTypeAdapter` is compatible with the factory approach above, just make your static method's implementation
point to it. It can also be an alternative to it if you use the runtime factory, particularly if you
have a multimodule project and are willing to accept a small amount of (heavily cached) reflection.

The generated class will have the same parameters as if it were the inner class. If it's generic, its constructor
accepts a `Gson` instance and `TypeToken` of the generics. If it's not generic, it's just a `Gson` instance.

Example usage:

```java
@GenerateTypeAdapter
@AutoValue
public class Foo {
  // ...
}

// Generates
public final class Foo_GsonTypeAdapter extends TypeAdapter<Foo> {
  public Foo_GsonTypeAdapter(Gson gson) {
    //...
  }
}

// Or with generics
@GenerateTypeAdapter
@AutoValue
public class Foo<T> {
  // ...
}

// Generates
public final class Foo_GsonTypeAdapter extends TypeAdapter<Foo> {
  public Foo_GsonTypeAdapter(Gson gson, TypeToken<? extends Foo<T>> typeToken) {
    //...
  }
}

// Using the runtime FACTORY
new GsonBuilder()
    .registerTypeAdapterFactory(GenerateTypeAdapter.FACTORY)
    .create()
    .toJson(myFooInstance);
```