import com.github.jknack.handlebars.Handlebars;
import models.*;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import java.util.*;
import static spark.Spark.*;

public class App {
    public static void main(String[] args){
        staticFileLocation("/public");

        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get(".hero/createHero", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "hero-form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/hero",(req, res) ->{
           Map<String, Object> model = new HashMap<>();
           ArrayList<Hero> hero = Hero.getAllHeroes();
           model.put("hero",hero);
           return new ModelAndView(model, "hero.hbs");
        }, new HandlebarsTemplateEngine());


        get("/squad/createSquad",(req, res) ->{
          Map<String, Object> model = new HashMap<>();
          return new ModelAndView(model, "squad-form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squad",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            ArrayList<Squad> squads = Squad.getInstances();
            model.put("squads",squads);
            ArrayList<Hero> members = Hero.getAllHeroes();
            model.put("heroes",members);
            Squad newSquad = Squad.findBySquadId(1);
            model.put("allSquadMembers", newSquad.getSquadMembers());
            return new ModelAndView(model, "squad.hbs");
        }, new HandlebarsTemplateEngine());

        post("/squad/createSquad/new",(req,res)-> {
            Map<String, Object> model = new HashMap<>();
            String squadName = req.queryParams("squadName");
            Integer size = Integer.parseInt(req.queryParams("maxSize"));
            String cause = req.queryParams("cause");
            Squad newSquad = new Squad(size, squadName,cause);
            req.session().attribute("item",squadName);
            model.put("item",req.session().attribute("item"));
            return new ModelAndView(model,"success.hbs");
        }, new HandlebarsTemplateEngine());

        post("/hero/createHero/new",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            String name = req.queryParams("name");
            Integer age = Integer.parseInt(req.queryParams("age"));
            String power = req.queryParams("power");
            String weakness = req.queryParams("weakness");
            String heroSquad = req.queryParams("heroSquad");
            Hero newHero = new Hero(name,age,power,weakness,heroSquad);
            Squad newSquad = Squad.findBySquadId(1);
            newSquad.addSquadMembers(newHero);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("hero/createHero/new/member/:squadId",(req,res)->{
            Map<String, Object> model = new HashMap<>();
            req.session().attribute("selectedSquad",req.params("squadId"));
            model.put("selectedSquad", req.session().attribute("selectedSquad"));
            model.put("item",1);
            return new ModelAndView(model, "squadAssigned.hbs");
        },new HandlebarsTemplateEngine());

    }
}













