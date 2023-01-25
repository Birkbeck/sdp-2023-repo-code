import java.util.List;

public class Test02Filter {

    public static void main(String[] args) {

        List<Person> pl = Person.createShortList();

        SearchCriteria search = SearchCriteria.getInstance();

        System.out.println("\n=== Style 1 Pilot Phone List ===");

        pl.stream().filter(search.getCriteria("allPilots"))
                .forEach(Person::printNameStyle1);


        System.out.println("\n=== Style 2 Draftee Phone List ===");

        pl.stream().filter(search.getCriteria("allDraftees"))
                .forEach(Person::printNameStyle2);

    }
}