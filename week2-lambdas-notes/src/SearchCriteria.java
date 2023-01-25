import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class SearchCriteria {
    private static final int LOW = 16;
    private static final int START = 18;
    private static final int MID = 23;
    private static final int END = 25;
    private static final int RETIRED = 65;

    private final Map<String, Predicate<Person>> searchMap = new HashMap<>();

    private SearchCriteria() {
        initSearchMap();
    }

    public static SearchCriteria getInstance() {
        return new SearchCriteria();
    }

    private void initSearchMap() {
        Predicate<Person> allDrivers = p -> p.getAge() >= LOW;
        Predicate<Person> allDraftees = p -> p.getAge() >= START
                && p.getAge() <= END && p.getGender() == Gender.MALE;
        Predicate<Person> allPilots = p -> p.getAge() >= MID
                && p.getAge() <= RETIRED;

        searchMap.put("allDrivers", allDrivers);
        searchMap.put("allDraftees", allDraftees);
        searchMap.put("allPilots", allPilots);
    }

    public Predicate<Person> getCriteria(String PredicateName) {
        Predicate<Person> target;

        target = searchMap.get(PredicateName);

        if (target == null) {
            System.out.println("Search Criteria not found... ");
            System.exit(1);
        }
        return target;
    }
}