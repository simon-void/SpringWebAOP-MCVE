# Spring Web + AOP issue MCVE

just a minimal example of a REST endpoint that should trigger an advice, but currently doesn't

## Run the app

via invoking `SpringWebAopApp` in an IDE or by executing `./gradlew bootRun` on the commandline.

Open a browser at: `http://localhost:8080/echo/test`

## Expected behaviour

the browser should display:
```responding: test```

and the log should show a line
```"target: $targetClass, signature: $signature"```

and a RuntimeException with the same message indicating that the advice was executed.

## Current behaviour

the browser is displaying:
```responding: test```

but the log shows no sign of the advice being executed.

## Solution

there is now a [solution branch](https://github.com/simon-void/SpringWebAOP-MCVE/tree/solution)
with an working implementation. (the fix was to replace `@target` with `@annotation` in the pointcut.)