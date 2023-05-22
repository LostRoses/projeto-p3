import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BibliotecaController {
    private Biblioteca biblioteca;

    public BibliotecaController() {
        this.biblioteca = new Biblioteca();
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/livro/cadastrar")
    public String cadastrarLivro(@RequestParam("titulo") String titulo,
                                 @RequestParam("autor") String autor,
                                 @RequestParam("tipo") String tipo,
                                 Model model) {
        Livro livro;
        if (tipo.equals("fisico")) {
            livro = new LivroFisico(titulo, autor, 0);
        } else {
            livro = new LivroDigital(titulo, autor, "");
        }

        biblioteca.cadastrarLivro(livro);
        model.addAttribute("mensagem", "Livro cadastrado com sucesso!");

        return "index";
    }

    @PostMapping("/livro/buscar")
    public String buscarLivro(@RequestParam("titulo") String titulo, Model model) {
        Livro livro = biblioteca.buscarLivro(titulo);
        if (livro != null) {
            model.addAttribute("livro", livro);
        } else {
            model.addAttribute("mensagem", "Livro não encontrado na biblioteca.");
        }

        return "index";
    }
}
public class Livro  {
    private String titulo;
    private String autor;
    

    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    // Getters e Setters

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    // Método para exibir informações do livro

    public void exibirInformacoes() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
    }
}public class LivroFisico extends Livro {
    private int numeroPaginas;

    public LivroFisico(String titulo, String autor, int numeroPaginas) {
        super(titulo, autor);
        this.numeroPaginas = numeroPaginas;
    }

    // Getter e Setter

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    // Sobrescrita do método para exibir informações do livro físico

    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("Número de páginas: " + numeroPaginas);
    }
}public class LivroDigital extends Livro {
    private String formato;

    public LivroDigital(String titulo, String autor, String formato) {
        super(titulo, autor);
        this.formato = formato;
    }

    // Getter e Setter

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    // Sobrescrita do método para exibir informações do livro digital

    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("Formato: " + formato);
}
}import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros;

    public Biblioteca() {
        this.livros = new ArrayList<>();
    }

