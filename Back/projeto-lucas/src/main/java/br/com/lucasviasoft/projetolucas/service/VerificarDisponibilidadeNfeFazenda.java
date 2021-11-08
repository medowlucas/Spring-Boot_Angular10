package br.com.lucasviasoft.projetolucas.service;

import br.com.lucasviasoft.projetolucas.model.*;
import br.com.lucasviasoft.projetolucas.repository.EstadoRepository;
import br.com.lucasviasoft.projetolucas.repository.ServicoEstadoRepository;
import br.com.lucasviasoft.projetolucas.repository.ServicoRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.text.Normalizer;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class VerificarDisponibilidadeNfeFazenda {

    @Autowired
    private EstadoRepository estadoRepository;
    @Autowired
    private ServicoRepository servicoRepository;
    @Autowired
    private ServicoEstadoRepository servicoEstadoRepository;

    public Elements requestRows(){
        String receitaUrl = "http://www.nfe.fazenda.gov.br/portal/disponibilidade.aspx";
        Document resposta = null;
        try {
            resposta = Jsoup.connect(receitaUrl).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements tabelaSite = resposta.select("tbody");
        if (tabelaSite.size() < 1) {
            System.out.println("A Tabela não foi carregada");
        }
        return tabelaSite.get(1).select("tr");
    }

    public void estadosBuilder(){
        Elements rows = requestRows();
            for (int i = 1; i < rows.size(); i++) {
                Elements values = rows.get(i).select("td");
                String estadosRequest = values.get(0).text().replaceAll("[^a-z A-Z]", "");
                Estado estado = new Estado();
                estado.setSigla(estadosRequest);
                estadoRepository.save(estado);
            }
            Estado estadoMA = new Estado();
            estadoMA.setSigla("MA");
            estadoRepository.save(estadoMA);

            String [] svrsAutorizador = new String[]{"AC", "AL", "AP", "DF", "ES", "PA", "PB", "PI", "RJ,", "RN", "RO", "RR", "SC", "SE", "TO"};
        for (String s : svrsAutorizador) {
            Estado estadosSvrs = new Estado();
            estadosSvrs.setSigla(s);
            estadoRepository.save(estadosSvrs);
        }
        System.out.println("A Tabela estado foi criada com sucesso!");
    }

    public static String normalizarPalavra(String palavra) {
        return Normalizer.normalize(palavra, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").toLowerCase();
    }

    public void servicosBuilder(){
       Elements cols = requestRows();
       Elements headerCols = cols.get(0).select("th");
            for (int i = 1; i < headerCols.size(); i++) {
                if(i != 6) {
                    Servico servico = new Servico();
                    Elements descricao = headerCols.get(i).select("th");
                    servico.setDescricao(normalizarPalavra(
                            descricao.text().replaceAll(
                            "\\<[^>]*>",""
                            ).replaceAll(
                                    "\\d",""
                            )
                    ));
                    servicoRepository.save(servico);
                }
            }
        System.out.println("A Tabela servico foi criada com sucesso!");
    }

    @Scheduled(cron="0 0/1 * 1/1 * ?")
    public void checkReceitaStatus() {
        List<Estado> estados = estadoRepository.findAll();
        if (estados.size() < 31) {
            estadosBuilder();
        } else {
            System.out.println("A Tabela estado já existe");
        }

        List<Servico> servicos = servicoRepository.findAll();
        if (servicos.size() < 7) {
            servicosBuilder();
        } else {
            System.out.println("A Tabela servico já existe");
        }

        Elements rows = requestRows();

        for (int i = 1; i < rows.size(); i++) {
            Elements values = rows.get(i).select("td");
            Estado estado = estadoRepository.getById(Long.valueOf(i));
            Servico servico1 = servicoRepository.getById(1L);
            Servico servico2 = servicoRepository.getById(2L);
            Servico servico3 = servicoRepository.getById(3L);
            Servico servico4 = servicoRepository.getById(4L);
            Servico servico5 = servicoRepository.getById(5L);
            Servico servico6 = servicoRepository.getById(6L);
            Servico servico7 = servicoRepository.getById(7L);

            ServicoEstado servicoEstado1 = new ServicoEstado();
            servicoEstado1.setEstado(estado);
            servicoEstado1.setServico(servico1);
            servicoEstado1.setHistoricoData(LocalDateTime.now());
            String status1 = (values.get(1).select("img[src$=.png]")).toString();
            servicoEstado1.setStatus(status1);
            servicoEstadoRepository.save(servicoEstado1);

            ServicoEstado servicoEstado2 = new ServicoEstado();
            servicoEstado2.setEstado(estado);
            servicoEstado2.setServico(servico2);
            servicoEstado2.setHistoricoData(LocalDateTime.now());
            String status2 = (values.get(2).select("img[src$=.png]")).toString();
            servicoEstado2.setStatus(status2);
            servicoEstadoRepository.save(servicoEstado2);

            ServicoEstado servicoEstado3 = new ServicoEstado();
            servicoEstado3.setEstado(estado);
            servicoEstado3.setServico(servico3);
            servicoEstado3.setHistoricoData(LocalDateTime.now());
            String status3 = (values.get(3).select("img[src$=.png]")).toString();
            servicoEstado3.setStatus(status3);
            servicoEstadoRepository.save(servicoEstado3);

            ServicoEstado servicoEstado4 = new ServicoEstado();
            servicoEstado4.setEstado(estado);
            servicoEstado4.setServico(servico4);
            servicoEstado4.setHistoricoData(LocalDateTime.now());
            String status4 = (values.get(4).select("img[src$=.png]")).toString();
            servicoEstado4.setStatus(status4);
            servicoEstadoRepository.save(servicoEstado4);

            ServicoEstado servicoEstado5 = new ServicoEstado();
            servicoEstado5.setEstado(estado);
            servicoEstado5.setServico(servico5);
            servicoEstado5.setHistoricoData(LocalDateTime.now());
            String status5 = (values.get(5).select("img[src$=.png]")).toString();
            servicoEstado5.setStatus(status5);
            servicoEstadoRepository.save(servicoEstado5);

            ServicoEstado servicoEstado6 = new ServicoEstado();
            servicoEstado6.setEstado(estado);
            servicoEstado6.setServico(servico6);
            servicoEstado6.setHistoricoData(LocalDateTime.now());
            String status6 = (values.get(7).select("img[src$=.png]")).toString();
            servicoEstado6.setStatus(status6);
            servicoEstadoRepository.save(servicoEstado6);

            ServicoEstado servicoEstado7 = new ServicoEstado();
            servicoEstado7.setEstado(estado);
            servicoEstado7.setServico(servico7);
            servicoEstado7.setHistoricoData(LocalDateTime.now());
            String status7 = (values.get(8).select("img[src$=.png]")).toString();
            servicoEstado7.setStatus(status7);
            servicoEstadoRepository.save(servicoEstado7);

            if(i == 12) {
                Estado estadoMA = estadoRepository.getById(16L);

                ServicoEstado servicoEstadoMA1 = servicoEstado1.clonarServicoEstado();
                servicoEstadoMA1.setEstado(estadoMA);
                servicoEstadoMA1.setStatus(status1);
                servicoEstadoRepository.save(servicoEstadoMA1);

                ServicoEstado servicoEstadoMA2 = servicoEstado2.clonarServicoEstado();
                servicoEstadoMA2.setEstado(estadoMA);
                servicoEstadoMA2.setStatus(status2);
                servicoEstadoRepository.save(servicoEstadoMA2);

                ServicoEstado servicoEstadoMA3 = servicoEstado3.clonarServicoEstado();
                servicoEstadoMA3.setEstado(estadoMA);
                servicoEstadoMA3.setStatus(status3);
                servicoEstadoRepository.save(servicoEstadoMA3);

                ServicoEstado servicoEstadoMA4 = servicoEstado4.clonarServicoEstado();
                servicoEstadoMA4.setEstado(estadoMA);
                servicoEstadoMA4.setStatus(status4);
                servicoEstadoRepository.save(servicoEstadoMA4);

                ServicoEstado servicoEstadoMA5 = servicoEstado5.clonarServicoEstado();
                servicoEstadoMA5.setEstado(estadoMA);;
                servicoEstadoMA5.setStatus(status5);
                servicoEstadoRepository.save(servicoEstadoMA5);

                ServicoEstado servicoEstadoMA6 = servicoEstado6.clonarServicoEstado();
                servicoEstadoMA6.setEstado(estadoMA);
                servicoEstadoMA6.setStatus(status6);
                servicoEstadoRepository.save(servicoEstadoMA6);

                ServicoEstado servicoEstadoMA7 = servicoEstado7.clonarServicoEstado();
                servicoEstadoMA7.setEstado(estadoMA);
                servicoEstadoMA7.setStatus(status7);
                servicoEstadoRepository.save(servicoEstadoMA7);
            }

            if(i == 13){
                for(int j = 17;j < 31;j++){
                    Estado estadoSvrs = estadoRepository.getById(Long.valueOf(j));

                    ServicoEstado servicoEstadoSvrs1 = servicoEstado1.clonarServicoEstado();
                    servicoEstadoSvrs1.setEstado(estadoSvrs);
                    servicoEstadoSvrs1.setStatus(status1);
                    servicoEstadoRepository.save(servicoEstadoSvrs1);

                    ServicoEstado servicoEstadoSvrs2 = servicoEstado2.clonarServicoEstado();
                    servicoEstadoSvrs2.setEstado(estadoSvrs);
                    servicoEstadoSvrs2.setStatus(status2);
                    servicoEstadoRepository.save(servicoEstadoSvrs2);

                    ServicoEstado servicoEstadoSvrs3 = servicoEstado3.clonarServicoEstado();
                    servicoEstadoSvrs3.setEstado(estadoSvrs);
                    servicoEstadoSvrs3.setStatus(status3);
                    servicoEstadoRepository.save(servicoEstadoSvrs3);

                    ServicoEstado servicoEstadoSvrs4 = servicoEstado4.clonarServicoEstado();
                    servicoEstadoSvrs4.setEstado(estadoSvrs);
                    servicoEstadoSvrs4.setStatus(status4);
                    servicoEstadoRepository.save(servicoEstadoSvrs4);

                    ServicoEstado servicoEstadoSvrs5 = servicoEstado5.clonarServicoEstado();
                    servicoEstadoSvrs5.setEstado(estadoSvrs);
                    servicoEstadoSvrs5.setStatus(status5);
                    servicoEstadoRepository.save(servicoEstadoSvrs5);

                    ServicoEstado servicoEstadoSvrs6 = servicoEstado6.clonarServicoEstado();
                    servicoEstadoSvrs6.setEstado(estadoSvrs);
                    servicoEstadoSvrs6.setStatus(status6);
                    servicoEstadoRepository.save(servicoEstadoSvrs6);

                    ServicoEstado servicoEstadoSvrs7 = servicoEstado7.clonarServicoEstado();
                    servicoEstadoSvrs7.setEstado(estadoSvrs);
                    servicoEstadoSvrs7.setStatus(status7);
                    servicoEstadoRepository.save(servicoEstadoSvrs7);
                }
            }
        }
    }
}
