interface Notifier {
    String generateWeatherAlert(String weatherConditions);

    void notify(String weatherConditions);
}
