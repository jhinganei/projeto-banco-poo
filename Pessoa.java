public class Pessoa {

    private String nomePessoa;
    private String cpfPessoa;

    public Pessoa(String n, String cpf){
        this.nomePessoa = n;
        this.cpfPessoa = cpf;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public String getCpfPessoa() {
        return cpfPessoa;
    }
}


