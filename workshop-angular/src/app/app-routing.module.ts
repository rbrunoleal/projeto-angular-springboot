import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdicionarComponent } from './Funcionario/adicionar/adicionar.component';
import { EditarComponent } from './Funcionario/editar/editar.component';
import { ListarComponent } from './Funcionario/listar/listar.component';

const routes: Routes = [
  {path:'listar', component:ListarComponent},
  {path:'adicionar', component:AdicionarComponent},
  {path:'editar', component:EditarComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
