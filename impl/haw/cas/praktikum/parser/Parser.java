package haw.cas.praktikum.parser;

import haw.cas.praktikum.parser.configFile.ConfigFile;
import haw.cas.praktikum.parser.configFile.SimpleConfigFile;
import haw.cas.praktikum.parser.prolog.PrologGenerator;
import haw.cas.praktikum.parser.prolog.PrologParser;
import objects.MObjectRepo;
import objects.Ort;
import objects.Strasse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public final class Parser {
	private Parser() {
	}

	private static HashMap<String, PrologParser> functionMap;
	private static List<PrologGenerator> generatorList;

	static void init() {

		functionMap = new HashMap<>();

		functionMap.put("ort", (param)->{
			assert param.length == 1 : "the Parameter Length for an ort must be 1, but was " + param.length;
			new Ort(param[0]);
		});

		functionMap.put("strasse", (param)->{
			assert param.length == 3 : "the Parameter Length for an strasse must be 3, but was " + param.length;
			Ort start = (Ort) MObjectRepo.getMObject(param[0]);
			Ort end = (Ort) MObjectRepo.getMObject(param[1]);
			int kosten = Integer.parseInt(param[2]);
			start.connect(end, kosten);
		});

		
		// functionMap.put(Funk.class.getName().toLowerCase(), new
		// StrasseParser());
		// functionMap.put(SchwarzesBrett.class.getName().toLowerCase(), new
		// SchwarzesBrettParser());
		// functionMap.put(Tankstelle.class.getName().toLowerCase(), new
		// TankstelleParser());
		// functionMap.put(Umladebucht.class.getName().toLowerCase(), new
		// UmladebuchtParser());
		
		/*generatorList = new ArrayList<>();

		generatorList.add(new AkteurGenerator());
		generatorList.add(new AuftragsGenerator());
		generatorList.add(new GenGenerator());
		generatorList.add(new KonsortiumGenerator());
		generatorList.add(new LKWGenerator());
		generatorList.add(new LocalServiceGenerator());
		generatorList.add(new NetGenerator());*/
	}

	public static void main(String[] args) {
		init();
		long now = System.currentTimeMillis();
		parse("__FILE_NAME_HERE__");
		System.out.println(System.currentTimeMillis() - now);
		
	}

	public static void store(String datei) {
		ConfigFile cf = new SimpleConfigFile(datei);
		for (PrologGenerator pg : generatorList) {
			pg.generate(cf, MObjectRepo.getStream());
		}
		;
		cf.store();

	}

	public static void parse(String datei) {
		try (Stream<String> stream = Files.lines(Paths.get(datei))) {
			stream.forEach(Parser::parseLine);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static void parseLine(String line) {

		// Validit�t der Line Pr�fen
		if (line.isEmpty()) {
			// System.out.println("leer");
			return;
		}
		if (line.charAt(0) == '%') {
			// System.out.println("kommentarzeile");
			return;
		}
		int open = line.indexOf('(');
		String fnc = line.substring(0, open);
		String paramsS = line.substring(open + 1, line.length() - 2);
		String[] params = paramsS.split(",");
		functionMap.get(fnc).create(params);
	}

}
