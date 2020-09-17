package org.acme.rest.client

import io.smallrye.mutiny.Uni
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient
import org.jboss.resteasy.annotations.jaxrs.PathParam
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces

@Path("/v0/item")
@RegisterRestClient(configKey = "newsConfigService")
interface NewsService {

    @GET
    @Path("/{id}.json")
    @Produces("application/json")
    fun getNews(@PathParam id: String): Uni<News>
}