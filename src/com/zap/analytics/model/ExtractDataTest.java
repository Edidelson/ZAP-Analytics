package com.zap.analytics.model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import static java.util.stream.Collectors.*;

/**
 *
 * @author Renato-PC
 */
public class ExtractDataTest {

    public static void main(String[] args) {

        String[] data = new String[]{"Nota Fiscal;1;Arroz Beneficiado;10;Qtd;10;Orion Joias",
            "Nota Fiscal;1;Arroz Beneficiado;10;Qtd;20;Orion Joias",
            "Nota Fiscal;2;Arroz Beneficiado;10;Qtd;10;Comercial Camargo",
            "Nota Fiscal;2;Bolacha;40;Qtd;17;Comercial Camargo",
            "Nota Fiscal;3;Achocolatado;30;Qtd;5;Comercial Camargo"};

        Map<String, List<String[]>> map = Arrays
                .stream(data)
                .map(u -> u.split(Pattern.quote(";")))
                .parallel()             
                .collect(groupingBy(t -> t[3]));
        
        Comparator<Map.Entry<String, List<String[]>>> comparator = Comparator.comparing((Map.Entry<String, List<String[]>> c) -> c.getValue().stream().parallel().mapToInt(t -> Integer.parseInt(t[5])).sum()).reversed();
        
        // Produtos mais vendidos
        map.entrySet().stream()                
                .sorted(comparator)
                .forEach(k -> {            
                    System.out.println(k.getKey() + "|"
                            + k.getValue().stream().parallel().map(t -> t[1]).findFirst().get() + "|"
                            + k.getValue().stream().parallel().map(t -> t[2]).findFirst().get() + "|"
                            + k.getValue().stream().parallel().mapToInt(t -> Integer.parseInt(t[5])).sum());
        });
        
        // Produtos mais vendidos por cliente
    }

}