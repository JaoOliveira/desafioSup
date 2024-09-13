import java.util.ArrayList;
import java.util.List;

public class DesafioResistores {
    public static String converterOhmsEmPadraoDeCores(String rawOhms) {

        if (rawOhms.equals("")) {
            return "invalid request";
        }
        String[] partes = rawOhms.split(" ");

        if (partes.length != 2) {
            return "invalid request";
        }

        if (!partes[1].toLowerCase().equals("ohms")) {
            return "invalid request";
        }

        if (partes[0].contains("k") || partes[0].contains("M")) {
            if (partes[0].contains("k") && partes[0].contains("M")) {
                return "invalid request";
            }
            String corPadrao = partes[0].contains("k") ? Cor.VERMELHO.toString() : Cor.VERDE.toString();

            try {
                char[] charArray = partes[0].toCharArray();
                int intOhms = charArray.length - 1;

                List<Integer> convertidos = new ArrayList<>();
                for (char index : charArray) {
                    if (!(index == '.' || index == 'k' || index == 'M')) {
                        convertidos.add(Integer.parseInt(String.valueOf(index)));
                    }

                }

                if (intOhms >= 1 && intOhms <= 3) {
                    return (Cor.fromCodigo(convertidos.get(0)).toString() + " " +  (intOhms == 1 ? Cor.PRETO.toString() : Cor.fromCodigo(convertidos.get(1)).toString()) + " " + corPadrao + " " + Cor.DOURADO.toString()).toLowerCase();
                } else {
                    return "invalid request";
                }


            } catch (Exception e) {
                return "invalid request" + e.getMessage();
            }

        } else {
            try {
                char[] charArray = partes[0].toCharArray();
                int intOhms = charArray.length;
                String valor = "";
                List<Integer> convertidos = new ArrayList<>();
                for (char index : charArray) {
                    if (!(index == '.')) {
                        convertidos.add(Integer.parseInt(String.valueOf(index)));
                    }

                }

                switch (intOhms) {
                    case 2:
                        valor = Cor.fromCodigo(convertidos.get(0)).toString() + " " + Cor.fromCodigo(convertidos.get(1)).toString() + " " + Cor.PRETO.toString() + " " + Cor.DOURADO.toString();
                        break;
                    case 3:
                        valor = Cor.fromCodigo(convertidos.get(0)).toString() + " " + Cor.fromCodigo(convertidos.get(1)).toString() + " " + Cor.MARROM.toString() + " " + Cor.DOURADO.toString();
                        break;
                    default:
                        return "invalid request";

                }

                return valor.toLowerCase();

            } catch (Exception e) {
                return "invalid request" + e.getMessage();
            }
        }


    }
}
