
package org.gabriel.moviebudget.model.tmdb;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "adult",
    "backdrop_path",
    "belongs_to_collection",
    "budget",
    "genres",
    "homepage",
    "id",
    "imdb_id",
    "original_language",
    "original_title",
    "overview",
    "popularity",
    "poster_path",
    "production_companies",
    "production_countries",
    "release_date",
    "revenue",
    "runtime",
    "spoken_languages",
    "status",
    "tagline",
    "title",
    "video",
    "vote_average",
    "vote_count"
})
public class Movie {

    @JsonProperty("adult")
    private boolean adult;
    @JsonProperty("backdrop_path")
    private String backdropPath;
    @JsonProperty("belongs_to_collection")
    private Object belongsToCollection;
    @JsonProperty("budget")
    private Integer budget;
    @JsonProperty("genres")
    private List<Genre> genres = null;
    @JsonProperty("homepage")
    private String homepage;
    @JsonProperty("id")
    private int id;
    @JsonProperty("imdb_id")
    private String imdbId;
    @JsonProperty("original_language")
    private String originalLanguage;
    @JsonProperty("original_title")
    private String originalTitle;
    @JsonProperty("overview")
    private String overview;
    @JsonProperty("popularity")
    private float popularity;
    @JsonProperty("poster_path")
    private Object posterPath;
    @JsonProperty("production_companies")
    private List<ProductionCompany> productionCompanies = null;
    @JsonProperty("production_countries")
    private List<ProductionCountry> productionCountries = null;
    @JsonProperty("release_date")
    private String releaseDate;
    @JsonProperty("revenue")
    private int revenue;
    @JsonProperty("runtime")
    private int runtime;
    @JsonProperty("spoken_languages")
    private List<SpokenLanguage> spokenLanguages = null;
    @JsonProperty("status")
    private String status;
    @JsonProperty("tagline")
    private String tagline;
    @JsonProperty("title")
    private String title;
    @JsonProperty("video")
    private boolean video;
    @JsonProperty("vote_average")
    private float voteAverage;
    @JsonProperty("vote_count")
    private int voteCount;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("adult")
    public boolean isAdult() {
        return adult;
    }

    @JsonProperty("adult")
    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    @JsonProperty("backdrop_path")
    public String getBackdropPath() {
        return backdropPath;
    }

    @JsonProperty("backdrop_path")
    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    @JsonProperty("belongs_to_collection")
    public Object getBelongsToCollection() {
        return belongsToCollection;
    }

    @JsonProperty("belongs_to_collection")
    public void setBelongsToCollection(Object belongsToCollection) {
        this.belongsToCollection = belongsToCollection;
    }

    @JsonProperty("budget")
    public Integer getBudget() {
        return budget;
    }

    @JsonProperty("budget")
    public void setBudget(int budget) {
        this.budget = budget;
    }

    @JsonProperty("genres")
    public List<Genre> getGenres() {
        return genres;
    }

    @JsonProperty("genres")
    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    @JsonProperty("homepage")
    public String getHomepage() {
        return homepage;
    }

    @JsonProperty("homepage")
    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    @JsonProperty("id")
    public int getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty("imdb_id")
    public String getImdbId() {
        return imdbId;
    }

    @JsonProperty("imdb_id")
    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    @JsonProperty("original_language")
    public String getOriginalLanguage() {
        return originalLanguage;
    }

    @JsonProperty("original_language")
    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    @JsonProperty("original_title")
    public String getOriginalTitle() {
        return originalTitle;
    }

    @JsonProperty("original_title")
    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    @JsonProperty("overview")
    public String getOverview() {
        return overview;
    }

    @JsonProperty("overview")
    public void setOverview(String overview) {
        this.overview = overview;
    }

    @JsonProperty("popularity")
    public float getPopularity() {
        return popularity;
    }

    @JsonProperty("popularity")
    public void setPopularity(float popularity) {
        this.popularity = popularity;
    }

    @JsonProperty("poster_path")
    public Object getPosterPath() {
        return posterPath;
    }

    @JsonProperty("poster_path")
    public void setPosterPath(Object posterPath) {
        this.posterPath = posterPath;
    }

    @JsonProperty("production_companies")
    public List<ProductionCompany> getProductionCompanies() {
        return productionCompanies;
    }

    @JsonProperty("production_companies")
    public void setProductionCompanies(List<ProductionCompany> productionCompanies) {
        this.productionCompanies = productionCompanies;
    }

    @JsonProperty("production_countries")
    public List<ProductionCountry> getProductionCountries() {
        return productionCountries;
    }

    @JsonProperty("production_countries")
    public void setProductionCountries(List<ProductionCountry> productionCountries) {
        this.productionCountries = productionCountries;
    }

    @JsonProperty("release_date")
    public String getReleaseDate() {
        return releaseDate;
    }

    @JsonProperty("release_date")
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @JsonProperty("revenue")
    public int getRevenue() {
        return revenue;
    }

    @JsonProperty("revenue")
    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    @JsonProperty("runtime")
    public int getRuntime() {
        return runtime;
    }

    @JsonProperty("runtime")
    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    @JsonProperty("spoken_languages")
    public List<SpokenLanguage> getSpokenLanguages() {
        return spokenLanguages;
    }

    @JsonProperty("spoken_languages")
    public void setSpokenLanguages(List<SpokenLanguage> spokenLanguages) {
        this.spokenLanguages = spokenLanguages;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("tagline")
    public String getTagline() {
        return tagline;
    }

    @JsonProperty("tagline")
    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("video")
    public boolean isVideo() {
        return video;
    }

    @JsonProperty("video")
    public void setVideo(boolean video) {
        this.video = video;
    }

    @JsonProperty("vote_average")
    public float getVoteAverage() {
        return voteAverage;
    }

    @JsonProperty("vote_average")
    public void setVoteAverage(float voteAverage) {
        this.voteAverage = voteAverage;
    }

    @JsonProperty("vote_count")
    public int getVoteCount() {
        return voteCount;
    }

    @JsonProperty("vote_count")
    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
