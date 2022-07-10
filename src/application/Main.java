    package application;

    import entities.Produto;
    import entities.ProdutoImportado;
    import entities.ProdutoUsado;

    import java.text.ParseException;
    import java.text.SimpleDateFormat;
    import java.util.*;

    public class Main {

        public static void main(String[] args) throws ParseException {
            Locale.setDefault(Locale.US);
         Scanner sc = new Scanner(System.in);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

         System.out.print("Informe o numero de produtos:");
         int n = sc.nextInt();

         List<Produto> list = new ArrayList<>();
         for (int i = 1; i <= n; i ++){
             System.out.println("Dados do # " + i + " produto :") ;
             System.out.print("Comum,usado ou importado (c/u/i)? ");
             char ch = sc.next().charAt(0);
             System.out.print("Nome: ");
             sc.nextLine();
             String nome = sc.nextLine();
             System.out.print("Preco: ");
             double preco = sc.nextDouble();

             if( ch == 'c'){
                 list.add(new Produto(nome,preco));
             }
             else if (ch == 'u'){
                 System.out.print("Data de fabricacao (DD/MM/YYYY)");
                 Date dataDefabricacao = sdf.parse(sc.next());
                 list.add(new ProdutoUsado(nome,preco,dataDefabricacao));
             }
             else {
                 System.out.print("Livre de Alfandega: ");
                 double livreDeAlfandega = sc.nextDouble();
                 list.add(new ProdutoImportado(nome,preco,livreDeAlfandega));
             }
         }
            System.out.println();
            System.out.println("Etiquetas : ");
            for(Produto prod : list){
                System.out.println(prod.etiquetaProduto());
            }
         sc.close();
        }
    }
