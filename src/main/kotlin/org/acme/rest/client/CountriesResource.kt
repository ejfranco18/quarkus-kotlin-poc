package org.acme.rest.client

import io.smallrye.mutiny.Uni
import org.eclipse.microprofile.rest.client.inject.RestClient
import org.jboss.resteasy.annotations.jaxrs.PathParam
import java.util.concurrent.CompletionStage
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces

@Path("/country")
class CountriesResource {
    @Inject
    @field: RestClient
    internal lateinit var countriesService: CountriesService

    @GET
    @Path("check")
    @Produces("application/json")
    fun getResponse(): Set<Country> {
        return countriesService.response()
    }

    @GET
    @Path("/name/{name}")
    @Produces("application/json")
    fun name(@PathParam name: String): Set<Country> {
        return countriesService.getByName(name)
    }

    @GET
    @Path("/name-async/{name}")
    @Produces("application/json")
    fun nameAsync(@PathParam name: String): CompletionStage<Set<Country>> {
        return countriesService.getByNameAsync(name)
    }

    @GET
    @Path("/name-uni/{name}")
    @Produces("application/json")
    fun nameAsyncUni(@PathParam name: String): Uni<Set<Country>> {
        return countriesService.getByNameAsUni(name)
    }

    @GET
    @Path("/greet")
    @Produces("application/json")
    fun hello() = Greeting("Hello welcome")

    @GET
    @Path("/greet/{name}")
    @Produces("application/json")
    fun hello(@PathParam name: String) = Greeting("Hello" , name)
    
}
