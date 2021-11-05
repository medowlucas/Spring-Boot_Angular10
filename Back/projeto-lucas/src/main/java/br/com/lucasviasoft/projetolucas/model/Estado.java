package br.com.lucasviasoft.projetolucas.model;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Estado {

    private Date data;
    private EstadosEnum sigla;
    private StatusEnum servico1;

    public Estado(){
    }

    public Estado(Date data, EstadosEnum sigla, StatusEnum servico1){
        this.data = data;
        this.sigla = sigla;
        this.servico1 = servico1;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public EstadosEnum getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        String c = sigla;
        Pattern pt = Pattern.compile("[^A-Z]");
        Matcher match = pt.matcher(c);
        while(match.find()){
            c=c.replace(Character.toString(c.charAt(match.start())),"");
        }
        System.out.println(String.valueOf(c));
        this.sigla = EstadosEnum.PR;

    }


}
