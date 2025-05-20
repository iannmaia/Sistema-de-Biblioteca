public class Livro {
    public String titulo;
    public String autor;
    public int anoPublicacao;
    public int codigoLivro;
    public boolean emprestado;
    public String nomeLeitor;

    public Livro(String titulo, String autor, int anoPublicacao, int codigoLivro) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.codigoLivro = codigoLivro;
        this.emprestado = false;
    }

    public String toString() {
        String status = emprestado ? "Emprestado para " + nomeLeitor : "Disponível";
        return "Código: " + codigoLivro + "\nTítulo: " + titulo + "\nAutor: " + autor + "\nAno: " + anoPublicacao + "\nStatus: " + status;
    }
}

