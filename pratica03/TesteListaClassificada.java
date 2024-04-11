public class TesteListaClassificada {
  public static void main(String[] args) {
    
    ListaClassificada<Integer> listaDeInteiros = new ListaClassificada<Integer>();
    ListaClassificada<String> listaDeStrings = new ListaClassificada<String>();
    ListaClassificada<Float> listaDeFloats = new ListaClassificada<Float>();
    ListaClassificada<Double> listaDeDoubles = new ListaClassificada<Double>();
    ListaClassificada<Boolean> listaDeBooleans = new ListaClassificada<Boolean>();

    try {

      listaDeInteiros.inserir(10);
      listaDeInteiros.inserir(6);
      listaDeInteiros.inserir(1);
      listaDeInteiros.inserir(11);

      listaDeInteiros.imprimir();

      listaDeStrings.inserir("marcus");
      listaDeStrings.inserir("joao");
      listaDeStrings.inserir("Ana Luisa");
      listaDeStrings.inserir("Maria");
      listaDeStrings.inserir("Zeca");
      listaDeStrings.inserir("Ana");

      listaDeStrings.imprimir();

      listaDeFloats.inserir(10.1111f);
      listaDeFloats.inserir(10.11131f);
      listaDeFloats.inserir(1.54321f);
      listaDeFloats.inserir(1.0003f);
      listaDeFloats.inserir(1.554321f);
      listaDeFloats.inserir(1.0002f);

      listaDeFloats.imprimir();

      listaDeDoubles.inserir(10.1);
      listaDeDoubles.inserir(10.12);
      listaDeDoubles.inserir(1.5);
      listaDeDoubles.inserir(1.0);
      listaDeDoubles.inserir(1.55);
      listaDeDoubles.inserir(1.6);

      listaDeDoubles.imprimir();

      listaDeBooleans.inserir(true);
      listaDeBooleans.inserir(false);

    } catch (TipoDeObjetoNPermitidoException e) {
      e.printStackTrace();
    }

  }
}
