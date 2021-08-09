# Spring Web with AOP: use own annotation to as a target for an advice

just a minimal example of a REST endpoint that triggers an advice.

## Run the app

via invoking `SpringWebAopApp` in an IDE or by executing `./gradlew bootRun` on the commandline.

Open a browser at: `http://localhost:8080/echo/test`

## Behaviour

the browser displays:
```responding: test```

and the log shows a line (printed by the advice)

```"target: $targetClass, signature: $signature"```
