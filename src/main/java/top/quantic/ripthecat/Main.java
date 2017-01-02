package top.quantic.ripthecat;

import joptsimple.OptionParser;
import joptsimple.OptionSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static java.util.Arrays.asList;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        OptionParser parser = new OptionParser();
        parser.nonOptions("Files to scan for releases");
        parser.acceptsAll(asList("o", "output"), "Output file").withRequiredArg().defaultsTo("downloads.csv");
        parser.acceptsAll(asList("f", "format"), "Audio format").withRequiredArg().defaultsTo("mp3_320");
        parser.acceptsAll(asList("c", "catalog"), "Only include releases with this catalog_id").withRequiredArg().defaultsTo("");
        parser.acceptsAll(asList("h", "?", "help"), "Display this help").forHelp();
        OptionSet optionSet = parser.parse(args);
        if (optionSet.has("h")) {
            try {
                parser.printHelpOn(System.out);
            } catch (IOException e) {
                log.warn("Could not print help", e);
            }
        } else {
            new Converter(optionSet).convert();
        }
    }
}
