public class Livro{
    private String nome;
    private String editora;

    public Livro(String nome, String editora){
        this.nome = nome;
        this.editora = editora;
    }

    public String getNome(){
        return this.nome;
    }

    public String getEditora(){
        return this.editora;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setEditora(String editora){
        this.editora = editora;
    }

}

