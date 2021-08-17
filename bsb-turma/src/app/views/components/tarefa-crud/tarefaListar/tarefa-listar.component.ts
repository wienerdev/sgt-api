import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Tarefa} from '../../../../model/tarefa.model';
import {TarefaService} from '../../../../service/tarefa.service';
import {Responsavel} from "../../../../model/responsavel.model";
import {FormControl, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {ResponsavelService} from "../../../../service/responsavel.service";

@Component({
  selector: 'app-tarefa-crud',
  templateUrl: './tarefa-listar.component.html',
  styleUrls: ['./tarefa-crud.component.css']
})
export class TarefaListarComponent implements OnInit {

  responsavel: Responsavel = {
    id: '',
    setor: ''
  }

  id = new FormControl('', [Validators.minLength(1)]);
  setor = new FormControl('', [Validators.minLength(4)]);

  constructor(private router: Router, private service: ResponsavelService) {
  }

  ngOnInit(): void {
  }

  cancel(): void {
    this.router.navigate(['responsavel'])
  }


  salvar(): void {
    this.service.salvar(this.responsavel).subscribe((res) => {
      this.router.navigate(['responsavel'])
      this.service.message('Responsavel criado com sucesso!')
    }, erro => {
      if (erro.error.error.match('já cadastrado')) {
        this.service.message(erro.error.error)
      }
    })
  }

  errorValidSetor() {
    if (this.setor.invalid) {
      return 'O nome deve ter entre 5 e 100 caracteres!';
    }
    return false;
  }

}
