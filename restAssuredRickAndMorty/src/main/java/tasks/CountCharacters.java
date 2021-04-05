package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import utils.Constants;
import utils.RickAndMortyPaths;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CountCharacters implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {

        Map<String,Object> info = actor.recall(Constants.PAGINATION_INFO);

        int pages = Integer.parseInt(info.get("pages").toString().replace(".0",""));
        int counter = pages;
        ArrayList<Map<String,Object>> result;

        Map<String,Object> queryParams =new HashMap<>();

        int amount = 0;

        while (counter >= 1){
            queryParams.put("page",counter);
            actor.attemptsTo(GetCharacterData.getCharacterData(Constants.BASE_URL, RickAndMortyPaths.CHARACTERS.getValue()).setQueryParams(queryParams));

             result= actor.recall(Constants.RESULT_INFO);
             amount+= result.size();

            counter--;
        }


        actor.remember(Constants.COUNT_CHARACTERS_VALIDATION,String.valueOf(amount).equals(info.get("count").toString().replace(".0","")));

    }

    public static CountCharacters countCharacters(){
        return  Tasks.instrumented(CountCharacters.class);
    }
}
