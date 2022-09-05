# ReaderJsonFromResource - чтение json файлов из ресурсов

```java
public static void main(String[] args) {
    try {
        JSONObject jsonObject = ReaderJsonFromResource.read("./test.json");

        System.out.println(jsonObject.getString("test"));
        System.out.println(jsonObject.getInt("id"));
    } catch (URISyntaxException | IOException | JSONException error) {
        error.printStackTrace();
    }
}
```
