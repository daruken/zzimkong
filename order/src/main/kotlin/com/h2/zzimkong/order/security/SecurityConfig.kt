package com.h2.zzimkong.order.security

import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain

@EnableWebSecurity
class SecurityConfig {
    @Bean
    fun securityFilterChain(httpSecurity: HttpSecurity): SecurityFilterChain {
        return httpSecurity
            .httpBasic().disable()
            .csrf().disable()
            .build()
    }
}
