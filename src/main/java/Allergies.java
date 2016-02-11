import java.util.HashMap;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

import java.util.ArrayList;

public class Allergies {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap model = new HashMap();
      model.put("template", "templates/allergyInput.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/result", (request, response) -> {
      HashMap model = new HashMap();
      model.put("template", "templates/allergyResult.vtl");

      String userAllergyString = request.queryParams("userInput");
      Integer userAllergyInteger = Integer.parseInt(userAllergyString);

      ArrayList<String> result = checkAllergy(userAllergyInteger);

      model.put("result", result);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }

  public static ArrayList<String> checkAllergy(int allergyNumber) {

    ArrayList<String> allergyList = new ArrayList<String>();

    while (allergyNumber > 0) {
      if (allergyNumber >=128) {
        allergyNumber -= 128;
        allergyList.add("cats");
      } else if (allergyNumber >= 64) {
        allergyNumber -= 64;
        allergyList.add("pollen");
      } else if (allergyNumber >= 32) {
        allergyNumber -= 32;
        allergyList.add("chocolate");
      } else if (allergyNumber >= 16) {
        allergyNumber -= 16;
        allergyList.add("tomatoes");
      } else if (allergyNumber >= 8) {
        allergyNumber -= 8;
        allergyList.add("strawberries");
      } else if (allergyNumber >= 4) {
        allergyNumber -= 4;
        allergyList.add("shellfish");
      } else if (allergyNumber >= 2) {
        allergyNumber -= 2;
        allergyList.add("peanuts");
      } else if (allergyNumber >= 1) {
        allergyNumber -= 1;
        allergyList.add("eggs");
      }
    }
    return allergyList;
  }
}
