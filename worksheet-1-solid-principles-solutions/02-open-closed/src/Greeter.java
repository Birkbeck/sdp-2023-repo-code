public class Greeter {
    private Personality personality;

    public Greeter() {
        this(() -> "Hello.");
    }

    public Greeter(Personality personality) {
        this.personality = personality;
    }

    /**
     * to be eliminated when the client code is refactored
     * @param formality level of formality
     */
    @Deprecated
    public void setFormality(String formality) {
        personality = switch (formality) {
            case "formal" ->  new FormalPersonality();
            case "casual" -> new CasualPersonality();
            case "intimate" -> new IntimatePersonality();
            default -> () -> "Hello.";
        };
    }

    public String greet() {
        return this.personality.greet();
    }
}
