package extractors;

import java.io.File;
import java.util.Map;
import java.util.Set;

import javatools.administrative.Announce;
import javatools.datatypes.FinalSet;
import basics.FactSource;
import basics.FactWriter;
import basics.Theme;

/**
 * PatternHardExtractor - YAGO2s
 * 
 * Produces the hard-coded facts that are YAGO-internal.
 * 
 * @author Fabian
 * 
 */
public class PatternHardExtractor extends HardExtractor {

	/** Patterns of infoboxes */
	public static final Theme INFOBOXPATTERNS = new Theme("_infoboxPatterns",
			"These are the Wikipedia infobox patterns used in YAGO");
	/** Patterns of titles */
	public static final Theme TITLEPATTERNS = new Theme("_titlePatterns",
			"These are the replacement patterns for Wikipedia titles used in YAGO");
	/** Patterns of categories */
	public static final Theme CATEGORYPATTERNS = new Theme("_categoryPatterns",
			"These are the Wikipedia category patterns used in YAGO");
	/** Patterns of disambiguation pages */
	public static final Theme DISAMBIGUATIONTEMPLATES = new Theme("_disambiguationPatterns",
			"Patterns for the disambiguation pages of Wikipedia");
	 /** Patterns of entity keyphrases */
  public static final Theme CONTEXTPATTERNS = new Theme("_extendedContextWikiPatterns",
      "Patterns for extracting Keyphrases");
  /** Patterns of entity keyphrases */
 public static final Theme STRUCTUREPATTERNS = new Theme("_extendedStructureWikiPatterns",
     "Patterns for extracting regular structure from Wikipedia (e.g. links)");
	/** Patterns of categories */
	public static final Theme RULES = new Theme("_rules", "These are the implication rules of YAGO");

	public Set<Theme> output() {
		return (new FinalSet<Theme>(
		    INFOBOXPATTERNS, TITLEPATTERNS, CATEGORYPATTERNS, RULES, DISAMBIGUATIONTEMPLATES, 
		    CONTEXTPATTERNS, STRUCTUREPATTERNS));
	}

	@Override
	public void extract(Map<Theme, FactWriter> writers, Map<Theme, FactSource> factCollections) throws Exception {
		Announce.doing("Copying patterns");
		Announce.message("Input folder is", inputFolder);
		for (Theme t : output()) {
			extract(t.file(inputFolder), writers.get(t));
		}
		Announce.done();
	}

	public PatternHardExtractor(File inputFolder) {
		super(inputFolder);
	}
}
