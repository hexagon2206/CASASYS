package haw.cas.praktikum.parser.configFile;

import java.util.ArrayList;

public class SimpleConfigFile implements ConfigFile {

	ArrayList<String> list;
	
	public SimpleConfigFile(String datei) {
		list = new ArrayList<>();
		for(int i = 0;i<10;i++)list.add("");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addToSection(int section, String textToAdd) {
		if(section>=10) return;
		String l = list.get(section);
		list.set(section,l+textToAdd+"\n");
	}

	@Override
	public void store() {
		for(int i = 0;i< 10 ;i++){
			System.out.println("%section : "+i);
			System.out.print(list.get(i));
		}
	}

}
