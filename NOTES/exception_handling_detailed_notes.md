# Detailed Notes: Java Exception Handling

## 1. Overview

Exception handling in Java is a mechanism to handle runtime errors, allowing the normal flow of program execution to continue. Exceptions are objects that describe an exceptional condition that has occurred in a piece of code.

Key concepts:
- Exception: an event that disrupts normal execution.
- Throwable: root class for all errors and exceptions.
- Exception vs Error: `Exception` indicates conditions the application might handle; `Error` indicates serious problems that applications should not try to handle.

## 2. Exception Types

- Checked exceptions: must be declared in a method's `throws` clause or handled with try-catch. Examples: `IOException`, `SQLException`.
- Unchecked exceptions (runtime exceptions): extend `RuntimeException` and do not require explicit handling. Examples: `NullPointerException`, `IndexOutOfBoundsException`.
- Errors: extend `Error`. Examples: `OutOfMemoryError`, `StackOverflowError`.

## 3. try-catch-finally

- `try` block: contains code that might throw an exception.
- `catch` block(s): handle specific exception types. Multiple catch blocks are allowed; order from most specific to most general is required.
- `finally` block: executes regardless of whether an exception occurred (useful for cleanup). Since Java 7, `finally` may be less necessary due to try-with-resources.

Example:

```java
try {
    FileInputStream fis = new FileInputStream("file.txt");
    // work with stream
} catch (FileNotFoundException e) {
    // handle missing file
} catch (IOException e) {
    // handle IO errors
} finally {
    // cleanup code
}
```

## 4. throw vs throws

- `throw` is used to explicitly throw an exception instance from a method or block.
- `throws` declares that a method may propagate certain checked exceptions to its caller.

Example:

```java
public void readFile(String path) throws IOException {
    if (path == null) {
        throw new IllegalArgumentException("path is null");
    }
    // may throw IOException
}
```

## 5. try-with-resources (recommended)

Introduced in Java 7. Automatically closes resources that implement `AutoCloseable`.

```java
try (BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
    return br.readLine();
} catch (IOException e) {
    // handle
}
```

Benefits: concise, less error-prone, ensures deterministic resource cleanup.

## 6. Creating Custom Exceptions

When to create:
- To represent domain-specific error conditions.

Guidelines:
- Extend `Exception` for checked custom exceptions, or `RuntimeException` for unchecked.
- Provide constructors mirroring superclasses (message, cause).

Example:

```java
public class InvalidOrderException extends Exception {
    public InvalidOrderException(String message) { super(message); }
    public InvalidOrderException(String message, Throwable cause) { super(message, cause); }
}
```

## 7. Best Practices

- Prefer specific catch blocks rather than catching `Exception` or `Throwable`.
- Do not swallow exceptions silently; always log or rethrow when appropriate.
- Use exception chaining (`new Exception(msg, cause)`) to preserve original stack traces.
- Keep the `try` block small to avoid catching unrelated exceptions.
- Use `try-with-resources` for `Closeable`/`AutoCloseable` resources.
- Validate method arguments early and throw `IllegalArgumentException`/`NullPointerException` as appropriate.

## 8. Common Pitfalls

- Catching and ignoring exceptions (empty catch blocks).
- Using exceptions for control flow (expensive and against intent).
- Overusing checked exceptions which can clutter APIs — consider unchecked exceptions for programming errors.
- Failing to close resources (use try-with-resources).

## 9. Debugging and Stack Traces

- Stack traces show the chain of method calls leading to the exception.
- Inspect `getCause()` to find root causes when exceptions are wrapped.

Example of logging with stack trace:

```java
catch (Exception e) {
    logger.error("Failed to process request", e);
}
```

## 10. Testing Exception Handling

- Unit tests should verify both normal behavior and exceptional paths.
- In JUnit 5, use `assertThrows` to assert exceptions are thrown:

```java
@Test
void testInvalidInput() {
    assertThrows(InvalidOrderException.class, () -> service.process(null));
}
```

## 11. Performance Considerations

- Throwing exceptions is relatively expensive; avoid using them in hot loops or as regular control flow.

## 12. Quick Reference: Useful Exception Classes

- `RuntimeException`, `NullPointerException`, `IllegalArgumentException`, `IllegalStateException`
- `IOException`, `FileNotFoundException`, `EOFException`
- `SQLException` (JDBC), `ClassNotFoundException` (reflection/Class.forName)

## 13. Further Reading

- Oracle Java Tutorials: Exceptions
- Effective Java (Joshua Bloch) — items on exceptions and API design

---

If you want, I can:
- add examples from the project's source files
- convert these notes into a printable PDF
- expand to other languages (C, Python) found in the repo
