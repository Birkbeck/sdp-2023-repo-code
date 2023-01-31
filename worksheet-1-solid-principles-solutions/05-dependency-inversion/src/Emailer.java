import java.util.Optional;

public class Emailer implements Notifier {
    public String generateWeatherAlert(String weatherConditions) {
        if ("sunny".equals(weatherConditions))
            return "It is sunny";
        return null;
    }

    @Override
    public void notify(String weatherConditions) {
        Optional<String> alert = Optional.ofNullable(generateWeatherAlert(weatherConditions));
        alert.ifPresent(s -> System.out.print(s));
    }
}
