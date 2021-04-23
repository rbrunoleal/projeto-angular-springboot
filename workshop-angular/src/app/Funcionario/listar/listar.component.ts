import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Funcionario } from 'src/app/Modelo/Funcionario';
import { ServiceService } from '../../Service/service.service';
import { jsPDF } from "jspdf";

@Component({
  selector: 'app-listar',
  templateUrl: './listar.component.html',
  styleUrls: ['./listar.component.css']
})
export class ListarComponent implements OnInit {

  funcionarios: Funcionario[] = [];
  func!: any;

  constructor(private service:ServiceService, private router:Router) { }

  ngOnInit(): void {
    this.service.getFuncionario().subscribe(d => {
      this.funcionarios = d.sort((a, b) => (a.nome_funcionario > b.nome_funcionario ? 1 : -1));
    })    
  }

  Editar(funcionario:Funcionario):void{
    localStorage.setItem("id",funcionario.id.toString());
    this.router.navigate(["editar"]);
  }

  Deletar(funcionario:Funcionario){
    this.service.deleteFuncionario(funcionario.id)
    .subscribe(d => {
      this.funcionarios = this.funcionarios.filter(p=>p!==funcionario);
      alert("Funcionário Deletado")
    })
  }  


  GerarPDF() {      
    let result = this.funcionarios.map(x => ({ 
      Nome: x.nome_funcionario, CPF: x.cpf_funcionario}))    

    let documento = new jsPDF()

    documento.setFont("Courier");    
    documento.setFontSize(20);
    documento.text("Lista de Funcionários", 65, 15);   
    
    const headers = [
      'Nome',
      'CPF'
    ]
    
    documento.table(60, 45, result, headers, { autoSize: true })
    documento.output("dataurlnewwindow");  

  }

  async getAsyncData(func_:any){
    this.service.getFuncionarioId(func_.id).subscribe(d => {
      this.func = d
    });
  }


  async GerarPDFFuncionario(func_:any){ 

    await this.getAsyncData(func_);
    console.log(func_);

    let documento = new jsPDF()

    documento.setFont("Courier");    
    documento.setFontSize(20);
    documento.text("Funcionário", 80, 15);   

    documento.setFontSize(12);
    documento.text("Nome:", 15, 25); 
    documento.text(func_.nome_funcionario, 35, 25); 
    documento.text("CPF:", 15, 30); 
    documento.text(func_.cpf_funcionario, 35, 30); 
    documento.text("Cargo:", 15, 35); 
    documento.text(func_.cargo.descricao, 35, 35); 
    documento.text("Endereço", 80, 40); 
    documento.text("Rua:", 15, 45);
    documento.text(func_.endereco.rua, 35, 45); 
    documento.text("Bairro:", 15, 50);
    documento.text(func_.endereco.bairro, 35, 50); 
    documento.text("Número:", 15, 55);
    documento.text(func_.endereco.numero, 35, 55); 
    documento.text("CEP:", 15, 60);
    documento.text(func_.endereco.numero, 35, 60); 
    documento.text("Cidade:", 15, 65);
    documento.text(func_.endereco.cidade.descricao, 35, 65); 

    documento.text("Contatos", 80, 70);
    
    const headers_contatos = [
      'tipo',
      'campo'
    ]
    
    documento.table(15, 75, func_.contatos, headers_contatos, { autoSize: true })

    documento.text("Projetos", 80, 150);

    const headers_projetos = [
      'nome',
      'contratante',
      'dataInicio'
    ]
    
    documento.table(10, 155, func_.projetos, headers_projetos, { autoSize: true })


    documento.output("dataurlnewwindow");
  }
}
