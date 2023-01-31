import java.util.Optional;

public class Phone implements Notifier {
    public String generateWeatherAlert(String weatherConditions) {
        if ("rainy".equals(weatherConditions))
            return "It is rainy";
        return null;
    }

    @Override
    public void notify(String weatherConditions) {
        Optional<String> alert = Optional.ofNullable(generateWeatherAlert(weatherConditions));
        alert.ifPresent(s -> System.out.print(s));
    }
}
