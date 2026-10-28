import java.util.Scanner;

public class Validador_de_Senha {

    static String[] senhasObvias = {"12345678", "senha123", "admin123"};
    static final String SUCESSO = "SUCESSO: Sua senha passou nos critérios básicos!";

    static String avaliarSenha(String senha) {
        if (senha.length() < 8) {
            return "DICA: A senha deve ter no mínimo 8 caracteres.";
        }

        boolean temNumero = false;
        for (int i = 0; i < senha.length(); i++) {
            if (Character.isDigit(senha.charAt(i))) {
                temNumero = true;
            }
        }
        if (!temNumero) {
            return "DICA: Adicione pelo menos um número à sua senha.";
        }

        for (int i = 0; i < senhasObvias.length; i++) {
            if (senha.equals(senhasObvias[i])) {
                return "ALERTA: Esta senha é muito comum ou óbvia.";
            }
        }

        boolean temMaiuscula = false;
        for (int i = 0; i < senha.length(); i++) {
            if (Character.isUpperCase(senha.charAt(i))) {
                temMaiuscula = true;
            }
        }
        if (!temMaiuscula) {
            return "DICA: Adicione pelo menos uma letra maiúscula à sua senha.";
        }

        return SUCESSO;
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String resultado;

        do {
            System.out.print("Digite uma senha fictícia: ");
            String senha = teclado.nextLine(); 
            resultado = avaliarSenha(senha);
            System.out.println(resultado);
        } while (!resultado.equals(SUCESSO));

        teclado.close();
    }
}
