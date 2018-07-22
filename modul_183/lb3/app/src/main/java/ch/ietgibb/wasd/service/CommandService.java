package ch.ietgibb.wasd.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@Service
public class CommandService {
    public String runCommand(String sysout) {
        final StringBuilder resultBuilder = new StringBuilder();

        try {
            final Process process = Runtime.getRuntime().exec("ifconfig -" + sysout);
            process.waitFor();

            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream(), StandardCharsets.UTF_8))) {
                String next;
                while ((next = reader.readLine()) != null) {
                    resultBuilder.append(next);
                }
            } catch (IOException e) {
                throw new IllegalArgumentException(e);
            }
        } catch (IOException | InterruptedException e) {
            if (e instanceof InterruptedException) {
                Thread.currentThread().interrupt();
            }

            throw new IllegalArgumentException(e);
        }

        return resultBuilder.toString();
    }

    public boolean isValidOption(String option){
        switch (option){
            case "a":
            case "l":
            case "v":
                return true;
            default:
                return false;
        }
    }

}
