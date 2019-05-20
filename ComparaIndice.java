//Código escrito em conjunto por Leonardo Izaú (@Vladek96) e Mariana Fortes (@MarianaFortes)

import java.util.Comparator;

public class ComparaIndice implements Comparator<ElementoIndice>
{
    public int compare(ElementoIndice e1, ElementoIndice e2)
    {
        return (e1.getNis()).compareTo(e2.getNis());
    }
}
