package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import utils.Constants;
import utils.RickAndMortyPaths;

import java.util.HashMap;
import java.util.Map;

public class GoOverNavigationPages implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {

        Map<String,Object> info = actor.recall(Constants.PAGINATION_INFO);

        int pages = Integer.parseInt(info.get("pages").toString().replace(".0",""));


        boolean endValidation=false;

        int nextPage;
        Map<String,Object> queryParams =new HashMap<>();

        nextPage=pages-1;
        queryParams.put("page",nextPage);
        actor.attemptsTo(GetCharacterData.getCharacterData(Constants.BASE_URL, RickAndMortyPaths.CHARACTERS.getValue()).setQueryParams(queryParams));
        Map<String,Object> navigationData = actor.recall(Constants.PAGINATION_INFO);

        if(pages==1){

            boolean nextNavigationCheck= info.get("prev") ==null;
            boolean prevNavigationCheck= info.get("prev") ==null;

            endValidation=nextNavigationCheck&&prevNavigationCheck;

        }else if(pages ==2){
            String nextNavigation=navigationData.get("next").toString();

            boolean nextNavigationCheck= nextNavigation.contains("page="+pages);
            boolean prevNavigationCheck= navigationData.get("prev") ==null;

            endValidation=nextNavigationCheck&&prevNavigationCheck;

        }else{
            String nextNavigation=navigationData.get("next").toString();
            String prevNavigation=navigationData.get("prev").toString();

            boolean nextNavigationCheck= nextNavigation.contains("page="+pages);
            boolean prevNavigationCheck= prevNavigation.contains("page="+(pages-2));

            endValidation=nextNavigationCheck&&prevNavigationCheck;
        }


        actor.remember(Constants.NAVIGATION_VALIDATION,endValidation);

    }

    public static GoOverNavigationPages goOverNavigationPages(){
        return  Tasks.instrumented(GoOverNavigationPages.class);
    }
}
