import {Component, OnInit} from "@angular/core";
import {TipoTarefa} from '../../../../model/tipoTarefa.model';
import {TipoTarefaService} from "../../../../service/tipoTarefa.service";
import {FormControl, Validators} from "@angular/forms";
import {Router} from "@angular/router";


@Component({
    selector: 'app-tipoTarefa-crud',
    templateUrl: './tipoTarefa-salvar.component.html',
    styleUrls: [ './tipoTarefa-salvar.component.css']
})
export class TipoTarefaSalvarComponent implements OnInit {
  tipoTarefa: TipoTarefa = {
    id: '',
    descricaoTipoTarefa: ''
  }

  id = new FormControl('', [Validators.minLength(1)]);
  descricaoTipoTarefa = new FormControl('', [Validators.minLength(4)]);

  constructor(private router: Router, private service: TipoTarefaService) {
  }

  ngOnInit(): void {
  }

  cancel(): void {
    this.router.navigate(['tipotarefas'])
  }

  errorValidDescricaoTipoTarefa() {

    if (this.descricaoTipoTarefa.invalid) {
      return 'O nome deve ter entre 5 e 100 caracteres!';
    }
    return false;

  }

  salvar(): void {
    this.service.salvar(this.tipoTarefa).subscribe((res) => {
      this.router.navigate(['tipotarefas'])
      this.service.message('Tipo de Tarefa criada com sucesso!')
    }, erro => {
      if (erro.error.error.match('já cadastrado')) {
        this.service.message(erro.error.error)
      }
    })
  }
}
