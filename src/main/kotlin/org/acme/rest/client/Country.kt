package org.acme.rest.client


class Country {
    var by: String? = null
    var alpha2Code: String? = null
    var capital: String? = null
    var alpha3Code: String? = null
    var region: String? = null
    var currencies: List<Currency>? = null

    class Currency {
        var code: String? = null
        var name: String? = null
        var symbol: String? = null
    }
}