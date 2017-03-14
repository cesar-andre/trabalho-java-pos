package br.com.eleicoes.migration;

public class Migration {
	
	private static void commit() {
		PermissaoMigration.up();
		EleicaoMigration.up();
		UsuarioMigration.up();
		VotoMigration.up();
	}
	
	private static void rollback() {
		VotoMigration.down();
		UsuarioMigration.down();
		EleicaoMigration.down();
		PermissaoMigration.down();
	}
	
	
	public static void main(String[] args) {
		commit();
	}
}
