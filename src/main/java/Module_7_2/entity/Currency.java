package Module_7_2.entity;

public class Currency {
    private final String name;
    private final String abbreviation;

    public Currency(String name, String abbreviation) {
        this.name = name;
        this.abbreviation = abbreviation;
    }

    public String getName() {
        return name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }
}
