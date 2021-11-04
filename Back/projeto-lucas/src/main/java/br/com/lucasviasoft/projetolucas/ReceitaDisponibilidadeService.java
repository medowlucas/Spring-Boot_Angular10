package br.com.lucasviasoft.projetolucas;

import lombok.extern.java.Log;
import org.jsoup.Connection;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Log
public class ReceitaDisponibilidadeService {

@Scheduled(cron="0 0/5 * 1/1 * ?")
    public void checkReceitaStatus(){
    try {
        String receitaUrl = "http://www.nfe.fazenda.gov.br/portal/disponibilidade.aspx";
        Document doc = Jsoup.connect(receitaUrl).get();
        log.info(String.valueOf(doc));
    } catch (IOException e){
        e.printStackTrace();
    }
    }
}
