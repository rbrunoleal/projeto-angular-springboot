import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Funcionario } from '../Modelo/Funcionario';
import { Estado } from '../Modelo/Estado';
import { Cidade } from '../Modelo/Cidade';
import { Departamento } from '../Modelo/Departamento';
import { Cargo } from '../Modelo/Cargo';
import { Projeto } from '../Modelo/Projeto';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor(private http:HttpClient) { }

  Url = 'http://localhost:8090/api/'
  
  UrlFuncionarios = 'http://localhost:8090/api/funcionarios'

  UrlFuncionariosFull = 'http://localhost:8090/api/funcionarios/full'
  
  UrlEstados = 'http://localhost:8090/api/estados'

  UrlCidadesEstado = 'http://localhost:8090/api/cidades/estado'

  UrlCidades = 'http://localhost:8090/api/cidades'

  UrlDepartamento = 'http://localhost:8090/api/departamentos'

  UrlCargosDepartamento = 'http://localhost:8090/api/cargos/departamento'   
  
  UrlProjetos = 'http://localhost:8090/api/projetos'  

  UrlCargos = 'http://localhost:8090/api/cargos'

  getEstados(){    
    return this.http.get<Estado[]>(this.UrlEstados)
  }

  getCidades(){    
    return this.http.get<Cidade[]>(this.UrlCidades)
  }

  getCidadePorId(id:number){
    return this.http.get<Cidade>(this.UrlCidades+"/"+id)
  }

  getCargoPorId(id:number){
    return this.http.get<Cidade>(this.UrlCargos+"/"+id)
  }

  getCidadesPorEstadoId(id:number){
    return this.http.get<Cidade[]>(this.UrlCidadesEstado+"/"+id)
  }

  getProjetos(){
    return this.http.get<Projeto[]>(this.UrlProjetos)
  }

  getDepartamentos(){    
    return this.http.get<Departamento[]>(this.UrlDepartamento)
  }  

  getCargos(){    
    return this.http.get<Cargo[]>(this.UrlCargos)
  } 

  getCargoPorDepartamentoId(id:number){
    return this.http.get<Cargo[]>(this.UrlCargosDepartamento+"/"+id)
  }

  getFuncionario(){
    return this.http.get<Funcionario[]>(this.UrlFuncionarios)
  }

  createFuncionario(func:Funcionario){
    return this.http.post<Funcionario>(this.UrlFuncionarios,func)
  }

  createFuncionarioFull(func:Funcionario){
    return this.http.post<Funcionario>(this.UrlFuncionariosFull,func)
  }

  getFuncionarioId(id:number){
    return this.http.get<any>(this.UrlFuncionarios+"/"+id)
  }

  updateFuncionario(func:Funcionario){
    return this.http.put<Funcionario>(this.UrlFuncionarios+"/"+func.id,func)
  }

  deleteFuncionario(id:number){    
    return this.http.delete<Funcionario>(this.UrlFuncionarios+"/"+id)
  }

}
