package ru.axel.reader;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;

import org.jetbrains.annotations.NotNull;
import org.json.*;

/**
 * Класс для чтения json файлов из ресурсов
 */
public final class ReaderJsonFromResource {
    /** Пустой конструктор */
//    public ReaderJsonFromResource() { }
    /**
     * Метод читает json файл из ресурсов и трансформирует его в JSONObject
     * @param fileNameFromResource имя файла из ресурсов
     * @return JSONObject
     * @throws URISyntaxException если путь до файла задан неверно
     * @throws IOException если произошла ошибка чтения файла
     */
    @NotNull
    public static JSONObject read(String fileNameFromResource) throws URISyntaxException, IOException {
        final File file = getFileFromResource(fileNameFromResource);
        final StringBuilder stringJson = new StringBuilder((int)file.length());

        return new JSONObject(writeFileToStringBuilder(file, stringJson).toString());
    }

    /**
     * Получаем файл из ресурсов
     * @param fileName имя файла в ресурсах
     * @return File
     * @throws IOException если произошла ошибка чтения файла
     * @throws URISyntaxException если путь до файла задан неверно
     */
    @NotNull
    private static File getFileFromResource(String fileName) throws IOException, URISyntaxException {
        final URL url = ReaderJsonFromResource.class.getClassLoader().getResource(fileName);

        if (url != null) {
            return new File(url.toURI());
        } else {
            throw new IOException("No file exists!");
        }
    }

    /**
     * Записываем содержимое файла в StringBuilder
     * @param file файл
     * @param stringBuilder StringBuilder
     * @return StringBuilder
     * @throws IOException если произошла ошибка чтения файла
     */
    private static StringBuilder writeFileToStringBuilder(
        File file,
        StringBuilder stringBuilder
    ) throws IOException {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String s;
            while((s = bufferedReader.readLine()) != null) {
                stringBuilder.append(s);
            }

            return stringBuilder;
        }
    }
}
