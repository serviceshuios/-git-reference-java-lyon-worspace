import java.util.*;
public class LiasseClient extends Liasse
{
  public LiasseClient(String informations)
  {
    documents = new ArrayList<Document>();
    LiasseVierge laLiasseVierge = LiasseVierge.Instance();
    List<Document> documentsVierges =
      laLiasseVierge.getDocuments();
    for (Document document: documentsVierges)
    {
      Document copieDocument = document.duplique();
      copieDocument.remplit(informations);
      documents.add(copieDocument);
    }
  }

  public void affiche()
  {
    for (Document document: documents)
      document.affiche();
  }

  public void imprime()
  {
    for (Document document: documents)
      document.imprime();
  }
}
