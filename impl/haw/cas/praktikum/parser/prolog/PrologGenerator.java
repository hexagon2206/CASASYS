package haw.cas.praktikum.parser.prolog;

import java.util.stream.Stream;

import haw.cas.praktikum.parser.configFile.ConfigFile;
import objects.MObject;

public interface PrologGenerator {
	void generate(ConfigFile cf,Stream<MObject> objectStream);
}
