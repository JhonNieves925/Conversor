import javax.swing.JOptionPane;

public class Conversor {
    public static void main(String[] args) {
        String[] opcionesMoneda = { "Dólar", "Euro", "Libra Esterlina", "Yen Japonés", "Won Surcoreano" };
        String[] opcionesConversion = { "Moneda a Pesos Colombianos", "Pesos Colombianos a Moneda", "Kilómetros a Millas" };

        boolean salir = false;

        while (!salir) {
            // Mostrar ventana de selección de opción
            int opcionConversion = JOptionPane.showOptionDialog(null, "¿Qué conversión deseas realizar?",
                    "Conversor de Moneda", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                    opcionesConversion, opcionesConversion[0]);

            if (opcionConversion == 0) {
                // Conversión de moneda a pesos colombianos
                int opcionMoneda = JOptionPane.showOptionDialog(null, "Elige la moneda de origen",
                        "Conversor de Moneda", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                        opcionesMoneda, opcionesMoneda[0]);

                double tasaConversion = 0;

                switch (opcionMoneda) {
                    case 0: // Dólar
                        tasaConversion = 4.128;
                        break;
                    case 1: // Euro
                        tasaConversion = 4.652;
                        break;
                    case 2: // Libra Esterlina
                        tasaConversion = 5.704;
                        break;
                    case 3: // Yen Japonés
                        tasaConversion = 29.827;
                        break;
                    case 4: // Won Surcoreano
                        tasaConversion = 3.244;
                        break;
                    default:
                        break;
                }

                // Obtener la cantidad a convertir
                String input = JOptionPane.showInputDialog("Introduce la cantidad de " + opcionesMoneda[opcionMoneda] + ":");
                double cantidadMoneda = 0;

                try {
                    cantidadMoneda = Double.parseDouble(input);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Formato inválido. Introduce un número válido.");
                    continue;
                }

                // Realizar la conversión a pesos colombianos
                double resultado = cantidadMoneda * tasaConversion;

                // Formatear el resultado a 4 decimales
                String resultadoFormateado = String.format("%.3f", resultado);

                // Mostrar el resultado formateado
                JOptionPane.showMessageDialog(null,
                        "El resultado de la conversión es: " + resultadoFormateado + " pesos colombianos");

            } else if (opcionConversion == 1) {
                // Conversión de pesos colombianos a moneda
                int opcionMoneda = JOptionPane.showOptionDialog(null, "Elige la moneda de destino",
                        "Conversor de Moneda", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                        opcionesMoneda, opcionesMoneda[0]);

                double tasaConversion = 0;

                switch (opcionMoneda) {
                    case 0: // Dólar
                        tasaConversion = 1 / 4128.0;
                        break;
                    case 1: // Euro
                        tasaConversion = 1 / 4652.0;
                        break;
                    case 2: // Libra Esterlina
                        tasaConversion = 1 / 5704.0;
                        break;
                    case 3: // Yen Japonés
                        tasaConversion = 1 / 37.57;
                        break;
                    case 4: // Won Surcoreano
                        tasaConversion = 1 / 0.3081;
                        break;
                    default:
                        break;
                }

                // Obtener la cantidad a convertir
                String input = JOptionPane.showInputDialog("Introduce la cantidad de pesos colombianos:");
                double cantidadPesos = 0;

                try {
                    cantidadPesos = Double.parseDouble(input);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Formato inválido. Introduce un número válido.");
                    continue;
                }

                // Realizar la conversión a la moneda seleccionada
                double resultado = cantidadPesos * tasaConversion;

                // Formatear el resultado a 4 decimales
                String resultadoFormateado = String.format("%.4f", resultado);

                // Mostrar el resultado formateado
                JOptionPane.showMessageDialog(null,
                        "El resultado de la conversión es: " + resultadoFormateado + " " + opcionesMoneda[opcionMoneda]);

            } else if (opcionConversion == 2) {
                // Conversión de kilómetros a millas
                String input = JOptionPane.showInputDialog("Introduce la cantidad en kilómetros:");
                double cantidadKilometros = 0;

                try {
                    cantidadKilometros = Double.parseDouble(input);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Formato inválido. Introduce un número válido.");
                    continue;
                }

                // Realizar la conversión
                double resultado = cantidadKilometros * 0.621371;

                // Formatear el resultado a 4 decimales
                String resultadoFormateado = String.format("%.4f", resultado);

                // Mostrar el resultado formateado
                JOptionPane.showMessageDialog(null,
                        "El resultado de la conversión es: " + resultadoFormateado + " millas");
            }

            // Preguntar si desea volver a la interfaz inicial
            int opcionVolver = JOptionPane.showConfirmDialog(null, "¿Deseas realizar otra conversión?",
                    "Volver a la interfaz inicial", JOptionPane.YES_NO_OPTION);

            if (opcionVolver == JOptionPane.NO_OPTION) {
                // Preguntar si realmente quiere salir del programa
                int opcionSalir = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que quieres salir?",
                        "Salir del programa", JOptionPane.YES_NO_OPTION);

                if (opcionSalir == JOptionPane.YES_OPTION) {
                    salir = true;
                }
            }
        }
    }
}
