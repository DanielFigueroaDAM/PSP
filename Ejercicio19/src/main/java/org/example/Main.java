package org.example;

public class Main {
    public static int contadorVocales = 0;
    public static void main(String[] args) {
        String palabra = "El Lorem Ipsum fue concebido como un texto de relleno, formateado de una cierta manera para permitir la presentación de elementos gráficos en documentos, sin necesidad de una copia formal. El uso de Lorem Ipsum permite a los diseñadores reunir los diseños y la forma del contenido antes de que el contenido se haya creado, dando al diseño y al proceso de producción más libertad.\n" +
                "\n" +
                "Se cree ampliamente que la historia de Lorem Ipsum se origina con Cicerón en el siglo I aC y su texto De Finibus bonorum et malorum. Esta obra filosófica, también conocida como En los extremos del bien y del mal, se dividió en cinco libros. El Lorem Ipsum que conocemos hoy se deriva de partes del primer libro Liber Primus y su discusión sobre el hedonismo, cuyas palabras habían sido alteradas, añadidas y eliminadas para convertirlas en un latín sin sentido e impropio. No se sabe exactamente cuándo el texto recibió su forma tradicional actual. Sin embargo, las referencias a la frase \"Lorem Ipsum\" se pueden encontrar en la Edición de la Biblioteca Clásica Loeb de 1914 del De Finibus en las secciones 32 y 33. Fue en esta edición del De Finibus en la que H. Rackman tradujo el texto. El siguiente fragmento se selecciona de la sección 32:\n" +
                "\n" +
                "    \"qui dolorem ipsum, quia dolor sit amet consectetur adipisci velit, sed quia non numquam eius modi tempora incidunt, ut labore et dolore magnam aliquam quaerat voluptatem\".\n" +
                "\n" +
                "Esto es reconocible, en parte, como el estándar del Lorem Ipsum de hoy y fue traducido a:\n" +
                "\n" +
                "    \"Nor again is there anyone who loves or pursues or desires to obtain pain of itself, because it is pain, but occasionally circumstances occur in which toil and pain can procure him some great pleasure\".\n" +
                "\n" +
                "Pasando a la década de 1960, el Lorem Ipsum fue popularizado por el fabricante de tipografía Letraset, que lo utilizó en sus campañas publicitarias. Letraset ofrecía páginas de Lorem Ipsum como hojas de transferencia, que fueron ampliamente utilizadas en la era anterior a los ordenadores para los diseños. Estas páginas de transferencia, conocidas como Letraset Body Type, se incluyeron en la publicidad de la compañía y en su popular catálogo.\n" +
                "\n" +
                "El Lorem Ipsum fue reintroducido en la década de 1980 por Aldus Corporation, una empresa que desarrolló Software de Publicación de Escritorio. Su producto más conocido PageMaker viene con gráficos y plantillas de procesamiento de textos previamente instaladas que contienen una versión del lenguaje latín falso.";

        Thread A = new Thread(()->cuentaLetras('a',palabra));
        Thread E = new Thread(()->cuentaLetras('e',palabra));
        Thread I = new Thread(()->cuentaLetras('i',palabra));
        Thread O = new Thread(()->cuentaLetras('o',palabra));
        Thread U = new Thread(()->cuentaLetras('u',palabra));
        A.start();
        E.start();
        I.start();
        O.start();
        U.start();
        try {
            A.join();
            E.join();
            I.join();
            O.join();
            U.join();
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(contadorVocales);

    }
    public synchronized static void cuentaLetras(Character letra, String palabra){
        for(Character n : palabra.toCharArray()){
            if(letra == n || letra == Character.toUpperCase(n)){
                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                contadorVocales++;
                System.out.println(contadorVocales  );
            }

        }


    }




}