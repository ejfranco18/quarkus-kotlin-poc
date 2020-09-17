package org.acme.rest.client

import io.smallrye.mutiny.Uni
import org.eclipse.microprofile.rest.client.inject.RestClient
import org.jboss.resteasy.annotations.jaxrs.PathParam
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces

@Path("/news")
class NewsResource {
    @Inject
    @field: RestClient
    internal lateinit var newsService: NewsService

    @GET
    @Path("/{id}")
    @Produces("application/json")
    fun getNews(@PathParam id: String): Uni<News> {
        return newsService.getNews(id)
    }

    @GET
    @Path("/message/greet")
    @Produces("application/json")
    fun hello() = Greeting("Hello welcome")
}
