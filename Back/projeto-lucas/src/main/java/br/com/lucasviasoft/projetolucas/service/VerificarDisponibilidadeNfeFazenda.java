package br.com.lucasviasoft.projetolucas.service;

import br.com.lucasviasoft.projetolucas.model.*;
import lombok.extern.java.Log;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
                    Elements values = rows.get(i).select("td");

                    Estado estado = new Estado(String.valueOf(values.get(0).text()));
                    ServicoEstado servicoEstado = new ServicoEstado();
                    List<ServicoEstado> servicoEstadoList = new ArrayList<ServicoEstado>();

                    Servico servico1 = new Servico(ServicosEnum.SERVICO1);
                    StatusServicoEstado statusServicoEstado1 = new StatusServicoEstado(servicoEstado.getId(),
                            String.valueOf(values.get(1).text()));
                    ServicoEstado servicoEstado1 = new ServicoEstado(estado.getId(),servico1.getId(),
                            statusServicoEstado1.getStatus());
                    servicoEstadoList.add(servicoEstado1);

                    Servico servico2 = new Servico(ServicosEnum.SERVICO2);
                    StatusServicoEstado statusServicoEstado2 = new StatusServicoEstado(servicoEstado.getId(),
                            String.valueOf(values.get(2).text()));
                    ServicoEstado servicoEstado2 = new ServicoEstado(estado.getId(),servico2.getId(),
                            statusServicoEstado2.getStatus());
                    servicoEstadoList.add(servicoEstado2);

                    Servico servico3 = new Servico(ServicosEnum.SERVICO3);
                    StatusServicoEstado statusServicoEstado3 = new StatusServicoEstado(servicoEstado.getId(),
                            String.valueOf(values.get(3).text()));
                    ServicoEstado servicoEstado3 = new ServicoEstado(estado.getId(),servico3.getId(),
                            statusServicoEstado3.getStatus());
                    servicoEstadoList.add(servicoEstado3);

                    Servico servico4 = new Servico(ServicosEnum.SERVICO4);
                    StatusServicoEstado statusServicoEstado4 = new StatusServicoEstado(servicoEstado.getId(),
                            String.valueOf(values.get(4).text()));
                    ServicoEstado servicoEstado4 = new ServicoEstado(estado.getId(),servico4.getId(),
                            statusServicoEstado4.getStatus());
                    servicoEstadoList.add(servicoEstado4);

                    Servico servico5 = new Servico(ServicosEnum.SERVICO5);
                    StatusServicoEstado statusServicoEstado5 = new StatusServicoEstado(servicoEstado.getId(),
                            String.valueOf(values.get(5).text()));
                    ServicoEstado servicoEstado5 = new ServicoEstado(estado.getId(),servico5.getId(),
                            statusServicoEstado5.getStatus());
                    servicoEstadoList.add(servicoEstado5);

                    Servico servico6 = new Servico(ServicosEnum.SERVICO6);
                    StatusServicoEstado statusServicoEstado6 = new StatusServicoEstado(servicoEstado.getId(),
                            String.valueOf(values.get(7).text()));
                    ServicoEstado servicoEstado6 = new ServicoEstado(estado.getId(),servico6.getId(),
                            statusServicoEstado6.getStatus());
                    servicoEstadoList.add(servicoEstado6);

                    Servico servico7 = new Servico(ServicosEnum.SERVICO7);
                    StatusServicoEstado statusServicoEstado7 = new StatusServicoEstado(servicoEstado.getId(),
                            String.valueOf(values.get(8).text()));
                    ServicoEstado servicoEstado7 = new ServicoEstado(estado.getId(),servico7.getId(),
                            statusServicoEstado7.getStatus());
                    servicoEstadoList.add(servicoEstado7);

                    estado.setServicosEstados(servicoEstadoList);
                    servico1.setServicosEstados(servicoEstadoList);
                    servico2.setServicosEstados(servicoEstadoList);
                    servico3.setServicosEstados(servicoEstadoList);
                    servico4.setServicosEstados(servicoEstadoList);
                    servico5.setServicosEstados(servicoEstadoList);
                    servico6.setServicosEstados(servicoEstadoList);
                    servico7.setServicosEstados(servicoEstadoList);

                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
