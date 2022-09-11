import org.jetbrains.kotlin.backend.common.push
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    val kotlinVersion = "1.7.10"
    id("com.graphql_java_generator.graphql-gradle-plugin") version "1.18.7"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.3.61"
    id("org.springframework.boot") version "2.7.2"
    id("io.spring.dependency-management") version "1.0.12.RELEASE"
    kotlin("jvm") version kotlinVersion
    kotlin("kapt") version kotlinVersion
    kotlin("plugin.jpa") version kotlinVersion
    kotlin("plugin.spring") version kotlinVersion
    idea
}

group = "com.h2"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-graphql")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.projectlombok:lombok:1.18.24")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    runtimeOnly("mysql:mysql-connector-java")

    /* QUERYDSL */
    implementation("com.querydsl:querydsl-jpa:5.0.0")

    /* R2DBC */
    implementation("dev.miku:r2dbc-mysql:0.8.2.RELEASE")
    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
    runtimeOnly("dev.miku:r2dbc-mysql")

    /* GRAPHQL */
    implementation("com.graphql-java-generator:graphql-java-common-runtime:1.18.7")
    implementation("com.graphql-java:graphql-java-extended-scalars:18.1")

    /* KOTLIN */
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactive:1.6.4")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:1.6.4")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-slf4j:1.6.4")
    runtimeOnly("org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm:1.6.4")

    /* TEST */
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework:spring-webflux")
    testImplementation("org.springframework.graphql:spring-graphql-test")
    testImplementation("org.springframework.security:spring-security-test")

    kapt("com.querydsl:querydsl-apt:5.0.0:jpa")
    kapt("com.github.pozo:mapstruct-kotlin-processor:1.4.0.0")
    kapt("org.mapstruct:mapstruct-processor:1.5.2.Final")
    kapt("org.hibernate.javax.persistence:hibernate-jpa-2.1-api:1.0.2.Final")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

idea {
    module {
        val kaptMain = file("build/generated/source/kapt/main")
        sourceDirs.add(kaptMain)
        generatedSourceDirs.add(kaptMain)
    }
}

generatePojoConf {
    packageName = "$group.zzimkong.graphql"
    setSchemaFileFolder("$rootDir/src/main/resources/graphql")
    mode = com.graphql_java_generator.plugin.conf.PluginMode.server

    customScalars.push(
        com.graphql_java_generator.plugin.conf.CustomScalarDefinition(
            "Long",
            "java.lang.Long",
            null,
            "graphql.scalars.ExtendedScalars.GraphQLLong",
            null
        )
    )
}

sourceSets {
    named("main") {
        java.srcDirs("/build/generated/sources/graphqlGradlePlugin")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks {
    jar {
        enabled = false
    }
    compileKotlin {
        dependsOn("generatePojo")
    }
}
