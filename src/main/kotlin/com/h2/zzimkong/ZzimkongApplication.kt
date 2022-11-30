package com.h2.zzimkong

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories

@EnableR2dbcRepositories(basePackages = ["com.h2.zzimkong"])
@EnableR2dbcAuditing
@SpringBootApplication
class ZzimkongApplication

fun main(args: Array<String>) {
	runApplication<ZzimkongApplication>(*args)
}
