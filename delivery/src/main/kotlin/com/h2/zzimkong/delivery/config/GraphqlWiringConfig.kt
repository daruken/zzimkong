package com.h2.zzimkong.delivery.config

import graphql.scalars.ExtendedScalars
import graphql.schema.idl.RuntimeWiring
import org.springframework.context.annotation.Configuration
import org.springframework.graphql.execution.RuntimeWiringConfigurer

@Configuration
class GraphqlWiringConfig : RuntimeWiringConfigurer {
    override fun configure(builder: RuntimeWiring.Builder) {
        builder.scalar(ExtendedScalars.GraphQLLong).build()
    }
}
