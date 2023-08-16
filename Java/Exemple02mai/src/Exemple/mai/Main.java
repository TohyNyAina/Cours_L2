package Exemple.mai;

interface Inflammable {
	void enflammer();
}

class Bois implements Inflammable {
	public void enflammer() {
		System.out.println("Je brule et fais des braises");
	}
}

class Dancefloor implements Inflammable {
	public void enflammer() {
		System.out.println("♪ ♫ Youhouhou ♬ ♫ ");
	}
}

public class Main {
	static public void main(String[] args) {
		Inflammable[] tab = { new Bois(), new Dancefloor() };
		for(Inflammable i : tab)
			i.enflammer();
	}
}
