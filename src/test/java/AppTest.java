import org.junit.*;
import static org.junit.Assert.*;

import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void checkAllergyCounter_1_Eggs() {
    Allergies testApp = new Allergies();
    ArrayList<String> arrayTest = new ArrayList<String>();
    arrayTest.add("eggs");
    assertEquals(arrayTest, testApp.checkAllergy(1));
  }

  @Test
  public void checkAllergyCounter_2_Peanuts() {
    Allergies testApp = new Allergies();
    ArrayList<String> arrayTest = new ArrayList<String>();
    arrayTest.add("peanuts");
    assertEquals(arrayTest, testApp.checkAllergy(2));
  }
}
