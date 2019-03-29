package org.jbradfield.gilionaire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    public TestController() {
    }

    @GetMapping(value = "/csv", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<?> readCSV() throws Exception {
        String link = "https://raw.githubusercontent.com/viion/ffxiv-datamining/master/csv/Item.csv";
        URL url = new URL(link);
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        Map<String, List<String>> headers = http.getHeaderFields();

        // handle possible redirect
        // what does get(null) do here?
        // (this seems like a dumb way to check status codes in general but w/e)
        for (String header : headers.get(null)) {
            if (header.contains("302") || header.contains("301")) {
                link = headers.get("Location").get(0);
                url = new URL(link);
                http = (HttpURLConnection) url.openConnection();
                headers = http.getHeaderFields();
            }
        }

        InputStream stream = http.getInputStream();
        String response = getStringFromStream(stream);
        return ResponseEntity.ok(response);
    }

    private static String getStringFromStream(InputStream stream) throws IOException {
        if (stream != null) {
            Writer writer = new StringWriter();
            char[] buffer = new char[2048];
            try (stream) {
                Reader reader = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8));
                int counter;
                while ((counter = reader.read(buffer)) != -1) {
                    writer.write(buffer, 0, counter);
                }
            }
            return writer.toString();
        }
        else {
            return "No contents";
        }
    }
}
