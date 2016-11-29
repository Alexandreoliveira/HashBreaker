package core;

import com.twmacinta.util.MD5;
import util.Util;
import static util.Util.alfabeto;
import view.Principal;
import static view.Principal.listaDeHashs;
import static view.Principal.listaDeHashs2;

/**
 *
 * @author Alexandre Oliveira
 */
public class Brute implements Runnable {

    private long start;
    private long end;
    private final int alfaIni;
    private final int alfaFim;

    public Brute(int alfaIni, int alfaFim) {

        this.start = 0;
        this.end = 0;
        this.alfaIni = alfaIni;
        this.alfaFim = alfaFim;
    }

    @Override
    public void run() {

        start = System.currentTimeMillis();
        for (int wordlength = Util.MIN_WORDLENGTH; wordlength <= Util.MAX_WORDLENGTH; wordlength++) {
            if (!listaDeHashs.isEmpty()) {
                generate(wordlength, this.alfaIni, this.alfaFim);
            } else {
                Principal.setArea("Terminou\n");
                Principal.setButton(1, true);
                break;
            }
        }
        Principal.setArea("Terminou\n");
        Principal.setButton(1, true);
    }

    private void generate(int wordlength, int ini, int fim) {

        char[] word = new char[wordlength];
        boolean flag = false;

        switch (wordlength) {
            case 4:
                for (int i = ini; i <= fim; i++) {
                    word[0] = alfabeto[i];
                    for (int o = 0; o < alfabeto.length; o++) {
                        word[1] = alfabeto[o];
                        for (int p = 0; p < alfabeto.length; p++) {
                            word[2] = alfabeto[p];
                            for (int d = 0; d < alfabeto.length; d++) {
                                word[3] = alfabeto[d];

                                /**
                                 * Essa parte Compara as hash gerada com as
                                 * hashs que tem que quebrar
                                 */
                                String ss = new String(word);
                                String cript = encriptar(ss);

                                if (listaDeHashs.contains(cript)) {
                                    flag = true;
                                    end = System.currentTimeMillis();
                                    Util.gravaLog(cript + ";" + ss + ";" + Util.formataHora(this.end - this.start));
                                    listaDeHashs.remove(cript);
                                    Principal.setArea(cript + ";" + ss + ";" + Util.formataHora(this.end - this.start) + "\n");
                                }
                                if (listaDeHashs.isEmpty()) {
                                    return;
                                }
                            }
                        }
                    }
                }
                break;

            case 5:
                for (int i = ini; i <= fim; i++) {
                    word[0] = alfabeto[i];
                    for (int o = 0; o < alfabeto.length; o++) {
                        word[1] = alfabeto[o];
                        for (int p = 0; p < alfabeto.length; p++) {
                            word[2] = alfabeto[p];
                            for (int d = 0; d < alfabeto.length; d++) {
                                word[3] = alfabeto[d];
                                for (int x = 0; x < alfabeto.length; x++) {
                                    word[4] = alfabeto[x];

                                    /**
                                     * Essa parte Compara as hash gerada com as
                                     * hashs que tem que quebrar
                                     */
                                    String ss = new String(word);
                                    String cript = encriptar(ss);
                                    if (listaDeHashs.contains(cript)) {
                                        flag = true;
                                        end = System.currentTimeMillis();
                                        Util.gravaLog(cript + ";" + ss + ";" + Util.formataHora(this.end - this.start));
                                        listaDeHashs.remove(cript);
                                        Principal.setArea(cript + ";" + ss + ";" + Util.formataHora(this.end - this.start) + "\n");
                                    }
                                    if (listaDeHashs.isEmpty()) {
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
                break;

            case 6:
                for (int i = ini; i <= fim; i++) {
                    word[0] = alfabeto[i];
                    for (int o = 0; o < alfabeto.length; o++) {
                        word[1] = alfabeto[o];
                        for (int p = 0; p < alfabeto.length; p++) {
                            word[2] = alfabeto[p];
                            for (int d = 0; d < alfabeto.length; d++) {
                                word[3] = alfabeto[d];
                                for (int x = 0; x < alfabeto.length; x++) {
                                    word[4] = alfabeto[x];
                                    for (int t = 0; t < alfabeto.length; t++) {
                                        word[5] = alfabeto[t];

                                        /**
                                         * Essa parte Compara as hash gerada com
                                         * as hashs que tem que quebrar
                                         */
                                        String ss = new String(word);
                                        String cript = encriptar(ss);
                                        if (listaDeHashs.contains(cript)) {
                                            flag = true;
                                            end = System.currentTimeMillis();
                                            Util.gravaLog(cript + ";" + ss + ";" + Util.formataHora(this.end - this.start));
                                            listaDeHashs.remove(cript);
                                            Principal.setArea(cript + ";" + ss + ";" + Util.formataHora(this.end - this.start) + "\n");
                                        }
                                        if (listaDeHashs.isEmpty()) {
                                            return;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                break;

            case 7:

                for (int i = ini; i <= fim; i++) {
                    word[0] = alfabeto[i];
                    for (int o = 0; o < alfabeto.length; o++) {
                        word[1] = alfabeto[o];
                        for (int p = 0; p < alfabeto.length; p++) {
                            word[2] = alfabeto[p];
                            for (int d = 0; d < alfabeto.length; d++) {
                                word[3] = alfabeto[d];
                                for (int x = 0; x < alfabeto.length; x++) {
                                    word[4] = alfabeto[x];
                                    for (int t = 0; t < alfabeto.length; t++) {
                                        word[5] = alfabeto[t];
                                        for (int y = 0; y < alfabeto.length; y++) {
                                            word[6] = alfabeto[y];

                                            /**
                                             * Essa parte Compara as hash gerada
                                             * com as hashs que tem que quebrar
                                             */
                                            String ss = new String(word);
                                            String cript = encriptar(ss);
                                            if (listaDeHashs.contains(cript)) {
                                                flag = true;
                                                end = System.currentTimeMillis();
                                                Util.gravaLog(cript + ";" + ss + ";" + Util.formataHora(this.end - this.start));
                                                listaDeHashs.remove(cript);
                                                Principal.setArea(cript + ";" + ss + ";" + Util.formataHora(this.end - this.start) + "\n");
                                            }
                                            if (listaDeHashs.isEmpty()) {
                                                return;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                break;

            case 8:
                for (int i = ini; i <= fim; i++) {
                    word[0] = alfabeto[i];
                    for (int o = 0; o < alfabeto.length; o++) {
                        word[1] = alfabeto[o];
                        for (int p = 0; p < alfabeto.length; p++) {
                            word[2] = alfabeto[p];
                            for (int d = 0; d < alfabeto.length; d++) {
                                word[3] = alfabeto[d];
                                for (int x = 0; x < alfabeto.length; x++) {
                                    word[4] = alfabeto[x];
                                    for (int t = 0; t < alfabeto.length; t++) {
                                        word[5] = alfabeto[t];
                                        for (int y = 0; y < alfabeto.length; y++) {
                                            word[6] = alfabeto[y];
                                            for (int g = 0; g < alfabeto.length; g++) {
                                                word[7] = alfabeto[g];

                                                /**
                                                 * Essa parte Compara as hash
                                                 * gerada com as hashs que tem
                                                 * que quebrar
                                                 */
                                                String ss = new String(word);
                                                String cript = encriptar(ss);
                                                if (listaDeHashs.contains(cript)) {
                                                    flag = true;
                                                    end = System.currentTimeMillis();
                                                    Util.gravaLog(cript + ";" + ss + ";" + Util.formataHora(this.end - this.start));
                                                    listaDeHashs.remove(cript);
                                                    Principal.setArea(cript + ";" + ss + ";" + Util.formataHora(this.end - this.start) + "\n");
                                                }
                                                if (listaDeHashs.isEmpty()) {
                                                    return;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                break;
        }
    }

    private String encriptar(String str) {
        MD5 md5 = new MD5();
        md5.Update(str);
        return md5.asHex();
    }

}
