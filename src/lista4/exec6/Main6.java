package lista4.exec6;

public class Main6 {
    public static void main(String[] args){
        Diretorio diretorio = montaEstruturaDiretorios();
        System.out.println(diretorio);
    }

    public static Diretorio montaEstruturaDiretorios(){
        Diretorio diretorioPrincipal = new Diretorio("Diretorio Principal");

        Diretorio filmes = new Diretorio("Filmes");
        Diretorio herois = new Diretorio("Herois");
        Diretorio marvel = new Diretorio("Marvel");
        Diretorio dc = new Diretorio("DC");
        Diretorio jogos = new Diretorio("Jogos");
        Diretorio drama = new Diretorio("Drama");
        Diretorio cr = new Diretorio("Comédia Romantica");
        Diretorio faculdade = new Diretorio("Faculdade");
        Diretorio aces = new Diretorio("ACEs");

        diretorioPrincipal.insere(filmes);
        diretorioPrincipal.insere(faculdade);
        diretorioPrincipal.insere(jogos);

        filmes.insere(cr);
        filmes.insere(drama);
        filmes.insere(herois);

        herois.insere(dc);
        herois.insere(marvel);

        dc.insere(new Arquivo("SuperMan"));
        marvel.insere(new Arquivo("Homem-Aranha"));
        marvel.insere(new Arquivo("Vingadores"));


        drama.insere(new Arquivo("Brilho Eterno de Uma Mente Sem Lembranças "));

        faculdade.insere(new Arquivo("TPD"));
        faculdade.insere(aces);
        faculdade.insere(new Arquivo("AA"));
        faculdade.insere(new Arquivo("EDD2"));
        faculdade.insere(new Arquivo("EDD1"));

        aces.insere(new Arquivo("ACE3"));
        aces.insere(new Arquivo("ACE2"));
        aces.insere(new Arquivo("ACE1"));


        jogos.insere(new Arquivo("World of Warcraft"));
        jogos.insere(new Arquivo("Paciência"));
        jogos.insere(new Arquivo("Campo Minado"));

        return diretorioPrincipal;
    }
}
