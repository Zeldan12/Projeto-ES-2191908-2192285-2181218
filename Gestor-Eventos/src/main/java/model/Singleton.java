package model;

public class Singleton {
    private static Singleton single_instance = null;

    public DadosAplicacao dadosAplicacao;

    private Singleton()
    {
        dadosAplicacao = new DadosAplicacao();
    }

    public static Singleton getInstance()
    {
        if (single_instance == null)
            single_instance = new Singleton();

        return single_instance;
    }
}
