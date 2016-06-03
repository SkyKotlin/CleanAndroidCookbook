package pro.averin.anton.clean.android.cookbook.data.flickr

import pro.averin.anton.clean.android.cookbook.data.flickr.model.FlickrResponse
import pro.averin.anton.clean.android.cookbook.data.flickr.model.Media
import pro.averin.anton.clean.android.cookbook.data.flickr.model.Method
import pro.averin.anton.clean.android.cookbook.data.flickr.model.Sort
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable


interface FlickrAPIService {

    @GET("?method=${Method.SEARCH}")
    fun searchPhotos(
            @Query("lat") lat: Double,
            @Query("lon") lon: Double,
            @Query("radius") radius: Int,
            @Query("text") tags: String = "landscape",
            @Query("extras") extras: String = "description,date_upload,date_taken,owner_name,geo,tags,media",
            @Query("per_page") perPage: Int = 500,
            @Query("sort") sort: String = Sort.INTREST_DESC,
            @Query("media") contentType: String = Media.PHOTOS,
            @Query("has_geo") hasGeo: Boolean = true,
            @Query("geo_context") geoContext: Int = 2
    ): Observable<FlickrResponse>

}