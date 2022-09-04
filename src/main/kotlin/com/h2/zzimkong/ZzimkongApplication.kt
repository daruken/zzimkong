package com.h2.zzimkong

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EnableJpaRepositories(basePackages = ["com.h2.zzimkong"])
@SpringBootApplication
class ZzimkongApplication

fun main(args: Array<String>) {
	runApplication<ZzimkongApplication>(*args)
}
