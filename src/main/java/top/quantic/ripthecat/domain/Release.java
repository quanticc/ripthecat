package top.quantic.ripthecat.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Release {

    @JsonProperty("_id")
    private String id;
    private String title;
    private String label;
    private String type;
    private String renderedArtists;
    private Instant releaseDate;
    private String coverArt;
    private String catalogId;
    private String playlistId;
    private String upc;
    private String imageHashSum;
    private Map<String, String> thumbHashes = new LinkedHashMap<>();
    private Instant preReleaseDate;
    private List<String> tags = new ArrayList<>();
    private boolean freeDownloadForUsers;
    private boolean showToAdminsOnly;
    private boolean showOnWebsite;
    private boolean showAsFree;
    private List<String> urls = new ArrayList<>();
    private boolean downloadable;
    private boolean streamable;
    private boolean inEarlyAccess;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRenderedArtists() {
        return renderedArtists;
    }

    public void setRenderedArtists(String renderedArtists) {
        this.renderedArtists = renderedArtists;
    }

    public Instant getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Instant releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(String catalogId) {
        this.catalogId = catalogId;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getImageHashSum() {
        return imageHashSum;
    }

    public void setImageHashSum(String imageHashSum) {
        this.imageHashSum = imageHashSum;
    }

    public Map<String, String> getThumbHashes() {
        return thumbHashes;
    }

    public void setThumbHashes(Map<String, String> thumbHashes) {
        this.thumbHashes = thumbHashes;
    }

    public Instant getPreReleaseDate() {
        return preReleaseDate;
    }

    public void setPreReleaseDate(Instant preReleaseDate) {
        this.preReleaseDate = preReleaseDate;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public boolean isFreeDownloadForUsers() {
        return freeDownloadForUsers;
    }

    public void setFreeDownloadForUsers(boolean freeDownloadForUsers) {
        this.freeDownloadForUsers = freeDownloadForUsers;
    }

    public boolean isShowToAdminsOnly() {
        return showToAdminsOnly;
    }

    public void setShowToAdminsOnly(boolean showToAdminsOnly) {
        this.showToAdminsOnly = showToAdminsOnly;
    }

    public boolean isShowOnWebsite() {
        return showOnWebsite;
    }

    public void setShowOnWebsite(boolean showOnWebsite) {
        this.showOnWebsite = showOnWebsite;
    }

    public boolean isShowAsFree() {
        return showAsFree;
    }

    public void setShowAsFree(boolean showAsFree) {
        this.showAsFree = showAsFree;
    }

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

    public boolean isDownloadable() {
        return downloadable;
    }

    public void setDownloadable(boolean downloadable) {
        this.downloadable = downloadable;
    }

    public boolean isStreamable() {
        return streamable;
    }

    public void setStreamable(boolean streamable) {
        this.streamable = streamable;
    }

    public boolean isInEarlyAccess() {
        return inEarlyAccess;
    }

    public void setInEarlyAccess(boolean inEarlyAccess) {
        this.inEarlyAccess = inEarlyAccess;
    }

    public String getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(String playlistId) {
        this.playlistId = playlistId;
    }

    public String getCoverArt() {
        return coverArt;
    }

    public void setCoverArt(String coverArt) {
        this.coverArt = coverArt;
    }
}
