package cps3230;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

import java.util.List;

public class RestHandling {

    public void AddAlert(JSONObject json) throws UnirestException {
        Unirest.setHttpClient(org.apache.http.impl.client.HttpClients.custom()
                .disableRedirectHandling()
                .build());
        HttpResponse<String> response = Unirest.post("https://api.marketalertum.com/Alert")
                .header("Content-Type", "application/json")
                .body(json)
                .asString();

        System.out.println(response.getBody());
    }

    public void DeleteAlerts() throws UnirestException {
        HttpResponse<String> response = Unirest.delete("https://api.marketalertum.com/Alert?userId=abd230b1-3908-46a5-9ca7-36f4464198b7")
                .asString();
        System.out.println(response.getBody());
    }

    public JSONObject CreateJsonObject(String title, String desc, String image, String url, int price) throws UnirestException {
        JSONObject json = new JSONObject();
        json.put("alertType", 6);
        json.put("heading", title);
        json.put("description", desc);
        json.put("url", url);
        json.put("imageURL", image);
        json.put("postedBy", "abd230b1-3908-46a5-9ca7-36f4464198b7");
        json.put("priceInCents", price);

        return json;
    }

}
