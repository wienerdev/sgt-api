import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { ResponsavelListarComponent } from './views/components/responsavel-crud/responsavelListar/responsavel-listar.component';
import { HomeComponent } from './views/components/template/home/home.component';
import { ResponsavelSalvarComponent} from "./views/components/responsavel-crud/responsavelSalvar/responsavel-salvar.component";
import {ResponsavelDeletarComponent} from "./views/components/responsavel-crud/responsavelDeletar/responsavel-deletar.component";
import {ResponsavelAtualizarComponent} from "./views/components/responsavel-crud/responsavelAtualizar/responsavel-atualizar.component";

const routes: Routes = [
  {
    path:'',
    component: HomeComponent
  },
  {
    path:'responsavel',
    component: ResponsavelListarComponent
  },
  {
    path:'responsavel/salvar',
    component: ResponsavelSalvarComponent
  },
  {
    path: 'responsavel/delete',
    component: ResponsavelDeletarComponent
  },

  {
     path: 'responsavel/delete/:id',
        component: ResponsavelDeletarComponent
      },
    {
    path:'responsavel/update/:id',
    component: ResponsavelAtualizarComponent
  },
  {
    path:'responsavel/update',
    component: ResponsavelAtualizarComponent
  }


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
