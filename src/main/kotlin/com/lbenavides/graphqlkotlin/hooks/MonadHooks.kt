import com.expediagroup.graphql.SchemaGeneratorConfig
import com.expediagroup.graphql.directives.KotlinDirectiveWiringFactory
import com.expediagroup.graphql.hooks.SchemaGeneratorHooks
import graphql.language.StringValue
import graphql.schema.Coercing
import graphql.schema.GraphQLScalarType
import graphql.schema.GraphQLType
import org.springframework.beans.factory.BeanFactoryAware
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*
import kotlin.reflect.KClass
import kotlin.reflect.KType
import kotlin.reflect.full.isSubclassOf


@Component
class MonadHooks() : SchemaGeneratorHooks {


    /**
     * Register Reactor Mono monad type.
     */
    override fun willResolveMonad(type: KType): KType = when (type.classifier) {
        Mono::class, Flux::class -> type.arguments.firstOrNull()?.type
        else -> type
    } ?: type



}
