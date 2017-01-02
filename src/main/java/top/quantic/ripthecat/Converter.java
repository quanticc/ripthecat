package top.quantic.ripthecat;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.univocity.parsers.csv.CsvFormat;
import com.univocity.parsers.csv.CsvWriter;
import com.univocity.parsers.csv.CsvWriterSettings;
import joptsimple.OptionSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.quantic.ripthecat.domain.Releases;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

class Converter {

    private static final Logger log = LoggerFactory.getLogger(Converter.class);

    private final ObjectMapper mapper;
    private final OptionSet optionSet;

    Converter(OptionSet optionSet) {
        this.mapper = new ObjectMapper()
            .enable(SerializationFeature.INDENT_OUTPUT)
            .setSerializationInclusion(JsonInclude.Include.NON_NULL)
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
            .registerModule(new JavaTimeModule());
        this.optionSet = optionSet;
    }

    void convert() {
        List<?> inputFiles = optionSet.nonOptionArguments();
        if (inputFiles.isEmpty()) {
            convertOne(new File("releases.json"));
        } else {
            for (Object inputFile : inputFiles) {
                convertOne(new File((String) inputFile));
            }
        }
    }

    private void convertOne(File file) {
        try {
            Releases releases = mapper.readValue(file, Releases.class);
            CsvFormat csvFormat = new CsvFormat();
            csvFormat.setDelimiter(';');
            CsvWriterSettings csvWriterSettings = new CsvWriterSettings();
            csvWriterSettings.setFormat(csvFormat);
            Path outputPath = Paths.get((String) optionSet.valueOf("o"));
            CsvWriter writer = new CsvWriter(Files.newBufferedWriter(outputPath), csvWriterSettings);
            writer.writeHeaders("catalogId", "artist", "title", "url");
            boolean filterByCatalog = optionSet.has("c") && !"".equals(((String) optionSet.valueOf("c")).trim());
            releases.getResults().stream()
                .filter(r -> !filterByCatalog || (r.getCatalogId() != null && r.getCatalogId().startsWith((String) optionSet.valueOf("c"))))
                .forEach(r -> {
                    String url = "https://connect.monstercat.com/api/release/" + r.getId() + "/download?method=download&type="
                        + optionSet.valueOf("f");
                    writer.writeRow(r.getCatalogId(), r.getRenderedArtists(), r.getTitle(), url);
                });
            writer.close();
        } catch (IOException e) {
            log.warn("Could not load releases", e);
        }
    }
}
