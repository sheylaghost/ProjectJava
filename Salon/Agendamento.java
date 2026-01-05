public class Agendamento {

    private String cliente;
    private String servico;
    private String data;
    private String horario;

    public Agendamento(String cliente, String servico, String data, String horario) {
        this.cliente = cliente;
        this.servico = servico;
        this.data = data;
        this.horario = horario;
    }

    public String getCliente() {
        return cliente;
    }

    public String getServico() {
        return servico;
    }

    public String getData() {
        return data;
    }

    public String getHorario() {
        return horario;
    }

    @Override
    public String toString() {
        return "Cliente: " + cliente +
                " | Serviço: " + servico +
                " | Data: " + data +
                " | Horário: " + horario;
    }
}
