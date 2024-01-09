package org.csystem.app.generator.text.configuration.io.file;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

@Configuration
public class BufferedWriterConfig {
    @Bean
    @Lazy
    public BufferedWriter createBufferedWriter(@Value("${generator.path:default_texts.txt}") String pathStr) throws IOException
    {
        return Files.newBufferedWriter(Path.of(pathStr), StandardCharsets.UTF_8, StandardOpenOption.APPEND, StandardOpenOption.CREATE);
    }
}
