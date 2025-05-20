import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Livro> livros = new ArrayList<Livro>();
        int codigoAtual = 1;
        String opcao = "";

        while (!opcao.equals("9")) {
            opcao = JOptionPane.showInputDialog(
                    "1 - Cadastrar livro\n" +
                            "2 - Listar todos os livros\n" +
                            "3 - Buscar por título\n" +
                            "4 - Realizar empréstimo\n" +
                            "5 - Registrar devolução\n" +
                            "6 - Excluir livro\n" +
                            "7 - Listar apenas livros emprestados\n" +
                            "8 - Contar livros disponíveis e emprestados\n" +
                            "9 - Sair\n\nEscolha uma opção:"
            );

            if (opcao == null) break;

            if (opcao.equals("1")) {
                String titulo = JOptionPane.showInputDialog("Digite o título do livro:");
                String autor = JOptionPane.showInputDialog("Digite o título do autor:");
                int anoPublicacao = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano de publicação:"));

                Livro novoLivro = new Livro(titulo, autor, anoPublicacao, codigoAtual);
                codigoAtual++;
                livros.add(novoLivro);
                JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso!");


            } else if (opcao.equals("2")) {

                if (livros.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Nenhum livro encontrado!");
                } else {
                    String lista = "";
                    for (Livro livro : livros) {
                        lista += livro.toString() + "\n\n";
                    }
                    JOptionPane.showMessageDialog(null, lista);
                }

            } else if (opcao.equals("3")) {
                String busca = JOptionPane.showInputDialog("Digite o nome do livro que você deseja:");
                String resultados = "";
                for (Livro livro : livros) {
                    if (livro.titulo.toLowerCase().contains(busca.toLowerCase())) {
                        resultados += livro.toString() + "\n\n";
                    }
                }
                if (resultados.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Nenhum livro encontrado!");
                } else {
                    JOptionPane.showMessageDialog(null, resultados);
                }

            } else if (opcao.equals("4")) {
                int codigoBusca = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do livro para empréstimo:"));
                Livro livroEncontrado = null;
                for (Livro livro : livros) {
                    if (livro.codigoLivro == codigoBusca) {
                        livroEncontrado = livro;
                        break;
                    }
                }
                if (livroEncontrado == null) {
                    JOptionPane.showMessageDialog(null, "Livro não encontrado.");
                } else if (livroEncontrado.emprestado) {
                    JOptionPane.showMessageDialog(null, "Livro já está emprestado.");
                } else {
                    String leitor = JOptionPane.showInputDialog("Digite o nome do leitor");
                    livroEncontrado.emprestado = true;
                    livroEncontrado.nomeLeitor = leitor;
                    JOptionPane.showMessageDialog(null, "Livro emprestado com sucesso!");
                }

            } else if (opcao.equals("5")) {
                int codigoBusca = Integer.parseInt(JOptionPane.showInputDialog("Digite o códigho do livro para devolucão:"));
                Livro livroEncontrado = null;
                for (Livro livro : livros) {
                    if (livro.codigoLivro == codigoBusca) {
                        livroEncontrado = livro;
                        break;
                    }
                }
                if (livroEncontrado == null) {
                    JOptionPane.showMessageDialog(null, "Livro não encontrado.");
                } else if (!livroEncontrado.emprestado) {
                    JOptionPane.showMessageDialog(null, "Livro não está emprestado.");
                } else {
                    livroEncontrado.emprestado = false;
                    livroEncontrado.nomeLeitor = "";
                    JOptionPane.showMessageDialog(null, "Devolução realizada com sucesso!");
                }

            } else if (opcao.equals("6")) {
                int codigoBusca = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do livro que deseja excluir:"));
                Livro livroEncontrado = null;
                for (Livro livro : livros) {
                    if (livro.codigoLivro == codigoBusca) {
                        livroEncontrado = livro;
                        break;
                    }
                }
                if (livroEncontrado == null) {
                    JOptionPane.showMessageDialog(null, "Livro não encontrado.");
                } else if (livroEncontrado.emprestado) {
                    JOptionPane.showMessageDialog(null, "Não é possível excluir livro emprestado.");
                } else {
                    int confirmar = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir o livro: " + livroEncontrado.titulo + "?", "Confirmação", JOptionPane.YES_NO_OPTION);
                    if (confirmar == JOptionPane.YES_OPTION) {
                        livros.remove(livroEncontrado);
                        JOptionPane.showMessageDialog(null, "Livro removido com sucesso!");
                    }
                }

            } else if (opcao.equals("7")) {
                String listaEmprestados = "";
                for (Livro livro : livros) {
                    if (livro.emprestado) {
                        listaEmprestados += livro.titulo + "\n\n";
                    }
                }
                if (listaEmprestados.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Nenhum livro está emprestado.");
                } else {
                    JOptionPane.showMessageDialog(null, listaEmprestados);
                }

            } else if (opcao.equals("8")) {
                int disponiveis = 0;
                int emprestados = 0;
                for (Livro livro : livros) {
                    if (livro.emprestado) {
                        emprestados++;
                    } else {
                        disponiveis++;
                    }
                }
                JOptionPane.showMessageDialog(null, "Livros disponíveis: " + disponiveis + "\nLivros emprestados: " + emprestados + "\nTotal de livros: " + livros.size());

            } else if (opcao.equals("9")) {
                JOptionPane.showMessageDialog(null, "Programa finalizado! Até mais.");

            } else {
                JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
            }
        }
    }
}