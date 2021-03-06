## Read me first

This project is licensed under both LGPLv3 and ASL 2.0. See file LICENSE for more details.

Requires Java 8.

## What this is

This package allows you to easily use lambdas (whether they be hand-written lambdas or method
references) which can potentially throw checked exceptions. Unchecked exceptions (and `Error`s) are
still thrown "as is".

The primary focus of this package is on everything `Stream`, including their primitive type
specializations (`IntStream`, `LongStream` and `DoubleStream`).

No further dependencies than the JRE itself is required.

## Versions

The current version is **0.1.0**. It is available on Maven central. Using
gradle:

```gradle
compile(group: "com.github.fge", name: "throwing-lambdas", version: "0.1.0");
```

Using maven:

```xml
<dependency>
    <groupId>com.github.fge</groupId>
    <artifactId>throwing-lambdas</artifactId>
    <version>0.1.0</version>
</dependency>
```

## Short example

Let's take an example; you want to list the real paths (ie, following symbolic links and all) of all
entries in a directory. Right now you have to do this:

```java
Files.list(somedir).map(
    path -> {
        try {
            return path.toRealPath();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }).forEach(System.out::println);
```

But that's a waste; `Path`'s `.toRealPath()` is a method and could easily be used as a method
reference, except that it throws a checked exception... And lambdas unfortunately cannot propagate
exceptions out of their context.

With this package you can do this instead:

```java
import static com.github.fge.lambdas.functions.Functions.rethrow;

Files.list(somedir).map(rethrow(Path::toRealPath))
    .forEach(System.out::println);
```

Or this:

```java
final ThrowingFunction<Path, Path> f = Path::toRealPath;

Files.list(somedir).map(f).forEach(System.out::println);
```

If you want to see how this works, see [this
page](https://github.com/fge/throwing-lambdas/wiki/How-it-works).

## Further reading

You can see more about what you can do [here](https://github.com/fge/throwing-lambdas/wiki/How-to-use).

Future plans [here](https://github.com/fge/throwing-lambdas/wiki/Future-plans).

There is also a [FAQ](https://github.com/fge/throwing-lambdas/wiki/FAQ) available.

