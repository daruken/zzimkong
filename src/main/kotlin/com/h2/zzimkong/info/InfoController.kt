package com.h2.zzimkong.info

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class InfoController {
    @GetMapping("/info")
    fun info(): String {
        return "Hello, world!"
    }
}