package com.example.springbootplayground2

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.EnableAspectJAutoProxy

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
class SpringbootPlayground2Application

fun main(args: Array<String>) {
	runApplication<SpringbootPlayground2Application>(*args)
}
