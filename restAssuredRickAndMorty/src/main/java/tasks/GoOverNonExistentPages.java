package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import utils.Constants;
import utils.RickAndMortyPaths;

import java.util.HashMap;
import java.util.Map;

public class GoOverNonExistentPages implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {

        Map<String,Object> info = actor.recall(Constants.PAGINATION_INFO);

        int pages = Integer.parseInt(info.get("pages").toString().replace(".0",""));


        int nextPage;
        Map<String,Object> queryParams =new HashMap<>();
        nextPage=pages + 1;
        queryParams.put("page",nextPage);
        actor.attemptsTo(GetCharacterData
                .getCharacterData(Constants.BASE_URL, RickAndMortyPaths.CHARACTERS.getValue())
                .setQueryParams(queryParams)
                .rememberErrorResponse(true));

        String statusCode = actor.recall(Constants.CODE_STATUS).toString();
        String errorResponse = actor.recall(Constants.RESULT_INFO);

        actor.remember(Constants.NON_EXISTENT_PAGE_CODE_STATUS,statusCode);
        actor.remember(Constants.ERROR_RESPONSE,errorResponse);

    }

    public static GoOverNonExistentPages goOverNavigationPages(){
        return  Tasks.instrumented(GoOverNonExistentPages.class);
    }
}
