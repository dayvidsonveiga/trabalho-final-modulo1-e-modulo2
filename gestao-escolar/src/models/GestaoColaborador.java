package models;

import interfaces.Gestao;

import java.util.Scanner;

public class GestaoColaborador implements Gestao {
    @Override
    public void editar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha o colaborador que deseja editar: ");
        for (int i = 0; i < Menu.getListaDeColaboradores().size(); i++) {
            System.out.println((i + 1) + " - " + Menu.getListaDeColaboradores().get(i).getNome());
        }
        int indexColaborador = Integer.parseInt(scanner.nextLine());
        Colaborador colaborador = (Colaborador) Menu.getListaDeColaboradores().get(indexColaborador - 1);
        System.out.println("Digite o nome do colaborador:");
        colaborador.setNome(scanner.nextLine());
        System.out.println("Digite o telefone do Colaborador:");
        colaborador.setTelefone(scanner.nextLine());
        System.out.println("Digite o E-mail do Colaborador:");
        colaborador.setEmail(scanner.nextLine());
        System.out.println("Digite o cargo do Colaborador:");
        colaborador.setCargo(scanner.nextLine());
        System.out.println("Digite o salário do colaborador:");
        System.out.print("R$");
        colaborador.setSalario(Double.parseDouble(scanner.nextLine()));
        System.out.println("Digite o endereço do Colaborador:");
        System.out.println("Logradouro:");
        colaborador.setEndereco(new Endereco(scanner.nextLine()));
        System.out.println("Número:");
        colaborador.getEndereco().setNumero(Integer.parseInt(scanner.nextLine()));
        System.out.println("Cidade:");
        colaborador.getEndereco().setCidade(scanner.nextLine());
        System.out.println("Estado:");
        colaborador.getEndereco().setEstado(scanner.nextLine());
        System.out.println("Cep:");
        colaborador.getEndereco().setCep(scanner.nextLine());
    }

    @Override
    public void remover() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha o colaborador que deseja remover: ");
        for (int i = 0; i < Menu.getListaDeColaboradores().size(); i++) {
            System.out.println((i + 1) + " - " + Menu.getListaDeColaboradores().get(i).getNome());
        }
        int indexColaborador = Integer.parseInt(scanner.nextLine());
        Menu.getListaDeColaboradores().remove(indexColaborador - 1);
    }
}
