package config.environment;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public enum Environment {
    URL("https://flukeout.github.io/");

    @Getter
    @NonNull
    String url;

    @Getter
    private static Environment currentEnvironment = resolveEnvironment();


    private static Environment resolveEnvironment() {
        String env = (String) System.getProperties().get("environment");
        return env == null ? URL : Environment.valueOf(env.toUpperCase());
    }
}