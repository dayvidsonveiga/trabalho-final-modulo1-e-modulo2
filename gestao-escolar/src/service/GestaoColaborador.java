package service;

import models.Colaborador;
import models.Endereco;
import view.Menu;

import java.util.Scanner;

public class GestaoColaborador implements Gestao, Portal {
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

    @Override
    public void imprimirInformacoes() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha o colaborador: ");
        for (int i = 0; i < Menu.getListaDeColaboradores().size(); i++) {
            System.out.println((i + 1) + " - " + Menu.getListaDeColaboradores().get(i).getNome());
        }
        int indexColaborador = Integer.parseInt(scanner.nextLine());
        Colaborador colaborador = (Colaborador) Menu.getListaDeColaboradores().get(indexColaborador - 1);
        System.out.println("Nome: " + colaborador.getNome());
        System.out.println("Cargo: " + colaborador.getCargo());
        System.out.println("Salário: R$" + colaborador.getSalario());
        System.out.println("Endereço: " + colaborador.getEndereco().getLogradouro());
        System.out.println("Número: " + colaborador.getEndereco().getNumero());
        System.out.println("Cep: " + colaborador.getEndereco().getCep());
        System.out.println("Cidade: " + colaborador.getEndereco().getCidade());
        System.out.println("Estado: " + colaborador.getEndereco().getEstado());
    }
}
