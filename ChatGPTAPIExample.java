import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
//All of the imports
public class ChatGPTAPIExample {
    public static void listTokens() {
        try {
//This API will fetch the models available.
            URL url = new URL("https://api.openai.com/v1/models");
            // this is creating a new url for chatGPT's API
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            // opening URL for ChatGPT
            //con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");
            // setting up the request.json for later
            con.setRequestProperty("Accept", "application/json");
//Make sure you put the right Organization key saved earlier.
            con.setRequestProperty("OpenAI-Organization", "org-yL5hsWZggAucJu1adRAY2YHS");
            // getting my organization key
            con.setDoOutput(true);
//Make sure you put the right API Key saved earlier.
            con.setRequestProperty("Authorization", "Bearer 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");
            // getting API key
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            // Initializing a bufferedReader in order to read the input stream
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            // appending the input line
            // appending is to add something to a string
            in.close();
            System.out.println(response);
            //printing the response
        } catch (Exception e) {
        }
    }
    public static void prompts() {
        try {
            URL url = new URL("https://api.openai.com/v1/completions");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");
//Make sure you put the right Organization key saved earlier.
            con.setRequestProperty("OpenAI-Organization", "org-yL5hsWZggAucJu1adRAY2YHS");
            con.setDoOutput(true);
//Make sure you put the right API Key saved earlier.
            con.setRequestProperty("Authorization", "Bearer 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");
//Make sure to relace the path of the json file created earlier.
            String jsonInputString = FileHelper.readLinesAsString(new File("C:\\Users\\HHSRobot7\\Downloads\\ChatGPTAdventure\\ChatGPTAdventure\\src\\Request.json"));
            // the pathway for where the request.json is
            try (OutputStream os = con.getOutputStream()) {
                byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }
            int responseCode = con.getResponseCode();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println(response);
        } catch (Exception e) {
        }
    }
    public static void main(String[] args) {
        //listTokens();
        prompts();
    }
}