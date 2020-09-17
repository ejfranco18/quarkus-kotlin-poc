package org.acme.rest.client

import io.smallrye.mutiny.Uni
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient
import org.jboss.resteasy.annotations.jaxrs.PathParam
import java.util.concurrent.CompletionStage
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces

@Path("/v2")
@RegisterRestClient(configKey = "countryService")
interface CountriesService {
    @GET
    @Path("/name/{name}")
    @Produces("application/json")
    fun getByName(@PathParam name: String): Set<Country>

    @GET
    @Path("/name/germany")
    @Produces("application/json")
    fun response(): Set<Country>

    @GET
    @Path("/name/{name}")
    @Produces("application/json")
    fun getByNameAsync(@PathParam name: String): CompletionStage<Set<Country>>

    @GET
    @Path("/name/{name}")
    @Produces("application/json")
    fun getByNameAsUni(@PathParam name: String): Uni<Set<Country>>
}