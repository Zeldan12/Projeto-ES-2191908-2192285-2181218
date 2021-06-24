package model;

public class Singleton {
    private static Singleton single_instance = null;

    // variable of type String
    public DadosAplicacao dadosAplicacao;

    // private constructor restricted to this class itself
    private Singleton()
    {
        dadosAplicacao = new DadosAplicacao();
    }

    // static method to create instance of Singleton class
    public static Singleton getInstance()
    {
        if (single_instance == null)
            single_instance = new Singleton();

        return single_instance;
    }
}
