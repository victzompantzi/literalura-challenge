package com.alura.literalura.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataBooks(

        @JsonAlias("title") String title,

        @JsonAlias("authors") List<Author> authors,

        @JsonAlias("languages") List<String> languages,

        @JsonAlias("download_count") Integer numDownloads) {

    @Override
    public String toString() {
        return "DataBooks [title=" + title + ", authors=" + authors + ", languages=" + languages
                + ", numDownloads=" + numDownloads + "]";
    }
}
