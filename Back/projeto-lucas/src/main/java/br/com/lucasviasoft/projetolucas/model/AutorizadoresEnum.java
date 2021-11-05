package br.com.lucasviasoft.projetolucas.model;

public enum AutorizadoresEnum {

    AM("Amazonas"),
    BA("Bahia"),
    CE("Ceará"),
    GO("Goiás"),
    MG("Minas Gerais"),
    MS("Mato Grosso do Sul"),
    MT("Mato Grosso"),
    PE("Pernambuco"),
    PR("Paraná"),
    RS("Rio Grande do Sul"),
    SP("São Paulo"),
    SVAN("Sefaz Virtual Ambiente Nacional"),
    SVRS("Sefaz Virtual Rio Grande do Sul"),
    SVCAN("Sefaz Virtual de Contingência Ambiente Nacional: AC, AL, AP, DF, ES, MG, PA, PB, PI, RJ, RN, RO, RR, RS, SC, SE, SP, TO"),
    SVCRS("Sefaz Virtual de Contingência Rio Grande do Sul: AM, BA, CE, GO, MA, MS, MT, PE, PR");

    private String legenda;

    AutorizadoresEnum(String legenda) {
        this.legenda = legenda;
    }

    public String getLegenda(){
        return legenda;
    }
}