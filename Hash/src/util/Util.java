/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.Principal;

/**
 *
 * @author Alexandre
 */
public abstract class Util {

    public static final char alfabeto2[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
        's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
        'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3',
        '4', '5', '6', '7', '8', '9', '`', '~', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '=', '+',
        '|', '{', '}', '[', ']', ';', ':', ',', '<', '.', '>', '/', '?'};

    public static final char alfabeto[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
        's', 't', 'u', 'w', 'v', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
        'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'W', 'V', 'X', 'Y', 'Z', '0', '1', '2', '3',
        '4', '5', '6', '7', '8', '9', '!', '@', '#', '$', '%', '&', '*', '(', ')', '_', '-', '+', '=', '[', ']', '{',
        '}', '?', '/', '\\', '|', '>', '<', '.'};

    public static int MAX_WORDLENGTH = 8;//MAXIMO DE CARACTERES DA SENHA
    public static int MIN_WORDLENGTH = 4;//MAXIMO DE CARACTERES DA SENHA
    
    public static void limpaLog(){
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter("hashQuebradas.txt", false)));
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        out.println("");
        out.close();
    }

    public static void gravaLog(String text) {
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter("hashQuebradas.txt", true)));
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        out.println(text);
        out.close();
    }

    public static String formataHora(long ms) {

        long mili = (ms % 1000);
        long segundos = (ms / 1000) % 60;
        long minutos = (ms / 60000) % 60;     // 60000    = 60 * 1000
        long horas = (ms / 3600000) % 24;   // 3600000  = 60 * 60 * 1000
        long dias = ms / 86400000; // 86400000 = 24 * 60 * 60 * 1000

        if (dias > 0) {
            return String.format("%03d dia(s) %02d:%02d:%02d", dias, horas, minutos, segundos);
        } else {
            return String.format("%02d:%02d:%02d:%03d", horas, minutos, segundos, mili);
        }

    }

    public static HashSet<String> leitor(String path) throws IOException {
        HashSet<String> list = new HashSet<>();
        try (BufferedReader buffRead = new BufferedReader(new FileReader(path))) {
            String linha = "";
            while (true) {
                if (linha != null) {
                } else {
                    break;
                }
                linha = buffRead.readLine();
                if (linha != null) {
                    list.add(linha);
                }
            }
        }
        return list;
    }

    public static void geraHtml() throws FileNotFoundException {
        ArrayList<Hash> hashs = new ArrayList<Hash>();
        BufferedReader br2 = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader("HashQuebradas.txt"));
            br2 = new BufferedReader(new FileReader("HashQuebradas.txt"));
            while(br.ready()){
                String linha = br.readLine();
                if(linha.contains(";")){
                    String partes[] =  linha.split(";");
                    int tamanho = partes[1].length();
                    boolean contem = false;
                    for (int i=0; i <hashs.size(); i++){
                        if(hashs.get(i).getCaracteres() == tamanho){
                            hashs.get(i).setQtd();
                            contem = true;
                        }
                    }
                    if(!contem){
                        Hash hash = new Hash(tamanho);
                        hashs.add(hash);
                    }
                }  
            }
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
        PrintWriter html = null;
        try {
            html = new PrintWriter(new BufferedWriter(new FileWriter("hash.html", false)));
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal = Calendar.getInstance();
        html.println("<!doctype html><html><head><meta charset=\"UTF-8\">\n");
        html.println("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
        html.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
        html.println("<title>HashBreaker</title>\n");
        html.println("<link rel=\"stylesheet\" href=\"assets/lib/bootstrap/css/bootstrap.css\">\n");
        html.println("<link rel=\"stylesheet\" href=\"assets/css/main.css\">\n");
        html.println("<link rel=\"stylesheet\" href=\"https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css\">\n");
        html.println("<style type=\"text/css\">li { cursor: pointer; cursor: hand; }</style>\n");
        html.println("<script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>\n");
        html.println("<script src=\"assets/lib/jquery/jquery.js\"></script>\n");
        html.println("<script src=\"assets/lib/bootstrap/js/bootstrap.js\"></script>\n");
        html.println("<script type=\"text/javascript\" src=\"https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js\"></script>\n");
        html.println("<script type=\"text/javascript\">function viewTabela(){\n");
        html.println("document.getElementById(\"grafico\").style.display = \"none\";\n");
        html.println("document.getElementById(\"tabela\").style.display = \"block\";}\n");
        html.println("function viewGrafico(){\n");
        html.println("document.getElementById(\"grafico\").style.display = \"block\";\n");
        html.println("document.getElementById(\"tabela\").style.display = \"none\";}\n");
        html.println("google.charts.load(\"current\", {packages:[\"corechart\"]});\n");
        html.println("google.charts.setOnLoadCallback(drawChart);\n");
        html.println("function drawChart() {\n");
        html.println("var data = google.visualization.arrayToDataTable([\n");
        html.println("['Caracteres', 'Total'],\n");
        for (int i=0; i <hashs.size(); i++){
            if(i == hashs.size()-1){
                html.println("['"+hashs.get(i).getCaracteres()+" caracteres',"+hashs.get(i).getQtd()+"]]);\n");
            } else {
                html.println("['"+hashs.get(i).getCaracteres()+" caracteres',"+hashs.get(i).getQtd()+"],\n");
            }
        }
        html.println("var options = {pieHole: 0.4};\n");
        html.println("var chart = new google.visualization.PieChart(document.getElementById('donutchart'));\n");
        html.println("chart.draw(data, options);}\n");
        if(hashs.size() > 0){
            html.println("$(document).ready(function(){");
            html.println("var table = $('#tabHash').DataTable();");
            try {
                while(br2.ready()){
                    String linha = br2.readLine();
                    if(linha.contains(";")){
                        String partes[] =  linha.split(";");
                        String cripto = partes[0];
                        String senha = partes[1];
                        String tempo = partes[2];
                         html.println("table.row.add(['"+cripto+"','"+senha+"','"+tempo+"']).draw();");
                    }
            }
            html.println("});");
            br2.close();
        } catch (IOException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        html.println("</script></head><body class=\"  \">\n");
        html.println("<div class=\"bg-dark dk\" id=\"wrap\"><div id=\"top\">\n");
        html.println("<nav class=\"navbar navbar-inverse navbar-static-top\">\n");
        html.println("<div class=\"container-fluid\">\n");
        html.println("<header class=\"navbar-header\">\n");
        html.println("<img src=\"assets/img/logo.png\" alt=\"\">\n");
        html.println("</header></div></nav><header class=\"head\">\n");
        html.println("</header></div><div id=\"left\">\n");
        html.println("<div class=\"media user-media bg-dark dker\">\n");
        html.println("<div class=\"user-media-toggleHover\">\n");
        html.println("<span class=\"fa fa-user\"></span></div>\n");
        html.println("<div class=\"user-wrapper bg-dark\">\n");
        html.println("<a class=\"user-link\" href=\"\">\n");
        html.println("<img class=\"media-object img-thumbnail user-img\" alt=\"User Picture\" src=\"assets/img/hacker.jpg\">\n");
        html.println("</a><div class=\"media-body\">\n");
        html.println("<h5 class=\"media-heading\">Hacker</h5>\n");
        html.println("<ul class=\"list-unstyled user-info\">\n");
        html.println("<li>Data atual : <br><small><i class=\"fa fa-calendar\"></i>&nbsp;"+df.format(cal.getTime())+"</small>\n");
        html.println("</li></ul></div></div></div>\n");
        html.println("<ul id=\"menu\" class=\"bg-dark\">\n");
        html.println("<li class=\"nav-header\">Menu</li>\n");
        html.println("<li class=\"nav-divider\"></li>\n");
        html.println("<li class=\"selected\"><a onclick=\"viewGrafico()\"><i class=\"fa fa-dashboard\"></i>\n");
        html.println("<span class=\"link-title\">&nbsp;Gráfico</span></a></li>\n");
        html.println("<li class=\"\"><a onclick=\"viewTabela()\">\n");
        html.println("<i class=\"fa fa-dashboard\"></i><span class=\"link-title\">&nbsp;Lista</span>\n");
        html.println("</a></li></ul></div><div id=\"content\"><div class=\"outer\">\n");
        html.println("<div class=\"inner bg-light lter\" id=\"grafico\"><div class=\"col-lg-12\">\n");
        html.println("<h1>Gráfico de Hashs Quebradas</h1>\n");
        if(hashs.size() > 0){
            html.println("<div id=\"donutchart\" style=\"width: 100%; height: 500px;\"></div>\n");
        } else{
            html.println("<div style=\"width: 100%; height: 500px;\">Não existem hashs quebradas até o momento.</div>\n");
        }
        html.println("</div></div><div class=\"inner bg-light lter\" id=\"tabela\" style=\"display: none\"><div class=\"col-lg-12\">\n");
        html.println("<h1>Lista de Hashs Quebradas</h1>\n");
        html.println("<div style=\"width: 100%; height: 500px;\">\n");
        if(hashs.size() > 0){
            html.println("<table id=\"tabHash\" class=\"display\" width=\"100%\" cellspacing=\"0\">");
            html.println("<thead><tr><th>Hash</th><th>Senha</th><th>Tempo</th></tr></thead>");
            html.println("<tfoot><tr><th>Hash</th><th>Senha</th><th>Tempo</th></tr></tfoot></table></div>");
        } else{
            html.println("<div style=\"width: 100%; height: 500px;\">Não existem hashs quebradas até o momento.</div>\n");
        }
        html.println("</div></div></div></div></div>\n");
        html.println("<footer class=\"Footer bg-dark dker\">\n");
        html.println("<p>2016 &copy; HashBreaker</p>\n");
        html.println("</footer></body></html>\n");
        html.close();
    }
    
    public static void exibeHtml(){
        Desktop d = Desktop.getDesktop();
      try {
        d.browse( new URI( "hash.html" ) );
      }
      catch ( IOException e ) {
         System.out.println(e);
      }
      catch ( URISyntaxException e ) {
         System.out.println(e);
      }
    }

}
