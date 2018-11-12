package metier;

public class Caramel extends DecorateurIngredient{

	public Caramel(Boisson boisson) {
		super(boisson);
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return boisson.getDescription()+", Caramel";
	}

	@Override
	public double cout() {
		// TODO Auto-generated method stub
		return 0.22+boisson.cout();
	}

}
