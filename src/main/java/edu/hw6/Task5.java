package edu.hw6;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static java.net.http.HttpClient.newHttpClient;

public class Task5 {
    static class HackerNews {
        private final static Pattern PATTERN = Pattern.compile("\"title\":\".+?\"");
        private final static int NINTH_SYMBOL = 9;
        private final static String URI_HACKER_NEWS = "https://hacker-news.firebaseio.com/v0";
        private long[] hackerNewsTopStoriesId;

        public long[] hackerNewsTopStories() throws URISyntaxException, IOException, InterruptedException {
            HttpRequest getIdsRequest = HttpRequest.newBuilder()
                .uri(new URI(URI_HACKER_NEWS + "/topstories.json"))
                .GET()
                .build();

            HttpResponse<String> idsResponse = newHttpClient()
                .send(getIdsRequest, HttpResponse.BodyHandlers.ofString());

            hackerNewsTopStoriesId = Arrays.stream(idsResponse.body().substring(1, idsResponse.body().length() - 1)
                    .split(","))
                .mapToLong(Long::parseLong)
                .toArray();

            return hackerNewsTopStoriesId;
        }

        public String news(long id) throws IOException, InterruptedException, URISyntaxException {
            HttpRequest getIdsRequest = HttpRequest.newBuilder()
                .uri(new URI(URI_HACKER_NEWS + "/item/" + id + ".json"))
                .GET()
                .build();

            HttpResponse<String> idsResponse = newHttpClient()
                .send(getIdsRequest, HttpResponse.BodyHandlers.ofString());

            String json = idsResponse.body();

            Matcher matcher = PATTERN.matcher(json);

            if (matcher.find()) {
                String titlePartOfJson = json.substring(matcher.start(), matcher.end());

                return titlePartOfJson.substring(NINTH_SYMBOL, titlePartOfJson.length() - 1);
            }

            return null;
        }
    }
}
