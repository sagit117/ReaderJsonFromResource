package ru.axel.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import org.json.*;

public class ReaderJsonConfig {
    private final String fileName;

    public ReaderJsonConfig(String fileNameFromResource) {
        fileName = fileNameFromResource;
    }

    public JSONObject read() throws URISyntaxException, IOException {
        URL url = this.getClass().getClassLoader().getResource(fileName);
        File file;
        if (url != null) {
            file = new File(url.toURI());
        } else {
            throw new IOException("No file exists!");
        }

        StringBuilder stringJson = new StringBuilder((int)file.length());

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String s;
            while((s = bufferedReader.readLine()) != null) {
                stringJson.append(s);
            }

            return new JSONObject(stringJson.toString());
        }
    }
}
