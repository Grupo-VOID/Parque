package modelo.ObjetosNulos;

import modelo.Usuario;

public class UsuarioNulo extends Usuario {

	public static Usuario constructor() {
		return new UsuarioNulo();
	}

	public UsuarioNulo() {
		super(0, "", "", "", 0.0, 0.0, false);
	}

	public boolean isNull() {
		return true;
	}

}
