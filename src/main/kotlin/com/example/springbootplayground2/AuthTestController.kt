package com.example.springbootplayground2

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthTestController(
) {
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/echo/{msg}")
    @UserAuthorized(roles = ["admin"])
    fun echo(@PathVariable msg: String) = "responding: $msg"
}
