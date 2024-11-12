import java.util.Scanner;
    class Producto{
        //atributos
    
        //Arreglo Unidimensional para los Nombres de Cultivos
        private String[] productoscultivados = new String[3];


         //Metodos Geters y Setters
        public String[] getProductosCultivados() {
            return productoscultivados;
        }
        
        public void setProductoVerdura(String codeVerdura){
            
                productoscultivados[0] = codeVerdura; 
        }

        public void setProductoVegetal(String codeVegetal){
           
                productoscultivados[1] = codeVegetal;
        }

        public void setProductoFruta(String codeFruta){
         
                productoscultivados[2] = codeFruta;
        }

        // Impresion de Productos Seleccionados
        public void productosCultivados(){
            System.out.println("Verdura Selecionada : " + productoscultivados[0]);
            System.out.println("Vegetal Selecionado : " + productoscultivados[1]);
            System.out.println("Fruta Selecionado : " + productoscultivados[2]);
        }

    }

    //Clase Trimestre
    class Trimestre{

        //atributos
        private double costoVerduraKG;
        private double costoVegetalKG;
        private double costoFrutaKG;
        private String[] productosCultivados;

        // Arreglo bidimensional para produccion por kilo en un año
        private double[][] produccionKilo = new double[3][4];

        //Arreglo bidimensional para costos/gastos de la produccion en un año
        private double [][] costoproduccion = new double [3][4];

        //Metodos Getters y Setters

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
        public void costotrimestre(double costeVerdura,double costeVegetal,double costeFruta){
            
                costoVerduraKG = costeVerdura; 

                costoVegetalKG = costeVegetal; 
                
                costoFrutaKG = costeFruta; 
                
        } 

        // impresion de prueba para ver si esta guardando los valores
        public void ImpresionProdTrimestres(){
            for(int x=0;x<produccionKilo.length;x++){
                System.out.println("");
                for(int y=0;y<produccionKilo[x].length;y++){
                    System.out.println("El producto " + productosCultivados[x]  + " con " + produccionKilo[x][y] + " Kilogramos producidos y su costo en el trimestre " + (y+1) +" es de "+ costoproduccion[x][y] );
                }
            }  
        }

        //Impresion de Producto con mayor produccion
        public void productoConMayorProduccion(){

            double[] sumaAnual = new double[3]; 
            //recorrido de filas
            for (int i = 0; i < produccionKilo.length; i++) {
                //recorrido de columnas / trimestres
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
            
            System.out.println("\nEl producto con mayor producción anual es: " + productosCultivados[indexMayorProduccion]);
            System.out.println("Producción anual: " + maxProduccion + " kg");
            
        }

        // impresion del producto con menor produccion
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
        
            System.out.println("\nEl producto con menor producción anual es: " + productosCultivados[indexMenorProduccion]);
            System.out.println("Producción anual: " + minProduccion + " kg");
        }

        // Consultar Informacion de X producto
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
         //Consultar Informacion de Y trimestre
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

                //Creacion de Objetos
                Producto producto = new Producto();
                Trimestre trimestre = new Trimestre();

                //Variables para almacenar respuestas
                double kilosProducidos;
                String respuesta;
                int code; 

                //Preuntas que vera el Usuario al iniciar
                System.out.println("\n Bienvenido a la Finca Primavera");
                System.out.println("\n--Ingrese una verdura a cultivar este 2024");
               
                String codeVerdura = sc.nextLine();
                producto.setProductoVerdura(codeVerdura);
                //Ingreso de costes
                System.out.println("Ingrese el coste de produccion en Kg");
                double costeVerdura = sc.nextDouble();
                sc.nextLine();

                System.out.println("\n--Ingrese un vegetal a cultivar este 2024");
                
                String codeVegetal = sc.nextLine();
                producto.setProductoVegetal(codeVegetal);
                //Ingreso de costes
                System.out.println("Ingrese el coste de produccion en Kg");
                double costeVegetal = sc.nextDouble();
                sc.nextLine();


                System.out.println("\n--Ingrese una fruta a cultivar este 2024");
              
                String codeFruta = sc.nextLine();
                producto.setProductoFruta(codeFruta);
                //Ingreso de costes
                System.out.println("Ingrese el coste de produccion en Kg");
                double costeFruta = sc.nextDouble();
                sc.nextLine();

                //Call Back de las funciones que imnpriman los productos seleccionados
                trimestre.setProductosCultivados(producto.getProductosCultivados());
                trimestre.costotrimestre(costeVerdura,costeVegetal,costeFruta);
                producto.productosCultivados();
                System.out.println("");

                //Impresion de los Calculos de Kilos producidos
                for(int k=0;k<4;k++){ 
                System.out.println("Kilos de "+codeVerdura+ " producidos el Trimestre "+(k+1));
                kilosProducidos = sc.nextDouble();
                    trimestre.produccionTrimestres(0,k,kilosProducidos);
                }
                for(int v=0;v<4;v++){
                System.out.println("Kilos de "+codeVegetal+ " producidos el Trimestre"+(v+1));
                kilosProducidos = sc.nextDouble();
                    trimestre.produccionTrimestres(1,v,kilosProducidos);
                }
                for(int f=0; f<4;f++){
                System.out.println("Kilos de "+codeFruta+ " producidos el Trimestre"+(f+1));
                kilosProducidos= sc.nextDouble();
                    trimestre.produccionTrimestres(2,f,kilosProducidos);
                }
                System.out.println("");
                trimestre.ImpresionProdTrimestres();
                trimestre.productoConMayorProduccion();
                trimestre.productoConMenorProduccion();


                //Bucles para consular informacion del producto y del trimestre
                //Bucle de informacion
                System.out.println("\n Informacion de Productos");
                do {
                    System.out.println("Codigo 1 = Verdura");
                    System.out.println("Codigo 2 = Vegetal");
                    System.out.println("Codigo 3 = Fruta");
                    System.out.println("");
                    System.out.println("Codigo del Producto?");
                    code = sc.nextInt();

                    trimestre.Informacion(code);
                    sc.nextLine();
                System.out.println("Desea volver? (s/n)");
                respuesta = sc.nextLine();
                } while (respuesta.equalsIgnoreCase("s"));
                
                //Bucle de trimestre
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
                    sc.nextLine();
                System.out.println("Desea volver? (s/n)");
                respuesta = sc.nextLine();
                } while (respuesta.equalsIgnoreCase("s"));

                sc.close();
            }
        } 