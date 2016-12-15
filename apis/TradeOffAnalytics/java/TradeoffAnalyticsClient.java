import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.TradeoffAnalytics;
import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model.Problem;
import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model.Dilemma;
import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model.Option;

import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model.column.Column;
import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model.column.Column.Goal;
import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model.column.NumericColumn;
import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model.column.CategoricalColumn;
import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model.column.DateColumn;

import java.util.*;

public class TradeoffAnalyticsClient {

  public static void main(String[] args) {

    TradeoffAnalytics service = new TradeoffAnalytics();
    service.setUsernameAndPassword("cc35d4e3-a15b-4052-958d-fe0e4f40f9ca", "xX62zUw36Gd4");

    // categories
    String price = "price";
    String weight = "weight";
    String brand = "brand";
    String rDate = "rDate";

    // preferences
    String apple = "Apple";
    String htc = "HTC";
    String samsung = "Samsung";
    String sony = "Sony";

    List<String> categories = new ArrayList<String>();
    categories.add(apple);
    categories.add(htc);
    categories.add(samsung);
    categories.add(sony);

    List<String> preferences = new ArrayList<String>();
    preferences.add(samsung);
    preferences.add(apple);
    preferences.add(htc);

    Problem problem = new Problem("phones");

    // Define the objectives.
    List<Column> columns = new ArrayList<Column>();
    problem.setColumns(columns);

    NumericColumn priceColumn = new NumericColumn();
    priceColumn.setKey(price);
    priceColumn.setGoal(Goal.MIN);
    priceColumn.setObjective(true);
    priceColumn.range(0, 400);
    priceColumn.setFullName("Price");
    priceColumn.setFormat("number:2");
    columns.add(priceColumn);

    NumericColumn weightColumn = new NumericColumn();
    weightColumn.setKey(weight);
    weightColumn.setGoal(Goal.MIN);
    weightColumn.setObjective(true);
    weightColumn.setFullName("Weight");
    weightColumn.setFormat("number:0");
    columns.add(weightColumn);

    CategoricalColumn brandColumn = new CategoricalColumn();
    brandColumn.setKey(brand);
    brandColumn.setGoal(Goal.MIN);
    brandColumn.setObjective(true);
    brandColumn.setRange(categories);
    brandColumn.setPreference(preferences);
    brandColumn.setFullName("Brand");
    columns.add(brandColumn);

    DateColumn rDateColumn = new DateColumn();
    rDateColumn.setKey(rDate);
    rDateColumn.setGoal(Goal.MIN);
    rDateColumn.setObjective(true);
    rDateColumn.setFullName("Release Date");
    rDateColumn.setFormat("date: 'MMM dd, yyyy'");
    columns.add(rDateColumn);

    // Define the options.
    List<Option> options = new ArrayList<Option>();
    problem.setOptions(options);

    HashMap<String, Object> galaxyS4Specs = new HashMap<String, Object>();
    galaxyS4Specs.put(price, 249);
    galaxyS4Specs.put(weight, 130);
    galaxyS4Specs.put(brand, samsung);
    galaxyS4Specs.put(rDate, "2013-04-29T00:00:00Z");
    options.add(new Option("1", "Galaxy S4").values(galaxyS4Specs));

    HashMap<String, Object> iphone5Specs = new HashMap<String, Object>();
    iphone5Specs.put(price, 349);
    iphone5Specs.put(weight, 112);
    iphone5Specs.put(brand, apple);
    iphone5Specs.put(rDate, "2012-09-21T00:00:00Z");
    options.add(new Option("2", "iPhone 5").values(iphone5Specs));

    HashMap<String, Object> oneSpecs = new HashMap<String, Object>();
    oneSpecs.put(price, 299);
    oneSpecs.put(weight, 112);
    oneSpecs.put(brand, htc);
    oneSpecs.put(rDate, "2013-03-01T00:00:00Z");
    options.add(new Option("3", "One").values(oneSpecs));

    HashMap<String, Object> galaxyS5Specs = new HashMap<String, Object>();
    galaxyS5Specs.put(price, 349);
    galaxyS5Specs.put(weight, 135);
    galaxyS5Specs.put(brand, samsung);
    galaxyS5Specs.put(rDate, "2014-04-29T00:00:00Z");
    options.add(new Option("4", "Galaxy S5").values(galaxyS5Specs));

    HashMap<String, Object> iphone6Specs = new HashMap<String, Object>();
    iphone6Specs.put(price, 399);
    iphone6Specs.put(weight, 118);
    iphone6Specs.put(brand, apple);
    iphone6Specs.put(rDate, "2013-09-21T00:00:00Z");
    options.add(new Option("5", "iPhone 6").values(iphone6Specs));

    HashMap<String, Object> iphone7Specs = new HashMap<String, Object>();
    iphone7Specs.put(price, 499);
    iphone7Specs.put(weight, 118);
    iphone7Specs.put(brand, apple);
    iphone7Specs.put(rDate, "2014-09-21T00:00:00Z");
    options.add(new Option("6", "iPhone 7").values(iphone7Specs));

    HashMap<String, Object> xperiaSpecs = new HashMap<String, Object>();
    xperiaSpecs.put(price, 199);
    xperiaSpecs.put(weight, 120);
    xperiaSpecs.put(brand, sony);
    xperiaSpecs.put(rDate, "2014-08-21T00:00:00Z");
    options.add(new Option("7", "Xperia").values(xperiaSpecs));

    // Call the service and get the problem resolution
    Dilemma dilemma = service.dilemmas(problem, false).execute();
    System.out.println(dilemma);
  }

}
