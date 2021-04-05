package tasks;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import utils.Constants;

import java.util.Map;

public class GetCharacterData implements Task {


    Response response;
    Gson gson = new Gson();

    String baseUrl;
    String path;
    Map<String,Object> queryParams;
    boolean rememberErrorResponse=false;

    public GetCharacterData setQueryParams(Map<String,Object> queryParams){
        this.queryParams=queryParams;
        return this;
    }

    public GetCharacterData(String baseUrl, String path) {
        this.baseUrl = baseUrl;
        this.path = path;
    }

    public GetCharacterData rememberErrorResponse(boolean rememberErrorResponse) {
        this.rememberErrorResponse = rememberErrorResponse;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        loadCharacters();

        Map<String,Object> body = gson.fromJson(response.getBody().asString(),Map.class);

        if(rememberErrorResponse) {
            actor.remember(Constants.CODE_STATUS,response.getStatusCode());
            actor.remember(Constants.RESULT_INFO,body.get("error"));
        }else {
            actor.remember(Constants.CODE_STATUS,response.getStatusCode());
            actor.remember(Constants.PAGINATION_INFO,body.get("info"));
            actor.remember(Constants.RESULT_INFO,body.get("results"));
        }

    }


    public static GetCharacterData getCharacterData(String baseUrl, String path){
        return  Tasks.instrumented(GetCharacterData.class,baseUrl,path);
    }

    private void loadCharacters(){

        RestAssured.baseURI= baseUrl;
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("Accept", "*/*");
        request= setQueryParams(request);
        response= request.get(path);
    }


    private RequestSpecification setQueryParams(RequestSpecification request ){

        if(queryParams!=null){
            request.queryParams(queryParams);
        }
        return request;
    }
}
