package UrlConn;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
public class BasicUrlConnection {


    public static final String GET_URL = "https://jsonplaceholder.typicode.com/posts";
    public static final String POST_URL = "https://jsonplaceholder.typicode.com/posts";

    public static void main(String[] args) {
//       getGames();
        postItem();
    }

    private static dibble me

    private static void getGames() {
        try{

            URL url = new URL(GET_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            int responseCode = connection.getResponseCode();
            System.out.println("RESPONSE CODE:  " +  responseCode);
            if(responseCode == HttpURLConnection.HTTP_OK){
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                JSONParser jsonParser = new JSONParser();
                JSONArray array = (JSONArray) jsonParser.parse(response.toString());

                if(array.size())

                for (int i=0; i < array.size(); i++){
                    JSONObject object = (JSONObject) jsonParser.parse(array.get(i).toString());
                    System.out.println(object);
                }

//                JSONObject object = (JSONObject) jsonParser.parse(response.toString());
//                String title = (String)object.get("title");
                FileWriter writer = new FileWriter("data.json");
                writer.write(response.toString());
                writer.flush();
                writer.close();
//                System.out.println("Get request response is: "+ response );
            }else{
                System.out.println("Get response did not work");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static void postItem(){

        try{
            URL url = new URL(POST_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);
            OutputStream outputStream = conn.getOutputStream();
            JSONObject cred = new JSONObject();
            cred.put("title", "MeanMAchine");
            cred.put("body","Archiving");
            cred.put("userId",456);
            outputStream.write(cred.toString().getBytes());
            outputStream.flush();
            outputStream.close();

            int responseCode = conn.getResponseCode();
            System.out.println("RESPONSE CODE ::: " + responseCode);
            if(responseCode == conn.HTTP_CREATED){
                //Grab the mesage from server
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line;
                StringBuffer buffer = new StringBuffer();
                while ((line = bufferedReader.readLine()) != null){
                    buffer.append(line);
                }
                bufferedReader.close();
                JSONParser jsonParser = new JSONParser();
                JSONObject obj = (JSONObject) jsonParser.parse(buffer.toString());
                System.out.println(obj);
                String title = (String) obj.get("title");
                 int id = Integer.valueOf(obj.get("id").toString());


                System.out.println("Sent to server succesfully " + buffer + " title is " + title);
            }else{
                System.out.println("Something spoooky happened");
            }
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }

    }
}
