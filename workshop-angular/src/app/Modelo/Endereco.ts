export class Endereco{
    id!: number;
    idCidade!: number;    
    rua!: String;
    bairro!: String;
    numero!: String;

    constructor(idCidade: number, rua: string, bairro: string, numero:string) {
        this.idCidade = idCidade;
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;        
    }
}