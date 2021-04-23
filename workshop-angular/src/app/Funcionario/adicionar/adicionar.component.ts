import { getTranslationDeclStmts } from '@angular/compiler/src/render3/view/template';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Estado } from 'src/app/Modelo/Estado';
import { Funcionario } from 'src/app/Modelo/Funcionario';
import { Cidade } from 'src/app/Modelo/Cidade';
import { Departamento } from 'src/app/Modelo/Departamento';
import { Cargo } from 'src/app/Modelo/Cargo';
import { Contato } from 'src/app/Modelo/Contato';
import { Projeto } from 'src/app/Modelo/Projeto';
import { ServiceService } from '../../../app/Service/service.service';
import { Endereco } from 'src/app/Modelo/Endereco';

@Component({
  selector: 'app-adicionar',
  templateUrl: './adicionar.component.html',
  styleUrls: ['./adicionar.component.css']
})
export class AdicionarComponent implements OnInit {

  constructor(private router:Router, private service:ServiceService){}
  
  estados: Estado[] = [];
  cidades: Cidade[] = [];  
  departamentos: Departamento[] = [];  
  cargos: Cargo[] = [];
  contatos: Contato[] = [];
  projetos: Projeto[] = [];
  func!: Funcionario;  

  Types: any = [
    {tipo: 'C', descricao: 'Celular'},
    {tipo: 'T', descricao: 'Telefone'},
    {tipo: 'E', descricao: 'E-mail'}
  ];
 
  ngOnInit(): void {
    this.service.getEstados().subscribe(d => {this.estados = d;})       
    this.service.getDepartamentos().subscribe(d => {this.departamentos = d;})  
    this.service.getProjetos().subscribe(d => {this.projetos = d;})  
  }
   
  changeDepartament(departamento: any) {          				
    this.service.getCargoPorDepartamentoId(departamento.target.value).subscribe(d => {this.cargos = d;})
	}   

  addContact(){        
    this.contatos.push({tipo:       
      (<HTMLInputElement>document.getElementById("TipoContato")).value == 'C' ? 'Celular' :
      (<HTMLInputElement>document.getElementById("TipoContato")).value == 'E' ? 'E-mail' : 'Telefone',
      campo: (<HTMLInputElement>document.getElementById("CampoContato")).value});        
  }

  changeState(estado: any) {     
    this.service.getCidadesPorEstadoId(estado.target.value).subscribe(d => {this.cidades = d;})
	}  

  CheckElement(projeto: Projeto) {      
    var objIndex = this.projetos.findIndex((obj => obj.id == projeto.id));    
    this.projetos[objIndex].selecionado = true;
	}   

  DeletarContato(contato: any){
    this.contatos = this.contatos.filter(obj => obj.campo !== contato.campo && obj.tipo !== contato.tipo);
  }

  Salvar(){
    var lNomeFuncionario = (<HTMLInputElement>document.getElementById("NomeFuncionario")).value;
    var lCPFFuncionario = (<HTMLInputElement>document.getElementById("CPFFuncionario")).value;

    var lCargoTela = (<HTMLInputElement>document.getElementById("CargoFuncionario")).value
    //var lCargoFuncionario = this.cargos.find(x=>x.id == +lCargoTela)!;
    
    //Endereço:
    var lCidadeTela = (<HTMLInputElement>document.getElementById("CidadeFuncionario")).value;  
    //var lCidadeFuncionario = this.cidades.find(x=>x.id == +lCidadeTela)!;    
    
    var lRuaFuncionario = (<HTMLInputElement>document.getElementById("RuaFuncionario")).value;
    var lBairroFuncionario = (<HTMLInputElement>document.getElementById("BairroFuncionario")).value;
    var lNumeroFuncionario = (<HTMLInputElement>document.getElementById("NumeroFuncionario")).value;
    
    var lContatos = this.contatos.map(x => ({ 
      tipo: x.tipo == 'Celular' ? 'C' : x.tipo == 'Telefone' ? 'T' : 'E', campo: x.campo}))

    var lProjetos = this.projetos.filter(x => x.selecionado == true);
    var larrayProjetos = []
    for (let entry of lProjetos) {
      larrayProjetos.push(entry.id);
    }

    var newEndereco: Endereco = new Endereco(+lCidadeTela,lRuaFuncionario,lBairroFuncionario,lNumeroFuncionario);
    var newFuncionario: Funcionario = new Funcionario(lNomeFuncionario,lCPFFuncionario,+lCargoTela,newEndereco,lContatos,larrayProjetos)

    console.log(newFuncionario);

    var obj = JSON.stringify(newFuncionario);

    console.log(obj);

    this.service.createFuncionarioFull(newFuncionario).subscribe(data=>{
      alert("Funcionario cadastrado com Sucesso!");
      this.router.navigate(["listar"])
    });
  }
}
