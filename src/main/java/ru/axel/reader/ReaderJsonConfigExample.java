package ru.axel.reader;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URISyntaxException;

/** Пример чтения json файла из ресурсов */
public class ReaderJsonConfigExample {
    /** Пустой конструктор */
    public ReaderJsonConfigExample() { }

    /**
     * Точка входа
     * @param args аргументы вызова
     */
    public static void main(String[] args) {
        try {
            JSONObject jsonObject = ReaderJsonFromResource.read("./test.json");

            System.out.println(jsonObject.getString("test"));
            System.out.println(jsonObject.getInt("id"));
        } catch (URISyntaxException | IOException | JSONException error) {
            error.printStackTrace();
        }
    }
}