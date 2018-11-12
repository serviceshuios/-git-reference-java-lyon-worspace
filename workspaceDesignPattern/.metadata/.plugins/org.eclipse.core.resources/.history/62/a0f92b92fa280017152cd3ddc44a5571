public abstract class Document implements Cloneable
{
  protected String contenu = new String();

  public Document duplique()
  {
    Document resultat;
    try
    {
      resultat = (Document)this.clone();
    }
    catch (CloneNotSupportedException exception)
    {
      return null;
    }
    return resultat;
  }

  public void remplit(String informations)
  {
    contenu = informations;
  }

  public abstract void imprime();
  public abstract void affiche();
}
