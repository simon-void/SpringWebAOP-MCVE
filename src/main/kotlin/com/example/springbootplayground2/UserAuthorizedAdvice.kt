package com.example.springbootplayground2

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.annotation.Pointcut
import org.aspectj.lang.Signature
import org.springframework.stereotype.Component


@Target(AnnotationTarget.FUNCTION) @MustBeDocumented
annotation class UserAuthorized(val roles: Array<String>)

@Component
@Aspect
class UserAuthorizedAdvice {

    // the within-condition isn't strictly necessary but a build-time optimization. Make sure to adapt it to your base-package.
    @Pointcut("@annotation(com.example.springbootplayground2.UserAuthorized) && within(com.example..* )")
    fun userAuthorizedMethods() {}

    @Before("userAuthorizedMethods()")
    fun checkIfUserHasRequiredRole(jp: JoinPoint) {
        val signature: Signature = jp.getSignature()
        val target: Any? = jp.target
        val targetClass = target?.javaClass?.canonicalName ?: "null"
        val msg = "target: $targetClass, signature: $signature"
        println(msg)
    }
}
