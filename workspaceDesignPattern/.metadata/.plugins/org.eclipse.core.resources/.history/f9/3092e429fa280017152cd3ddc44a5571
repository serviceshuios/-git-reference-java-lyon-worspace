
public class CommandeCredit extends Commande
{
  public CommandeCredit(double montant)
  {
    super(montant);
  }

  public void paye()
  {
    System.out.println(
      "Le paiement de la commande au crédit de : " +
      montant + " est effectué.");
  }

  public boolean valide()
  {
    return (montant >= 1000.0) && (montant <= 5000.0);
  }
}
