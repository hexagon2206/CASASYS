package haw.cas.praktikum.parser.configFile;

public interface ConfigFile {
	void addToSection(int section,String textToAdd);
	void store();
}
