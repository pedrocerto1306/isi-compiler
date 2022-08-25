package br.com.comp2022.isilang.ast;

public class ComandoEscrita extends AbstractCommand {
	private String id;
	private String texto;

	public ComandoEscrita(String id) {
		this.id = id;
		this.texto = null;
	}

	public ComandoEscrita(String texto, boolean isText) {
		if (isText) {
			this.texto = texto;
			this.id = null;
		} else {
			this.id = texto;
			this.texto = null;
		}
	}

	@Override
	public String generateJavaCode() {
		if (id == null) {
			return "System.out.println(" + texto + ");\n";
		} else {
			return "System.out.println(" + id + ");\n";
		}

	}

	@Override
	public String generateClangCode() {
		if (id == null) {
			return "printf(" + texto + ");\n";
		} else {
			return "printf(\"%lf\"," + id + ");\n";
		}
	}

	@Override
	public String toString() {
		return "CommandEscrita"
				+ "[id="
				+ id
				+ "]"
				+ "[texto="
				+ texto
				+ "]";
	}
}