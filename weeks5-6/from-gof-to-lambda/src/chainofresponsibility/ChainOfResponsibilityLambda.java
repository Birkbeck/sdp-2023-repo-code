package chainofresponsibility;

import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

public class ChainOfResponsibilityLambda {

    public static Optional<String> parseText(File file) {
        return Optional.ofNullable(file)
            .filter(f -> f.getType() == File.Type.TEXT)
            .map(f -> "Text file: " + f.getContent());
    }

    public static Optional<String> parsePresentation(File file) {
        return Optional.ofNullable(file)
            .filter(f -> f.getType() == File.Type.PRESENTATION)
            .map(f -> "Presentation file: " + f.getContent());
    }

    public static Optional<String> parseAudio(File file) {
        return Optional.ofNullable(file)
            .filter(f -> f.getType() == File.Type.AUDIO)
            .map(f -> "Audio file: " + f.getContent());
    }

    public static Optional<String> parseVideo(File file) {
        return Optional.ofNullable(file)
            .filter(f -> f.getType() == File.Type.VIDEO)
            .map(f -> "Video file: " + f.getContent());
    }

    public static void main(String... args) {
        File file = new File(File.Type.AUDIO, "Dream Theater  - The Astonishing");

        System.out.println(
            Stream.<Function<File, Optional<String>>>of(
                    ChainOfResponsibilityLambda::parseText,
                    ChainOfResponsibilityLambda::parsePresentation,
                    ChainOfResponsibilityLambda::parseAudio,
                    ChainOfResponsibilityLambda::parseVideo)
                .map(f -> f.apply(file))
                .flatMap(Optional::stream)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Unknown file: " + file))
        );
    }
}
