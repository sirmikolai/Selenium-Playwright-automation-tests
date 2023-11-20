package utils;

import com.google.common.collect.ImmutableMap;
import core.PomParams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

public class AllureEnvironmentWriter implements PomParams {

    private AllureEnvironmentWriter() {

    }

    public static void writeAllureEnvironmentProperties() {
        ImmutableMap<String, String> allureProperties = ImmutableMap.<String, String> builder()
                .put("Environment URL:", System.getProperty("baseUrl"))
                .put("Branch:", getCurrentGitBranch())
                .put("Browser:", System.getProperty("browser"))
                .put("Headless:", System.getProperty("headless"))
                .put("Java version:", System.getProperty("java.version"))
                .build();
        allureEnvironmentWriter(allureProperties, System.getProperty("user.dir") + "/allure-results/");
    }

    private static String getCurrentGitBranch() {
        try {
            Process process = Runtime.getRuntime().exec("git name-rev --name-only HEAD");
            process.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String branch = reader.readLine();
            return branch.substring(branch.lastIndexOf("/") + 1);
        } catch (IOException | InterruptedException e) {
            Thread.currentThread().interrupt();
            return "";
        }
    }
}
