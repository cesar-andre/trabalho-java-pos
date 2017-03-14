package br.com.eleicoes.seeder;

public class Seeder {
	
	private static void seed() {
		PermissoesSeeder.seed();
	}

	public static void main(String[] args) {
		seed();
	}
	
}
