package TD_Lambda_Stream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class Main {
    public static void main(String[] args) {
        Bar b1 = new Bar("La cascade", "Lille");
        Bar b2 = new Bar("Le flambeur", "Lille");
        Bar b3 = new Bar("Le mirage", "Lille");
        Bar b4 = new Bar("Le cocktail", "Valenciennes");
        List<ChiffreAffaire> l = new ArrayList<>();
        l.add(new ChiffreAffaire(b1, 2020, 30000));
        l.add(new ChiffreAffaire(b1, 2019, 50000));
        l.add(new ChiffreAffaire(b2, 2020, 5000));
        l.add(new ChiffreAffaire(b2, 2019, 33000));
        l.add(new ChiffreAffaire(b3, 2020, 6000));
        l.add(new ChiffreAffaire(b3, 2020, 9000));
        l.add(new ChiffreAffaire(b4, 2020, 29000));
    }
}
