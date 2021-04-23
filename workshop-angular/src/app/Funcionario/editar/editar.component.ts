import { Component, OnInit } from '@angular/core';
import { SelectControlValueAccessor } from '@angular/forms';
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
import { unescapeIdentifier } from '@angular/compiler';

@Component({
  selector: 'app-editar',
  templateUrl: './editar.component.html',
  styleUrls: ['./editar.component.css']
})
export class EditarComponent implements OnInit {

  constructor(private router:Router, private service:ServiceService){}

  estados: Estado[] = [];
  cidades: Cidade[] = [];  
  departamentos: Departamento[] = [];  
  cargos: Cargo[] = [];
  contatos: Contato[] = [];
  projetos: Projeto[] = [];
  funcionario: any;
  id_edit!: string;

  Types: any = [
    {tipo: 'C', descricao: 'Celular'},
    {tipo: 'T', descricao: 'Telefone'},
    {tipo: 'E', descricao: 'E-mail'}
  ];

  ngOnInit(): void {
    this.Editar();
  }

  changeDepartament(departamento: any) {          				
    this.service.getCargoPorDepartamentoId(departamento.target.value).subscribe(d => {this.cargos = d;})
	}   
  
  addContact(){        
    this.contatos.push({      
      tipo:       
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


  async getAsyncData() {
    this.id_edit = localStorage.getItem("id")!; 
    this.funcionario = await this.service.getFuncionarioId(+this.id_edit).toPromise();
    this.estados = await this.service.getEstados().toPromise();
    this.cidades = await this.service.getCidades().toPromise();
    this.cargos = await this.service.getCargos().toPromise();
    this.departamentos = await this.service.getDepartamentos().toPromise();
    this.projetos = await this.service.getProjetos().toPromise();
  }

  async Editar(){
    await this.getAsyncData()    
    console.log(this.projetos);
    console.log(this.funcionario.projetos);
    this.setValues();
  }

  setValues(){    
    (<HTMLInputElement>document.getElementById("NomeFuncionario")).value = this.funcionario.nome_funcionario;
    (<HTMLInputElement>document.getElementById("CPFFuncionario")).value = this.funcionario.cpf_funcionario;
    (<HTMLInputElement>document.getElementById("RuaFuncionario")).value = this.funcionario.endereco.rua;
    (<HTMLInputElement>document.getElementById("BairroFuncionario")).value = this.funcionario.endereco.bairro;
    (<HTMLInputElement>document.getElementById("NumeroFuncionario")).value = this.funcionario.endereco.numero;
    (<HTMLInputElement>document.getElementById("DepartamentoFuncionario")).value = this.funcionario.cargo.departamento.id;
    (<HTMLInputElement>document.getElementById("CargoFuncionario")).value = this.funcionario.cargo.id;
    (<HTMLInputElement>document.getElementById("EstadoFuncionario")).value = this.funcionario.endereco.cidade.estado.id;
    (<HTMLInputElement>document.getElementById("CidadeFuncionario")).value = this.funcionario.endereco.cidade.id;

    for (let x of this.funcionario.contatos) {
      this.contatos.push(
        {
          tipo: x.tipo == 'C' ? 'Celular' : x.tipo == 'T' ? 'Telefone' : 'E-mail',
          campo: x.campo
        }
      )
    }    

    for (let y of this.funcionario.projetos) {
      var objIndex = this.projetos.findIndex((obj => obj.id == y.id));
      console.log(objIndex);
      this.projetos[objIndex].selecionado = true
    } 
  };

  Salvar(){
    this.service.deleteFuncionario(+this.id_edit).toPromise();

    var lNomeFuncionario = (<HTMLInputElement>document.getElementById("NomeFuncionario")).value;
    var lCPFFuncionario = (<HTMLInputElement>document.getElementById("CPFFuncionario")).value;

    var lCargoTela = (<HTMLInputElement>document.getElementById("CargoFuncionario")).value        
    
    var lCidadeTela = (<HTMLInputElement>document.getElementById("CidadeFuncionario")).value; 
    
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
      alert("Funcionario atualizado com Sucesso!");
      this.router.navigate(["listar"])
    });
  }

}
