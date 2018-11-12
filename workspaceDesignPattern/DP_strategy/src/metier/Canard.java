package metier;

public abstract class Canard {
	protected ComportementVol comportementVol;
	protected ComportementCancan comportementCancan;
	
	public void effectuerCancan()
	{
		comportementCancan.cancaner();
	}
	public void effectuerVol()
	{
		comportementVol.voler();
	}
	public ComportementVol getComportementVol() {
		return comportementVol;
	}
	public void setComportementVol(ComportementVol comportementVol) {
		this.comportementVol = comportementVol;
	}
	public ComportementCancan getComportementCancan() {
		return comportementCancan;
	}
	public void setComportementCancan(ComportementCancan comportementCancan) {
		this.comportementCancan = comportementCancan;
	}
	
	public void nager()
	{
		System.out.println("JE NAGE");
	}
	public abstract void afficher();
}
