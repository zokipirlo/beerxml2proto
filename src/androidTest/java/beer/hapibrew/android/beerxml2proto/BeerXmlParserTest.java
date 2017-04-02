package beer.hapibrew.android.beerxml2proto;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import beer.hapibrew.beerxml2proto.BeerXmlParser;
import beer.hapibrew.beerxml2proto.proto.Recipe;

import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class BeerXmlParserTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        List<Recipe> recipeList1 = new BeerXmlParser().parse(getClass().getClassLoader().getResourceAsStream("recipes.xml"));
        assertTrue(recipeList1.size() > 0);
        List<Recipe> recipeList2 = new BeerXmlParser().parse(getClass().getClassLoader().getResourceAsStream("zoka-pale-ale.xml"));
        assertTrue(recipeList2.size() > 0);
        List<Recipe> recipeList3 = new BeerXmlParser().parse(getClass().getClassLoader().getResourceAsStream("oatmeal-stout-large.xml"));
        assertTrue(recipeList3.size() > 0);
    }
}