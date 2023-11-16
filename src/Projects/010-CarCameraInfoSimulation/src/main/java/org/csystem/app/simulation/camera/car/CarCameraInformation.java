package org.csystem.app.simulation.camera.car;

import org.csystem.app.simulation.camera.car.model.ModelInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class CarCameraInformation {
    private final HashMap<String, List<ModelInfo>> m_models = new HashMap<>();
    private final Path m_path;

    private static ModelInfo createModelInfo(String [] modelInfo)
    {
        return new ModelInfo(modelInfo[0], modelInfo[1], Double.parseDouble(modelInfo[2]), Double.parseDouble(modelInfo[3]));
    }

    private void loadMap(BufferedReader br) throws IOException
    {
        String line;

        while ((line = br.readLine()) != null) {
            var modelInfo = line.split(",");

            if (modelInfo.length != 4)
                throw new IOException("Invalid file format");

            List<ModelInfo> list;

            if (!m_models.containsKey(modelInfo[0])) {
                list = new ArrayList<>();
                m_models.put(modelInfo[0], list);
            }
            else
                list = m_models.get(modelInfo[0]);

            list.add(createModelInfo(modelInfo));
        }
    }

    public CarCameraInformation(String pathStr)
    {
        this(Path.of(pathStr));
    }

    public CarCameraInformation(Path path)
    {
        m_path = path;
    }

    public long getLength()
    {
        return m_path.toFile().length();
    }

    public CarCameraInformation load() throws IOException
    {
        try (var br = Files.newBufferedReader(m_path, StandardCharsets.UTF_8)) {
            br.readLine();
            loadMap(br);
        }

        return this;
    }

    public Optional<List<ModelInfo>> search(String model)
    {
        return m_models.containsKey(model) ? Optional.of(m_models.get(model)) : Optional.empty();
    }

    public void forEach(Consumer<? super String> keyConsumer, Consumer<? super ModelInfo> valueConsumer)
    {
        m_models.keySet().forEach(k -> {keyConsumer.accept(k);m_models.get(k).forEach(valueConsumer);});
    }

    public Optional<List<ModelInfo>> searchFromFile(String model) throws IOException
    {
        try (var br = Files.newBufferedReader(m_path, StandardCharsets.UTF_8)) {
            br.readLine();
            String line;
            List<ModelInfo> models = new ArrayList<>();

            while ((line = br.readLine()) != null) {
                var modelInfo = line.split(",");

                if (modelInfo.length != 4)
                    throw new IOException("Invalid file format");


                if (modelInfo[0].equals(model))
                    models.add(createModelInfo(modelInfo));
            }

            return models.isEmpty() ? Optional.empty() : Optional.of(models);
        }
    }

    public void forEachFromFile(Consumer<? super ModelInfo> consumer) throws IOException
    {
        try (var br = Files.newBufferedReader(m_path, StandardCharsets.UTF_8)) {
            br.readLine();
            String line;
            List<ModelInfo> models = new ArrayList<>();

            while ((line = br.readLine()) != null) {
                var modelInfo = line.split(",");

                if (modelInfo.length != 4)
                    throw new IOException("Invalid file format");

                consumer.accept(createModelInfo(modelInfo));
            }
        }
    }
}
