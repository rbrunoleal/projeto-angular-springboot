import { Contato } from "./Contato";
import { Endereco } from "./Endereco";

export class Funcionario{
    id!: number;
    nome_funcionario!: string;
    cpf_funcionario!: string;
    idCargo!: number;
    endereco!: Endereco;
    contatos!: Contato[];
    idProjetos!: number[];

    constructor(nome_funcionario: string, cpf_funcionario: string, idCargo: number, endereco:Endereco, contatos: Contato[], projetos: number[]) {
        this.nome_funcionario = nome_funcionario;
        this.cpf_funcionario = cpf_funcionario;
        this.idCargo = idCargo;
        this.endereco = endereco;
        this.contatos = contatos;
        this.idProjetos = projetos;
    }
    
}