package br.com.lucasviasoft.projetolucas.service;

import br.com.lucasviasoft.projetolucas.model.Estado;
import br.com.lucasviasoft.projetolucas.model.EstadosEnum;
import lombok.extern.java.Log;
import org.jsoup.Connection;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Log
public class VerificarDisponibilidadeNfeFazenda {

@Scheduled(cron="0 0/5 * 1/1 * ?")
    public void checkReceitaStatus(){
        try {
            String receitaUrl = "http://www.nfe.fazenda.gov.br/portal/disponibilidade.aspx";
            Document resposta = Jsoup.connect(receitaUrl).get();
            Elements tabela = resposta.select("tbody");

            if (tabela.size() > 1) {
                Elements rows = tabela.get(1).select("tr");

                for (int i = 1; i < rows.size(); i++) {
                    Elements values = rows.get(1).select("td");
                    log.info(String.valueOf(values));
                    Estado estado = new Estado();
                    estado.setSigla("SP");
                    log.info(String.valueOf(values.get(0)));
                    //log.info(String.valueOf(values.get(0)) + String.valueOf(values.get(5)));
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
