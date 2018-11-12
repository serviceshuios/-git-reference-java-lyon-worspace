package metier;

public abstract class Vehicule {
	protected String modele;
	protected String couleur;
	protected int puissance;
	public Vehicule(String modele, String couleur, int puissance) {
		super();
		this.modele = modele;
		this.couleur = couleur;
		this.puissance = puissance;
	}
	
	
}
