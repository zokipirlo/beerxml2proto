package beer.hapibrew.beerxml2proto.parser;

import com.squareup.wire.Wire;

import java.util.ArrayList;
import java.util.List;

import beer.hapibrew.beerxml2proto.proto.Fermentation;

public class FermentationParser extends BaseParser {

    public int fermentationStages = 0;
    Fermentation.Builder primary = new Fermentation.Builder().step(1);
    Fermentation.Builder secondary = new Fermentation.Builder().step(2);
    Fermentation.Builder tertiary = new Fermentation.Builder().step(3);
    Fermentation.Builder aging = new Fermentation.Builder().step(99).is_aging(true);

    List<Fermentation> buildFermentation() {
        ArrayList<Fermentation> fermentations = new ArrayList<>();
        if (fermentationStages > 0) {
            if (Wire.get(primary.days, 0).floatValue() > 0)
                fermentations.add(primary.build());
            if (Wire.get(secondary.days, 0).floatValue() > 0)
                fermentations.add(secondary.build());
            if (Wire.get(tertiary.days, 0).floatValue() > 0)
                fermentations.add(tertiary.build());
            if (Wire.get(aging.days, 0).floatValue() > 0)
                fermentations.add(aging.build());
        }

        return fermentations;
    }
}
