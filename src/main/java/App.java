import com.github.jknack.handlebars.Handlebars;
import models.*;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import java.util.*;
import static spark.Spark.*;


public class App {

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567;
    }

    public static void main(String[] args){
        port(getHerokuAssignedPort());
        staticFileLocation("/public");

        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Squad> allSquads = Squad.getInstances();
            ArrayList<Hero> allHeroes = Hero.getAllHeroes();
            model.put("squads", allSquads);
            model.put("heroes", allHeroes);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/hero", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Squad> allSquads = Squad.getInstances();
            ArrayList<Hero> allHeroes = Hero.getAllHeroes();
            model.put("squads", allSquads);
            model.put("heroes", allHeroes);
            return new ModelAndView(model, "hero.hbs");
        }, new HandlebarsTemplateEngine());

//        get("/hero",(req, res) ->{
//           Map<String, Object> model = new HashMap<>();
//           ArrayList<Hero> hero = Hero.getAllHeroes();
//           model.put("hero",hero);
//           return new ModelAndView(model, "hero.hbs");
//        }, new HandlebarsTemplateEngine());
//

        get("/squad",(req, res) ->{
          Map<String, Object> model = new HashMap<>();
          return new ModelAndView(model, "squad.hbs");
        }, new HandlebarsTemplateEngine());

//        get("/squad",(req, res) ->{
//            Map<String, Object> model = new HashMap<>();
//            ArrayList<Squad> squads = Squad.getInstances();
//            model.put("squads",squads);
//            ArrayList<Hero> members = Hero.getAllHeroes();
//            model.put("heroes",members);
//            Squad newSquad = Squad.getBySquadId(1);
//            model.put("allSquadMembers", newSquad.getSquadMembers());
//            return new ModelAndView(model, "viewSquad.hbs");
//        }, new HandlebarsTemplateEngine());

        post("/squad/new",(req,res)-> {
            Map<String, Object> model = new HashMap<>();
            String squadName = req.queryParams("squadName");
            Integer maxSize = Integer.parseInt(req.queryParams("maxSize"));
            String cause = req.queryParams("cause");
            Squad newSquad = new Squad(maxSize, squadName,cause);
            model.put("squadName", squadName);
            model.put("maxSize", maxSize);
            model.put("cause", cause);
            return new ModelAndView(model,"squadSuccess.hbs");
        }, new HandlebarsTemplateEngine());

        post("/hero/new",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            String name = req.queryParams("name");
            Integer age = Integer.parseInt(req.queryParams("age"));
            String power = req.queryParams("power");
            String weakness = req.queryParams("weakness");
            String heroSquad = req.queryParams("heroSquad");
            Hero newHero = new Hero(name,age,power,weakness,heroSquad);
            Squad newSquad = Squad.getBySquadId(Integer.parseInt(heroSquad));
            newSquad.addSquadMembers(newHero);
            model.put("newSquad", newSquad);
            return new ModelAndView(model, "heroSuccess.hbs");
        }, new HandlebarsTemplateEngine());


//        get("hero/createHero/new/member/:squadId",(req,res)->{
//            Map<String, Object> model = new HashMap<>();
//            req.session().attribute("selectedSquad",req.params("squadId"));
//            model.put("selectedSquad", req.session().attribute("selectedSquad"));
//            model.put("item",1);
//            return new ModelAndView(model, "squadAssigned.hbs");
//        },new HandlebarsTemplateEngine());

    }
}













