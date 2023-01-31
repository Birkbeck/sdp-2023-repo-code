import java.util.List;

public class WeatherTracker {
    String currentConditions;
    List<Notifier> notifierList;

    WeatherTracker(List<Notifier> notifierList) {
        this.notifierList = notifierList;
    }

    public void setCurrentConditions(String weatherDescription) {
        currentConditions = weatherDescription;
        notifierList.forEach(n -> n.notify(weatherDescription));
    }
}
