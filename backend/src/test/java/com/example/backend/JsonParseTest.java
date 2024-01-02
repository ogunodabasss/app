package com.example.backend;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.junit.jupiter.api.Test;

public class JsonParseTest {
    private static final String JSON_0 = """
                                    {
                                    "html_attributions": [],
                                    "results": [],
                                    "status": "ZERO_RESULTS"
                                }
            """;

    private static final String JSON = """
            {
                "html_attributions": [],
                "next_page_token": "******************",
                "results": [
                    {
                        "business_status": "OPERATIONAL",
                        "geometry": {
                            "location": {
                                "lat": 41.0069322,
                                "lng": 38.8214027
                            },
                            "viewport": {
                                "northeast": {
                                    "lat": 41.0082923302915,
                                    "lng": 38.8228362802915
                                },
                                "southwest": {
                                    "lat": 41.0055943697085,
                                    "lng": 38.8201383197085
                                }
                            }
                        },
                        "icon": "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/restaurant-71.png",
                        "icon_background_color": "#FF9E67",
                        "icon_mask_base_uri": "https://maps.gstatic.com/mapfiles/place_api/icons/v2/restaurant_pinlet",
                        "name": "Kale Restaurant",
                        "opening_hours": {
                            "open_now": false
                        },
                        "photos": [
                            {
                                "height": 4032,
                                "html_attributions": [
                                    "<a href=\\"https://maps.google.com/maps/contrib/111599403371000076848\\">Murat Serda Topal</a>"
                                ],
                                "photo_reference": "AWU5eFgGl1cmzX3xWx1U5Af4ownXD0g1OXYbHlq1zdGGuWSuhQb9Pt-YQswRMYbIgCZOlQI_lyNIOddjd4zrJf3efE9TuF2oxjov-XaXU1hAsyThHcUsLSgWTS8gPStvUAY9NPFVKTHdYMlWNtqfi4d7l7371upY280RzH4uKA73hli3zhiJ",
                                "width": 3024
                            }
                        ],
                        "place_id": "ChIJF25sP6KDY0AR7AM8k1v_Mvk",
                        "plus_code": {
                            "compound_code": "2R4C+QH Tirebolu/Giresun, Türkiye",
                            "global_code": "8GHW2R4C+QH"
                        },
                        "price_level": 2,
                        "rating": 3.8,
                        "reference": "ChIJF25sP6KDY0AR7AM8k1v_Mvk",
                        "scope": "GOOGLE",
                        "types": [
                            "restaurant",
                            "food",
                            "point_of_interest",
                            "establishment"
                        ],
                        "user_ratings_total": 367,
                        "vicinity": "Hamam Mah. Kaledibi Mevkii"
                    },
                    {
                        "business_status": "OPERATIONAL",
                        "geometry": {
                            "location": {
                                "lat": 41.0065071,
                                "lng": 38.81017489999999
                            },
                            "viewport": {
                                "northeast": {
                                    "lat": 41.0077196302915,
                                    "lng": 38.8116064302915
                                },
                                "southwest": {
                                    "lat": 41.0050216697085,
                                    "lng": 38.8089084697085
                                }
                            }
                        },
                        "icon": "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/cafe-71.png",
                        "icon_background_color": "#FF9E67",
                        "icon_mask_base_uri": "https://maps.gstatic.com/mapfiles/place_api/icons/v2/cafe_pinlet",
                        "name": "Çakoğlu Gençlik Parkı",
                        "opening_hours": {
                            "open_now": false
                        },
                        "photos": [
                            {
                                "height": 1440,
                                "html_attributions": [
                                    "<a href=\\"https://maps.google.com/maps/contrib/109823218281321778310\\">Çakoğlu Gençlik Parkı</a>"
                                ],
                                "photo_reference": "AWU5eFgV98TKuvYfjeOjIKiww5sBwKjp8cvvsAnFCcD5ruLUCZJDCEYD1F0HCOADxzl8aep_knssC0yVms-tFdXEAFB4g9SqWZQX8LyUCWJa2fN5k3Dxw9SWn_TW6XzJ2z2FN0r7eEv5rZ1MVi1pRkQA-caBPaaq4uQ_SA2Ew_yHOdi0K9hq",
                                "width": 3224
                            }
                        ],
                        "place_id": "ChIJbXkkXKeDY0ARey21PZuX_uk",
                        "plus_code": {
                            "compound_code": "2R46+J3 Tirebolu/Giresun, Türkiye",
                            "global_code": "8GHW2R46+J3"
                        },
                        "rating": 4,
                        "reference": "ChIJbXkkXKeDY0ARey21PZuX_uk",
                        "scope": "GOOGLE",
                        "types": [
                            "tourist_attraction",
                            "cafe",
                            "restaurant",
                            "food",
                            "point_of_interest",
                            "establishment"
                        ],
                        "user_ratings_total": 214,
                        "vicinity": "Yeniköy, Amiral Şükrü Okan Caddesi No:22"
                    },
                    {
                        "business_status": "OPERATIONAL",
                        "geometry": {
                            "location": {
                                "lat": 41.0052051,
                                "lng": 38.81084870000001
                            },
                            "viewport": {
                                "northeast": {
                                    "lat": 41.0065319302915,
                                    "lng": 38.8121377302915
                                },
                                "southwest": {
                                    "lat": 41.0038339697085,
                                    "lng": 38.8094397697085
                                }
                            }
                        },
                        "icon": "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/restaurant-71.png",
                        "icon_background_color": "#FF9E67",
                        "icon_mask_base_uri": "https://maps.gstatic.com/mapfiles/place_api/icons/v2/restaurant_pinlet",
                        "name": "Çakoğlu Fast Food",
                        "opening_hours": {
                            "open_now": false
                        },
                        "photos": [
                            {
                                "height": 3024,
                                "html_attributions": [
                                    "<a href=\\"https://maps.google.com/maps/contrib/108663543715091766623\\">Fatih Suat Oyman</a>"
                                ],
                                "photo_reference": "AWU5eFhb0NyHITEHqzuIxsR4V3_iFEkePkIJx1pWM_ssJMeVDXY1Ip56lrhTB7DmG-Jk-12_ZKoLabVupzPrwe3P8n-_FHyRhabBCwO7YqhLRkgSUjBXK2VfcY9nK2I-kU5cdL053XYRKKercwbeR7Ju4WX55hoPY3vGRskVDyBeBTCqVesZ",
                                "width": 4032
                            }
                        ],
                        "place_id": "ChIJjzTkaKeDY0ARfIDfH9QuDFc",
                        "plus_code": {
                            "compound_code": "2R46+38 Tirebolu/Giresun, Türkiye",
                            "global_code": "8GHW2R46+38"
                        },
                        "rating": 4.2,
                        "reference": "ChIJjzTkaKeDY0ARfIDfH9QuDFc",
                        "scope": "GOOGLE",
                        "types": [
                            "restaurant",
                            "food",
                            "point_of_interest",
                            "establishment"
                        ],
                        "user_ratings_total": 68,
                        "vicinity": "Yeniköy, Sağlık Sokak No:18"
                    },
                    {
                        "business_status": "OPERATIONAL",
                        "geometry": {
                            "location": {
                                "lat": 41.0066857,
                                "lng": 38.8123421
                            },
                            "viewport": {
                                "northeast": {
                                    "lat": 41.0080905302915,
                                    "lng": 38.8136558802915
                                },
                                "southwest": {
                                    "lat": 41.0053925697085,
                                    "lng": 38.8109579197085
                                }
                            }
                        },
                        "icon": "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/restaurant-71.png",
                        "icon_background_color": "#FF9E67",
                        "icon_mask_base_uri": "https://maps.gstatic.com/mapfiles/place_api/icons/v2/restaurant_pinlet",
                        "name": "ÖZBAL EKMEK FIRINI",
                        "opening_hours": {
                            "open_now": true
                        },
                        "photos": [
                            {
                                "height": 5632,
                                "html_attributions": [
                                    "<a href=\\"https://maps.google.com/maps/contrib/110782947612742498623\\">ÖZBAL EKMEK FIRINI</a>"
                                ],
                                "photo_reference": "AWU5eFj3KZNBr9BGXS0XD4KUMO6YM5j-VuD5FTQLq002Z8K6MWTAwCDhervb8HG6Mbnl25B-aNYNoLFimprDEPjsxTp9_ygqjayw0wCbXPIta0ODzTDv5fmyR9vJR_DR1o5BE8hXPejvtfH7_jqYB_JOrxE9NUv9IvqmlAyCROWVS8IwTCf6",
                                "width": 4224
                            }
                        ],
                        "place_id": "ChIJcSmINqeDY0AR5mnoljNVY3o",
                        "plus_code": {
                            "compound_code": "2R46+MW Tirebolu/Giresun, Türkiye",
                            "global_code": "8GHW2R46+MW"
                        },
                        "rating": 4,
                        "reference": "ChIJcSmINqeDY0AR5mnoljNVY3o",
                        "scope": "GOOGLE",
                        "types": [
                            "restaurant",
                            "food",
                            "point_of_interest",
                            "establishment"
                        ],
                        "user_ratings_total": 4,
                        "vicinity": "Yeniköy mah A şükrü ca No 30"
                    },
                    {
                        "business_status": "CLOSED_TEMPORARILY",
                        "geometry": {
                            "location": {
                                "lat": 41.0057204,
                                "lng": 38.8123537
                            },
                            "viewport": {
                                "northeast": {
                                    "lat": 41.0070692802915,
                                    "lng": 38.8137030802915
                                },
                                "southwest": {
                                    "lat": 41.0043713197085,
                                    "lng": 38.8110051197085
                                }
                            }
                        },
                        "icon": "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/restaurant-71.png",
                        "icon_background_color": "#FF9E67",
                        "icon_mask_base_uri": "https://maps.gstatic.com/mapfiles/place_api/icons/v2/restaurant_pinlet",
                        "name": "Yeniköy Kıraathanesi",
                        "permanently_closed": true,
                        "place_id": "ChIJJc5WH6eDY0ARIEWiXpNbmJM",
                        "plus_code": {
                            "compound_code": "2R46+7W Tirebolu/Giresun, Türkiye",
                            "global_code": "8GHW2R46+7W"
                        },
                        "rating": 4.5,
                        "reference": "ChIJJc5WH6eDY0ARIEWiXpNbmJM",
                        "scope": "GOOGLE",
                        "types": [
                            "restaurant",
                            "food",
                            "point_of_interest",
                            "establishment"
                        ],
                        "user_ratings_total": 2,
                        "vicinity": "Yeniköy, Gazipaşa Caddesi"
                    },
                    {
                        "business_status": "OPERATIONAL",
                        "geometry": {
                            "location": {
                                "lat": 41.0055079,
                                "lng": 38.8124454
                            },
                            "viewport": {
                                "northeast": {
                                    "lat": 41.0068616802915,
                                    "lng": 38.8137373302915
                                },
                                "southwest": {
                                    "lat": 41.0041637197085,
                                    "lng": 38.8110393697085
                                }
                            }
                        },
                        "icon": "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/restaurant-71.png",
                        "icon_background_color": "#FF9E67",
                        "icon_mask_base_uri": "https://maps.gstatic.com/mapfiles/place_api/icons/v2/restaurant_pinlet",
                        "name": "Küçük Ev Pide",
                        "opening_hours": {
                            "open_now": false
                        },
                        "photos": [
                            {
                                "height": 1536,
                                "html_attributions": [
                                    "<a href=\\"https://maps.google.com/maps/contrib/116322439976529737388\\">Hayrullah Karaman</a>"
                                ],
                                "photo_reference": "AWU5eFiGrWGhoBJOV1BLDon-UMzeaDTZqnK_pUYbOPA2Pis5wismWt4DArt6lga3T7U0YwMvnoyy1hHChUlzd8QBAQEyoxoF5yBbtUT2qU-FDRXUlViYuVAuIgdsMbvqbLgRoxivUR7sRz14ZUFJQV8BXs3venKZKEjEeOG7zrJwLMxo_vZZ",
                                "width": 2560
                            }
                        ],
                        "place_id": "ChIJVxgbHqeDY0ARmBLUzPaz3U4",
                        "plus_code": {
                            "compound_code": "2R46+6X Tirebolu/Giresun, Türkiye",
                            "global_code": "8GHW2R46+6X"
                        },
                        "rating": 5,
                        "reference": "ChIJVxgbHqeDY0ARmBLUzPaz3U4",
                        "scope": "GOOGLE",
                        "types": [
                            "restaurant",
                            "food",
                            "point_of_interest",
                            "establishment"
                        ],
                        "user_ratings_total": 2,
                        "vicinity": "Yeniköy, Gazipaşa Caddesi"
                    },
                    {
                        "business_status": "OPERATIONAL",
                        "geometry": {
                            "location": {
                                "lat": 41.0052975,
                                "lng": 38.8124863
                            },
                            "viewport": {
                                "northeast": {
                                    "lat": 41.0066643302915,
                                    "lng": 38.8137405302915
                                },
                                "southwest": {
                                    "lat": 41.0039663697085,
                                    "lng": 38.8110425697085
                                }
                            }
                        },
                        "icon": "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/restaurant-71.png",
                        "icon_background_color": "#FF9E67",
                        "icon_mask_base_uri": "https://maps.gstatic.com/mapfiles/place_api/icons/v2/restaurant_pinlet",
                        "name": "Fak Pide",
                        "opening_hours": {
                            "open_now": false
                        },
                        "photos": [
                            {
                                "height": 2304,
                                "html_attributions": [
                                    "<a href=\\"https://maps.google.com/maps/contrib/117585143960554040614\\">Cemal Dvd</a>"
                                ],
                                "photo_reference": "AWU5eFgI7drDazRkKSaPnyQPqYSW0SnCTAYA8CtmhvlW7jk2J9e1ioaZ965vprJuKx_zPt4tLGdeVUIqFkqO90yzE-9iiCWB0M4QYItITsu7UIx1wMxAWKD6GtUtS-fBrXf8E1kYUTQLDIFLXozaNjRgGgUNf-nZtPLcPBkQ5IdDVGL5pJcX",
                                "width": 4096
                            }
                        ],
                        "place_id": "ChIJeRXf4qaDY0ARrMGRKAm0rbE",
                        "plus_code": {
                            "compound_code": "2R46+4X Tirebolu/Giresun, Türkiye",
                            "global_code": "8GHW2R46+4X"
                        },
                        "rating": 4.6,
                        "reference": "ChIJeRXf4qaDY0ARrMGRKAm0rbE",
                        "scope": "GOOGLE",
                        "types": [
                            "restaurant",
                            "food",
                            "point_of_interest",
                            "establishment"
                        ],
                        "user_ratings_total": 29,
                        "vicinity": "Yeniköy, Gazipaşa Caddesi"
                    },
                    {
                        "business_status": "OPERATIONAL",
                        "geometry": {
                            "location": {
                                "lat": 41.0045906,
                                "lng": 38.8118066
                            },
                            "viewport": {
                                "northeast": {
                                    "lat": 41.0059260302915,
                                    "lng": 38.8131933802915
                                },
                                "southwest": {
                                    "lat": 41.0032280697085,
                                    "lng": 38.8104954197085
                                }
                            }
                        },
                        "icon": "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/restaurant-71.png",
                        "icon_background_color": "#FF9E67",
                        "icon_mask_base_uri": "https://maps.gstatic.com/mapfiles/place_api/icons/v2/restaurant_pinlet",
                        "name": "CAFE MİNEL",
                        "opening_hours": {
                            "open_now": false
                        },
                        "photos": [
                            {
                                "height": 768,
                                "html_attributions": [
                                    "<a href=\\"https://maps.google.com/maps/contrib/108189983081233453859\\">Umut Kaya</a>"
                                ],
                                "photo_reference": "AWU5eFh4TWE5vJ2KSaMxUtlYgSEpGgurtC65YobT56b6ToBvMuMHIvXwClRHU_sjCxJkoGfpZSIuKMgm09OdJ2ysV5xwRwIdxr0SWRYaPyoKYGtP89x5CM1m3Au58KnuOWrCeZ-OzbSConu2nFhdMnwaLReOuDSwi9Nei2ROhGFAmjOKMwl5",
                                "width": 768
                            }
                        ],
                        "place_id": "ChIJM3yBC--DY0ARDOrTgvpAFGA",
                        "plus_code": {
                            "compound_code": "2R36+RP Tirebolu/Giresun, Türkiye",
                            "global_code": "8GHW2R36+RP"
                        },
                        "reference": "ChIJM3yBC--DY0ARDOrTgvpAFGA",
                        "scope": "GOOGLE",
                        "types": [
                            "restaurant",
                            "food",
                            "point_of_interest",
                            "establishment"
                        ],
                        "vicinity": "Yeniköy, Gazipaşa Caddesi"
                    },
                    {
                        "business_status": "CLOSED_TEMPORARILY",
                        "geometry": {
                            "location": {
                                "lat": 41.00677829999999,
                                "lng": 38.8138105
                            },
                            "viewport": {
                                "northeast": {
                                    "lat": 41.00819818029149,
                                    "lng": 38.8152423802915
                                },
                                "southwest": {
                                    "lat": 41.00550021970849,
                                    "lng": 38.8125444197085
                                }
                            }
                        },
                        "icon": "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/restaurant-71.png",
                        "icon_background_color": "#FF9E67",
                        "icon_mask_base_uri": "https://maps.gstatic.com/mapfiles/place_api/icons/v2/restaurant_pinlet",
                        "name": "Salih Çay Evi",
                        "permanently_closed": true,
                        "place_id": "ChIJGYXT1qCDY0ARybDjPzGA3Fs",
                        "plus_code": {
                            "compound_code": "2R47+PG Tirebolu/Giresun, Türkiye",
                            "global_code": "8GHW2R47+PG"
                        },
                        "rating": 4,
                        "reference": "ChIJGYXT1qCDY0ARybDjPzGA3Fs",
                        "scope": "GOOGLE",
                        "types": [
                            "restaurant",
                            "food",
                            "point_of_interest",
                            "establishment"
                        ],
                        "user_ratings_total": 2,
                        "vicinity": "Çarşı, Sahil Sokak"
                    },
                    {
                        "business_status": "OPERATIONAL",
                        "geometry": {
                            "location": {
                                "lat": 41.0034331,
                                "lng": 38.809129
                            },
                            "viewport": {
                                "northeast": {
                                    "lat": 41.0047938302915,
                                    "lng": 38.8104383802915
                                },
                                "southwest": {
                                    "lat": 41.0020958697085,
                                    "lng": 38.8077404197085
                                }
                            }
                        },
                        "icon": "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/restaurant-71.png",
                        "icon_background_color": "#FF9E67",
                        "icon_mask_base_uri": "https://maps.gstatic.com/mapfiles/place_api/icons/v2/restaurant_pinlet",
                        "name": "7/24 çorbacı",
                        "photos": [
                            {
                                "height": 1080,
                                "html_attributions": [
                                    "<a href=\\"https://maps.google.com/maps/contrib/116605070452069421094\\">7/24 çorbacı</a>"
                                ],
                                "photo_reference": "AWU5eFiHW04foiQtHv2XZm3D0DBFabtIuuCVoIZOGMvj0ij9U3uvsm6624pxdzkm1sL18bwhuk28QRArpPf9xYjmI3CyVdQ52SpK2jvzJ9f4gZ7JdVgDHJzxXUB5P_GSbPD4gPlyxqMTi0qL6ehpUn-uEWA-FbwZK5OZxxr_nM88QojkQVJj",
                                "width": 1920
                            }
                        ],
                        "place_id": "ChIJWeHsPdmDY0ARudftDccoZHA",
                        "plus_code": {
                            "compound_code": "2R35+9M Tirebolu/Giresun, Türkiye",
                            "global_code": "8GHW2R35+9M"
                        },
                        "rating": 3,
                        "reference": "ChIJWeHsPdmDY0ARudftDccoZHA",
                        "scope": "GOOGLE",
                        "types": [
                            "restaurant",
                            "food",
                            "point_of_interest",
                            "establishment"
                        ],
                        "user_ratings_total": 8,
                        "vicinity": "Yeniköy, Plaj Sokak 69/14"
                    },
                    {
                        "business_status": "OPERATIONAL",
                        "geometry": {
                            "location": {
                                "lat": 41.0080332,
                                "lng": 38.81343519999999
                            },
                            "viewport": {
                                "northeast": {
                                    "lat": 41.0093424802915,
                                    "lng": 38.8147156302915
                                },
                                "southwest": {
                                    "lat": 41.00664451970851,
                                    "lng": 38.8120176697085
                                }
                            }
                        },
                        "icon": "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/restaurant-71.png",
                        "icon_background_color": "#FF9E67",
                        "icon_mask_base_uri": "https://maps.gstatic.com/mapfiles/place_api/icons/v2/restaurant_pinlet",
                        "name": "Otogar Çay Evi",
                        "opening_hours": {
                            "open_now": false
                        },
                        "place_id": "ChIJbchXlqCDY0ARLDJJ6dZpe44",
                        "plus_code": {
                            "compound_code": "2R57+69 Tirebolu/Giresun, Türkiye",
                            "global_code": "8GHW2R57+69"
                        },
                        "rating": 5,
                        "reference": "ChIJbchXlqCDY0ARLDJJ6dZpe44",
                        "scope": "GOOGLE",
                        "types": [
                            "restaurant",
                            "food",
                            "point_of_interest",
                            "establishment"
                        ],
                        "user_ratings_total": 1,
                        "vicinity": "Çarşı, Amiral Şükrü Okan Caddesi"
                    },
                    {
                        "business_status": "OPERATIONAL",
                        "geometry": {
                            "location": {
                                "lat": 41.00790469999999,
                                "lng": 38.8135473
                            },
                            "viewport": {
                                "northeast": {
                                    "lat": 41.0092173802915,
                                    "lng": 38.8148343302915
                                },
                                "southwest": {
                                    "lat": 41.0065194197085,
                                    "lng": 38.8121363697085
                                }
                            }
                        },
                        "icon": "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/restaurant-71.png",
                        "icon_background_color": "#FF9E67",
                        "icon_mask_base_uri": "https://maps.gstatic.com/mapfiles/place_api/icons/v2/restaurant_pinlet",
                        "name": "Otogar Lokantası",
                        "opening_hours": {
                            "open_now": false
                        },
                        "photos": [
                            {
                                "height": 2322,
                                "html_attributions": [
                                    "<a href=\\"https://maps.google.com/maps/contrib/109226936411940374264\\">Hüseyin Uğuzman</a>"
                                ],
                                "photo_reference": "AWU5eFh1uWwgQOZr_CK-Q-EXv5j2FsO5WU1DmRiUNxGLKHw3QTKa81S-9m3OHSykRjFzl9fHlOjb56_s6DlWq5ZdesJnJg8Uwfy-OFlr6jDehcNI_88fhxRg6kAcHlJUGUe2TTW87Lq0jPRHDyA-77Q8b_ZZbfEM1eODESenEVCt4qr_8rSq",
                                "width": 4128
                            }
                        ],
                        "place_id": "ChIJ87RwlqCDY0ARzHFa5ukJhQY",
                        "plus_code": {
                            "compound_code": "2R57+5C Tirebolu/Giresun, Türkiye",
                            "global_code": "8GHW2R57+5C"
                        },
                        "rating": 3.6,
                        "reference": "ChIJ87RwlqCDY0ARzHFa5ukJhQY",
                        "scope": "GOOGLE",
                        "types": [
                            "restaurant",
                            "food",
                            "point_of_interest",
                            "establishment"
                        ],
                        "user_ratings_total": 9,
                        "vicinity": "Çarşı, Amiral Şükrü Okan Caddesi"
                    },
                    {
                        "business_status": "CLOSED_TEMPORARILY",
                        "geometry": {
                            "location": {
                                "lat": 41.00785,
                                "lng": 38.81359999999999
                            },
                            "viewport": {
                                "northeast": {
                                    "lat": 41.00917063029149,
                                    "lng": 38.81487698029149
                                },
                                "southwest": {
                                    "lat": 41.00647266970849,
                                    "lng": 38.81217901970849
                                }
                            }
                        },
                        "icon": "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/restaurant-71.png",
                        "icon_background_color": "#FF9E67",
                        "icon_mask_base_uri": "https://maps.gstatic.com/mapfiles/place_api/icons/v2/restaurant_pinlet",
                        "name": "Yakamoz Çay Evi",
                        "permanently_closed": true,
                        "place_id": "ChIJZ_WYlaCDY0ARsisc5GNMSS8",
                        "plus_code": {
                            "compound_code": "2R57+4C Tirebolu/Giresun, Türkiye",
                            "global_code": "8GHW2R57+4C"
                        },
                        "reference": "ChIJZ_WYlaCDY0ARsisc5GNMSS8",
                        "scope": "GOOGLE",
                        "types": [
                            "restaurant",
                            "food",
                            "point_of_interest",
                            "establishment"
                        ],
                        "vicinity": "Çarşı, Amiral Şükrü Okan Caddesi"
                    },
                    {
                        "business_status": "OPERATIONAL",
                        "geometry": {
                            "location": {
                                "lat": 41.0076681,
                                "lng": 38.8138589
                            },
                            "viewport": {
                                "northeast": {
                                    "lat": 41.00897493029149,
                                    "lng": 38.81516938029149
                                },
                                "southwest": {
                                    "lat": 41.00627696970849,
                                    "lng": 38.8124714197085
                                }
                            }
                        },
                        "icon": "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/restaurant-71.png",
                        "icon_background_color": "#FF9E67",
                        "icon_mask_base_uri": "https://maps.gstatic.com/mapfiles/place_api/icons/v2/restaurant_pinlet",
                        "name": "Barabut Pide",
                        "opening_hours": {
                            "open_now": false
                        },
                        "photos": [
                            {
                                "height": 1080,
                                "html_attributions": [
                                    "<a href=\\"https://maps.google.com/maps/contrib/108909565159759977000\\">Amer ELNECCAR عامر النجار</a>"
                                ],
                                "photo_reference": "AWU5eFhT4tsy5A1dh-Bh3e02B2Ggl8_DkQW9c5wwClU7xdxHRduZONoRLsFVlDbPDn2hIV1GjsulsDB7dIOA0INJFH6-rcKhCGpYu_rq4NLJ4GO0bk19e9IP4iM06yhcFpky0BeMBDsB9FVrlhpbhq1KzuqXKf3tqrn4EGLU1bAkw0yTkid8",
                                "width": 1920
                            }
                        ],
                        "place_id": "ChIJbT0F-qCDY0AR9TLpCN9sjE4",
                        "plus_code": {
                            "compound_code": "2R57+3G Tirebolu/Giresun, Türkiye",
                            "global_code": "8GHW2R57+3G"
                        },
                        "price_level": 2,
                        "rating": 3.9,
                        "reference": "ChIJbT0F-qCDY0AR9TLpCN9sjE4",
                        "scope": "GOOGLE",
                        "types": [
                            "restaurant",
                            "food",
                            "point_of_interest",
                            "establishment"
                        ],
                        "user_ratings_total": 190,
                        "vicinity": "Çarşı"
                    },
                    {
                        "business_status": "OPERATIONAL",
                        "geometry": {
                            "location": {
                                "lat": 41.0076904,
                                "lng": 38.8140001
                            },
                            "viewport": {
                                "northeast": {
                                    "lat": 41.0089680802915,
                                    "lng": 38.81526983029151
                                },
                                "southwest": {
                                    "lat": 41.0062701197085,
                                    "lng": 38.81257186970851
                                }
                            }
                        },
                        "icon": "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/restaurant-71.png",
                        "icon_background_color": "#FF9E67",
                        "icon_mask_base_uri": "https://maps.gstatic.com/mapfiles/place_api/icons/v2/restaurant_pinlet",
                        "name": "Tirebolum Pide & Köfte",
                        "opening_hours": {
                            "open_now": false
                        },
                        "photos": [
                            {
                                "height": 4032,
                                "html_attributions": [
                                    "<a href=\\"https://maps.google.com/maps/contrib/106742170826404959001\\">Muhammed KAMAT</a>"
                                ],
                                "photo_reference": "AWU5eFgjkmihSvXBuSzH60WnZJsyPOamiAqO2Mx1FYn86xOYgldjs52AC-pE0A1TVGNXk50GCRcJXSQjJUWKkqT7m9llZ8I4MBlM5Vst64Krm4PikEn7MXTB1MQud5JVbwba7kg2n0VlFtlil9Rsr273PPvMrefL7XdH1pX4tcDEswe8zbAu",
                                "width": 3024
                            }
                        ],
                        "place_id": "ChIJdfOgwaCDY0ARRdCdiW3Aezo",
                        "plus_code": {
                            "compound_code": "2R57+3J Tirebolu/Giresun, Türkiye",
                            "global_code": "8GHW2R57+3J"
                        },
                        "price_level": 2,
                        "rating": 3.6,
                        "reference": "ChIJdfOgwaCDY0ARRdCdiW3Aezo",
                        "scope": "GOOGLE",
                        "types": [
                            "restaurant",
                            "food",
                            "point_of_interest",
                            "establishment"
                        ],
                        "user_ratings_total": 101,
                        "vicinity": "Yeniköy, Amiral Şükrü Okan Caddesi/Çevre yolu sok No:4 D:5, Tirebolu"
                    },
                    {
                        "business_status": "OPERATIONAL",
                        "geometry": {
                            "location": {
                                "lat": 41.0069288,
                                "lng": 38.8145917
                            },
                            "viewport": {
                                "northeast": {
                                    "lat": 41.0082759802915,
                                    "lng": 38.8159192802915
                                },
                                "southwest": {
                                    "lat": 41.0055780197085,
                                    "lng": 38.8132213197085
                                }
                            }
                        },
                        "icon": "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/restaurant-71.png",
                        "icon_background_color": "#FF9E67",
                        "icon_mask_base_uri": "https://maps.gstatic.com/mapfiles/place_api/icons/v2/restaurant_pinlet",
                        "name": "HANE DÖNER",
                        "opening_hours": {
                            "open_now": false
                        },
                        "photos": [
                            {
                                "height": 3096,
                                "html_attributions": [
                                    "<a href=\\"https://maps.google.com/maps/contrib/110893807151888066855\\">İrfan Kaplan</a>"
                                ],
                                "photo_reference": "AWU5eFiraZ5V4ZIJZdY0iDiAIwNaJb5DX5KUJmBeKn-YiKWKSibgtWSOegZJOt15az8AJ38CwvJx1Te85K7zrmaW4lsbFRTvAwZYU-SWfU9URtSwqwyRBvp6xPRXZrv0I4lgZI-7T2wNhc4kPGpgt69l74A8vbLSiKK7L9PgcviEVKAh3f-L",
                                "width": 4128
                            }
                        ],
                        "place_id": "ChIJJ0302KCDY0ARkU6e3rxzopE",
                        "plus_code": {
                            "compound_code": "2R47+QR Tirebolu/Giresun, Türkiye",
                            "global_code": "8GHW2R47+QR"
                        },
                        "rating": 3.9,
                        "reference": "ChIJJ0302KCDY0ARkU6e3rxzopE",
                        "scope": "GOOGLE",
                        "types": [
                            "restaurant",
                            "food",
                            "point_of_interest",
                            "establishment"
                        ],
                        "user_ratings_total": 14,
                        "vicinity": "Çarşı, Zübeyde Hanım Sokak No:1"
                    },
                    {
                        "business_status": "OPERATIONAL",
                        "geometry": {
                            "location": {
                                "lat": 41.00837899999999,
                                "lng": 38.813763
                            },
                            "viewport": {
                                "northeast": {
                                    "lat": 41.0097122302915,
                                    "lng": 38.81509783029149
                                },
                                "southwest": {
                                    "lat": 41.0070142697085,
                                    "lng": 38.8123998697085
                                }
                            }
                        },
                        "icon": "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/restaurant-71.png",
                        "icon_background_color": "#FF9E67",
                        "icon_mask_base_uri": "https://maps.gstatic.com/mapfiles/place_api/icons/v2/restaurant_pinlet",
                        "name": "Hasan Usta'nın Yeri",
                        "opening_hours": {
                            "open_now": false
                        },
                        "photos": [
                            {
                                "height": 3744,
                                "html_attributions": [
                                    "<a href=\\"https://maps.google.com/maps/contrib/103283833543895997855\\">fatih a</a>"
                                ],
                                "photo_reference": "AWU5eFhRm8qgverxXN8LPwqjcb6pZOKmfxv-XWIAUdKoePGTJDmYEnQRFYSxuM5rJkUg59BillfPd580kBUFef5xKmU3mhOvtHxJQoOV-RkQDoVuuhDfqzmS6gdIyY6NLTrS6rcARyY7BDkpoL_lrYSMWZcn3myNSrVZQp6DraZxvooDByda",
                                "width": 5616
                            }
                        ],
                        "place_id": "ChIJMd7oj6CDY0ARvZER3yuwzoU",
                        "plus_code": {
                            "compound_code": "2R57+9G Tirebolu/Giresun, Türkiye",
                            "global_code": "8GHW2R57+9G"
                        },
                        "rating": 4,
                        "reference": "ChIJMd7oj6CDY0ARvZER3yuwzoU",
                        "scope": "GOOGLE",
                        "types": [
                            "restaurant",
                            "food",
                            "point_of_interest",
                            "establishment"
                        ],
                        "user_ratings_total": 1,
                        "vicinity": "Çarşı, Park Sokak"
                    },
                    {
                        "business_status": "OPERATIONAL",
                        "geometry": {
                            "location": {
                                "lat": 41.0077139,
                                "lng": 38.8143013
                            },
                            "viewport": {
                                "northeast": {
                                    "lat": 41.00907908029151,
                                    "lng": 38.81572523029151
                                },
                                "southwest": {
                                    "lat": 41.00638111970851,
                                    "lng": 38.81302726970851
                                }
                            }
                        },
                        "icon": "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/restaurant-71.png",
                        "icon_background_color": "#FF9E67",
                        "icon_mask_base_uri": "https://maps.gstatic.com/mapfiles/place_api/icons/v2/restaurant_pinlet",
                        "name": "Cafebest",
                        "opening_hours": {
                            "open_now": false
                        },
                        "photos": [
                            {
                                "height": 3264,
                                "html_attributions": [
                                    "<a href=\\"https://maps.google.com/maps/contrib/107742395613401257595\\">Cafebest</a>"
                                ],
                                "photo_reference": "AWU5eFiTqc_nBeOh-3M1UUBKtG_WUg2P6A91lbt9LNQRv9NFUX_PnfUBZeeSWeBZXXAkg7XG9VDp9krJgoMSG2m_ZVuTc85lwftPnt_fI5zX39O22q-QH_9mAQEuUuX-RFTchd-3IY7wL4o4D9W3EcoT9TZSyX-IiwJsfXHX5gXCSrB9xjEx",
                                "width": 2448
                            }
                        ],
                        "place_id": "ChIJ72Ty8YKDY0ARbR3mqTZg5V0",
                        "plus_code": {
                            "compound_code": "2R57+3P Tirebolu/Giresun, Türkiye",
                            "global_code": "8GHW2R57+3P"
                        },
                        "reference": "ChIJ72Ty8YKDY0ARbR3mqTZg5V0",
                        "scope": "GOOGLE",
                        "types": [
                            "restaurant",
                            "food",
                            "point_of_interest",
                            "establishment"
                        ],
                        "vicinity": "Çarşı, Zübeyde Hanım Sokak 17 b"
                    },
                    {
                        "business_status": "OPERATIONAL",
                        "geometry": {
                            "location": {
                                "lat": 41.00687069999999,
                                "lng": 38.8147139
                            },
                            "viewport": {
                                "northeast": {
                                    "lat": 41.00821583029149,
                                    "lng": 38.8160167802915
                                },
                                "southwest": {
                                    "lat": 41.0055178697085,
                                    "lng": 38.8133188197085
                                }
                            }
                        },
                        "icon": "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/restaurant-71.png",
                        "icon_background_color": "#FF9E67",
                        "icon_mask_base_uri": "https://maps.gstatic.com/mapfiles/place_api/icons/v2/restaurant_pinlet",
                        "name": "Köşem Et Döner",
                        "opening_hours": {
                            "open_now": false
                        },
                        "place_id": "ChIJAR2NJ6GDY0ARcD_V353E6JM",
                        "plus_code": {
                            "compound_code": "2R47+PV Tirebolu/Giresun, Türkiye",
                            "global_code": "8GHW2R47+PV"
                        },
                        "rating": 4.4,
                        "reference": "ChIJAR2NJ6GDY0ARcD_V353E6JM",
                        "scope": "GOOGLE",
                        "types": [
                            "restaurant",
                            "food",
                            "point_of_interest",
                            "establishment"
                        ],
                        "user_ratings_total": 13,
                        "vicinity": "Çarşı, Zübeyde Hanım Sokak"
                    },
                    {
                        "business_status": "CLOSED_TEMPORARILY",
                        "geometry": {
                            "location": {
                                "lat": 41.0073772,
                                "lng": 38.8145586
                            },
                            "viewport": {
                                "northeast": {
                                    "lat": 41.0087261802915,
                                    "lng": 38.8159002302915
                                },
                                "southwest": {
                                    "lat": 41.0060282197085,
                                    "lng": 38.8132022697085
                                }
                            }
                        },
                        "icon": "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/restaurant-71.png",
                        "icon_background_color": "#FF9E67",
                        "icon_mask_base_uri": "https://maps.gstatic.com/mapfiles/place_api/icons/v2/restaurant_pinlet",
                        "name": "EFSAM RESTAURANT",
                        "permanently_closed": true,
                        "photos": [
                            {
                                "height": 1920,
                                "html_attributions": [
                                    "<a href=\\"https://maps.google.com/maps/contrib/117948110985427533136\\">Mutlu Yıldız</a>"
                                ],
                                "photo_reference": "AWU5eFh16Rz2dEYy0tTaRZrF0xvMLG8DD4PF9HvPoAkFcv1k57FiF-q6OYRBp0tyFR3NCm1RyvtI8e7aPNvL0wajGOzrWhxNVpO7Y7bL7R24YX9Dgy-fT3x2NFUWoBEILSD1URNHiCuQ-niBXLkdIxGLybRDVjc75sEr3qAeqdfKtAQcSicK",
                                "width": 1080
                            }
                        ],
                        "place_id": "ChIJIXwA1wWDY0AR-9kILuTqmcQ",
                        "plus_code": {
                            "compound_code": "2R47+XR Tirebolu/Giresun, Türkiye",
                            "global_code": "8GHW2R47+XR"
                        },
                        "reference": "ChIJIXwA1wWDY0AR-9kILuTqmcQ",
                        "scope": "GOOGLE",
                        "types": [
                            "restaurant",
                            "food",
                            "point_of_interest",
                            "establishment"
                        ],
                        "vicinity": "Tirebolu"
                    }
                ],
                "status": "OK"
            }
            """;


    @Test
    void find1() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        JsonNode jsonNode = mapper.readTree(JSON);
        System.out.println(mapper.readTree(JSON_0).at("/status").asText().equals("ZERO_RESULTS"));

        ArrayNode t = jsonNode.withArray("/results");
        System.out.println(mapper.readTree(JSON_0).at("/next_page_token").isMissingNode());
        System.out.println(mapper.readTree(JSON).at("/next_page_token").isMissingNode());
        System.out.println(mapper.readTree(JSON).at("/next_page_token2").isMissingNode());

        var d = t.get(0).at("/geometry/location/lat");
        System.out.println(d);

        for (JsonNode node : t) {
            System.out.println(node.toPrettyString().substring(0,11));
            System.err.println(node.at("/geometry/location/lat"));
            System.err.println(node.at("/geometry/location/lat").decimalValue());
            System.err.println(node.at("/geometry/location/lat").doubleValue());
            System.err.println(node.at("/geometry/location/lat").floatValue());
            System.err.println(node.at("/geometry/location/lng"));
            System.err.println(node.at("/geometry/location/lng").decimalValue());

        }
        var aDouble = jsonNode.at("/status").asText();

        System.out.println(aDouble);
    }

}
