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

    @Pointcut("@target(com.example.springbootplayground2.UserAuthorized) && within(com.example..* )")
    fun userAuthorizedMethods() {}

    @Before("userAuthorizedMethods()")
    fun checkIfUserHasRequiredRole(jp: JoinPoint) {
        val signature: Signature = jp.getSignature()
        val target: Any? = jp.target
        val targetClass = target?.javaClass?.canonicalName ?: "null"
        val msg = "target: $targetClass, signature: $signature"
        println(msg)
        // just to make extra sure that invoking this advice would be noticeable
        throw RuntimeException(msg)
    }
}
