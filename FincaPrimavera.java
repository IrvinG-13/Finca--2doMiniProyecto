import java.util.Scanner;


class Producto{
    //atributos
    private String[] productosVerdura = new String[1];
    private String[] productosVegetal = new String[1];
    private String[] productosFruta = new String[1];

    public void setProductoVerdura(int codeVerdura){
        if(codeVerdura == 1){
            productosVerdura[0] = "Lechuga";

        }else if(codeVerdura == 2){
            productosVerdura[0] = "Espinaca";

        }else if(codeVerdura == 3){
            productosVerdura[0] = "Apio";

        }else if (codeVerdura == 4){
            productosVerdura[0] = "Brocoli";

        }else{
            System.out.println("Codigo Invalido");
        }
    }

    public void setProductoVegetal(int codeVegetal){
        if(codeVegetal == 1){
            productosVegetal[0] = "Papa";

        }else if(codeVegetal == 2){
            productosVegetal[0] = "Zanahoria";

        }else if(codeVegetal == 3){
            productosVegetal[0] = "Tomate";

        }else if (codeVegetal == 4){
            productosVegetal[0] = "Cebolla";

        }else{
            System.out.println("Codigo Invalido");
        }
    }

    public void setProductoFruta(int codeFruta){
        if(codeFruta == 1){
            productosFruta[0] = "Manzana";

        }else if(codeFruta == 2){
            productosFruta[0] = "Naranja";

        }else if(codeFruta == 3){
            productosFruta[0] = "Sandia";

        }else if (codeFruta == 4){
            productosFruta[0] = "Fresa";

        }else{
            System.out.println("Codigo Invalido");
        }
    }

    //Productos Seleccionados
    public void productosCultivados(){
        System.out.println("Verdura Selecionada : " + productosVerdura[0]);
        System.out.println("Producto Selecionado : " + productosVegetal[0]);
        System.out.println("Producto Selecionado : " + productosFruta[0]);
    }

}

class Trimestre{
    //atributos
    private double kilosProducidos;
    private double kilosVendidos;
    private double precioPromedio;
    private String name;
    
}

//Algoritmo Principal
public class FincaPrimavera{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Producto producto = new Producto();

        System.out.println("\n Bienvenido a la Finca Primavera");
        System.out.println("--Seleccione una verdura");
        System.out.println("1.Lechuga");
        System.out.println("2.Espinaca");
        System.out.println("3.Apio");
        System.out.println("4.Brocoli");
        int codeVerdura = sc.nextInt();
        producto.setProductoVerdura(codeVerdura);


        System.out.println("--Seleccione un vegetal");
        System.out.println("1.Papa");
        System.out.println("2.Zanahoria");
        System.out.println("3.Tomate");
        System.out.println("4.Cebolla");
        int codeVegetal = sc.nextInt();
        producto.setProductoVegetal(codeVegetal);

        System.out.println("--Seleccione una fruta");
        System.out.println("1.Manzana");
        System.out.println("2.Naranja");
        System.out.println("3.Sandia");
        System.out.println("4.Fresa");
        int codeFruta = sc.nextInt();
        producto.setProductoFruta(codeFruta);

        System.out.println("");


        producto.productosCultivados();

        sc.close();
    }
}