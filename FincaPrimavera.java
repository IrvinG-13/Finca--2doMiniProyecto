import java.util.Scanner;
    class Producto{
        //atributos
    
        //Arreglo Unidimensional para los Nombres de Cultivos
        private String[] productoscultivados = new String[3];

        public String[] getProductosCultivados() {
            return productoscultivados;
        }
        
        public void setProductoVerdura(int codeVerdura){
            if(codeVerdura == 1){
                productoscultivados[0] = "Lechuga ";

            }else if(codeVerdura == 2){
                productoscultivados[0] = "Espinaca";

            }else if(codeVerdura == 3){
                productoscultivados[0] = "Apio";

            }else if (codeVerdura == 4){
                productoscultivados[0] = "Brocoli";

            }else{
                System.out.println("Codigo Invalido");
            }
        }

        public void setProductoVegetal(int codeVegetal){
            if(codeVegetal == 1){
                productoscultivados[1] = "Papa";

            }else if(codeVegetal == 2){
                productoscultivados[1] = "Zanahoria";

            }else if(codeVegetal == 3){
                productoscultivados[1] = "Tomate";

            }else if (codeVegetal == 4){
                productoscultivados[1] = "Cebolla";

            }else{
                System.out.println("Codigo Invalido");
            }
        }

        public void setProductoFruta(int codeFruta){
            if(codeFruta == 1){
                productoscultivados[2] = "Manzana";

            }else if(codeFruta == 2){
                productoscultivados[2] = "Naranja";

            }else if(codeFruta == 3){
                productoscultivados[2] = "Sandia";

            }else if (codeFruta == 4){
                productoscultivados[2] = "Guineo";

            }else{
                System.out.println("Codigo Invalido");
            }
        }

        //Productos Seleccionados
        public void productosCultivados(){
            System.out.println("Verdura Selecionada : " + productoscultivados[0]);
            System.out.println("Producto Selecionado : " + productoscultivados[1]);
            System.out.println("Producto Selecionado : " + productoscultivados[2]);
        }

    }

    class Trimestre{
        //atributos
        private double costoVerduraKG;
        private double costoVegetalKG;
        private double costoFrutaKG;
        private String[] productosCultivados; // Agregamos este atributo
        // Arreglo bidimensional para produccion por kilo en un año
        private double[][] produccionKilo = new double[3][4];
        //Arreglo bidimensional para costos/gastos de la produccion en un año
        private double [][] costoproduccion = new double [3][4];


       // Método para recibir los nombres de los productos

       public void setProductosCultivados(String[] productos) {
        this.productosCultivados = productos;
       }


        public void produccionTrimestres(int fila, int columna, double kilosProducidos){
            //datos de produccion
            produccionKilo[fila][columna] = kilosProducidos;
            //datos de costes
            for (int i=0;i<costoproduccion.length;i++){ 
                if(fila == 0){ 
                costoproduccion[fila][columna] = (kilosProducidos * costoVerduraKG); 
            }else if(fila == 1){
                costoproduccion[fila][columna] = (kilosProducidos * costoVegetalKG);
            }else if(fila == 2){
                costoproduccion[fila][columna] = (kilosProducidos * costoFrutaKG);
            }
                
            }
        }  
        public void costotrimestre(int codeVerdura,int codeVegetal,int codeFruta){
            switch(codeVerdura){
                case 1: costoVerduraKG = 3.49; break;
                case 2: costoVerduraKG = 3.90; break;
                case 3: costoVerduraKG = 2.99; break;
                case 4: costoVerduraKG = 4.95; break; 
            }
            switch(codeVegetal){
                case 1: costoVegetalKG = 2.29; break;
                case 2: costoVegetalKG = 2.50; break;
                case 3: costoVegetalKG = 2.39; break;
                case 4: costoVegetalKG = 2.65; break;
            }
            switch(codeFruta){
                case 1: costoFrutaKG = 2.49; break;
                case 2: costoFrutaKG = 1.09; break;
                case 3: costoFrutaKG = 1.59; break;
                case 4: costoFrutaKG = 0.95; break;
            }
        }

        // impresion de prueba para ver si esta guardando los valores
        public void ImpresionProdTrimestres(){
            for(int x=0;x<produccionKilo.length;x++){
                for(int y=0;y<produccionKilo[x].length;y++){
                    System.out.println("El producto " + productosCultivados[x]  + " con " + produccionKilo[x][y] + " Kilogramos producidos y su costo por trimestre es de "+ costoproduccion[x][y] );
                }
            }  
        }

        //Punto B
        public void productoConMayorProduccion(){
            double[] sumaAnual = new double[3]; 
            for (int i = 0; i < produccionKilo.length; i++) {
                for (int j = 0; j < produccionKilo[i].length; j++) {
                    sumaAnual[i] += produccionKilo[i][j];
                }
            }
    
            double maxProduccion = sumaAnual[0];
            int indexMayorProduccion = 0;
            for (int i = 1; i < sumaAnual.length; i++) {
                if (sumaAnual[i] > maxProduccion) {
                    maxProduccion = sumaAnual[i];
                    indexMayorProduccion = i;
                }
            }
            
            System.out.println("El producto con mayor producción anual es: " + productosCultivados[indexMayorProduccion]);
            System.out.println("Producción anual: " + maxProduccion + " kg");
            
        }

        //Punto C
        public void productoConMenorProduccion() {
            double[] sumaAnual = new double[3]; 
        
            for (int i = 0; i < produccionKilo.length; i++) {
                for (int j = 0; j < produccionKilo[i].length; j++) {
                    sumaAnual[i] += produccionKilo[i][j];
                }
            }
        
            
            double minProduccion = sumaAnual[0];
            int indexMenorProduccion = 0;
            for (int i = 1; i < sumaAnual.length; i++) {
                if (sumaAnual[i] < minProduccion) {
                    minProduccion = sumaAnual[i];
                    indexMenorProduccion = i;
                }
            }
        
            System.out.println("El producto con menor producción anual es: " + productosCultivados[indexMenorProduccion]);
            System.out.println("Producción anual: " + minProduccion + " kg");
        }

        public void Informacion(int code){
            int index = code - 1; 

            if (index < 0 || index >= productosCultivados.length) {
                System.out.println("Código de producto inválido.");
                return;
            }
    
            System.out.println("\nInformación del producto: " + productosCultivados[index]);
    
            double produccionAnual = 0;
            double costoAnual = 0;
            
            
            for (int trimestre = 0; trimestre < 4; trimestre++) {
                System.out.println("Trimestre " + (trimestre + 1) + ": ");
                System.out.println("  Producción: " + produccionKilo[index][trimestre] + " kg");
                System.out.println("  Costo: $" + costoproduccion[index][trimestre]);
    
                produccionAnual += produccionKilo[index][trimestre];
                costoAnual += costoproduccion[index][trimestre];
            }
    
            System.out.println("Producción anual total: " + produccionAnual + " kg");
            System.out.println("Costo anual total: $" + costoAnual);
            System.out.println();
        }

        public void informacionTrimestre(int code) {
            if (code < 1 || code > 4) {
                System.out.println("Código de trimestre inválido.");
                return;
            }
        
            int indexTrimestre = code - 1;
            System.out.println("\nInformación del Trimestre " + code + ":");
        
            double produccionTotalTrimestre = 0;
            double costoTotalTrimestre = 0;
        
            
            for (int i = 0; i < productosCultivados.length; i++) {
                System.out.println("Producto: " + productosCultivados[i]);
                System.out.println("  Producción: " + produccionKilo[i][indexTrimestre] + " kg");
                System.out.println("  Costo: $" + costoproduccion[i][indexTrimestre]);
        
                produccionTotalTrimestre += produccionKilo[i][indexTrimestre];
                costoTotalTrimestre += costoproduccion[i][indexTrimestre];
            }
        
            System.out.println("Producción total del trimestre: " + produccionTotalTrimestre + " kg");
            System.out.println("Costo total del trimestre: $" + costoTotalTrimestre);
            System.out.println("");
        }
        
    }
       


//Algoritmo Principal
public class FincaPrimavera{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Producto producto = new Producto();
        Trimestre trimestre = new Trimestre();
        double kilosProducidos;
        String respuesta;
        int code; 
        System.out.println("\n Bienvenido a la Finca Primavera");
        System.out.println("--Seleccione una verdura a cultivar este 2024");
        System.out.println("1.Lechuga - 3.49$*KG");
        System.out.println("2.Espinaca - 3.90*KG");
        System.out.println("3.Apio - 2.99*KG");
        System.out.println("4.Brocoli - 4.95*KG");
        int codeVerdura = sc.nextInt();
        producto.setProductoVerdura(codeVerdura);

        System.out.println("--Seleccione un vegetal a cultivar este 2024");
        System.out.println("1.Papa - 2.29*KG");
        System.out.println("2.Zanahoria - 2.50*KG");
        System.out.println("3.Tomate - 2.39*KG");
        System.out.println("4.Cebolla - 2.65*KG");
        int codeVegetal = sc.nextInt();
        producto.setProductoVegetal(codeVegetal);

        System.out.println("--Seleccione una fruta a cultivar este 2024");
        System.out.println("1.Manzana - 2.49*KG");
        System.out.println("2.Naranja - 1.09*KG");
        System.out.println("3.Sandia - 1.59*KG");
        System.out.println("4.Guineo - 0.95*KG");
        int codeFruta = sc.nextInt();
        producto.setProductoFruta(codeFruta);

        trimestre.setProductosCultivados(producto.getProductosCultivados());
        trimestre.costotrimestre(codeVerdura,codeVegetal,codeFruta);
        producto.productosCultivados();
        System.out.println("");


        for(int k=0;k<4;k++){ 
        System.out.println("Kilos de Verduras producidos el Trimestre "+(k+1));
           kilosProducidos = sc.nextDouble();
              trimestre.produccionTrimestres(0,k,kilosProducidos);
        }
        for(int v=0;v<4;v++){
        System.out.println("Kilos de Vegetales producidos el Trimestre"+(v+1));
           kilosProducidos = sc.nextDouble();
              trimestre.produccionTrimestres(1,v,kilosProducidos);
        }
        for(int f=0; f<4;f++){
        System.out.println("Kilos de Frutas producidos el Trimestre"+(f+1));
         kilosProducidos= sc.nextDouble();
              trimestre.produccionTrimestres(2,f,kilosProducidos);
        }
        System.out.println("");
        trimestre.ImpresionProdTrimestres();
        trimestre.productoConMayorProduccion();
        trimestre.productoConMenorProduccion();

        System.out.println("\n Informacion de Productos");
        do {
            System.out.println("Codigo 1 = Verdura");
            System.out.println("Codigo 2 = Vegetal");
            System.out.println("Codigo 3 = Fruta");
            System.out.println("");
            System.out.println("Codigo del Producto?");
             code = sc.nextInt();

            trimestre.Informacion(code);

           System.out.println("Desea continuar? (s/n)");
           respuesta = sc.nextLine();
        } while (respuesta.equalsIgnoreCase("s"));

        System.out.println("\n Informacion de Trimestres");
        do {
            System.out.println("Codigo 1 = Trimestre 1");
            System.out.println("Codigo 2 = Trimestre 2");
            System.out.println("Codigo 3 = Trimestre 3");
            System.out.println("Codigo 4 = Trimestre 4");
            System.out.println("");
            System.out.println("Codigo del Trimestre?");
             code = sc.nextInt();

            trimestre.informacionTrimestre(code);

           System.out.println("Desea continuar? (s/n)");
           respuesta = sc.nextLine();
        } while (respuesta.equalsIgnoreCase("s"));

        sc.close();
    }
} 