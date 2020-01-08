import com.github.jknack.handlebars.Handlebars;
import models.*;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import java.util.*;
import static spark.Spark.*;

public class App {
    public static void main(String[] args){
        staticFileLocation("/public");

        Hero.setUpNewHero();
        Hero.setUpNewHero1();
        Squad.setUpNewSquad();
        Squad.setUpNewSquad1();
    }
}
