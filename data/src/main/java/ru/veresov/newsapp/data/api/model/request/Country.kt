package ru.veresov.newsapp.data.api.model.request

import com.squareup.moshi.Json

enum class Country(val description: String) {
    @Json(name = "ae")
    AE("United Arab Emirates"),

    @Json(name = "ar")
    AR("Argentina"),

    @Json(name = "at")
    AT("Austria"),

    @Json(name = "au")
    AU("Australia"),

    @Json(name = "be")
    BE("Belgium"),

    @Json(name = "bg")
    BG("Bulgaria"),

    @Json(name = "br")
    BR("Brazil"),

    @Json(name = "ca")
    CA("Canada"),

    @Json(name = "ch")
    CH("Switzerland"),

    @Json(name = "cn")
    CN("China"),

    @Json(name = "co")
    CO("Colombia"),

    @Json(name = "cu")
    CU("Cuba"),

    @Json(name = "cz")
    CZ("Czech Republic"),

    @Json(name = "de")
    DE("Germany"),

    @Json(name = "eg")
    EG("Egypt"),

    @Json(name = "fr")
    FR("France"),

    @Json(name = "gb")
    GB("United Kingdom"),

    @Json(name = "gr")
    GR("Greece"),

    @Json(name = "hk")
    HK("Hong Kong"),

    @Json(name = "hu")
    HU("Hungary"),

    @Json(name = "id")
    ID("Indonesia"),

    @Json(name = "ie")
    IE("Ireland"),

    @Json(name = "il")
    IL("Israel"),

    @Json(name = "it")
    IT("Italy"),

    @Json(name = "jp")
    JP("Japan"),

    @Json(name = "kr")
    KR("South Korea"),

    @Json(name = "lt")
    LT("Lithuania"),

    @Json(name = "lv")
    LV("Latvia"),

    @Json(name = "ma")
    MA("Morocco"),

    @Json(name = "mx")
    MX("Mexico"),

    @Json(name = "my")
    MY("Malaysia"),

    @Json(name = "ng")
    NG("Nigeria"),

    @Json(name = "nl")
    NL("Netherlands"),

    @Json(name = "no")
    NO("Norway"),

    @Json(name = "nz")
    NZ("New Zealand"),

    @Json(name = "ph")
    PH("Philippines"),

    @Json(name = "pl")
    PL("Poland"),

    @Json(name = "pt")
    PT("Portugal"),

    @Json(name = "ro")
    RO("Romania"),

    @Json(name = "rs")
    RS("Serbia"),

    @Json(name = "ru")
    RU("Russia"),

    @Json(name = "sa")
    SA("Saudi Arabia"),

    @Json(name = "se")
    SE("Sweden"),

    @Json(name = "sg")
    SG("Singapore"),

    @Json(name = "si")
    SI("Slovenia"),

    @Json(name = "sk")
    SK("Slovakia"),

    @Json(name = "th")
    TH("Thailand"),

    @Json(name = "tr")
    TR("Turkey"),

    @Json(name = "tw")
    TW("Taiwan"),

    @Json(name = "ua")
    UA("Ukraine"),

    @Json(name = "us")
    US("United States"),

    @Json(name = "ve")
    VE("Venezuela"),

    @Json(name = "za")
    ZA("South Africa")
}